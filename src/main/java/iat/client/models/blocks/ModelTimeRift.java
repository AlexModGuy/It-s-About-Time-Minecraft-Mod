
package iat.client.models.blocks;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTimeRift extends ModelBase
{	
	ModelRenderer Cube;

	public ModelTimeRift()
	{
		textureWidth = 32;
		textureHeight = 16;

		Cube = new ModelRenderer(this, 0, 0);
		Cube.addBox(-4F, -4F, -4F, 8, 8, 8);
		Cube.setRotationPoint(0F, 15, 0F);
		Cube.setTextureSize(32, 16);
		Cube.mirror = true;
		setRotation(Cube, -0.7853982F, -0.7853982F, -0.7853982F);
	}

	public void render(float f5)
	{   
		Cube.render(f5);

	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

}
