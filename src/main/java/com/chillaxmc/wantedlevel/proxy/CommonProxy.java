package com.chillaxmc.wantedlevel.proxy;


import com.chillaxmc.wantedlevel.WLEventHandler;
import com.chillaxmc.wantedlevel.WLPacketHandler;
import com.chillaxmc.wantedlevel.capability.CapabilityHandler;
import com.chillaxmc.wantedlevel.capability.IWanted;
import com.chillaxmc.wantedlevel.capability.Wanted;
import com.chillaxmc.wantedlevel.gui.WantedOverlay;
import com.chillaxmc.wantedlevel.messages.WLMessage;
import com.chillaxmc.wantedlevel.messages.WLMessageHandler;
import com.chillaxmc.wantedlevel.storage.WantedStorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.relauncher.Side;

import javax.annotation.Nullable;

public class CommonProxy
{
    public WantedOverlay wantedOverlay;

    public void preInit()
    {
        MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
        WLPacketHandler.INSTANCE.registerMessage(WLMessageHandler.class, WLMessage.class, 1, Side.SERVER);
    }

    public void init()
    {
        CapabilityManager.INSTANCE.register(IWanted.class, new WantedStorage(), Wanted.class);
        MinecraftForge.EVENT_BUS.register(new WLEventHandler());
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