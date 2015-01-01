package itsabouttime.common.entities.ai;

import net.minecraft.entity.EntityLiving;
import thehippomaster.AnimationAPI.AIAnimation;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class AIBrontoscorpioAttack extends AIAnimation {
	
	public AIBrontoscorpioAttack(IAnimatedEntity entity) {
		super(entity);
	}
	
	public int getAnimID() {
		return 66;
	}
	
	public boolean isAutomatic() {
		return true;
	}
	
	public int getDuration() {
		return 180;
	}
	

}