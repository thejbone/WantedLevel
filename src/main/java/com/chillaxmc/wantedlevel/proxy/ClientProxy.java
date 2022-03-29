package com.chillaxmc.wantedlevel.proxy;

import com.chillaxmc.wantedlevel.WLPacketHandler;
import com.chillaxmc.wantedlevel.gui.WantedOverlay;
import com.chillaxmc.wantedlevel.messages.WLMessage;
import com.chillaxmc.wantedlevel.messages.WLMessageHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.relauncher.Side;

import javax.annotation.Nullable;

public class ClientProxy extends CommonProxy
{

    public WantedOverlay wantedOverlay;

    public void preInit()
    {
        super.preInit();
        WLPacketHandler.INSTANCE.registerMessage(WLMessageHandler.class, WLMessage.class, 1, Side.CLIENT);
    }

    public void init()
    {
        super.init();
    }

    public void postInit()
    {
        super.postInit();
        wantedOverlay = new WantedOverlay(Minecraft.getMinecraft());
        MinecraftForge.EVENT_BUS.register(wantedOverlay);
        MinecraftForge.EVENT_BUS.register(this);
    }



    public void loadComplete()
    {
        super.loadComplete();
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