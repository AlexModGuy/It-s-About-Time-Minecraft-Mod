package iat.entities;

import java.util.List;

import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;



public class EntityIatWolf extends EntityIatMob{

	private float field_1;
	private float field_2;
	private boolean field_3;   
	public boolean isCarnivore;
	public EntityIatWolf(World world) {
		super(world);

		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, aiSit);        
		this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(5, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
		this.tasks.addTask(6, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(11, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(2, new EntityAIOwnerHurtTarget(this));
		this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true));
		this.setTamed(false);
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

	protected void updateAITick()
	{
		this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(18, new Float(this.getHealth()));
		this.dataWatcher.addObject(19, new Byte((byte)0));
		this.dataWatcher.addObject(20, new Byte((byte)BlockColored.func_150032_b(1)));
	}



	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound tag)
	{
		super.writeEntityToNBT(tag);
		tag.setBoolean("Angry", this.isAngry());
		tag.setByte("CollarColor", (byte)this.getCollarColor());
	}

	public void readEntityFromNBT(NBTTagCompound tag)
	{
		super.readEntityFromNBT(tag);
		this.setAngry(tag.getBoolean("Angry"));

		if (tag.hasKey("CollarColor", 99))
		{
			this.setCollarColor(tag.getByte("CollarColor"));
		}
	}
	public void onUpdate()
	{
		frame++;
		super.onUpdate();
		this.field_2 = this.field_1;

		if (this.getThing())
		{
			this.field_1 += (1.0F - this.field_1) * 0.4F;
		}
		else
		{
			this.field_1 += (0.0F - this.field_1) * 0.4F;
		}

		if (this.getThing())
		{
			this.numTicksToChaseTarget = 10;
		}


	}
	/**
	 * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
	 * use in wolves.
	 */
	public int getVerticalFaceSpeed()
	{
		return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
	}



	public boolean attackEntityAsMob(Entity mob)
	{
		int i = this.isTamed() ? 4 : 2;

		return mob.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);

	}

	public boolean interact(EntityPlayer player)
	{
		ItemStack itemstack = player.inventory.getCurrentItem();
		if(this.isSitting()){
			this.aiSit.setSitting(!this.isSitting());
		}
		if (this.isTamed())
		{
			if (itemstack != null)
			{

				if (!player.capabilities.isCreativeMode)
				{
					--itemstack.stackSize;
				}
				if (itemstack.getItem() instanceof ItemFood)
				{
					ItemFood itemfood = (ItemFood)itemstack.getItem();

					if ( this.dataWatcher.getWatchableObjectFloat(18) < 20.0F)
					{
						if(isCarnivore){
							this.destroyItemIfPossible(player);
							this.heal((float)itemfood.func_150905_g(itemstack));
							return true;
						}
					}
				}
				else if (itemstack.getItem() == Items.dye)
				{
					int i = BlockColored.func_150032_b(itemstack.getItemDamage());

					if (i != this.getCollarColor())
					{
						this.setCollarColor(i);
						this.destroyItemIfPossible(player);
						return true;
					}
				}

			}


			if (this.func_152114_e(player) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack))
			{
				this.aiSit.setSitting(!this.isSitting());
				this.isJumping = false;
				this.setPathToEntity((PathEntity)null);
				this.setTarget((Entity)null);
				this.setAttackTarget((EntityLivingBase)null);
			}
		}
		else if (itemstack != null && itemstack.getItem() instanceof ItemFood && !this.isAngry()||itemstack != null && itemstack.getItem() == this.getTamingItem() && !this.isAngry())
		{
			this.destroyItemIfPossible(player);

			if (!this.worldObj.isRemote)
			{
				if (this.rand.nextInt(3) == 0)
				{
					this.setTamed(true);
					this.setPathToEntity((PathEntity)null);
					this.setAttackTarget((EntityLivingBase)null);
					this.aiSit.setSitting(true);
					this.setHealth(20.0F);
					this.func_152115_b(player.getUniqueID().toString());
					this.playTameEffect(true);
					this.worldObj.setEntityState(this, (byte)7);
				}
				else
				{
					this.playTameEffect(false);
					this.worldObj.setEntityState(this, (byte)6);
				}
			}

			return true;
		}

		return super.interact(player);
	}
	public Item getTamingItem() {
		return Items.bone;
	}
	public boolean isBreedingItem(ItemStack stack)
    {
		if(isCarnivore){
	        return stack == null ? false : (!(stack.getItem() instanceof ItemFood) ? false : ((ItemFood)stack.getItem()).isWolfsFavoriteMeat());

		}else{
			if(stack != null){
				if(stack.getItem() != null){
					if(stack.getItem() == this.getHerbivoreItem()){
						return true;
					}
				}
			}
		}
		return false;
    }
	/**returns an Item if this is an herbivore.*/
    public Item getHerbivoreItem() {
		return Items.wheat;
	}

	/**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 8;
    }

    /**
     * Determines whether this wolf is angry or not.
     */
    public boolean isAngry()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }

    /**
     * Sets whether this wolf is angry or not.
     */
    public void setAngry(boolean isAngry)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (isAngry)
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 2)));

        }
        else
        {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
        }
    }
   
    /**
     * Return this wolf's collar color.
     */
    public int getCollarColor()
    {
        return this.dataWatcher.getWatchableObjectByte(20) & 15;
    }

    /**
     * Set this wolf's collar color.
     */
    public void setCollarColor(int collorOfCollar)
    {
        this.dataWatcher.updateObject(20, Byte.valueOf((byte)(collorOfCollar & 15)));
    }

    public EntityIatWolf createChild(EntityAgeable mob)
    {
        EntityIatWolf entitywolf = new EntityIatWolf(this.worldObj);
        String s = this.func_152113_b();

        if (s != null && s.trim().length() > 0)
        {
            entitywolf.func_152115_b(s);
            entitywolf.setTamed(true);
        }

        return entitywolf;
    }

  

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    @Override
    public boolean canMateWith(EntityAnimal mob)
    {
    	
        if (mob == this)
        {
            return false;
        }
       
            
            
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(mob instanceof EntityIatWolf))
        {
            return false;
        }
    
        else
        {
            EntityIatWolf entitywolf = (EntityIatWolf)mob;
            return !entitywolf.isTamed() ? false : (entitywolf.isSitting() ? false : this.isInLove() && entitywolf.isInLove());
        }
        
    }

    public boolean getThing()
    {
        return this.dataWatcher.getWatchableObjectByte(19) == 1;
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return !this.isTamed() && this.ticksExisted > 2400;
    }

    public boolean canTargetCreature(EntityLivingBase targetMob, EntityLivingBase thisMob)
    {
        if (!(targetMob instanceof EntityCreeper) && !(targetMob instanceof EntityGhast))
        {
            if (targetMob instanceof EntityIatWolf)
            {
                EntityIatWolf entitywolf = (EntityIatWolf)targetMob;

                if (entitywolf.isTamed() && entitywolf.getOwner() == thisMob)
                {
                    return false;
                }
            }

            return targetMob instanceof EntityPlayer && thisMob instanceof EntityPlayer && !((EntityPlayer)thisMob).canAttackPlayer((EntityPlayer)targetMob) ? false : !(targetMob instanceof EntityHorse) || !((EntityHorse)targetMob).isTame();
        }
        else
        {
            return false;
        }
    }
    public boolean attackEntityFrom(DamageSource damage, float strength)
    {
    

     
        
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            Entity entity = damage.getEntity();
            this.aiSit.setSitting(false);

            if (entity  instanceof EntityLiving && !this.isTamed())
            {
                List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0D, 32.0D, 32.0D));

                for (int i = 0; i < list.size(); ++i)
                {
                    Entity entity1 = (Entity)list.get(i);

                    if (entity1 instanceof EntityIatWolf)
                    {
                    	EntityIatWolf entitypigzombie = (EntityIatWolf)entity1;
                        entitypigzombie.becomeAngryAt(entity);
                    }
                }

                this.becomeAngryAt(entity);
            }

            return super.attackEntityFrom(damage, strength);
        }
    }
    private void becomeAngryAt(Entity target)
    {
        this.entityToAttack = target;
    }
    /**
     * PigZombie GroupData
     */
    class GroupData implements IEntityLivingData
    {
        public boolean field_142048_a;
        public boolean field_142046_b;

        private GroupData(boolean p_i2348_2_, boolean p_i2348_3_)
        {
            this.field_142048_a = false;
            this.field_142046_b = false;
            this.field_142048_a = p_i2348_2_;
            this.field_142046_b = p_i2348_3_;
        }

        GroupData(boolean p_i2349_2_, boolean p_i2349_3_, Object p_i2349_4_)
        {
            this(p_i2349_2_, p_i2349_3_);
        }
    }
}
