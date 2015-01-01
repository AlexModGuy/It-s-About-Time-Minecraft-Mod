


package itsabouttime.client.model.prehistoric;

import org.lwjgl.opengl.GL11;

import itsabouttime.client.model.prehistoric.technical.MowzieModelBaseIAT;
import itsabouttime.client.model.prehistoric.technical.MowzieModelRenderer2;
import itsabouttime.common.entities.prehistoric.EntityDilophosaurus;
import net.minecraft.entity.Entity;

public class ModelDilophosaurus extends MowzieModelBaseIAT
{
  //fields
    MowzieModelRenderer2 body;
    MowzieModelRenderer2 tail3;
    MowzieModelRenderer2 tail2;
    MowzieModelRenderer2 tail1;
    MowzieModelRenderer2 neck1;
    MowzieModelRenderer2 neck2;
    MowzieModelRenderer2 head;
    MowzieModelRenderer2 topJaw;
    MowzieModelRenderer2 bottomJaw;
    MowzieModelRenderer2 leftCrest;
    MowzieModelRenderer2 RightCrest;
    MowzieModelRenderer2 RightHip;
    MowzieModelRenderer2 LeftHip;
    MowzieModelRenderer2 RightLeg1;
    MowzieModelRenderer2 RightLeg2;
    MowzieModelRenderer2 LeftLeg1;
    MowzieModelRenderer2 LeftLeg2;
    MowzieModelRenderer2 RightFoot;
    MowzieModelRenderer2 LeftFoot;
    MowzieModelRenderer2 LeftHand;
    MowzieModelRenderer2 RightHand;
    MowzieModelRenderer2 leftArm1;
    MowzieModelRenderer2 rightArm1;
    MowzieModelRenderer2 LeftArm2;
    MowzieModelRenderer2 RightArm2;
  
  public ModelDilophosaurus()
  {
    textureWidth = 64;
    textureHeight = 128;
    
      body = new MowzieModelRenderer2(this, 0, 0);
      body.addBox(-4F, -3F, 0F, 8, 7, 20);
      body.setRotationPoint(0F, 3F, -11F);
      body.setTextureSize(64, 128);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      tail3 = new MowzieModelRenderer2(this, 0, 116);
      tail3.addBox(-1F, -1F, 0F, 2, 2, 10);
      tail3.setRotationPoint(0F, 3.5F, 33F);
      tail3.setTextureSize(64, 128);
      tail3.mirror = true;
      setRotation(tail3, 0F, 0F, 0F);
      tail2 = new MowzieModelRenderer2(this, 25, 111);
      tail2.addBox(-2F, -2F, 0F, 4, 4, 13);
      tail2.setRotationPoint(0F, 3.5F, 20F);
      tail2.setTextureSize(64, 128);
      tail2.mirror = true;
      setRotation(tail2, 0F, 0F, 0F);
      tail1 = new MowzieModelRenderer2(this, 0, 93);
      tail1.addBox(-3F, -3F, 0F, 6, 6, 11);
      tail1.setRotationPoint(0F, 3.5F, 9F);
      tail1.setTextureSize(64, 128);
      tail1.mirror = true;
      setRotation(tail1, 0F, 0F, 0F);
     this.topJaw = new MowzieModelRenderer2(this, 23, 57);
      this.topJaw.setRotationPoint(0.0F, 1.2F, -5.4F);
      this.topJaw.addBox(-2.0F, -0.5F, -6.0F, 4, 1, 6);
      this.setRotation(topJaw, 0.2617993877991494F, -0.0F, 0.0F);
      this.bottomJaw = new MowzieModelRenderer2(this, 23, 47);
      this.bottomJaw.setRotationPoint(0.0F, 0.1F, -5.7F);
      this.bottomJaw.addBox(-2.0F, -2.4F, -6.0F, 4, 3, 6);
      this.setRotation(bottomJaw, 0.10471975511965977F, -0.0F, 0.0F);
      this.leftCrest = new MowzieModelRenderer2(this, 26, 33);
      this.leftCrest.setRotationPoint(0.0F, -1.8F, -3.0F);
      this.leftCrest.addBox(0.0F, -5.0F, -5.0F, 0, 5, 8);
      this.setRotation(leftCrest, 0.0F, -0.0F, 0.6108652381980153F);
      this.RightCrest = new MowzieModelRenderer2(this, 26, 33);
      this.RightCrest.setRotationPoint(0.0F, -1.8F, -3.0F);
      this.RightCrest.addBox(0.0F, -5.0F, -5.0F, 0, 5, 8);
      this.setRotation(RightCrest, 0.0F, -0.0F, -0.6108652381980153F);
      this.head = new MowzieModelRenderer2(this, 0, 53);
      this.head.setRotationPoint(0.0F, -0.5F, -6.1F);
      this.head.addBox(-2.5F, -2.5F, -6.0F, 5, 5, 6);
      this.setRotation(head, 0.2617993877991494F, -0.0F, 0.0F);
      this.neck1 = new MowzieModelRenderer2(this, 0, 28);
      this.neck1.setRotationPoint(0.0F, 3.0F, -9.0F);
      this.neck1.addBox(-2.5F, -2.5F, -7.0F, 5, 5, 7);
      this.setRotation(neck1, -0.6108652381980153F, -0.0F, 0.0F);
      this.neck2 = new MowzieModelRenderer2(this, 0, 41);
      this.neck2.setRotationPoint(0.0F, 0.2F, -6.2F);
      this.neck2.addBox(-2.0F, -2.5F, -7.0F, 4, 4, 7);
      this.setRotation(neck2, 0.3490658503988659F, -0.0F, 0.0F);
      RightHip = new MowzieModelRenderer2(this, 0, 65);
      RightHip.addBox(-4F, -2F, -2F, 4, 9, 5);
      RightHip.setRotationPoint(-4F, 3F, 5F);
      RightHip.setTextureSize(64, 128);
      RightHip.mirror = true;
      setRotation(RightHip, -0.4363323F, 0F, 0F);
      LeftHip = new MowzieModelRenderer2(this, 0, 65);
      LeftHip.addBox(0F, -2F, -2F, 4, 9, 5);
      LeftHip.setRotationPoint(4F, 3F, 5F);
      LeftHip.setTextureSize(64, 128);
      LeftHip.mirror = true;
      setRotation(LeftHip, -0.4363323F, 0F, 0F);
      RightLeg1 = new MowzieModelRenderer2(this, 19, 65);
      RightLeg1.addBox(-1.5F, 0F, -2F, 3, 10, 4);
      RightLeg1.setRotationPoint(-6F, 8F, 3F);
      RightLeg1.setTextureSize(64, 128);
      RightLeg1.mirror = true;
      setRotation(RightLeg1, 0.5061455F, 0F, 0F);
      RightLeg2 = new MowzieModelRenderer2(this, 34, 65);
      RightLeg2.addBox(-1.4F, 0F, -1.5F, 3, 8, 3);
      RightLeg2.setRotationPoint(-6F, 15.2F, 8.153334F);
      RightLeg2.setTextureSize(64, 128);
      RightLeg2.mirror = true;
      setRotation(RightLeg2, -0.3490659F, 0F, 0F);
      LeftLeg1 = new MowzieModelRenderer2(this, 19, 65);
      LeftLeg1.addBox(-1.5F, 0F, -2F, 3, 10, 4);
      LeftLeg1.setRotationPoint(6F, 8F, 3F);
      LeftLeg1.setTextureSize(64, 128);
      LeftLeg1.mirror = true;
      setRotation(LeftLeg1, 0.5061455F, 0F, 0F);
      LeftLeg2 = new MowzieModelRenderer2(this, 34, 65);
      LeftLeg2.addBox(-1.6F, 0F, -1.5F, 3, 8, 3);
      LeftLeg2.setRotationPoint(6F, 15.2F, 8.153334F);
      LeftLeg2.setTextureSize(64, 128);
      LeftLeg2.mirror = true;
      setRotation(LeftLeg2, -0.3490659F, 0F, 0F);
      RightFoot = new MowzieModelRenderer2(this, 26, 28);
      RightFoot.addBox(-2F, 0F, -6F, 4, 2, 7);
      RightFoot.setRotationPoint(-6F, 22F, 7F);
      RightFoot.setTextureSize(64, 128);
      RightFoot.mirror = true;
      setRotation(RightFoot, 0F, 0F, 0F);
      LeftFoot = new MowzieModelRenderer2(this, 26, 28);
      LeftFoot.addBox(-2F, 0F, -6F, 4, 2, 7);
      LeftFoot.setRotationPoint(6F, 22F, 7F);
      LeftFoot.setTextureSize(64, 128);
      LeftFoot.mirror = true;
      setRotation(LeftFoot, 0F, 0F, 0F);
      LeftHand = new MowzieModelRenderer2(this, 22, 80);
      LeftHand.addBox(-1.5F, -0.7F, -2F, 3, 6, 2);
      LeftHand.setRotationPoint(5F, 12F, -10F);
      LeftHand.setTextureSize(64, 128);
      LeftHand.mirror = true;
      setRotation(LeftHand, 0.837758F, 0F, 0F);
      RightHand = new MowzieModelRenderer2(this, 22, 80);
      RightHand.addBox(-1.5F, -0.7F, -2F, 3, 6, 2);
      RightHand.setRotationPoint(-5F, 12F, -10F);
      RightHand.setTextureSize(64, 128);
      RightHand.mirror = true;
      setRotation(RightHand, 0.837758F, 0F, 0F);
      leftArm1 = new MowzieModelRenderer2(this, 0, 80);
      leftArm1.addBox(0F, -1F, -1.5F, 2, 8, 3);
      leftArm1.setRotationPoint(4F, 3F, -7F);
      leftArm1.setTextureSize(64, 128);
      leftArm1.mirror = true;
      setRotation(leftArm1, 0.5235988F, 0F, 0F);
      rightArm1 = new MowzieModelRenderer2(this, 0, 80);
      rightArm1.addBox(-2F, -1F, -1.5F, 2, 8, 3);
      rightArm1.setRotationPoint(-4F, 3F, -7F);
      rightArm1.setTextureSize(64, 128);
      rightArm1.mirror = true;
      setRotation(rightArm1, 0.5235988F, 0F, 0F);
      LeftArm2 = new MowzieModelRenderer2(this, 11, 80);
      LeftArm2.addBox(-0.9F, -1F, -1.5F, 2, 8, 3);
      LeftArm2.setRotationPoint(5F, 8F, -5F);
      LeftArm2.setTextureSize(64, 128);
      LeftArm2.mirror = true;
      setRotation(LeftArm2, -0.7679449F, 0F, 0F);
      RightArm2 = new MowzieModelRenderer2(this, 11, 80);
      RightArm2.addBox(-1.1F, -1F, -1.5F, 2, 8, 3);
      RightArm2.setRotationPoint(-5F, 8F, -5F);
      RightArm2.setTextureSize(64, 128);
      RightArm2.mirror = true;
      setRotation(RightArm2, -0.7679449F, 0F, 0F);
      this.head.addChild(this.topJaw);
      this.head.addChild(this.bottomJaw);
      this.head.addChild(this.leftCrest);
      this.head.addChild(this.RightCrest);
      this.neck2.addChild(this.head);
      this.neck1.addChild(this.neck2);
      this.addChildTo(neck1, body);
      this.addChildTo(RightHand, RightArm2);
      this.addChildTo(RightArm2, rightArm1);
      this.addChildTo(rightArm1, body); 
      this.addChildTo(LeftHand, LeftArm2);
      this.addChildTo(LeftArm2, leftArm1);
      this.addChildTo(leftArm1, body);
      this.addChildTo(RightFoot, RightLeg2);
      this.addChildTo(RightLeg2, RightLeg1);
      this.addChildTo(RightLeg1, RightHip);
      this.addChildTo(LeftFoot, LeftLeg2);
      this.addChildTo(LeftLeg2, LeftLeg1);
      this.addChildTo(LeftLeg1, LeftHip);
      this.addChildTo(tail3, tail2);
      this.addChildTo(tail2, tail1);
      this.addChildTo(tail1, body);

      body.setInitValuesToCurrentPose();
      tail3.setInitValuesToCurrentPose();
      tail2.setInitValuesToCurrentPose();
      tail1.setInitValuesToCurrentPose();
      neck1.setInitValuesToCurrentPose();
      neck2.setInitValuesToCurrentPose();
      head.setInitValuesToCurrentPose();
      topJaw.setInitValuesToCurrentPose();
      bottomJaw.setInitValuesToCurrentPose();
      leftCrest.setInitValuesToCurrentPose();
      RightCrest.setInitValuesToCurrentPose();
      RightHip.setInitValuesToCurrentPose();
      LeftHip.setInitValuesToCurrentPose();
      RightLeg1.setInitValuesToCurrentPose();
      RightLeg2.setInitValuesToCurrentPose();
      LeftLeg1.setInitValuesToCurrentPose();
      LeftLeg2.setInitValuesToCurrentPose();
      RightFoot.setInitValuesToCurrentPose();
      LeftFoot.setInitValuesToCurrentPose();
      LeftHand.setInitValuesToCurrentPose();
      RightHand.setInitValuesToCurrentPose();
      leftArm1.setInitValuesToCurrentPose();
      rightArm1.setInitValuesToCurrentPose();
      LeftArm2.setInitValuesToCurrentPose();
      RightArm2.setInitValuesToCurrentPose();
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5,entity);
    if (this.isChild)
    {
        float f6 = 2.0F;
        GL11.glPushMatrix();
        GL11.glScalef(1F / f6, 1F / f6,1F / f6);
        GL11.glTranslatef(0.0F, 24.0F * f5 , 0.0F);
    body.render(f5);;
    RightHip.render(f5);
    LeftHip.render(f5);
    GL11.glPopMatrix();}else{
        body.render(f5);
        RightHip.render(f5);
        LeftHip.render(f5);	
    }
    
  }
  
  private void setRotation(MowzieModelRenderer2 model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
      super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
      EntityDilophosaurus dilo = (EntityDilophosaurus) entity;
      setAngles();
      /* f = herrera.frame;
      f1 = 1F;*/
      float scaleFactor = 0.77F;
      float height = 2F * f1;
      bob(body, 1F * scaleFactor, height, false, f, f1);
      bob(LeftHip, 1F * scaleFactor, height, false, f, f1);
      bob(RightHip, 1F * scaleFactor, height, false, f, f1);
      bob(neck2, 1F * scaleFactor, height / 2, false, f, f1);
      walk(neck1, 1F * scaleFactor, 0.25F, false, 1F, 0.1F, f, f1);
      walk(head, 1F * scaleFactor, 0.25F, true, 1F, -0.1F, f, f1);
      walk(body, 1F * scaleFactor, 0.1F, true, 0F, 0.07F, f, f1);
      walk(LeftHip, 0.5F * scaleFactor, 0.8F, false, 0F, 0.4F, f, f1);
      walk(LeftLeg1, 0.5F * scaleFactor, 0.5F, true, 1F, 0F, f, f1);
      walk(LeftLeg2, 0.5F * scaleFactor, 0.5F, false, 0F, 0F, f, f1);
      walk(LeftFoot, 0.5F * scaleFactor, 1.5F, true, 0.5F, 1F, f, f1);
      walk(RightHip, 0.5F * scaleFactor, 0.8F, true, 0F, 0.4F, f, f1);
      walk(RightLeg1, 0.5F * scaleFactor, 0.5F, false, 1F, 0F, f, f1);
      walk(RightLeg2, 0.5F * scaleFactor, 0.5F, true, 0F, 0F, f, f1);
      walk(RightFoot, 0.5F * scaleFactor, 1.5F, false, 0.5F, 1F, f, f1);
      faceTarget(head, 2, f3, f4);
      faceTarget(neck2, 2, f3, f4);
      MowzieModelRenderer2[] rightArmParts = {this.RightHand, this.RightArm2, this.rightArm1};
      MowzieModelRenderer2[] leftArmParts = {this.LeftHand, this.leftArm1, this.LeftArm2};
      MowzieModelRenderer2[] tailParts = {this.tail3, this.tail2, this.tail1};
      tailSwing(tailParts, 0.5F * scaleFactor, -0.1F * f1, 2, f);
      chainWave(tailParts, 1F * scaleFactor, -0.03F, 2, f, f1);
      chainWave(rightArmParts, 1F * scaleFactor, -0.3F, 4, f, f1);
      chainWave(leftArmParts, 1F * scaleFactor, -0.3F, 4, f, f1);
      //Idling
      chainWave(tailParts, 0.1F, -0.05F, 2, dilo.frame, 1F);
      walk(neck1, 0.1F, 0.07F, false, -1F, 0F, dilo.frame, 1F);
      walk(head, 0.1F, 0.07F, true, 0F, 0F, dilo.frame, 1F);
      walk(body, 0.1F, 0.05F, false, 0F, 0F, dilo.frame, 1F);
      chainWave(rightArmParts, 0.1F, -0.1F, 4, dilo.frame, 1F);
      chainWave(leftArmParts, 0.1F, -0.1F, 4, dilo.frame, 1F);  }

private void setAngles() {
    body.setCurrentPoseToInitValues();
    tail3.setCurrentPoseToInitValues();
    tail2.setCurrentPoseToInitValues();
    tail1.setCurrentPoseToInitValues();
    neck1.setCurrentPoseToInitValues();
    neck2.setCurrentPoseToInitValues();
    head.setCurrentPoseToInitValues();
    topJaw.setCurrentPoseToInitValues();
    bottomJaw.setCurrentPoseToInitValues();
    leftCrest.setCurrentPoseToInitValues();
    RightCrest.setCurrentPoseToInitValues();
    RightHip.setCurrentPoseToInitValues();
    LeftHip.setCurrentPoseToInitValues();
    RightLeg1.setCurrentPoseToInitValues();
    RightLeg2.setCurrentPoseToInitValues();
    LeftLeg1.setCurrentPoseToInitValues();
    LeftLeg2.setCurrentPoseToInitValues();
    RightFoot.setCurrentPoseToInitValues();
    LeftFoot.setCurrentPoseToInitValues();
    LeftHand.setCurrentPoseToInitValues();
    RightHand.setCurrentPoseToInitValues();
    leftArm1.setCurrentPoseToInitValues();
    rightArm1.setCurrentPoseToInitValues();
    LeftArm2.setCurrentPoseToInitValues();
    RightArm2.setCurrentPoseToInitValues(); 
}

}
