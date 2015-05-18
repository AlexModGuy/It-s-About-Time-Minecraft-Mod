package iat.entities;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityLargeCarnivore extends EntityIatMob{

	public boolean isBreedable;

	public EntityLargeCarnivore(World world) {
		super(world);
		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(11, new EntityAILookIdle(this));
		this.setTamed(false);
	}

	public void writeEntityToNBT(NBTTagCompound tag)
	{
		super.writeEntityToNBT(tag);
		tag.setBoolean("Angry", this.isAngry());
	}

	public void readEntityFromNBT(NBTTagCompound tag)
	{
		super.readEntityFromNBT(tag);
		this.setAngry(tag.getBoolean("Angry"));
	}
	@Override
	public EntityAgeable createChild(EntityAgeable entitiy) {
		return null;
	}

	public boolean isAIEnabled()
	{
		return true;
	}

	/**
	 * Sets the active target the Task system uses for tracking
	 */
	public void setAttackTarget(EntityLivingBase mob)
	{
		super.setAttackTarget(mob);

		if (mob == null)
		{
			this.setAngry(false);
		}
		else if (!this.isTamed())
		{
			this.setAngry(true);
			this.becomeAngryAt(mob);

		}
	}
	private void becomeAngryAt(Entity target)
	{
		this.entityToAttack = target;
	}
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(22, new Byte((byte)0));
	}
	public boolean isAngry()
	{
		return (this.dataWatcher.getWatchableObjectByte(22) & 2) != 0;
	}

	/**
	 * Sets whether this wolf is angry or not.
	 */
	public void setAngry(boolean isAngry)
	{
		byte b0 = this.dataWatcher.getWatchableObjectByte(22);

		if (isAngry)
		{
			this.dataWatcher.updateObject(22, Byte.valueOf((byte)(b0 | 2)));

		}
		else
		{
			this.dataWatcher.updateObject(22, Byte.valueOf((byte)(b0 & -3)));
		}
	}
	@Override
	public boolean canMateWith(EntityAnimal mob)
	{
		if(this.isBreedable && !this.isAngry()){
			return super.canMateWith(mob);
		}else{
			return false;
		}
	}
}
