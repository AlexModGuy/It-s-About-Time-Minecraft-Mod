package itsabouttime.client.renderer.entity.prehistoric;

import org.lwjgl.opengl.GL11;

import itsabouttime.client.model.prehistoric.ModelAnomalocaris;
import itsabouttime.client.model.prehistoric.ModelDilophosaurus;
import itsabouttime.client.model.prehistoric.ModelGuiyu;
import itsabouttime.client.model.prehistoric.ModelHaikouichthys;
import itsabouttime.client.model.prehistoric.ModelTrilobite;
import itsabouttime.common.entities.prehistoric.EntityAnomalocaris;
import itsabouttime.common.entities.prehistoric.EntityDilophosaurus;
import itsabouttime.common.entities.prehistoric.EntityGuiyu;
import itsabouttime.common.entities.prehistoric.EntityHaikouichthys;
import itsabouttime.common.entities.prehistoric.EntityTrilobite;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderDilophosaurus
  extends RenderLiving
{
  private static final ResourceLocation Texture1 = new ResourceLocation( "iat:textures/entity/Dilophosaurus/Dilophosaurus.png");
  private static final ResourceLocation Saddle = new ResourceLocation( "iat:textures/entity/Dilophosaurus/DilophosaurusSaddle.png");
  private static final ResourceLocation Evil = new ResourceLocation( "iat:textures/entity/Dilophosaurus/DilophosaurusEye.png");
  private static final ResourceLocation Harness = new ResourceLocation( "iat:textures/entity/Dilophosaurus/DilophosaurusTame.png");

  public RenderDilophosaurus()
  {
    super(new ModelDilophosaurus(), 0.3F);
  }
  
  protected ResourceLocation getEntityTextures(EntityDilophosaurus tr)
  {
      return Texture1;
  


  }
  
  protected int shouldRenderPass(EntityDilophosaurus p_77032_1_, int p_77032_2_, float p_77032_3_)
  {
      if (p_77032_2_ == 0 && p_77032_1_.getSaddled())
      {
          this.bindTexture(Saddle);
          return 1;
      }

      else
      {
          return -1;
      }
  }
  protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
  {
      return this.shouldRenderPass((EntityDilophosaurus)p_77032_1_, p_77032_2_, p_77032_3_);
  }

  @Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
	}
  
  
  protected ResourceLocation getEntityTexture(Entity entity)
  {
    return getEntityTextures((EntityDilophosaurus)entity);
  }
}
