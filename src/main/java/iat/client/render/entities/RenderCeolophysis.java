package iat.client.render.entities;

import iat.client.models.entities.ModelCeolophysis;
import iat.client.render.RenderIatLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderCeolophysis extends RenderIatLiving {

	public ResourceLocation texture = new ResourceLocation("iat:textures/models/coelophysis.png");
	

	public RenderCeolophysis() {
		super(new ModelCeolophysis(), 0.3F);
	}
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
	 	GL11.glScalef(0.66f, 0.66f, 0.66f);
	 	super.preRenderCallback(par1EntityLivingBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
