package itsabouttime.common.event;

import itsabouttime.common.core.IATstuff;

import java.util.Collection;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;





import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventTar extends Gui
{
    private static final ResourceLocation texture = new ResourceLocation("iat:textures/gui/Tar.png");

  private Minecraft mc;

  public EventTar(Minecraft mc)
  {
    super();
   
    this.mc = mc;
  }



  @SubscribeEvent(priority = EventPriority.LOWEST)
  public void onRenderOverlay(RenderGameOverlayEvent event) {
  if (event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE)
  return;
	  
  if(event.isCancelable() || !Minecraft.getMinecraft().thePlayer.isInsideOfMaterial(IATstuff.materialFluidTar)) {
  return;
  }


  GL11.glEnable(GL11.GL_BLEND);
  GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

  this.mc.getTextureManager().bindTexture(texture);

  drawTexturedModalRect(0, 0, 0, 0, event.resolution.getScaledWidth(), event.resolution.getScaledHeight());
  }
}
