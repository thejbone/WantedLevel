package com.chillaxmc.wantedlevel.proxy;


import com.chillaxmc.wantedlevel.EventHandler;
import com.chillaxmc.wantedlevel.capability.CapabilityHandler;
import com.chillaxmc.wantedlevel.capability.IWanted;
import com.chillaxmc.wantedlevel.capability.Wanted;
import com.chillaxmc.wantedlevel.capability.WantedProvider;
import com.chillaxmc.wantedlevel.storage.WantedStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nullable;

public class CommonProxy
{
    public void preInit()
    {
    }

    public void init()
    {
        CapabilityManager.INSTANCE.register(IWanted.class, new WantedStorage(), Wanted.class);
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }

    public void postInit()
    {

    }

    public void loadComplete()
    {

    }

    @Nullable
    public EntityPlayer getClientMinecraftPlayer()
    {
        return null;
    }

    @Nullable
    public Boolean isClientConnectedToServer()
    {
        return null;
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