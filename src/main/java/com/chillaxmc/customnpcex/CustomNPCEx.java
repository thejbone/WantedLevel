package com.chillaxmc.customnpcex;

import com.chillaxmc.customnpcex.client.gui.WantedOverlay;
import com.chillaxmc.customnpcex.proxy.CommonProxy;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.BossInfo;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.BossInfoServer;
import noppes.npcs.api.event.PlayerEvent;

import java.util.Locale;
import java.util.UUID;

@Mod(
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION
)
public class CustomNPCEx {
    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(Reference.MOD_ID)
    public static CustomNPCEx INSTANCE;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY,
            serverSide = Reference.SERVER_PROXY)
    public static CommonProxy proxy;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

    }

    @SubscribeEvent
    public void test(PlayerEvent.FactionUpdateEvent event){
        if(event.faction.getName().toLowerCase(Locale.ROOT).equals("police")){



        }
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {

    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new WantedOverlay());
    }


}
