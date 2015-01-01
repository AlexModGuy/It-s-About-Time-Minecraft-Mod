package itsabouttime.client.renderer.entity.prehistoric;

import itsabouttime.common.entities.prehistoric.EntityTrilobite;
import itsabouttime.common.entities.prehistoric.EntityVelociraptor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderVelociraptor extends RenderLiving
{
    private static final ResourceLocation WhiteTexture = new ResourceLocation("iat:textures/entity/Velociraptor/Velociraptor.png");
    private static final ResourceLocation BlueTexture = new ResourceLocation("iat:textures/entity/Velociraptor/VelociraptorBlue.png");
    private static final ResourceLocation CollarTexture = new ResourceLocation("iat:textures/entity/Velociraptor/VelociraptorCollar.png");
    private static final ResourceLocation EyeTexture = new ResourceLocation("iat:textures/entity/Velociraptor/VelociraptorEye.png");

    private static final String __OBFID = "CL_00001036";

    public RenderVelociraptor(ModelBase p_i1269_1_, ModelBase p_i1269_2_, float p_i1269_3_)
    {
        super(p_i1269_1_, p_i1269_3_);
        this.setRenderPassModel(p_i1269_2_);
    }

    
    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityVelociraptor p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        if (p_77032_2_ == 0 && p_77032_1_.getWolfShaking())
        {

            this.bindTexture(getEntityTextures(p_77032_1_));
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
    protected ResourceLocation getEntityTextures(EntityVelociraptor tr)
    {
      switch (tr.getType())
      {
      case 0: 
      default: 
        return WhiteTexture;
      case 1: 
        return BlueTexture;
      }
      
    }
  

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityVelociraptor)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */


    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTextures((EntityVelociraptor)p_110775_1_);
    }
}