package itsabouttime.client.renderer.entity.prehistoric;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import itsabouttime.client.model.prehistoric.ModelAnomalocaris;
import itsabouttime.client.model.prehistoric.ModelPikaia;
import itsabouttime.client.model.prehistoric.ModelTrilobite;
import itsabouttime.common.entities.prehistoric.EntityAnomalocaris;
import itsabouttime.common.entities.prehistoric.EntityPikaia;
import itsabouttime.common.entities.prehistoric.EntityTrilobite;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderAnomalocaris
  extends RenderLiving
{
  private static final ResourceLocation Texture1 = new ResourceLocation( "iat:textures/entity/Anomalocaris/BlueAnomalocaris.png");
  private static final ResourceLocation Texture2 = new ResourceLocation( "iat:textures/entity/Anomalocaris/RaptorsAnomalocaris.png");
  private static final ResourceLocation Texture3 = new ResourceLocation( "iat:textures/entity/Anomalocaris/RokuroCarisuAnomalocaris.png");

  public RenderAnomalocaris()
  {
    super(new ModelAnomalocaris(), 0.3F);
  }
  
  protected ResourceLocation getEntityTextures(EntityAnomalocaris tr)
  {
    switch (tr.getType())
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
	  GL11.glTranslatef(0.16F, 0.8f, -0.6F);

        }

	

  
  
  protected ResourceLocation getEntityTexture(Entity entity)
  {
    return getEntityTextures((EntityAnomalocaris)entity);
  }
  
}
