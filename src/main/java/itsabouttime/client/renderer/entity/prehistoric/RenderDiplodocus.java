package itsabouttime.client.renderer.entity.prehistoric;

import org.lwjgl.opengl.GL11;

import itsabouttime.client.model.prehistoric.ModelAnomalocaris;
import itsabouttime.client.model.prehistoric.ModelDiplodocus;
import itsabouttime.client.model.prehistoric.ModelMegalograptus;
import itsabouttime.client.model.prehistoric.ModelOpabina;
import itsabouttime.client.model.prehistoric.ModelTrilobite;
import itsabouttime.common.entities.prehistoric.EntityAnomalocaris;
import itsabouttime.common.entities.prehistoric.EntityDiplodocus;
import itsabouttime.common.entities.prehistoric.EntityMegalograptus;
import itsabouttime.common.entities.prehistoric.EntityOpabina;
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
public class RenderDiplodocus
  extends RenderLiving
{
  private static final ResourceLocation Texture1 = new ResourceLocation( "iat:textures/entity/Diplodocus.png");

  public RenderDiplodocus()
  {
    super(new ModelDiplodocus(), 0.3F);
  }
  
  protected ResourceLocation getEntityTextures(EntityDiplodocus tr)
  {
      return Texture1;
  


  }
  @Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
	GL11.glScalef(3.5f, 3.5f, 3.5f);
	}

  
  
  
  protected ResourceLocation getEntityTexture(Entity entity)
  {
    return getEntityTextures((EntityDiplodocus)entity);
  }
}
