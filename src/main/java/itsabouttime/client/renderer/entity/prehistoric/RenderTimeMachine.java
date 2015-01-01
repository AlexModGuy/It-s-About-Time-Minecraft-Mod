package itsabouttime.client.renderer.entity.prehistoric;

import org.lwjgl.opengl.GL11;

import itsabouttime.ProxyClient;
import itsabouttime.client.model.ModelTimeMachine;
import itsabouttime.client.model.prehistoric.ModelAnomalocaris;
import itsabouttime.client.model.prehistoric.ModelHaikouichthys;
import itsabouttime.client.model.prehistoric.ModelTrilobite;
import itsabouttime.common.entities.EntityTimeMachine;
import itsabouttime.common.entities.prehistoric.EntityAnomalocaris;
import itsabouttime.common.entities.prehistoric.EntityHaikouichthys;
import itsabouttime.common.entities.prehistoric.EntityTrilobite;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderTimeMachine
  extends RenderLiving
{
  private static final ResourceLocation Texture1 = new ResourceLocation( "iat:textures/entity/TimeMachine.png");
  private static final ResourceLocation RES_ITEM_GLINT = new ResourceLocation("textures/misc/enchanted_item_glint.png");

  public RenderTimeMachine()
  {
    super(new ModelTimeMachine(), 0.3F);
  }
  
  protected ResourceLocation getEntityTextures(EntityTimeMachine entity)
  {
      return Texture1;
  


  }
  

  @Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
	 
	}
  protected void passSpecialRender(EntityLivingBase p_77033_1_, double p_77033_2_, double p_77033_4_, double p_77033_6_)

  {

  super.passSpecialRender(p_77033_1_, p_77033_2_, p_77033_4_, p_77033_6_);
  GL11.glPushMatrix();

  GL11.glTranslated(p_77033_2_, p_77033_4_ + p_77033_1_.height / 2, p_77033_6_ +0.1D);

  GL11.glScalef(3.6F, 3.6F, 3.6F);

  GL11.glEnable(GL11.GL_BLEND);

  GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

  GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.8F);

  GL11.glCallList(ProxyClient.sphereId);

  GL11.glPopMatrix();
//2
  GL11.glPushMatrix();

  GL11.glTranslated(p_77033_2_, p_77033_4_ + p_77033_1_.height / 2, p_77033_6_ +0.1D);

  GL11.glScalef(3.6F, 3.6F, 3.6F);

  GL11.glEnable(GL11.GL_BLEND);

  GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

  GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.8F);

  GL11.glCallList(ProxyClient.SecondsphereId);

  GL11.glPopMatrix();
  }
 
  protected ResourceLocation getEntityTexture(Entity entity)
  {
    return getEntityTextures((EntityTimeMachine)entity);
  }
}
