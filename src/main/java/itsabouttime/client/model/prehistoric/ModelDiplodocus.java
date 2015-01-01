package itsabouttime.client.model.prehistoric;

import org.lwjgl.opengl.GL11;

import itsabouttime.client.model.prehistoric.technical.MowzieModelBaseIAT;
import itsabouttime.client.model.prehistoric.technical.MowzieModelRenderer2;
import itsabouttime.common.entities.prehistoric.EntityDilophosaurus;
import itsabouttime.common.entities.prehistoric.EntityDiplodocus;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

/**
 * Diploudicus.tcn - TechneToTabulaImporter
 * Created using Tabula 4.0.2
 */
public class ModelDiplodocus extends MowzieModelBaseIAT {
    public MowzieModelRenderer2 RightHand;
    public MowzieModelRenderer2 RightWrist;
    public MowzieModelRenderer2 RightArm;
    public MowzieModelRenderer2 RightShoulder;
    public MowzieModelRenderer2 Body;
    public MowzieModelRenderer2 LeftShoulder;
    public MowzieModelRenderer2 LeftArm;
    public MowzieModelRenderer2 LeftWrist;
    public MowzieModelRenderer2 LeftHand;
    public MowzieModelRenderer2 RightHip;
    public MowzieModelRenderer2 RightLeg;
    public MowzieModelRenderer2 RightAnkle;
    public MowzieModelRenderer2 RightFoot;
    public MowzieModelRenderer2 LeftHip;
    public MowzieModelRenderer2 LeftLeg;
    public MowzieModelRenderer2 LeftAnkle;
    public MowzieModelRenderer2 LeftFoot;
    public MowzieModelRenderer2 Tail1;
    public MowzieModelRenderer2 Tail2;
    public MowzieModelRenderer2 Tail3;
    public MowzieModelRenderer2 Tail4;
    public MowzieModelRenderer2 Tail5;
    public MowzieModelRenderer2 Neck1;
    public MowzieModelRenderer2 Neck2;
    public MowzieModelRenderer2 Neck3;
    public MowzieModelRenderer2 Neck4;
    public MowzieModelRenderer2 Neck5;
    public MowzieModelRenderer2 Head;
    public MowzieModelRenderer2 UpperJaw;
    public MowzieModelRenderer2 LowerJaw;

    public ModelDiplodocus() {
        this.textureWidth = 128;
        this.textureHeight = 256;
        this.LeftHip = new MowzieModelRenderer2(this, 0, 0);
        this.LeftHip.setRotationPoint(6.5F, -3.0F, 25.0F);
        this.LeftHip.addBox(0.0F, -3.0F, -3.5F, 6, 11, 8);
        this.setRotateAngle(LeftHip, 0.1047197580337524F, -0.0F, 0.0F);
        this.RightAnkle = new MowzieModelRenderer2(this, 21, 20);
        this.RightAnkle.setRotationPoint(0.0F, 8.8F, -0.7F);
        this.RightAnkle.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
        this.setRotateAngle(RightAnkle, 0.593411945678072F, -0.0F, 0.0F);
        this.Neck1 = new MowzieModelRenderer2(this, 0, 59);
        this.Neck1.setRotationPoint(0.0F, 0.0F, -20.0F);
        this.Neck1.addBox(-6.0F, -6.0F, -16.0F, 12, 12, 16);
        this.LeftShoulder = new MowzieModelRenderer2(this, 0, 202);
        this.LeftShoulder.setRotationPoint(6.5F, -2.799999952316284F, 0.0F);
        this.LeftShoulder.addBox(0.0F, -3.0F, -3.5F, 6, 10, 7);
        this.setRotateAngle(LeftShoulder, -0.12217304855585097F, -0.0F, 0.0F);
        this.LowerJaw = new MowzieModelRenderer2(this, 19, 193);
        this.LowerJaw.setRotationPoint(0.0F, 1.5F, -4.8F);
        this.LowerJaw.addBox(-2.0F, -0.5F, -4.0F, 4, 1, 4);
        this.setRotateAngle(LowerJaw, 0.13962634015954636F, -0.0F, 0.0F);
        this.Tail2 = new MowzieModelRenderer2(this, 57, 95);
        this.Tail2.setRotationPoint(0.0F, 0.5F, 22.0F);
        this.Tail2.addBox(-4.0F, -5.0F, 0.0F, 8, 11, 23);
        this.LeftHand = new MowzieModelRenderer2(this, 17, 237);
        this.LeftHand.setRotationPoint(0.0F, 8.2F, 0.0F);
        this.LeftHand.addBox(-2.5F, 0.0F, -2.5F, 5, 4, 5);
        this.setRotateAngle(LeftHand, 0.3141592653589793F, -0.0F, 0.0F);
        this.RightWrist = new MowzieModelRenderer2(this, 0, 237);
        this.RightWrist.setRotationPoint(0.0F, 9.8F, 0.7F);
        this.RightWrist.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
        this.setRotateAngle(RightWrist, -0.593411945678072F, -0.0F, 0.0F);
        this.LeftWrist = new MowzieModelRenderer2(this, 0, 237);
        this.LeftWrist.setRotationPoint(0.0F, 9.8F, 0.7F);
        this.LeftWrist.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
        this.setRotateAngle(LeftWrist, -0.593411945678072F, -0.0F, 0.0F);
        this.Tail3 = new MowzieModelRenderer2(this, 57, 130);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 23.0F);
        this.Tail3.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 23);
        this.Neck5 = new MowzieModelRenderer2(this, 0, 163);
        this.Neck5.setRotationPoint(0.0F, -0.0F, -15.0F);
        this.Neck5.addBox(-1.5F, -2.0F, -13.0F, 3, 5, 13);
        this.Head = new MowzieModelRenderer2(this, 0, 182);
        this.Head.setRotationPoint(0.0F, 0.5F, -13.0F);
        this.Head.addBox(-2.5F, -2.5F, -5.0F, 5, 5, 5);
        this.RightArm = new MowzieModelRenderer2(this, 0, 220);
        this.RightArm.setRotationPoint(-3.0F, 5.9F, -0.4F);
        this.RightArm.addBox(-2.5F, 0.0F, -2.5F, 5, 11, 5);
        this.setRotateAngle(RightArm, 0.41887902047863906F, -0.0F, 0.0F);
        this.Neck3 = new MowzieModelRenderer2(this, 0, 115);
        this.Neck3.setRotationPoint(0.0F, -0.5F, -16.0F);
        this.Neck3.addBox(-4.0F, -4.0F, -16.0F, 8, 8, 16);
        this.RightHand = new MowzieModelRenderer2(this, 38, 237);
        this.RightHand.setRotationPoint(0.0F, 8.2F, 0.0F);
        this.RightHand.addBox(-2.5F, 0.0F, -2.5F, 5, 4, 5);
        this.setRotateAngle(RightHand, 0.3141592653589793F, -0.0F, 0.0F);
        this.Tail5 = new MowzieModelRenderer2(this, 57, 193);
        this.Tail5.setRotationPoint(0.0F, 0.0F, 26.0F);
        this.Tail5.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 26);
        this.UpperJaw = new MowzieModelRenderer2(this, 0, 193);
        this.UpperJaw.setRotationPoint(0.0F, -0.5F, -4.6F);
        this.UpperJaw.addBox(-2.0F, -1.5F, -5.0F, 4, 3, 5);
        this.setRotateAngle(UpperJaw, 0.12217304763960307F, -0.0F, 0.0F);
        this.Tail4 = new MowzieModelRenderer2(this, 57, 161);
        this.Tail4.setRotationPoint(0.0F, 0.0F, 23.0F);
        this.Tail4.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 26);
        this.Tail1 = new MowzieModelRenderer2(this, 57, 59);
        this.Tail1.setRotationPoint(0.0F, -0.5F, 20.0F);
        this.Tail1.addBox(-5.0F, -5.0F, 0.0F, 10, 13, 22);
        this.RightFoot = new MowzieModelRenderer2(this, 68, 0);
        this.RightFoot.setRotationPoint(0.0F, 8.4F, 0.0F);
        this.RightFoot.addBox(-2.5F, 0.0F, -2.5F, 5, 4, 5);
        this.setRotateAngle(RightFoot, -0.296705972839036F, -0.0F, 0.0F);
        this.Neck2 = new MowzieModelRenderer2(this, 0, 88);
        this.Neck2.setRotationPoint(0.0F, -0.5F, -16.0F);
        this.Neck2.addBox(-5.0F, -5.0F, -16.0F, 10, 10, 16);
        this.LeftAnkle = new MowzieModelRenderer2(this, 21, 20);
        this.LeftAnkle.setRotationPoint(0.0F, 8.8F, -0.7F);
        this.LeftAnkle.addBox(-2.0F, 0.0F, -2.0F, 4, 9, 4);
        this.setRotateAngle(LeftAnkle, 0.593411945678072F, -0.0F, 0.0F);
        this.RightHip = new MowzieModelRenderer2(this, 0, 0);
        this.RightHip.setRotationPoint(-6.5F, -3.0F, 25.0F);
        this.RightHip.addBox(-6.0F, -3.0F, -3.5F, 6, 11, 8);
        this.setRotateAngle(RightHip, 0.1047197580337524F, -0.0F, 0.0F);
        this.LeftLeg = new MowzieModelRenderer2(this, 0, 20);
        this.LeftLeg.setRotationPoint(3.0F, 7.0F, 0.9F);
        this.LeftLeg.addBox(-2.5F, 0.0F, -2.5F, 5, 10, 5);
        this.setRotateAngle(LeftLeg, -0.41887902047863906F, -0.0F, 0.0F);
        this.Body = new MowzieModelRenderer2(this, 0, 0);
        this.Body.setRotationPoint(0.0F, -2.0F, 12.0F);
        this.Body.addBox(-6.5F, -6.5F, -20.0F, 13, 18, 40);
        this.LeftFoot = new MowzieModelRenderer2(this, 68, 0);
        this.LeftFoot.setRotationPoint(0.0F, 8.4F, 0.0F);
        this.LeftFoot.addBox(-2.5F, 0.0F, -2.5F, 5, 4, 5);
        this.setRotateAngle(LeftFoot, -0.296705972839036F, -0.0F, 0.0F);
        this.RightShoulder = new MowzieModelRenderer2(this, 0, 202);
        this.RightShoulder.setRotationPoint(-6.5F, -2.799999952316284F, 0.0F);
        this.RightShoulder.addBox(-6.0F, -3.0F, -3.5F, 6, 10, 7);
        this.setRotateAngle(RightShoulder, -0.12217304855585097F, -0.0F, 0.0F);
        this.RightLeg = new MowzieModelRenderer2(this, 0, 20);
        this.RightLeg.setRotationPoint(-3.0F, 7.0F, 0.9F);
        this.RightLeg.addBox(-2.5F, 0.0F, -2.5F, 5, 10, 5);
        this.setRotateAngle(RightLeg, -0.41887902047863906F, -0.0F, 0.0F);
        this.LeftArm = new MowzieModelRenderer2(this, 0, 220);
        this.LeftArm.setRotationPoint(3.0F, 5.9F, -0.4F);
        this.LeftArm.addBox(-2.5F, 0.0F, -2.5F, 5, 11, 5);
        this.setRotateAngle(LeftArm, 0.41887902047863906F, -0.0F, 0.0F);
        this.Neck4 = new MowzieModelRenderer2(this, 0, 140);
        this.Neck4.setRotationPoint(0.0F, -1.0F, -16.0F);
        this.Neck4.addBox(-2.5F, -2.5F, -15.0F, 5, 7, 15);
        
        this.Head.addChild(this.LowerJaw);
        this.Head.addChild(this.UpperJaw);
        this.Neck5.addChild(this.Head);
        this.Neck4.addChild(this.Neck5);
        this.Neck3.addChild(this.Neck4);
        this.Neck2.addChild(this.Neck3);
        this.Neck1.addChild(this.Neck2);
        this.Body.addChild(this.Neck1);
        this.LeftWrist.addChild(LeftHand);
        this.LeftArm.addChild(LeftWrist);
        this.LeftShoulder.addChild(LeftArm);
        this.RightWrist.addChild(RightHand);
        this.RightArm.addChild(RightWrist);
        this.RightShoulder.addChild(RightArm);
        this.LeftAnkle.addChild(LeftFoot);
        this.LeftLeg.addChild(LeftAnkle);
        this.LeftHip.addChild(LeftLeg);
        this.RightAnkle.addChild(RightFoot);
        this.RightLeg.addChild(RightAnkle);
        this.RightHip.addChild(RightLeg);
        this.Tail4.addChild(Tail5);
        this.Tail3.addChild(Tail4);
        this.Tail2.addChild(Tail3);
        this.Tail1.addChild(Tail2);
        this.Body.addChild(Tail1);

 RightHand.setInitValuesToCurrentPose();
 RightWrist.setInitValuesToCurrentPose();
 RightArm.setInitValuesToCurrentPose();
 RightShoulder.setInitValuesToCurrentPose();
 Body.setInitValuesToCurrentPose();
 LeftShoulder.setInitValuesToCurrentPose();
 LeftArm.setInitValuesToCurrentPose();
 LeftWrist.setInitValuesToCurrentPose();
 LeftHand.setInitValuesToCurrentPose();
 RightHip.setInitValuesToCurrentPose();
 RightLeg.setInitValuesToCurrentPose();
 RightAnkle.setInitValuesToCurrentPose();
 RightFoot.setInitValuesToCurrentPose();
 LeftHip.setInitValuesToCurrentPose();
 LeftLeg.setInitValuesToCurrentPose();
 LeftAnkle.setInitValuesToCurrentPose();
 LeftFoot.setInitValuesToCurrentPose();
 Tail1.setInitValuesToCurrentPose();
 Tail2.setInitValuesToCurrentPose();
 Tail3.setInitValuesToCurrentPose();
 Tail4.setInitValuesToCurrentPose();
 Tail5.setInitValuesToCurrentPose();
 Neck1.setInitValuesToCurrentPose();
 Neck2.setInitValuesToCurrentPose();
 Neck3.setInitValuesToCurrentPose();
 Neck4.setInitValuesToCurrentPose();
 Neck5.setInitValuesToCurrentPose();
 Head.setInitValuesToCurrentPose();
 UpperJaw.setInitValuesToCurrentPose();
 LowerJaw.setInitValuesToCurrentPose();
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (this.isChild)
        {
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glScalef(1F / f6, 1F / f6,1F / f6);
            GL11.glTranslatef(0.0F, 24.0F * f5 , 0.0F);
        this.RightShoulder.render(f5);
        this.LeftHip.render(f5);
        this.LeftShoulder.render(f5);
        this.Body.render(f5);
        this.RightHip.render(f5);
        GL11.glPopMatrix();}else{
            this.RightShoulder.render(f5);
            this.LeftHip.render(f5);
            this.LeftShoulder.render(f5);
            this.Body.render(f5);
            this.RightHip.render(f5);	
        }

    }
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        EntityDiplodocus dilo = (EntityDiplodocus) entity;
        setAngles();
        float scaleFactor = 0.77F;
        float height = 2F * f1;
        bob(Body, 1F * scaleFactor, height, false, f, f1);
        bob(LeftHip, 1F * scaleFactor, height, false, f, f1);
        bob(RightHip, 1F * scaleFactor, height, false, f, f1);
        bob(Neck1, 1F * scaleFactor, height / 2, false, f, f1);
        walk(Neck2, 1F * scaleFactor, 0.25F, false, 1F, 0.1F, f, f1);
        walk(Head, 1F * scaleFactor, 0.25F, true, 1F, -0.1F, f, f1);
        walk(Body, 1F * scaleFactor, 0.1F, true, 0F, 0.07F, f, f1);
        walk(LeftHip, 0.5F * scaleFactor, 0.8F, false, 0F, 0.4F, f, f1);
        walk(LeftLeg, 0.5F * scaleFactor, 0.5F, true, 1F, 0F, f, f1);
        walk(LeftAnkle, 0.5F * scaleFactor, 0.5F, false, 0F, 0F, f, f1);
        walk(LeftFoot, 0.5F * scaleFactor, 1.5F, true, 0.5F, 1F, f, f1);
        walk(RightHip, 0.5F * scaleFactor, 0.8F, true, 0F, 0.4F, f, f1);
        walk(RightLeg, 0.5F * scaleFactor, 0.5F, false, 1F, 0F, f, f1);
        walk(RightAnkle, 0.5F * scaleFactor, 0.5F, true, 0F, 0F, f, f1);
        walk(RightFoot, 0.5F * scaleFactor, 1.5F, false, 0.5F, 1F, f, f1);
        walk(RightShoulder, 0.5F * scaleFactor, 0.8F, false, 0F, 0.4F, f, f1);
        walk(RightArm, 0.5F * scaleFactor, 0.5F, true, 1F, 0F, f, f1);
        walk(RightWrist, 0.5F * scaleFactor, 0.5F, false, 0F, 0F, f, f1);
        walk(RightHand, 0.5F * scaleFactor, 1.5F, true, 0.5F, 1F, f, f1);
        walk(LeftShoulder, 0.5F * scaleFactor, 0.8F, true, 0F, 0.4F, f, f1);
        walk(LeftArm, 0.5F * scaleFactor, 0.5F, false, 1F, 0F, f, f1);
        walk(LeftShoulder, 0.5F * scaleFactor, 0.5F, true, 0F, 0F, f, f1);
        walk(RightHand, 0.5F * scaleFactor, 1.5F, false, 0.5F, 1F, f, f1);
        faceTarget(Head, 2, f3, f4);
        faceTarget(Neck5, 2, f3, f4);
        faceTarget(Neck4, 2, f3, f4);
        faceTarget(Neck3, 2, f3, f4);
        MowzieModelRenderer2[] tailParts = {this.Tail5, this.Tail4, this.Tail3, this.Tail2, this.Tail1};
        tailSwing(tailParts, 0.5F * scaleFactor, -0.1F * f1, 2, f);
        chainWave(tailParts, 1F * scaleFactor, -0.03F, 2, f, f1);
        //Idling
        chainWave(tailParts, 0.1F, -0.05F, 2, dilo.frame, 1F);
        walk(Neck1, 0.01F, 0.05F, false, -1F, 0F, dilo.frame, 1F);
        walk(Neck2, 0.01F, 0.01F, false, -1F, 0F, dilo.frame, 1F);
        walk(Neck3, 0.01F, 0.01F, false, -1F, 0F, dilo.frame, 1F);
        walk(Neck4, 0.01F, 0.005F, false, -1F, 0F, dilo.frame, 1F);
        walk(Head, 0.01F, 0.001F, true, 0F, 0F, dilo.frame, 1F);
        walk(Body, 0.05F, 0.05F, false, 0F, 0F, dilo.frame, 1F);
 }
public void setAngles(){
	 RightHand.setCurrentPoseToInitValues();
	 RightWrist.setCurrentPoseToInitValues();
	 RightArm.setCurrentPoseToInitValues();
	 RightShoulder.setCurrentPoseToInitValues();
	 Body.setCurrentPoseToInitValues();
	 LeftShoulder.setCurrentPoseToInitValues();
	 LeftArm.setCurrentPoseToInitValues();
	 LeftWrist.setCurrentPoseToInitValues();
	 LeftHand.setCurrentPoseToInitValues();
	 RightHip.setCurrentPoseToInitValues();
	 RightLeg.setCurrentPoseToInitValues();
	 RightAnkle.setCurrentPoseToInitValues();
	 RightFoot.setCurrentPoseToInitValues();
	 LeftHip.setCurrentPoseToInitValues();
	 LeftLeg.setCurrentPoseToInitValues();
	 LeftAnkle.setCurrentPoseToInitValues();
	 LeftFoot.setCurrentPoseToInitValues();
	 Tail1.setCurrentPoseToInitValues();
	 Tail2.setCurrentPoseToInitValues();
	 Tail3.setCurrentPoseToInitValues();
	 Tail4.setCurrentPoseToInitValues();
	 Tail5.setCurrentPoseToInitValues();
	 Neck1.setCurrentPoseToInitValues();
	 Neck2.setCurrentPoseToInitValues();
	 Neck3.setCurrentPoseToInitValues();
	 Neck4.setCurrentPoseToInitValues();
	 Neck5.setCurrentPoseToInitValues();
	 Head.setCurrentPoseToInitValues();
	 UpperJaw.setCurrentPoseToInitValues();
	 LowerJaw.setCurrentPoseToInitValues();
}
    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(MowzieModelRenderer2 MowzieModelRenderer2, float x, float y, float z) {
        MowzieModelRenderer2.rotateAngleX = x;
        MowzieModelRenderer2.rotateAngleY = y;
        MowzieModelRenderer2.rotateAngleZ = z;
    }
}
