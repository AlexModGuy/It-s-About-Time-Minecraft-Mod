package itsabouttime.client.renderer.entity.prehistoric;

import itsabouttime.client.model.prehistoric.ModelCompy;
import itsabouttime.client.model.prehistoric.ModelTroodon;
import itsabouttime.common.entities.prehistoric.EntityCompy;
import itsabouttime.common.entities.prehistoric.EntityTrilobite;
import itsabouttime.common.entities.prehistoric.EntityVelociraptor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderCompy extends RenderLiving
{
    private static final ResourceLocation CompyTexture = new ResourceLocation("iat:textures/entity/Compy/Compy.png");
    private static final ResourceLocation SleepTexture = new ResourceLocation("iat:textures/entity/Compy/CompySleeping.png");
    private static final ResourceLocation CollarTexture = new ResourceLocation("iat:textures/entity/Compy/CompyCollar.png");
    private static final ResourceLocation EyeTexture = new ResourceLocation("iat:textures/entity/Compy/CompyEye.png");

    public RenderCompy()
    {
        super(new ModelCompy(), 0.3F);
        this.setRenderPassModel(new ModelCompy());

    }


   	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
        EntityCompy entitywolf = (EntityCompy)par1EntityLivingBase;
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        if (entitywolf.isSitting())
        { if(entitywolf.isChild()){
            GL11.glTranslatef(0,0.15624984375F, 0);    

        }else{
            GL11.glTranslatef(0, 0.46875F, 0);    
	
        }
            }
    }
  
    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityCompy p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_2_ == 0 && p_77032_1_.getWolfShaking())
        {

            this.bindTexture(getEntityTexture(p_77032_1_));
            return 1;
        }
        if (p_77032_2_ == 1 && p_77032_1_.isAngry())
        {
            this.bindTexture(EyeTexture);
        	return 2;
        }
        else if (p_77032_2_ == 1 && p_77032_1_.isTamed())
        {
            this.bindTexture(CollarTexture);
            int j = p_77032_1_.getCollarColor();
            GL11.glColor3f(EntitySheep.fleeceColorTable[j][0], EntitySheep.fleeceColorTable[j][1], EntitySheep.fleeceColorTable[j][2]);
            return 1;
        }
        else
        {
            return -1;
        }
    }
    protected ResourceLocation getEntityTextures(EntityCompy tr)
    {
    if(tr.isSitting()){
    	return SleepTexture;
    }else{
        return CompyTexture;
    }
      
    
    }
  

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityCompy)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */


    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTextures((EntityCompy)p_110775_1_);
    }
}