package iat.client.render.entities;

import iat.client.models.entities.ModelTrilobite;
import iat.entities.mob.EntityTrilobite;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderTrilobite
  extends RenderLiving
{
  private static final ResourceLocation Texture1 = new ResourceLocation("iat:textures/models/trilobite.png");
  private static final ResourceLocation Texture2 = new ResourceLocation("iat:textures/models/trilobite_Black.png");
  private static final ResourceLocation Texture3 = new ResourceLocation("iat:textures/models/trilobite_Green.png");
 
  public RenderTrilobite()
  {
    super(new ModelTrilobite(), 0.3F);
  }
  
  protected ResourceLocation getEntityTextures(EntityTrilobite entity)
  {
    switch (entity.getType())
    {
    case 0: 
    default: 
      return Texture1;
    case 1: 
      return Texture2;
    case 2: 
      return Texture3;


  }
  }

  @Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
	GL11.glScalef(0.6f, 0.6f, 0.6f);
	GL11.glRotatef(180, 0, 1, 0);//commando made the model backwards :)
	super.preRenderCallback(par1EntityLivingBase, par2);
	}

	

  
  
  protected ResourceLocation getEntityTexture(Entity entity)
  {
    return getEntityTextures((EntityTrilobite)entity);
  }
}
