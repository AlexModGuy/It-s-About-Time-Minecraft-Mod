package itsabouttime.client.renderer.entity.prehistoric;

import itsabouttime.client.model.prehistoric.ModelTiktaalik;
import itsabouttime.common.entities.prehistoric.EntityTiktaalik;

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
public class RenderTiktaalik
  extends RenderLiving
{
  private static final ResourceLocation Texture1 = new ResourceLocation( "iat:textures/entity/Tiktaalik.png");

  public RenderTiktaalik()
  {
    super(new ModelTiktaalik(), 0.3F);
  }
  
  protected ResourceLocation getEntityTextures(EntityTiktaalik tr)
  {
      return Texture1;
  


  }
  

  @Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
	}
  
  
  protected ResourceLocation getEntityTexture(Entity entity)
  {
    return getEntityTextures((EntityTiktaalik)entity);
  }
}
