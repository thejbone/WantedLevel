package com.chillaxmc.wantedlevel.commands;

import com.chillaxmc.wantedlevel.WLPacketHandler;
import com.chillaxmc.wantedlevel.capability.IWanted;
import com.chillaxmc.wantedlevel.capability.WantedProvider;
import com.chillaxmc.wantedlevel.messages.WLMessage;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class GetWanted extends CommandBase {
    @Override
    public String getName() {
        return "getwanted";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "getwanted <player>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if(args != null && args.length == 1) {
            EntityPlayerMP playerMP = server.getPlayerList().getPlayerByUsername(args[0]);
            if(playerMP != null){
                IWanted wanted = playerMP.getCapability(WantedProvider.WANTED_CAP, null);
                int amount = wanted.getWanted();
                sender.sendMessage(new TextComponentString(playerMP.getName() + ": " + amount));
            }
            else {
                sender.sendMessage(new TextComponentString("Username does not exist!"));
                return;
            }
        }
    }
}
