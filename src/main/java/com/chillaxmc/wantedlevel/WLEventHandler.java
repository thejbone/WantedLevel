package com.chillaxmc.wantedlevel;

import com.chillaxmc.wantedlevel.capability.IWanted;
import com.chillaxmc.wantedlevel.capability.WantedProvider;
import com.chillaxmc.wantedlevel.messages.WLMessage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class WLEventHandler {

    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event)
    {
        if(event.isWasDeath()){
            return;
        }
        EntityPlayer player = event.getEntityPlayer();
        IWanted wanted = player.getCapability(WantedProvider.WANTED_CAP, null);
        IWanted oldWanted = event.getOriginal().getCapability(WantedProvider.WANTED_CAP, null);

        if(oldWanted != null){
            wanted.set(oldWanted.getWanted());
        } else {
            wanted.set(0);
        }
    }

    @SubscribeEvent
    public void onPlayerJoin(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event){
        EntityPlayer player = event.player;
        IWanted playerWanted = player.getCapability(WantedProvider.WANTED_CAP, null);
        IMessage iMessage;
        if(playerWanted != null){
            iMessage = new WLMessage(playerWanted.getWanted());
            playerWanted.set(playerWanted.getWanted());
        } else {
            iMessage = new WLMessage(0);
        }
        WLPacketHandler.INSTANCE.sendTo(iMessage, (EntityPlayerMP) player);
    }


}
