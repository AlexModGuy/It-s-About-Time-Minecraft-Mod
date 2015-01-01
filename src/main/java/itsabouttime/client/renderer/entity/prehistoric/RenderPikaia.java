package itsabouttime.client.renderer.entity.prehistoric;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import itsabouttime.client.model.prehistoric.ModelPikaia;
import itsabouttime.client.model.prehistoric.ModelTrilobite;
import itsabouttime.common.entities.prehistoric.EntityPikaia;
import itsabouttime.common.entities.prehistoric.EntityTrilobite;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderPikaia
  extends RenderLiving
{
  private static final ResourceLocation Texture1 = new ResourceLocation( "iat:textures/entity/Pikaia/PikaiaBlue.png");
  private static final ResourceLocation Texture2 = new ResourceLocation( "iat:textures/entity/Pikaia/PikaiaGreen.png");
 
  public RenderPikaia()
  {
    super(new ModelPikaia(), 0.3F);
  }
  
  protected ResourceLocation getEntityTextures(EntityPikaia tr)
  {
    switch (tr.getType())
    {
    case 0: 
    default: 
      return Texture1;
    case 1: 
      return Texture2;
    }
  }

  @Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
	  GL11.glTranslatef(0, 0.3f, 0);
	GL11.glScalef(0.6f, 0.6f, 0.6f); // mix and match the parameters to your likings. 1.0f = 100%.
	}

	

  
  
  protected ResourceLocation getEntityTexture(Entity entity)
  {
    return getEntityTextures((EntityPikaia)entity);
  }
  
}
