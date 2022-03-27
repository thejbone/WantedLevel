package com.chillaxmc.wantedlevel;

import com.chillaxmc.wantedlevel.capability.IWanted;
import com.chillaxmc.wantedlevel.capability.WantedProvider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

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
    public void onEntityKilled(AttackEntityEvent event){
        IWanted wanted = event.getEntityPlayer().getCapability(WantedProvider.WANTED_CAP, null);
        wanted.add(1);
        event.getEntityPlayer().sendMessage(new TextComponentString("You got an extra star!"));
    }

    @SubscribeEvent
    public void onBlockPlace(BlockEvent.EntityPlaceEvent event){
        if(event.getEntity() instanceof EntityPlayer){
            IWanted wanted = event.getEntity().getCapability(WantedProvider.WANTED_CAP, null);
            wanted.remove(1);
            event.getEntity().sendMessage(new TextComponentString("You got a star removed!"));
        }
    }

}
