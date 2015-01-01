package itsabouttime.common.entities.prehistoric;

import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import itsabouttime.common.core.IATstuff;
import itsabouttime.common.entities.ai.AIBrontoscorpioAttack;
import itsabouttime.common.entities.ai.EntityAINearestAttackablePisscatoTarget;
import itsabouttime.common.entities.ai.EntityAIPrehistoricMobMate;
import itsabouttime.common.entities.prehistoric.technical.EntityPrehistoricMob;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBrontoscorpio extends EntityPrehistoricMob implements IAnimatedEntity{
    private int animID;
    private int animTick;
	public EntityBrontoscorpio(World par1World) {
		super(par1World);      
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.0D, false));
        this.tasks.addTask(2, new EntityAIPrehistoricMobMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, IATstuff.MyFood1, false));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new AIBrontoscorpioAttack(this));
		this.targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true, ISmallWaterCritter.mobSelector));
		this.targetTasks.addTask(10, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	 public boolean isAIEnabled()
	    {
	        return true;
	    }
	 public boolean canBreatheUnderwater()
	    {
	        return true;
	    }
	 public boolean attackEntityAsMob(Entity p_70652_1_)
	    {
		 if(animID == 0) AnimationAPI.sendAnimPacket(this, 66);	        

return super.attackEntityAsMob(p_70652_1_);
}
	  public void onUpdate(){
		  super.onUpdate();
		  if(animID != 0) animTick++;

		  }
	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * Implemented method from IAnimatedEntity.
	 * Set the animID field to the id in the parameter.
	 */
	public void setAnimID(int id) {
		animID = id;
	}
	
	/*
	 * Implemented method from IAnimatedEntity.
	 * Set the animTick field to the tick in the parameter.
	 */
	public void setAnimTick(int tick) {
		animTick = tick;
	}
	
	/*
	 * Implemented method from IAnimatedEntity.
	 * Return the animID.
	 */
	public int getAnimID() {
		return animID;
	}
	
	/*
	 * Implemented method from IAnimatedEntity.
	 * Return the animTick.
	 */
	public int getAnimTick() {
		return animTick;
	}
}