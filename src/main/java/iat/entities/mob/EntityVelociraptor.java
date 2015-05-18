package iat.entities.mob;

import iat.entities.EntityIatMob;
import iat.entities.EntityIatWolf;
import iat.entities.ai.MobAIWatchClosestWhenAwake;
import iat.entities.mob.classification.ILandPrehistoricMedium;
import iat.entities.mob.classification.ILandPrehistoricSmall;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityVelociraptor extends EntityIatWolf implements ILandPrehistoricMedium
{

	private boolean field_3;   

    public EntityVelociraptor(World world)
    {
        super(world);
        this.setSize(1F, 0.6F);
        isCarnivore = true;
        minSize = 0.2F;
		maxSize = 1.4F;
		adultAge = 10;
		maxAge = 16;
        this.tasks.addTask(8, new EntityAITempt(this, 1.2D, Items.chicken, false));
        this.tasks.addTask(10, new MobAIWatchClosestWhenAwake(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityChicken.class, 200, false));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityCow.class, 200, false));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntitySheep.class, 200, false));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityCompsognathus.class, 200, false));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityPig.class, 200, false));

        this.setTamed(false);
    }
    @Override
    public boolean hasGenders()
	{
		return true;
	}
    @Override
    public Item getTamingItem() {
		return Items.chicken;
	}
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.370000011920929D);

        if (this.isTamed())
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(45.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D);
        }
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "iat:mob.iat.velociraptor.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "iat:mob.iat.velociraptor.hurt";
    }

    public void updateHealth(boolean isTrue)
    {
        if (isTrue)
        {
            this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
        }
        else
        {
            this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
        }
    }
    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "iat:mob.iat.velociraptor.hurt";
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.05F;
    }

    protected Item getDropItem()
    {
        return Items.bone;
    }
   
    public void setTamed(boolean tame)
    {
        super.setTamed(tame);

        if (tame)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        }
    }
@SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte health)
    {
        if (health == 8)
        {
            this.field_3 = true;
        }
        else
        {
            super.handleHealthUpdate(health);
        }
    }

    public EntityVelociraptor createChild(EntityAgeable mob)
    {
        EntityVelociraptor entitywolf = new EntityVelociraptor(this.worldObj);
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
    //TODO
    @Override
    public boolean canMateWith(EntityAnimal mob)
    {
    	
        if (mob == this)
        {
            return false;
        }
        if( this.getGender() == 0 && ((EntityIatMob) mob).getGender() == 1){
        	return true;
        }if(this.getGender() == 1 && ((EntityIatMob) mob).getGender() == 0){
        	return true;
        }	        
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(mob instanceof EntityVelociraptor))
        {
            return false;
        }
    
        else
        {
            EntityVelociraptor entitywolf = (EntityVelociraptor)mob;
            return !entitywolf.isTamed() ? false : (entitywolf.isSitting() ? false : this.isInLove() && entitywolf.isInLove());
        }
        
    }
}