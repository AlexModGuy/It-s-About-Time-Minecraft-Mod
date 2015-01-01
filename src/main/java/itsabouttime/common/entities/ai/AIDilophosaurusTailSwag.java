package itsabouttime.common.entities.ai;

import net.minecraft.entity.EntityLiving;
import thehippomaster.AnimationAPI.AIAnimation;
import thehippomaster.AnimationAPI.IAnimatedEntity;

public class AIDilophosaurusTailSwag extends AIAnimation {
	
	public AIDilophosaurusTailSwag(IAnimatedEntity entity) {
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