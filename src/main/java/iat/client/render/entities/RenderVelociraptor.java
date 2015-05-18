package iat.client.render.entities;

import iat.client.models.entities.ModelCarnotaurus;
import iat.client.models.entities.ModelCompsognathus;
import iat.client.models.entities.ModelSittingVelociraptor;
import iat.client.models.entities.ModelVelociraptor;
import iat.client.render.RenderIatLiving;
import iat.entities.mob.EntityVelociraptor;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderVelociraptor extends RenderIatLiving
{
	private static final ResourceLocation femaleTexture = new ResourceLocation("iat:textures/models/velociraptor_female.png");
	private static final ResourceLocation maleTexture = new ResourceLocation("iat:textures/models/velociraptor_male.png");
	private static final ResourceLocation collarTexture = new ResourceLocation("iat:textures/models/velociraptor_collar.png");

	public RenderVelociraptor()
	{
		super(new ModelVelociraptor(), 0.3F);
		this.setRenderPassModel(new ModelVelociraptor());

	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		GL11.glScalef(0.5F, 0.5F, 0.5F);	
		super.preRenderCallback(par1EntityLivingBase, par2);
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	 protected int shouldRenderPass(EntityVelociraptor mob, int pass, float f1)
	 {
		 if (pass == 0)
		 {
			 this.bindTexture(getEntityTexture(mob));
			 return 1;
		 }
		 
		 else if (pass == 1 && mob.isTamed())
		 {
			 this.bindTexture(collarTexture);
			 int j = mob.getCollarColor();
			 GL11.glColor3f(EntitySheep.fleeceColorTable[j][0], EntitySheep.fleeceColorTable[j][1], EntitySheep.fleeceColorTable[j][2]);
			 return 1;
		 }
		 else
		 {
			 return -1;
		 }
	 }

	 protected ResourceLocation getEntityTextures(EntityVelociraptor mob)
	 {
		 if(mob.getGender() == 0){
			 return femaleTexture;
		 }else{
			 return maleTexture;
		 }
	 }
	 protected ResourceLocation getEntityTexture(Entity mob)
	 {
		 return this.getEntityTextures((EntityVelociraptor)mob);
	 }
}