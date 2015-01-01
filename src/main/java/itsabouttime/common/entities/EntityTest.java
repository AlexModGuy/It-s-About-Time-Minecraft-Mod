package itsabouttime.common.entities;

import itsabouttime.common.entities.ai.AITestHeadBang;
import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityTest extends EntityCreature implements IAnimals, IAnimatedEntity {
	
	private int animID;
	private int animTick;
	
	public EntityTest(World world) {
		super(world);
		this.setSize(0.5F, 1.3F);

		animID = 0;
		animTick = 0;
		tasks.addTask(1, new EntityAISwimming(this));
		tasks.addTask(2, new AITestHeadBang(this));
		tasks.addTask(3, new EntityAIAttackOnCollide(this, 1F, false));
		tasks.addTask(4, new EntityAIWander(this, 0.8F));
		tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8F));
		tasks.addTask(5, new EntityAILookIdle(this));
	}
	
	  protected void applyEntityAttributes()
	  {
	    super.applyEntityAttributes();
	    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);


	  }
	  public boolean interact(EntityPlayer p_70085_1_){
		  if(animID == 0) AnimationAPI.sendAnimPacket(this, 2);
			return true;
	  }
	 
	public boolean isAIEnabled() {
		return true;
	}
	 public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_)
	  {
	      p_110161_1_ = super.onSpawnWithEgg(p_110161_1_);
	      this.setCustomNameTag("_TEST_");
	      if ( this.getRNG().nextInt(2)>0)
	      {
this.playSound("iat:Test-Spawn", 0.15F, 1.0F);
	 
	      }
			return p_110161_1_;}


	 protected String getLivingSound()
	    {
		    return "iat:Test";
		}
	 
	 protected String getHurtSound()
	    {
		    return "iat:Test-Error";
		}
	   protected String getDeathSound()
	    {
	        return "iat:Test-Death";
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
	
	public void onUpdate() {
		super.onUpdate();
		//increment the animTick if there is an animation playing
		if(animID != 0) animTick++;
	}


}