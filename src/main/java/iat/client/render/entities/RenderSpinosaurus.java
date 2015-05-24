package iat.client.render.entities;

import iat.client.models.entities.ModelCeolophysis;
import iat.client.models.entities.ModelSpinosaurus;
import iat.client.render.RenderIatLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderSpinosaurus extends RenderIatLiving {

	public ResourceLocation texture = new ResourceLocation("iat:textures/models/spinosaurus_female.png");
	

	public RenderSpinosaurus() {
		super(new ModelSpinosaurus(), 0.3F);
	}
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2) {
	 	GL11.glScalef(1.66f, 1.66f, 1.66f);
	 	super.preRenderCallback(par1EntityLivingBase, par2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}

}
