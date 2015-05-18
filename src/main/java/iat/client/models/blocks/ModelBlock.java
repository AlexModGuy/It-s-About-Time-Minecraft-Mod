
package iat.client.models.blocks;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBlock extends ModelBase
{
	//fields
	ModelRenderer Shape1;

	public ModelBlock()
	{
		textureWidth = 64;
		textureHeight = 32;

		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(-8F, -8F, -8F, 16, 16, 16);
		Shape1.setRotationPoint(0F, 16F, 0F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
	}

	public void render(float f5)
	{
		Shape1.render(f5);
	}

}
