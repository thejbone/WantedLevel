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
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
    }

    public void init()
    {
        CapabilityManager.INSTANCE.register(IWanted.class, new WantedStorage(), Wanted.class);
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

}