package itsabouttime.client.renderer.entity.prehistoric;

import itsabouttime.client.model.prehistoric.ModelTroodon;
import itsabouttime.common.entities.prehistoric.EntityTroodon;
import itsabouttime.common.entities.prehistoric.EntityTrilobite;
import itsabouttime.common.entities.prehistoric.EntityTroodon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderTroodon extends RenderLiving
{
    private static final ResourceLocation MaleTexture = new ResourceLocation("iat:textures/entity/Troodon/MaleTroodon.png");
    private static final ResourceLocation FemaleTexture = new ResourceLocation("iat:textures/entity/Troodon/FemaleTroodon.png");
    private static final ResourceLocation BabyTexture = new ResourceLocation("iat:textures/entity/Troodon/BabyTroodon.png");
    private static final ResourceLocation CollarTexture = new ResourceLocation("iat:textures/entity/Troodon/TroodonCollar.png");
    private static final ResourceLocation EyeTexture = new ResourceLocation("iat:textures/entity/Troodon/TroodonEye.png");
public static ModelTroodon Troodon;
    public RenderTroodon()
    {
        super( new ModelTroodon(), 0.3F);
        this.Troodon = (ModelTroodon)this.mainModel;
        this.setRenderPassModel(new ModelTroodon());
    }
    @Override
    protected void renderEquippedItems(EntityLivingBase p_77029_1_, float p_77029_2_)
    {
        this.renderEquippedItems((EntityTroodon)p_77029_1_, p_77029_2_);
    }
    protected void renderEquippedItems(EntityTroodon p_77029_1_, float p_77029_2_)
    {
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        super.renderEquippedItems(p_77029_1_, p_77029_2_);
        ItemStack itemstack = p_77029_1_.getHeldItem();
        ModelRenderer dummy = this.Troodon.RightHand;
        if (itemstack != null)
        {
            GL11.glPushMatrix();
            float f1;

            if (this.mainModel.isChild)
            {
                f1 = 0.5F;
                GL11.glTranslatef(0.0F, 0.0F, 0.0F);
                GL11.glScalef(f1/2, f1/2, f1/2);
            }


            else 
            {
            		f1 = 0.375F;
                    GL11.glScalef(f1, f1, f1);
                    GL11.glTranslatef(0.5F, 2.8F, -0.8F);
                    GL11.glRotatef(60.0F, 0.0F, 0.0F, 1.0F);
                    GL11.glRotatef(225.0F, 1.0F, 0.0F, 0.0F);
                    GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
            }
    	   
            this.renderManager.itemRenderer.renderItem(p_77029_1_, itemstack, 0);

            if (itemstack.getItem().requiresMultipleRenderPasses())
            {
                this.renderManager.itemRenderer.renderItem(p_77029_1_, itemstack, 1);
            }

            GL11.glPopMatrix();
        }
    }
  

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityTroodon p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_2_ == 0 && p_77032_1_.getWolfShaking())
        {

            this.bindTexture(getEntityTextures(p_77032_1_));
            return 0;
        }
        if (p_77032_2_ == 2 && !p_77032_1_.isChild())
        {
        this.bindTexture(EyeTexture);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

        if (p_77032_1_.isInvisible())
        {
            GL11.glDepthMask(false);
        }
        else
        {
            GL11.glDepthMask(true);
        }

        char c0 = 61680;
        int j = c0 % 65536;
        int k = c0 / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glEnable(GL11.GL_ALPHA_TEST);

        return 2;
}

        else if (p_77032_2_ == 1 && p_77032_1_.isTamed())
        {
            this.bindTexture(CollarTexture);
            return 1;
        }
        else
        {
            return -1;
        }
    }
    @Override
 	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
 	GL11.glScalef(0.8f, 0.8f, 0.8f); // mix and match the parameters to your likings. 1.0f = 100%.
 	}
    protected ResourceLocation getEntityTextures(EntityTroodon tr)
    {
    	if(!tr.isChild()){
      switch (tr.getType())
      {
      case 0: 
      default: 
        return FemaleTexture;
      case 1: 
        return MaleTexture;
      }
      }else{
    	return BabyTexture;  
      }
      
    }
  

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityTroodon)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */


    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTextures((EntityTroodon)p_110775_1_);
    }
}