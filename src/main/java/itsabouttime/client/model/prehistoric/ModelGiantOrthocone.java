package itsabouttime.client.model.prehistoric;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGiantOrthocone extends ModelBase
{
    /** The squid's body */
    ModelRenderer squidBody;
    /** The squid's tentacles */
    ModelRenderer[] squidTentacles = new ModelRenderer[10];
    ModelRenderer shell1;
    ModelRenderer shell2;
    ModelRenderer shell3;
  

    public ModelGiantOrthocone()
    {
    	
    	 textureWidth = 64;
    	    textureHeight = 64;	
    	
        byte b0 = -16;
        this.squidBody = new ModelRenderer(this, 0, 0);
        this.squidBody.addBox(-3.0F, 1.0F, -3F, 6, 7, 6);
        this.squidBody.rotationPointY +=  (float)(24 +b0);

        for (int i = 0; i < this.squidTentacles.length; ++i)
        {
            this.squidTentacles[i] = new ModelRenderer(this, 0, 15);
            double d0 = (double)i * Math.PI * 2.0D / (double)this.squidTentacles.length;
            float f = (float)Math.cos(d0) * 5.0F;
            float f1 = (float)Math.sin(d0) * 5.0F;
            this.squidTentacles[i].addBox(0F, -2F, -5.0F, 2, 18, 2);
            this.squidTentacles[i].rotationPointX = f;
            this.squidTentacles[i].rotationPointZ = f1;
            this.squidTentacles[i].rotationPointY = (float)(31 + b0);
            d0 = (double)i * Math.PI * -2.0D / (double)this.squidTentacles.length + (Math.PI / 2D);
            this.squidTentacles[i].rotateAngleY = (float)d0;
        }
        
        shell1 = new ModelRenderer(this, 32, 0);
        shell1.addBox(-4F, -19F, -4F, 8, 21, 8);
        shell1.setRotationPoint(0F, 0F, 0F);
        shell1.setTextureSize(64, 32);
        shell1.mirror = true;
        setRotation(shell1, 0.1745329F, 0F, 0F);
        shell2 = new ModelRenderer(this, 40, 29);
        shell2.addBox(-3F, -30F, -3F, 6, 14, 6);
        shell2.setRotationPoint(0F, -2F, 0F);
        shell2.setTextureSize(64, 32);
        shell2.mirror = true;
        setRotation(shell2, 0.1745329F, 0f, 0f);
        shell3 = new ModelRenderer(this, 0, 47);
        shell3.addBox(-2F, -44F, -2F, 4, 13, 4);
        shell3.setRotationPoint(0F, 0F, 0F);
        shell3.setTextureSize(64, 32);
        shell3.mirror = true;
        setRotation(shell3, 0.1745329F, 0F, 0F);
        
        squidBody.addChild(shell1);
        squidBody.addChild(shell2);
        squidBody.addChild(shell3);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
    {
        ModelRenderer[] amodelrenderer = this.squidTentacles;
        int i = amodelrenderer.length;

        for (int j = 0; j < i; ++j)
        {
            ModelRenderer modelrenderer = amodelrenderer[j];
            modelrenderer.rotateAngleX = p_78087_3_;
        }
    }
    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    }
    /**
     * Sets the models various rotation angles then renders the model.
     */
    
    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
    {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.squidBody.render(p_78088_7_);

       
        for (int i = 0; i < this.squidTentacles.length; ++i)
        {
            this.squidTentacles[i].render(p_78088_7_);
        }
    }
}