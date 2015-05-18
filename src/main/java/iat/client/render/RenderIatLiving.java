package iat.client.render;

import iat.entities.EntityIatMob;
import iat.entities.mob.EntityCompsognathus;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderIatLiving extends RenderLiving{

	public RenderIatLiving(ModelBase model, float f) {
		super(model, f);
	}
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
		EntityIatMob mob = (EntityIatMob)par1EntityLivingBase;
		GL11.glScalef(mob.getAnimalSize(), mob.getAnimalSize(), mob.getAnimalSize());
	}
	@Override
	protected ResourceLocation getEntityTexture(Entity entitiy) {
		return null;
	}

}
