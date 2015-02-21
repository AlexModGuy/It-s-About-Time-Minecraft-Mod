
package iat.client.models.entities;

import iat.client.models.MowzieModelBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTrilobite extends MowzieModelBase
{
  //fields
    ModelRenderer Head;
    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer RightHead;
    ModelRenderer LeftHead;
    ModelRenderer FrontalHead;
    ModelRenderer Body3;
    ModelRenderer Body4;
    ModelRenderer Tail;
    ModelRenderer Spike1;
    ModelRenderer Spike2;
    ModelRenderer Antenna1;
    ModelRenderer Antenna2;
    ModelRenderer Body21;
  
  public ModelTrilobite()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Head = new ModelRenderer(this, 0, 7);
      Head.addBox(0F, 0F, 0F, 4, 2, 4);
      Head.setRotationPoint(-2F, 22F, 0F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      Body1 = new ModelRenderer(this, 0, 13);
      Body1.addBox(0F, 0F, 0F, 7, 2, 3);
      Body1.setRotationPoint(-3.5F, 22F, -3F);
      Body1.setTextureSize(64, 32);
      Body1.mirror = true;
      setRotation(Body1, 0F, 0F, 0F);
      Body2 = new ModelRenderer(this, 0, 19);
      Body2.addBox(0F, 0F, 0F, 6, 1, 3);
      Body2.setRotationPoint(-3F, 23F, -6F);
      Body2.setTextureSize(64, 32);
      Body2.mirror = true;
      setRotation(Body2, 0F, 0F, 0F);
      RightHead = new ModelRenderer(this, 23, 0);
      RightHead.addBox(0F, 0F, 0F, 2, 1, 4);
      RightHead.setRotationPoint(2F, 23F, 0F);
      RightHead.setTextureSize(64, 32);
      RightHead.mirror = true;
      setRotation(RightHead, 0F, 0F, 0F);
      LeftHead = new ModelRenderer(this, 23, 0);
      LeftHead.addBox(0F, 0F, 0F, 2, 1, 4);
      LeftHead.setRotationPoint(-4F, 23F, 0F);
      LeftHead.setTextureSize(64, 32);
      LeftHead.mirror = true;
      setRotation(LeftHead, 0F, 0F, 0F);
      FrontalHead = new ModelRenderer(this, 0, 5);
      FrontalHead.addBox(0F, 0F, 0F, 6, 1, 1);
      FrontalHead.setRotationPoint(-3F, 23F, 4F);
      FrontalHead.setTextureSize(64, 32);
      FrontalHead.mirror = true;
      setRotation(FrontalHead, 0F, 0F, 0F);
      Body3 = new ModelRenderer(this, 0, 25);
      Body3.addBox(0F, 0F, 0F, 5, 1, 3);
      Body3.setRotationPoint(-2.5F, 23F, -9F);
      Body3.setTextureSize(64, 32);
      Body3.mirror = true;
      setRotation(Body3, 0F, 0F, 0F);
      Body4 = new ModelRenderer(this, 0, 29);
      Body4.addBox(0F, 0F, 0F, 4, 1, 2);
      Body4.setRotationPoint(-2F, 23F, -11F);
      Body4.setTextureSize(64, 32);
      Body4.mirror = true;
      setRotation(Body4, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 13, 30);
      Tail.addBox(0F, 0F, 0F, 3, 1, 1);
      Tail.setRotationPoint(-1.5F, 23F, -12F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, 0F, 0F, 0F);
      Spike1 = new ModelRenderer(this, 0, 0);
      Spike1.addBox(0F, 0F, -3F, 1, 1, 3);
      Spike1.setRotationPoint(-4F, 23F, 2F);
      Spike1.setTextureSize(64, 32);
      Spike1.mirror = true;
      setRotation(Spike1, 0F, 0.669215F, 0F);
      Spike2 = new ModelRenderer(this, 0, 0);
      Spike2.addBox(-1F, 0F, -3F, 1, 1, 3);
      Spike2.setRotationPoint(4F, 23F, 2F);
      Spike2.setTextureSize(64, 32);
      Spike2.mirror = true;
      setRotation(Spike2, 0F, -0.669215F, 0F);
      Antenna1 = new ModelRenderer(this, 21, 6);
      Antenna1.addBox(0F, 0F, 0F, 1, 0, 7);
      Antenna1.setRotationPoint(-2F, 23.5F, 4F);
      Antenna1.setTextureSize(64, 32);
      Antenna1.mirror = true;
      setRotation(Antenna1, 0F, -0.2974289F, 0F);
      Antenna2 = new ModelRenderer(this, 21, 6);
      Antenna2.addBox(0F, 0F, 0F, 1, 0, 7);
      Antenna2.setRotationPoint(1F, 23.5F, 4F);
      Antenna2.setTextureSize(64, 32);
      Antenna2.mirror = true;
      setRotation(Antenna2, 0F, 0.2974289F, 0F);
      Body21 = new ModelRenderer(this, 0, 19);
      Body21.addBox(0F, 0F, 0F, 6, 1, 3);
      Body21.setRotationPoint(-3F, 22.5F, -6F);
      Body21.setTextureSize(64, 32);
      Body21.mirror = true;
      setRotation(Body2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Head.render(f5);
    Body1.render(f5);
    Body2.render(f5);
    RightHead.render(f5);
    LeftHead.render(f5);
    FrontalHead.render(f5);
    Body3.render(f5);
    Body4.render(f5);
    Tail.render(f5);
    Spike1.render(f5);
    Spike2.render(f5);
    Antenna1.render(f5);
    Antenna2.render(f5);
    Body21.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
  }

}
