package com.chillaxmc.customnpcex.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import javax.annotation.Nullable;

public class ClientProxy extends CommonProxy
{
    public void preInit()
    {

    }

    public void init()
    {

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
        return Minecraft.getMinecraft().player;
    }

    @Nullable
    public Boolean isClientConnectedToServer()
    {
        return Minecraft.getMinecraft().getConnection().getNetworkManager().isChannelOpen();
    }
}