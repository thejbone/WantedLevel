package com.chillaxmc.wantedlevel.client.gui;

import com.chillaxmc.wantedlevel.Reference;
import com.chillaxmc.wantedlevel.capability.IWanted;
import com.chillaxmc.wantedlevel.capability.WantedProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WantedOverlay extends Gui {

    private final ResourceLocation bar = new ResourceLocation(Reference.MOD_ID, "textures/gui/wantedbar.png");
    private final int tex_width = 63, tex_height = 13;
    private int starCount = 0;

    private Minecraft mc;

    public WantedOverlay(Minecraft mc){
        super();
        this.mc = mc;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }

    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event){
        if(event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            IWanted playerWanted = Minecraft.getMinecraft().player.getCapability(WantedProvider.WANTED_CAP, null);
            if(playerWanted != null){
                starCount = playerWanted.getWanted();
            }
            mc.renderEngine.bindTexture(bar);

            float oneUnit = (float) tex_width / 5;
            int currentWidth = (int) (oneUnit * getStarCount());
            drawTexturedModalRect(event.getResolution().getScaledWidth()-tex_width-20,10,0,0, tex_width, tex_height);
            drawTexturedModalRect(event.getResolution().getScaledWidth()-tex_width-20,10,0, tex_height, currentWidth, tex_height);

        }
    }

}
