package itsabouttime.common.entities.ai;

import net.minecraft.entity.EntityLiving;
import thehippomaster.AnimationAPI.AIAnimation;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class AIMouthSay extends AIAnimation {
	
	public AIMouthSay(IAnimatedEntity entity) {
		super(entity);
	}
	
	public int getAnimID() {
		return 67;
	}
	
	public boolean isAutomatic() {
		return true;
	}
	
	public int getDuration() {
		return 10;
	}
	

}