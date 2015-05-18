package iat.client.render.entities;

import iat.client.models.entities.ModelCarnotaurus;
import iat.client.render.RenderIatLiving;
import iat.entities.mob.EntityCarnotaurus;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderCarnotaurus extends RenderIatLiving
{
	private static final ResourceLocation femaleTexture = new ResourceLocation("iat:textures/models/carnotaurus_Female.png");
	private static final ResourceLocation maleTexture = new ResourceLocation("iat:textures/models/carnotaurus_Male.png");

	public RenderCarnotaurus()
	{
		super(new ModelCarnotaurus(), 0.3F);
	}

	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		GL11.glScalef(1.3F, 1.3F, 1.3F);
		super.preRenderCallback(par1EntityLivingBase, par2);
	}

	 protected ResourceLocation getEntityTextures(EntityCarnotaurus mob)
	 {
		 if(mob.getGender() == 0){
			 return femaleTexture;
		 }else{
			 return maleTexture;
		 }
	 }
	 protected ResourceLocation getEntityTexture(Entity mob)
	 {
		 return this.getEntityTextures((EntityCarnotaurus)mob);
	 }
}