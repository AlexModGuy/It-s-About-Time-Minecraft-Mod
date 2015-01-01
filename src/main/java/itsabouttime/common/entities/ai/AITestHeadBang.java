package itsabouttime.common.entities.ai;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import itsabouttime.common.entities.EntityTest;
import thehippomaster.AnimationAPI.AIAnimation;

public class AITestHeadBang extends AIAnimation {
		
	private EntityTest entityTest;
	private EntityLivingBase attackTarget;
	public AITestHeadBang(EntityTest test) {
		super(test);
		entityTest = test;
		attackTarget = null;
	}
	
	public int getAnimID() {
		return 2;
	}
	public void updateTask() {
		if(entityTest.getAnimTick() < 14)
			entityTest.getLookHelper().setLookPositionWithEntity(attackTarget, 30F, 30F);
		if(entityTest.getAnimTick() == 14 && attackTarget != null)
			attackTarget.attackEntityFrom(DamageSource.causeMobDamage(entityTest), 1);
	}
	public boolean isAutomatic() {
		return true;
	}
	public void startExecuting() {
		//remember to super!
		super.startExecuting();
		attackTarget = entityTest.getAttackTarget();
	}
	public int getDuration() {
		return 30;
	}
}