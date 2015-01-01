package itsabouttime.common.entities.ai;

import net.minecraft.entity.EntityLiving;
import thehippomaster.AnimationAPI.AIAnimation;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class AIPsittacoGrassEating extends AIAnimation {
	
	public AIPsittacoGrassEating(IAnimatedEntity entity) {
		super(entity);
	}
	
	public int getAnimID() {
		return 60;
	}
	
	public boolean isAutomatic() {
		return true;
	}
	
	public int getDuration() {
		return 85;
	}
	

}