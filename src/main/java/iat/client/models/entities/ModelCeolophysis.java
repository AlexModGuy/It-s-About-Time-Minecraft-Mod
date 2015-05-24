package iat.client.models.entities;


import iat.client.models.MowzieModelBase;
import iat.client.models.MowzieModelRenderer;
import iat.entities.mob.EntityCoelophysis;

import org.lwjgl.opengl.GL11;

import thehippomaster.AnimationAPI.IAnimatedEntity;
import thehippomaster.AnimationAPI.client.Animator;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * Ceolophysis.tcn - TechneToTabulaImporter
 * Created using Tabula 4.0.2
 */
public class ModelCeolophysis extends MowzieModelBase {
    public static final float PI = (float)Math.PI;

    public MowzieModelRenderer Neck1;
    public MowzieModelRenderer Body;
    public MowzieModelRenderer RightArm;
    public MowzieModelRenderer LeftArm;
    public MowzieModelRenderer RightThigh;
    public MowzieModelRenderer LeftThigh;
    public MowzieModelRenderer Tail1;
    public MowzieModelRenderer Neck2;
    public MowzieModelRenderer Head;
    public MowzieModelRenderer UpperJaw;
    public MowzieModelRenderer LowerJaw;
    public MowzieModelRenderer RightHand;
    public MowzieModelRenderer LeftHand;
    public MowzieModelRenderer RightLeg;
    public MowzieModelRenderer RightAnkle;
    public MowzieModelRenderer RightFoot;
    public MowzieModelRenderer LeftLeg;
    public MowzieModelRenderer LeftAnkle;
    public MowzieModelRenderer LeftFoot;
    public MowzieModelRenderer Tail2;
    public MowzieModelRenderer Tail3;
    private Animator animator;

    public ModelCeolophysis() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        LeftAnkle = new MowzieModelRenderer(this, 26, 33);
        LeftAnkle.setRotationPoint(-0.1F, 6.2F, 0.6F);
        LeftAnkle.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
        setRotation(LeftAnkle, -0.8726646259971648F, -0.0F, 0.0F);
        RightThigh = new MowzieModelRenderer(this, 24, 10);
        RightThigh.setRotationPoint(-3.0F, 7.0F, 6.0F);
        RightThigh.addBox(-3.0F, -2.0F, -2.0F, 3, 7, 4);
        setRotation(RightThigh, -0.43633231520652765F, -0.0F, 0.0F);
        this.Neck2 = new MowzieModelRenderer(this, 44, 12);
        this.Neck2.setRotationPoint(0.0F, -0.4F, -6.6F);
        this.Neck2.addBox(-1.5F, -1.5F, -7.0F, 3, 3, 7);
        setRotation(Neck2, 0.296705972839036F, -0.0F, 0.0F);
        LeftLeg = new MowzieModelRenderer(this, 24, 22);
        LeftLeg.setRotationPoint(1.5F, 3.4F, -0.4F);
        LeftLeg.addBox(-1.0F, 0.0F, -1.5F, 2, 7, 3);
        setRotation(LeftLeg, 0.9424777960769379F, -0.0F, 0.0F);
        Tail1 = new MowzieModelRenderer(this, 0, 31);
        Tail1.setRotationPoint(0.0F, 7.0F, 10.0F);
        Tail1.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 8);
        Tail2 = new MowzieModelRenderer(this, 0, 21);
        Tail2.setRotationPoint(0.0F, 0.0F, 8.0F);
        Tail2.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 6);
        this.Neck1 = new MowzieModelRenderer(this, 42, 0);
        this.Neck1.setRotationPoint(0.0F, 6.0F, -2.0F);
        this.Neck1.addBox(-2.0F, -2.0F, -7.0F, 4, 4, 7);
        setRotation(Neck1, -0.6108652381980153F, -0.0F, 0.0F);
        Body = new MowzieModelRenderer(this, 0, 44);
        Body.setRotationPoint(0.0F, 7.0F, -4.0F);
        Body.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 14);
        RightLeg = new MowzieModelRenderer(this, 24, 22);
        RightLeg.setRotationPoint(-1.5F, 3.4F, -0.4F);
        RightLeg.addBox(-1.0F, 0.0F, -1.5F, 2, 7, 3);
        setRotation(RightLeg, 0.9424777960769379F, -0.0F, 0.0F);
        RightArm = new MowzieModelRenderer(this, 33, 0);
        RightArm.setRotationPoint(-3.0F, 8.0F, -2.0F);
        RightArm.addBox(-2.0F, -1.0F, -1.0F, 2, 6, 2);
        setRotation(RightArm, 0.24434609711170194F, -0.0F, 0.0F);
        LeftArm = new MowzieModelRenderer(this, 33, 0);
        LeftArm.setRotationPoint(3.0F, 8.0F, -2.0F);
        LeftArm.addBox(0.0F, -1.0F, -1.0F, 2, 6, 2);
        setRotation(LeftArm, 0.24434609711170194F, -0.0F, 0.0F);
        RightFoot = new MowzieModelRenderer(this, 0, 0);
        RightFoot.setRotationPoint(0.0F, 7.3F, -0.1F);
        RightFoot.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 5);
        setRotation(RightFoot, 0.3839724354387525F, -0.0F, 0.0F);
        LeftFoot = new MowzieModelRenderer(this, 0, 0);
        LeftFoot.setRotationPoint(0.0F, 7.3F, -0.1F);
        LeftFoot.addBox(-1.5F, 0.0F, -4.0F, 3, 2, 5);
        setRotation(LeftFoot, 0.3839724354387525F, -0.0F, 0.0F);
        LowerJaw = new MowzieModelRenderer(this, 52, 40);
        LowerJaw.setRotationPoint(0.0F, 1.2F, -3.6F);
        LowerJaw.addBox(-1.0F, -0.5F, -4.0F, 2, 1, 4);
        LeftHand = new MowzieModelRenderer(this, 24, 0);
        LeftHand.setRotationPoint(1.1F, 4.2F, 0.4F);
        LeftHand.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
        setRotation(LeftHand, -1.0297442586766543F, -0.0F, 0.0F);
        Head = new MowzieModelRenderer(this, 46, 23);
        Head.setRotationPoint(0.0F, 0.0F, -6.7F);
        Head.addBox(-2.0F, -2.0F, -4.57F, 4, 4, 5);
        setRotation(Head, 0.296705972839036F, 0.0F, 0.0F);
        UpperJaw = new MowzieModelRenderer(this, 50, 33);
        UpperJaw.setRotationPoint(0.0F, -0.5F, -4.4F);
        UpperJaw.addBox(-1.5F, -1.0F, -4.0F, 3, 2, 4);
        setRotation(UpperJaw, 0.15707963267948966F, -0.0F, 0.0F);
        Tail3 = new MowzieModelRenderer(this, 0, 9);
        Tail3.setRotationPoint(0.0F, 0.0F, 6.0F);
        Tail3.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 9);
        LeftThigh = new MowzieModelRenderer(this, 24, 10);
        LeftThigh.setRotationPoint(3.0F, 7.0F, 6.0F);
        LeftThigh.addBox(0.0F, -2.0F, -2.0F, 3, 7, 4);
        setRotation(LeftThigh, -0.43633231520652765F, -0.0F, 0.0F);
        RightHand = new MowzieModelRenderer(this, 24, 0);
        RightHand.setRotationPoint(-1.1F, 4.2F, 0.4F);
        RightHand.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2);
        setRotation(RightHand, -1.0297442586766543F, -0.0F, 0.017453292519943295F);
        RightAnkle = new MowzieModelRenderer(this, 26, 33);
        RightAnkle.setRotationPoint(0.1F, 6.2F, 0.6F);
        RightAnkle.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2);
        setRotation(RightAnkle, -0.8726646259971648F, -0.0F, 0.0F);

        /*LeftLeg.rotateAngleX=0.9424777960769379F;
        Neck2.rotateAngleX=0.296705972839036F;
        RightLeg.rotateAngleX=0.9424777960769379F;
        RightThigh.rotateAngleX=-0.43633231520652765F;
        LeftFoot.rotateAngleX=0.3839724354387525F;
        LeftThigh.rotateAngleX=-0.43633231520652765F;
        LeftHand.rotateAngleX=-1.0297442586766543F;
        LeftAnkle.rotateAngleX=-0.8726646259971648F;
        Neck1.rotateAngleX=-0.6108652381980153F;
        UpperJaw.rotateAngleX=0.15707963267948966F;
        Head.rotateAngleX=0.296705972839036F;
        RightHand.rotateAngleX=-1.0297442586766543F;
        //RightHand.rotateAngleZ=0.017453292519943295F;
        LeftArm.rotateAngleX=0.24434609711170194F;
        RightArm.rotateAngleX=0.24434609711170194F;
        RightFoot.rotateAngleX=0.3839724354387525F;*/
      animator = new Animator(this);

        this.Head.addChild(this.LowerJaw);
        this.Head.addChild(this.UpperJaw);
        this.Neck2.addChild(this.Head);
        this.Neck1.addChild(this.Neck2);
        
        this.RightAnkle.addChild(this.RightFoot);
        this.RightLeg.addChild(this.RightAnkle);
        this.RightThigh.addChild(this.RightLeg);
        
        this.Tail2.addChild(this.Tail3);
        this.Tail1.addChild(this.Tail2);
        convertToChild(Body,Tail1);
        
        this.LeftAnkle.addChild(this.LeftFoot);
        this.LeftLeg.addChild(this.LeftAnkle);
        this.LeftThigh.addChild(this.LeftLeg);
        
        this.LeftArm.addChild(this.LeftHand);
        this.RightArm.addChild(this.RightHand);

        Neck1.setInitValuesToCurrentPose();
        Body.setInitValuesToCurrentPose();
        RightArm.setInitValuesToCurrentPose();
        LeftArm.setInitValuesToCurrentPose();
        RightThigh.setInitValuesToCurrentPose();
        LeftThigh.setInitValuesToCurrentPose();
        Tail1.setInitValuesToCurrentPose();
        Neck2.setInitValuesToCurrentPose();
        Head.setInitValuesToCurrentPose();
        UpperJaw.setInitValuesToCurrentPose();
        LowerJaw.setInitValuesToCurrentPose();
        RightHand.setInitValuesToCurrentPose();
        LeftHand.setInitValuesToCurrentPose();
        RightLeg.setInitValuesToCurrentPose();
        RightAnkle.setInitValuesToCurrentPose();
        RightFoot.setInitValuesToCurrentPose();
        LeftLeg.setInitValuesToCurrentPose();
        LeftAnkle.setInitValuesToCurrentPose();
        LeftFoot.setInitValuesToCurrentPose();
        Tail2.setInitValuesToCurrentPose();
        Tail3.setInitValuesToCurrentPose();
    }
    private void setRotation(MowzieModelRenderer model, float x, float y, float z)
    {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    
          

    }
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
      super.render(entity, f, f1, f2, f3, f4, f5);
    animate((IAnimatedEntity)entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    if (this.isChild)
    {
        float f6 = 2.0F;
        
        GL11.glPushMatrix();
        GL11.glScalef(1F / f6, 1F / f6,1F / f6);
        GL11.glTranslatef(0.0F, 24.0F * f5 , 0.0F);
        this.RightThigh.render(f5);
        this.LeftThigh.render(f5);
        this.Body.render(f5);
        this.Neck1.render(f5);
        this.LeftArm.render(f5);
        this.RightArm.render(f5);
        GL11.glPopMatrix();
    }else{
        this.RightThigh.render(f5);
        this.LeftThigh.render(f5);
        this.Body.render(f5);
        this.Neck1.render(f5);
        this.LeftArm.render(f5);
        this.RightArm.render(f5);   
    }
    }


    protected void convertToChild(MowzieModelRenderer parParent, MowzieModelRenderer parChild)
    {
       // move child rotation point to be relative to parent
       parChild.rotationPointX -= parParent.rotationPointX;
       parChild.rotationPointY -= parParent.rotationPointY;
       parChild.rotationPointZ -= parParent.rotationPointZ;
       // make rotations relative to parent
       parChild.rotateAngleX -= parParent.rotateAngleX;
       parChild.rotateAngleY -= parParent.rotateAngleY;
       parChild.rotateAngleZ -= parParent.rotateAngleZ;
       // create relationship
       parParent.addChild(parChild);
    } 
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
    	  super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	    
    	    EntityCoelophysis mob = (EntityCoelophysis) entity;
    	    setAngles();
    	    float scaleFactor = 0.75F;
    	    float height = 2F * f1;
    	    walk(LeftThigh, 0.5F * scaleFactor, 0.8F, false, 0F, 0.4F, f, f1);
    	    walk(LeftLeg, 0.5F * scaleFactor, 0.5F, true, 1F, 0F, f, f1);
    	    walk(LeftAnkle, 0.5F * scaleFactor, 0.5F, false, 0F, 0F, f, f1);
    	    walk(LeftFoot, 0.5F * scaleFactor, 1.5F, true, 0.5F, 1F, f, f1);
    	    walk(RightThigh, 0.5F * scaleFactor, 0.8F, true, 0F, 0.4F, f, f1);
    	    walk(RightLeg, 0.5F * scaleFactor, 0.5F, false, 1F, 0F, f, f1);
    	    walk(RightAnkle, 0.5F * scaleFactor, 0.5F, true, 0F, 0F, f, f1);
    	    walk(RightFoot, 0.5F * scaleFactor, 1.5F, false, 0.5F, 1F, f, f1);
    	    faceTarget(Head, 2, f3, f4);
    	    MowzieModelRenderer[] tailParts = {this.Tail1, this.Tail2, this.Tail3};
    	    tailSwing(tailParts, 1F * scaleFactor, 0.1F * f1, 2, f);
    }
    public void setAngles() {
         Neck1.setCurrentPoseToInitValues();
         Body.setCurrentPoseToInitValues();
         RightArm.setCurrentPoseToInitValues();
         LeftArm.setCurrentPoseToInitValues();
         RightThigh.setCurrentPoseToInitValues();
         LeftThigh.setCurrentPoseToInitValues();
         Tail1.setCurrentPoseToInitValues();
         Neck2.setCurrentPoseToInitValues();
         Head.setCurrentPoseToInitValues();
         UpperJaw.setCurrentPoseToInitValues();
         LowerJaw.setCurrentPoseToInitValues();
         RightHand.setCurrentPoseToInitValues();
         LeftHand.setCurrentPoseToInitValues();
         RightLeg.setCurrentPoseToInitValues();
         RightAnkle.setCurrentPoseToInitValues();
         RightFoot.setCurrentPoseToInitValues();
         LeftLeg.setCurrentPoseToInitValues();
         LeftAnkle.setCurrentPoseToInitValues();
         LeftFoot.setCurrentPoseToInitValues();
         Tail2.setCurrentPoseToInitValues();
         Tail3.setCurrentPoseToInitValues();
    }
    public void renderModel(float f5)
    {
        setAngles();

      this.RightThigh.render(f5);
      this.LeftThigh.render(f5);
      this.Body.render(f5);
      this.Tail1.render(f5);
      this.Neck1.render(f5);
      this.LeftArm.render(f5);
      this.RightArm.render(f5);
    
    }
    public void animate(IAnimatedEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        animator.update(entity);
        setAngles();
        
    }
    }