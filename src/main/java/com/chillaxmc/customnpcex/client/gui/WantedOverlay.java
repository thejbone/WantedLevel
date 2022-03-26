package com.chillaxmc.customnpcex.client.gui;

import com.chillaxmc.customnpcex.CustomNPCEx;
import com.chillaxmc.customnpcex.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WantedOverlay extends Gui {

    private final ResourceLocation bar = new ResourceLocation(Reference.MOD_ID, "textures/gui/wantedbar.png");
    private final int tex_width = 64, tex_height = 13;

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event){
        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            Minecraft mc = Minecraft.getMinecraft();
            mc.renderEngine.bindTexture(bar);

            float oneUnit = (float) tex_width / 5;
            int currentWidth = (int) (oneUnit * 2);
            drawTexturedModalRect(event.getResolution().getScaledWidth()-tex_width-20,10,0,0, tex_width, tex_height);
            drawTexturedModalRect(event.getResolution().getScaledWidth()-tex_width-20,10,0, tex_height, currentWidth, tex_height);

        }
    }

}
