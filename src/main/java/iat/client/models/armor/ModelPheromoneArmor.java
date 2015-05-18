
package iat.client.models.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelPheromoneArmor extends ModelBiped
{
	ModelRenderer RightCase;
	ModelRenderer LeftCase;
	ModelRenderer MiddleCase;
	ModelRenderer Rightsmell;
	ModelRenderer Leftsmell;

	public ModelPheromoneArmor(float f)
	{
		super(f,0, 64, 64);
		textureWidth = 64;
		textureHeight = 64;
		RightCase = new ModelRenderer(this, 0, 32);
		RightCase.addBox(-3.5F, 0.1F, 2.1F, 3, 8, 3);
		RightCase.setRotationPoint(0F, 0F, 0F);
		RightCase.setTextureSize(64, 64);
		RightCase.mirror = true;
		setRotation(RightCase, 0F, 0F, 0F);
		LeftCase = new ModelRenderer(this, 0, 32);
		LeftCase.addBox(0.5F, 0.1F, 2.1F, 3, 8, 3);
		LeftCase.setRotationPoint(0F, 0F, 0F);
		LeftCase.setTextureSize(64, 64);
		LeftCase.mirror = true;
		setRotation(LeftCase, 0F, 0F, 0F);
		MiddleCase = new ModelRenderer(this, 12, 32);
		MiddleCase.addBox(-0.5F, 1F, 2.5F, 1, 2, 2);
		MiddleCase.setRotationPoint(0F, 0F, 0F);
		MiddleCase.setTextureSize(64, 64);
		MiddleCase.mirror = true;
		setRotation(MiddleCase, 0F, 0F, 0F);
		Rightsmell = new ModelRenderer(this, 12, 36);
		Rightsmell.addBox(-3F, 1.5F, 2.5F, 2, 6, 2);
		Rightsmell.setRotationPoint(0F, 0F, 0F);
		Rightsmell.setTextureSize(64, 64);
		Rightsmell.mirror = true;
		setRotation(Rightsmell, 0F, 0F, 0F);
		Leftsmell = new ModelRenderer(this, 12, 36);
		Leftsmell.addBox(1F, 1.5F, 2.5F, 2, 6, 2);
		Leftsmell.setRotationPoint(0F, 0F, 0F);
		Leftsmell.setTextureSize(64, 64);
		Leftsmell.mirror = true;
		setRotation(Leftsmell, 0F, 0F, 0F);
		this.bipedBody.addChild(LeftCase);
		this.bipedBody.addChild(RightCase);
		this.bipedBody.addChild(Leftsmell);
		this.bipedBody.addChild(Rightsmell);
		this.bipedBody.addChild(MiddleCase);

	}


	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5); setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
