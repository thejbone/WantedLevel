package com.chillaxmc.wantedlevel.messages;

import com.chillaxmc.wantedlevel.capability.IWanted;
import com.chillaxmc.wantedlevel.capability.WantedProvider;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class WLMessageHandler implements IMessageHandler<WLMessage, IMessage> {
    @Override public IMessage onMessage(WLMessage message, MessageContext ctx) {
        if(ctx.side.equals(Side.CLIENT)){
            int amount = message.getToSend();
            IWanted playerWanted = Minecraft.getMinecraft().player.getCapability(WantedProvider.WANTED_CAP, null);
            if(playerWanted != null){
                playerWanted.set(message.getToSend());
            }
        }
        return null;
    }
}