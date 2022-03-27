package com.chillaxmc.wantedlevel.proxy;

import com.chillaxmc.wantedlevel.client.gui.WantedOverlay;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

import javax.annotation.Nullable;

public class ClientProxy extends CommonProxy
{

    WantedOverlay wantedOverlay;

    public void preInit()
    {

    }

    public void init()
    {

    }

    public void postInit()
    {
        wantedOverlay = new WantedOverlay(Minecraft.getMinecraft());
        MinecraftForge.EVENT_BUS.register(wantedOverlay);
        MinecraftForge.EVENT_BUS.register(this);
    }



    public void loadComplete()
    {

    }

    @Nullable
    public EntityPlayer getClientMinecraftPlayer()
    {
        return Minecraft.getMinecraft().player;
    }

    @Nullable
    public Boolean isClientConnectedToServer()
    {
        return Minecraft.getMinecraft().getConnection().getNetworkManager().isChannelOpen();
    }
}