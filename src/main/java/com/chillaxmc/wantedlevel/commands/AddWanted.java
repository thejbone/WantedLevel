package com.chillaxmc.wantedlevel.commands;

import com.chillaxmc.wantedlevel.WLPacketHandler;
import com.chillaxmc.wantedlevel.capability.IWanted;
import com.chillaxmc.wantedlevel.capability.WantedProvider;
import com.chillaxmc.wantedlevel.messages.WLMessage;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class AddWanted extends CommandBase {
    @Override
    public String getName() {
        return "addwanted";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "addwanted <player> <amount>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(args != null && args.length == 2) {
            EntityPlayerMP playerMP = server.getPlayerList().getPlayerByUsername(args[0]);
            if(playerMP != null){
                int amount;
                try{
                    amount = parseInt(args[1]);
                } catch (Exception e) {
                    sender.sendMessage(new TextComponentString("Invalid amount"));
                    return;
                }
                IWanted playerWanted = playerMP.getCapability(WantedProvider.WANTED_CAP, null);
                IMessage iMessage;
                if(playerWanted != null){
                    iMessage = new WLMessage(playerWanted.getWanted() + amount);
                    playerWanted.set(playerWanted.getWanted() + amount);
                } else {
                    iMessage = new WLMessage(amount);
                }
                WLPacketHandler.INSTANCE.sendTo(iMessage, playerMP);
            }
            else {
                sender.sendMessage(new TextComponentString("Username does not exist!"));
                return;
            }
        }
    }
}
