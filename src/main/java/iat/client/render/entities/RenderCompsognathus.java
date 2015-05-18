package iat.client.render.entities;

import iat.client.models.entities.ModelCompsognathus;
import iat.client.render.RenderIatLiving;
import iat.entities.mob.EntityCompsognathus;
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
public class RenderCompsognathus extends RenderIatLiving
{
	private static final ResourceLocation CompyTexture = new ResourceLocation("iat:textures/models/compsognathus.png");
	private static final ResourceLocation SleepTexture = new ResourceLocation("iat:textures/models/compsognathus_Sleeping.png");
	private static final ResourceLocation CollarTexture = new ResourceLocation("iat:textures/models/compsognathus_Collar.png");
	private static final ResourceLocation EyeTexture = new ResourceLocation("iat:textures/models/compsognathus_Angry.png");

	public RenderCompsognathus()
	{
		super(new ModelCompsognathus(), 0.3F);
		this.setRenderPassModel(new ModelCompsognathus());
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		EntityCompsognathus entitywolf = (EntityCompsognathus)par1EntityLivingBase;
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		if (entitywolf.isSitting())
		{ if(entitywolf.isChild()){
			GL11.glTranslatef(0,0.15624984375F, 0);    

		}else{
			GL11.glTranslatef(0, 0.46875F, 0);    

		}
		}
		super.preRenderCallback(par1EntityLivingBase, par2);
	}

	/**
	 * Queries whether should render the specified pass or not.
	 */
	 protected int shouldRenderPass(EntityCompsognathus mob, int pass, float f1)
	 {
		 if (pass == 0)
		 {
			 this.bindTexture(getEntityTexture(mob));
			 return 1;
		 }
		 if (pass == 1 && mob.isAngry())
		 {
			 this.bindTexture(EyeTexture);
			 return 2;
		 }
		 else if (pass == 1 && mob.isTamed())
		 {
			 this.bindTexture(CollarTexture);
			 int j = mob.getCollarColor();
			 GL11.glColor3f(EntitySheep.fleeceColorTable[j][0], EntitySheep.fleeceColorTable[j][1], EntitySheep.fleeceColorTable[j][2]);
			 return 1;
		 }
		 else
		 {
			 return -1;
		 }
	 }
	 protected ResourceLocation getEntityTextures(EntityCompsognathus mob)
	 {
		 if(mob.isSitting()){
			 return SleepTexture;
		 }else{
			 return CompyTexture;
		 }


	 }


	 /**
	  * Queries whether should render the specified pass or not.
	  */
	 protected int shouldRenderPass(EntityLivingBase mob, int pass, float f1)
	 {
		 return this.shouldRenderPass((EntityCompsognathus)mob, pass, f1);
	 }

	 /**
	  * Defines what float the third param in setRotationAngles of ModelBase is
	  */


	 /**
	  * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	  */
	 protected ResourceLocation getEntityTexture(Entity mob)
	 {
		 return this.getEntityTextures((EntityCompsognathus)mob);
	 }
}