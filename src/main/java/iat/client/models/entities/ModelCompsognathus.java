package iat.client.models.entities;

import iat.client.models.MowzieModelBase;
import iat.client.models.MowzieModelRenderer;
import iat.entities.mob.EntityCompsognathus;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 * NewCompy.tcn - TechneToTabulaImporter
 * Created using Tabula 4.0.2
 */
public class ModelCompsognathus extends  MowzieModelBase {
	MowzieModelRenderer RightHip;
	MowzieModelRenderer LeftHip;
	MowzieModelRenderer Body;
	MowzieModelRenderer RightLeg;
	MowzieModelRenderer RightAnkle;
	MowzieModelRenderer RightFoot;
	MowzieModelRenderer LeftLeg;
	MowzieModelRenderer LeftAnkle;
	MowzieModelRenderer LeftFoot;
	MowzieModelRenderer Neck1;
	MowzieModelRenderer Tail1;
	MowzieModelRenderer RightArm;
	MowzieModelRenderer LeftArm;
	MowzieModelRenderer Neck2;
	MowzieModelRenderer Head;
	MowzieModelRenderer TopJaw;
	MowzieModelRenderer BottomJaw;
	MowzieModelRenderer Tail2;
	MowzieModelRenderer Tail3;
	MowzieModelRenderer Tail4;
	MowzieModelRenderer RightHand;
	MowzieModelRenderer LeftHand;

	public ModelCompsognathus() {

		this.textureWidth = 64;
		this.textureHeight = 32;
		this.Tail1 = new MowzieModelRenderer(this, 32, 19);
		this.Tail1.setRotationPoint(0.0F, 0.0F, 5.5F);
		this.Tail1.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 5);
		this.LeftAnkle = new MowzieModelRenderer(this, 0, 26);
		this.LeftAnkle.setRotationPoint(-0.1F, 4.6F, 0.2F);
		this.LeftAnkle.addBox(-0.5F, 0.1F, -0.5F, 1, 4, 1);
		this.setRotateAngle(LeftAnkle, -0.8028514559173915F, -0.0F, 0.0F);
		this.Tail4 = new MowzieModelRenderer(this, 10, 26);
		this.Tail4.setRotationPoint(0.0F, 0.0F, 7.0F);
		this.Tail4.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 5);
		this.Tail2 = new MowzieModelRenderer(this, 44, 22);
		this.Tail2.setRotationPoint(0.0F, 0.0F, 5.0F);
		this.Tail2.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 7);
		this.LeftHip = new MowzieModelRenderer(this, 46, 0);
		this.LeftHip.setRotationPoint(2.5F, 13.300000190734863F, 0.20000000298023224F);
		this.LeftHip.addBox(-0.01F, -1.0F, -1.5F, 2, 4, 3);
		this.setRotateAngle(LeftHip, -0.3141592741012573F, -0.0F, 0.0F);
		this.RightLeg = new MowzieModelRenderer(this, 39, 0);
		this.RightLeg.setRotationPoint(-1.0F, 2.3F, -0.6F);
		this.RightLeg.addBox(-0.5F, 0.0F, -1.0F, 1, 5, 2);
		this.setRotateAngle(RightLeg, 0.7155849933176751F, -0.0F, 0.0F);
		this.Neck2 = new MowzieModelRenderer(this, 17, 17);
		this.Neck2.setRotationPoint(0.0F, -0.2F, -4.7F);
		this.Neck2.addBox(-1.0F, -1.3F, -5.0F, 2, 3, 5);
		this.setRotateAngle(Neck2, 0.24434609527920614F, -0.0F, 0.0F);
		this.RightAnkle = new MowzieModelRenderer(this, 0, 26);
		this.RightAnkle.setRotationPoint(0.1F, 4.6F, 0.2F);
		this.RightAnkle.addBox(-0.5F, 0.1F, -0.5F, 1, 4, 1);
		this.setRotateAngle(RightAnkle, -0.8028514559173915F, -0.0F, 0.0F);
		this.RightArm = new MowzieModelRenderer(this, 57, 0);
		this.RightArm.setRotationPoint(-2.5F, -0.5F, -4.0F);
		this.RightArm.addBox(-0.99F, -1.0F, -1.0F, 1, 5, 2);
		this.setRotateAngle(RightArm, 0.4363323129985824F, -0.0F, 0.0F);
		this.BottomJaw = new MowzieModelRenderer(this, 48, 8);
		this.BottomJaw.setRotationPoint(0.0F, 1.0F, -3.5F);
		this.BottomJaw.addBox(-1.0F, -0.5F, -4.0F, 2, 1, 4);
		this.setRotateAngle(BottomJaw, -0.10471975511965977F, -0.0F, 0.0F);
		this.Tail3 = new MowzieModelRenderer(this, 46, 13);
		this.Tail3.setRotationPoint(0.0F, 0.0F, 7.0F);
		this.Tail3.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 7);
		this.LeftFoot = new MowzieModelRenderer(this, 0, 0);
		this.LeftFoot.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.LeftFoot.addBox(-1.0F, -0.14F, -2.6F, 2, 1, 3);
		this.setRotateAngle(LeftFoot, 0.40142572795869574F, -0.0F, 0.0F);
		this.RightHand = new MowzieModelRenderer(this, 5, 26);
		this.RightHand.setRotationPoint(-0.4F, 3.5F, -0.1F);
		this.RightHand.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1);
		this.setRotateAngle(RightHand, -0.8726646259971648F, -0.0F, 0.0F);
		this.RightFoot = new MowzieModelRenderer(this, 0, 0);
		this.RightFoot.setRotationPoint(0.0F, 4.0F, 0.0F);
		this.RightFoot.addBox(-1.0F, -0.14F, -2.6F, 2, 1, 3);
		this.setRotateAngle(RightFoot, 0.40142572795869574F, -0.0F, 0.0F);
		this.TopJaw = new MowzieModelRenderer(this, 33, 9);
		this.TopJaw.setRotationPoint(0.0F, -0.6F, -3.8F);
		this.TopJaw.addBox(-1.5F, -1.0F, -4.0F, 3, 2, 4);
		this.setRotateAngle(TopJaw, 0.10471975511965977F, -0.0F, 0.0F);
		this.LeftArm = new MowzieModelRenderer(this, 57, 0);
		this.LeftArm.setRotationPoint(2.5F, -0.5F, -4.0F);
		this.LeftArm.addBox(0.01F, -1.0F, -1.0F, 1, 5, 2);
		this.setRotateAngle(LeftArm, 0.4363323129985824F, -0.0F, 0.0F);
		this.LeftHand = new MowzieModelRenderer(this, 5, 26);
		this.LeftHand.setRotationPoint(0.4F, 3.5F, -0.1F);
		this.LeftHand.addBox(-0.5F, 0.0F, -0.5F, 1, 4, 1);
		this.setRotateAngle(LeftHand, -0.8726646259971648F, -0.0F, 0.0F);
		this.Head = new MowzieModelRenderer(this, 22, 0);
		this.Head.setRotationPoint(0.0F, 0.2F, -4.1F);
		this.Head.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 4);
		this.setRotateAngle(Head, 0.3141592653589793F, -0.0F, 0.0F);
		this.LeftLeg = new MowzieModelRenderer(this, 39, 0);
		this.LeftLeg.setRotationPoint(1.0F, 2.3F, -0.6F);
		this.LeftLeg.addBox(-0.5F, 0.0F, -1.0F, 1, 5, 2);
		this.setRotateAngle(LeftLeg, 0.7155849933176751F, -0.0F, 0.0F);
		this.Body = new MowzieModelRenderer(this, 0, 0);
		this.Body.setRotationPoint(0.0F, 14.0F, -3.0F);
		this.Body.addBox(-2.5F, -2.5F, -5.5F, 5, 5, 11);
		this.RightHip = new MowzieModelRenderer(this, 46, 0);
		this.RightHip.setRotationPoint(-2.5F, 13.300000190734863F, 0.20000000298023224F);
		this.RightHip.addBox(-2.01F, -1.0F, -1.5F, 2, 4, 3);
		this.setRotateAngle(RightHip, -0.3141592741012573F, -0.0F, 0.0F);
		this.Neck1 = new MowzieModelRenderer(this, 0, 17);
		this.Neck1.setRotationPoint(0.0F, -1.0F, -4.8F);
		this.Neck1.addBox(-1.5F, -1.5F, -5.0F, 3, 3, 5);
		this.setRotateAngle(Neck1, -0.5585053606381855F, -0.0F, 0.0F);

		this.Head.addChild(this.TopJaw);
		this.Head.addChild(this.BottomJaw);
		this.Neck2.addChild(this.Head);
		this.Neck1.addChild(this.Neck2);
		this.Body.addChild(this.Neck1);

		this.RightArm.addChild(this.RightHand);
		this.Body.addChild(this.RightArm);

		this.LeftArm.addChild(this.LeftHand);
		this.Body.addChild(this.LeftArm);

		this.RightAnkle.addChild(this.RightFoot);
		this.LeftLeg.addChild(this.LeftAnkle);
		this.RightHip.addChild(this.RightLeg);

		this.LeftAnkle.addChild(this.LeftFoot);
		this.RightLeg.addChild(this.RightAnkle);
		this.LeftHip.addChild(this.LeftLeg);

		this.Tail3.addChild(this.Tail4);
		this.Tail2.addChild(this.Tail3);
		this.Tail1.addChild(this.Tail2);
		this.Body.addChild(this.Tail1);

		RightHip.setInitValuesToCurrentPose();
		LeftHip.setInitValuesToCurrentPose();
		Body.setInitValuesToCurrentPose();
		RightLeg.setInitValuesToCurrentPose();
		RightAnkle.setInitValuesToCurrentPose();
		RightFoot.setInitValuesToCurrentPose();
		LeftLeg.setInitValuesToCurrentPose();
		LeftAnkle.setInitValuesToCurrentPose();
		LeftFoot.setInitValuesToCurrentPose();
		Neck1.setInitValuesToCurrentPose();
		Tail1.setInitValuesToCurrentPose();
		RightArm.setInitValuesToCurrentPose();
		LeftArm.setInitValuesToCurrentPose();
		Neck2.setInitValuesToCurrentPose();
		Head.setInitValuesToCurrentPose();
		TopJaw.setInitValuesToCurrentPose();
		BottomJaw.setInitValuesToCurrentPose();
		Tail2.setInitValuesToCurrentPose();
		Tail3.setInitValuesToCurrentPose();
		Tail4.setInitValuesToCurrentPose();
		RightHand.setInitValuesToCurrentPose();
		LeftHand.setInitValuesToCurrentPose();
	}
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{

		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		EntityCompsognathus mob = (EntityCompsognathus) entity;
		setAngles();
		if(!mob.isSitting()){
			float scale = 1F;
			float height = 2F * f1;
			walk(LeftHip, 0.5F * scale, 0.8F, false, 0F, 0.4F, f, f1);
			walk(LeftLeg, 0.5F * scale, 0.5F, true, 1F, 0F, f, f1);
			walk(LeftAnkle, 0.5F * scale, 0.5F, false, 0F, 0F, f, f1);
			walk(LeftFoot, 0.5F * scale, 1.5F, true, 0.5F, 1F, f, f1);
			walk(RightHip, 0.5F * scale, 0.8F, true, 0F, 0.4F, f, f1);
			walk(RightLeg, 0.5F * scale, 0.5F, false, 1F, 0F, f, f1);
			walk(RightAnkle, 0.5F * scale, 0.5F, true, 0F, 0F, f, f1);
			walk(RightFoot, 0.5F * scale, 1.5F, false, 0.5F, 1F, f, f1);
			faceTarget(Neck2, 8, f3, f4);
			faceTarget(Head, 4, f3, f4);
			MowzieModelRenderer[] tailParts = {this.Tail1, this.Tail2, this.Tail3, this.Tail4};
			tailSwing(tailParts, 1F * scale, 0.1F * f1, 2, f);
		}else{
			this.setRotateAngle(LeftFoot, 1.2747884856566583F, -0.0F, 0.0F);
			this.setRotateAngle(RightArm, 0.9075712110370513F, -0.0F, 0.0F);
			this.setRotateAngle(TopJaw, 0.10471975511965977F, -0.0F, 0.0F);
			this.setRotateAngle(Tail2, 0.045553093477052F, 0.9560913642424937F, 0.136659280431156F);
			this.setRotateAngle(RightHand, -2.321287905152458F, -0.0F, 0.0F);
			this.setRotateAngle(LeftHip, -0.9075712110370513F, -0.0F, 0.0F);    
			this.setRotateAngle(Tail1, -0.091106186954104F, 0.4150392961242516F, 0.0F);
			this.setRotateAngle(Tail4, 0.0F, 0.9560913642424937F, 0.0F);
			this.setRotateAngle(LeftAnkle, -2.6406831582674206F, -0.0F, 0.0F);
			this.setRotateAngle(LeftHand, -2.321986036853256F, -0.0F, 0.0F);
			this.setRotateAngle(Tail3, 0.36425021489121656F, 0.9105382707654417F, 0.31869712141416456F);
			this.setRotateAngle(BottomJaw, -0.10471975511965977F, -0.0F, 0.0F);
			this.setRotateAngle(RightFoot, 1.2747884856566583F, -0.0F, 0.0F);
			this.setRotateAngle(RightLeg, 2.231054382824351F, -0.0F, 0.0F);
			this.setRotateAngle(LeftArm, 0.9075712110370513F, -0.0F, 0.0F);       
			this.setRotateAngle(Neck1, 0.27314402793711257F, -0.6373942428283291F, 0.0F);
			this.setRotateAngle(RightHip, -0.9075712110370513F, -0.0F, 0.0F);       
			this.setRotateAngle(Head, -0.31869712141416456F, -1.4570008595648662F, 0.5462880558742251F);       
			this.setRotateAngle(LeftLeg, 2.231054382824351F, -0.0F, 0.0F);       
			this.setRotateAngle(Neck2, -0.22759093446006054F, -0.6829473363053812F, 0.0F);
			this.setRotateAngle(RightAnkle, -2.658136450787364F, -0.0F, 0.0F);
			this.LeftLeg.rotationPointY=2.5F;
			this.RightLeg.rotationPointY=2.5F;
		}
	}
	public void renderAmber(float f5){
		this.setRotateAngle(RightHip, -0.9105382707654417F, -0.0F, 0.0F);
		this.setRotateAngle(RightHand, -0.31869712141416456F, -0.0F, 0.0F);
		this.setRotateAngle(Neck2, -0.5462880558742251F, -0.0F, 0.0F);
		this.setRotateAngle(LeftLeg, 1.5481070465189704F, 0.0F, 0.0F);
		this.setRotateAngle(RightLeg, 1.3658946726107624F, -0.0F, 0.0F);
		this.setRotateAngle(LeftFoot, 2.6406831582674206F, -0.0F, 0.0F);
		this.setRotateAngle(RightAnkle, -0.8028514559173915F, -0.0F, 0.0F);
		this.setRotateAngle(LeftHip, -0.6373942428283291F, -0.0F, 0.0F);
		this.setRotateAngle(RightFoot, 2.367539130330308F, -0.0F, 0.0F);
		this.setRotateAngle(Tail1, -0.5009094953223726F, 0.0F, 0.0F);
		this.setRotateAngle(BottomJaw, 0.4553564018453205F, -0.0F, 0.0F);
		this.setRotateAngle(RightArm, -0.31869712141416456F, -0.0F, 0.0F);
		this.setRotateAngle(Head, -1.0016444577195458F, -0.0F, 0.0F);
		this.setRotateAngle(Tail3, -1.0016444577195458F, -0.0F, 0.0F);
		this.setRotateAngle(TopJaw, 0.10471975511965977F, -0.0F, 0.0F);
		this.setRotateAngle(LeftHand, -0.8726646259971648F, -0.0F, 0.0F);
		this.setRotateAngle(LeftAnkle, -0.8028514559173915F, -0.0F, 0.0F);
		this.setRotateAngle(Neck1, -0.9560913642424937F, -0.0F, 0.0F);
		this.setRotateAngle(Tail2, -1.0471975511965976F, -0.0F, 0.0F);
		this.setRotateAngle(LeftArm, 0.4363323129985824F, -0.0F, 0.0F);
		this.setRotateAngle(Tail4, -1.0471975511965976F, -0.0F, 0.0F);
		this.LeftHip.render(f5);
		this.Body.render(f5);
		this.RightHip.render(f5);
	}
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
				this.LeftHip.render(f5);
				this.Body.render(f5);
				this.RightHip.render(f5);
				
	}
	public void setAngles(){
		RightHip.setCurrentPoseToInitValues();
		LeftHip.setCurrentPoseToInitValues();
		Body.setCurrentPoseToInitValues();
		RightLeg.setCurrentPoseToInitValues();
		RightAnkle.setCurrentPoseToInitValues();
		RightFoot.setCurrentPoseToInitValues();
		LeftLeg.setCurrentPoseToInitValues();
		LeftAnkle.setCurrentPoseToInitValues();
		LeftFoot.setCurrentPoseToInitValues();
		Neck1.setCurrentPoseToInitValues();
		Tail1.setCurrentPoseToInitValues();
		RightArm.setCurrentPoseToInitValues();
		LeftArm.setCurrentPoseToInitValues();
		Neck2.setCurrentPoseToInitValues();
		Head.setCurrentPoseToInitValues();
		TopJaw.setCurrentPoseToInitValues();
		BottomJaw.setCurrentPoseToInitValues();
		Tail2.setCurrentPoseToInitValues();
		Tail3.setCurrentPoseToInitValues();
		Tail4.setCurrentPoseToInitValues();
		RightHand.setCurrentPoseToInitValues();
		LeftHand.setCurrentPoseToInitValues();
	}
	public void renderFossil(float f5){
		super.renderFossil(f5);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		this.LeftHip.render(f5);
		this.Body.render(f5);
		this.RightHip.render(f5);
	}
	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(MowzieModelRenderer MowzieModelRenderer, float x, float y, float z) {
		MowzieModelRenderer.rotateAngleX = x;
		MowzieModelRenderer.rotateAngleY = y;
		MowzieModelRenderer.rotateAngleZ = z;
	}

}
