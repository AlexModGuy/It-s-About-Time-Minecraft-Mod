package itsabouttime.client.renderer.entity.prehistoric;

import itsabouttime.common.entities.prehistoric.EntityTrilobite;
import itsabouttime.common.entities.prehistoric.EntityBrontoscorpio;
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
public class RenderBrontoscorpio extends RenderLiving
{
    private static final ResourceLocation Texture = new ResourceLocation("iat:textures/entity/Brontoscorpio/Brontoscorpio.png");
    private static final ResourceLocation ChestTexture = new ResourceLocation("iat:textures/entity/Brontoscorpio/BrontoscorpioChest.png");
    private static final ResourceLocation PoisonTexture = new ResourceLocation("iat:textures/entity/Brontoscorpio/BrontoscorpioPosion.png");


    public RenderBrontoscorpio(ModelBase p_i1269_1_, ModelBase p_i1269_2_, float p_i1269_3_)
    {
        super(p_i1269_1_, p_i1269_3_);
        this.setRenderPassModel(p_i1269_2_);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityWolf p_77044_1_, float p_77044_2_)
    {
        return p_77044_1_.getTailRotation();
    }



  
    @Override
   	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
   	GL11.glScalef(0.66f, 0.66f, 0.66f); // mix and match the parameters to your likings. 1.0f = 100%.
   	}
    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_)
    {
        return this.shouldRenderPass((EntityBrontoscorpio)p_77032_1_, p_77032_2_, p_77032_3_);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */


    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_)
    {
        return this.getEntityTexture((EntityBrontoscorpio)p_110775_1_);
    }
}