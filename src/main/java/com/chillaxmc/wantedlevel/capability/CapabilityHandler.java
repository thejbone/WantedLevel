package com.chillaxmc.wantedlevel.capability;

import com.chillaxmc.wantedlevel.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CapabilityHandler {
    public static final ResourceLocation WANTED_CAP = new ResourceLocation(Reference.MOD_ID, "wanted");

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event){
        if(!(event.getObject() instanceof EntityPlayer)) return;
        event.addCapability(WANTED_CAP, new WantedProvider());
    }

}
