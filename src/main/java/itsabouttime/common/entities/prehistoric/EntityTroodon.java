package itsabouttime.common.entities.prehistoric;

import java.util.List;

import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import itsabouttime.common.core.IATstuff;
import itsabouttime.common.entities.ai.AIDilophosaurusTailSwag;
import itsabouttime.common.entities.ai.EntityAIPrehistoricBeg;
import itsabouttime.common.entities.ai.EntityAIPrehistoricFollowOwner;
import itsabouttime.common.entities.ai.EntityAIPrehistoricHurtByTarget;
import itsabouttime.common.entities.ai.EntityAIPrehistoricMate;
import itsabouttime.common.entities.ai.EntityAIPrehistoricMobMate;
import itsabouttime.common.entities.ai.EntityAIPrehistoricOwnerHurtTarget;
import itsabouttime.common.entities.ai.EntityAIPrehistoricTargetNonTamed;
import itsabouttime.common.entities.prehistoric.technical.EntityPehistoricAnimal;
import itsabouttime.common.entities.prehistoric.technical.EntityPrehistoricMob;
import itsabouttime.common.entities.prehistoric.technical.EntityTamablePrehistoric;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIBeg;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityTroodon extends EntityTamablePrehistoric implements  IAnimatedEntity
{
    private float field_70926_e;
    private float field_70924_f;
    /** true is the wolf is wet else false */
    private boolean isShaking;
    private boolean field_70928_h;
    /**
     * This time increases while wolf is shaking and emitting water particles.
     */
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;
    /** AI task for player control. */
    private int animID;
    private int animTick;
    public EntityTroodon(World p_i1696_1_)
    {
        super(p_i1696_1_);
        this.setSize(1F, 1.2F);
        animID = 0;
        animTick = 0;		
        this.dataWatcher.addObject(13, Byte.valueOf((byte)0));
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(5, new EntityAIPrehistoricFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(6, new EntityAIPrehistoricMobMate(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.tasks.addTask(10, new EntityAIMoveIndoors(this));
        this.tasks.addTask(11, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(12, new EntityAIAvoidEntity(this, EntityDilophosaurus.class, 8.0F, 0.6D, 0.6D));
        this.targetTasks.addTask(1, new EntityAIPrehistoricOwnerHurtTarget(this));
        this.targetTasks.addTask(2, new EntityAIPrehistoricOwnerHurtTarget(this));
        this.targetTasks.addTask(3, new EntityAIPrehistoricHurtByTarget(this, true));
        this.targetTasks.addTask(4, new EntityAIPrehistoricTargetNonTamed(this, EntitySheep.class, 200, false));
        this.targetTasks.addTask(4, new EntityAIPrehistoricTargetNonTamed(this, EntityChicken.class, 200, false));
        this.targetTasks.addTask(4, new EntityAIPrehistoricTargetNonTamed(this, EntityCow.class, 200, false));
        this.targetTasks.addTask(4, new EntityAIPrehistoricTargetNonTamed(this, EntityOcelot.class, 200, false));
        this.targetTasks.addTask(4, new EntityAIPrehistoricTargetNonTamed(this, EntityPig.class, 200, false));
        this.targetTasks.addTask(4, new EntityAIPrehistoricTargetNonTamed(this, EntityCompy.class, 200, false));
       

        this.setTamed(false);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.300000011920929D);

        if (this.isTamed())
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(36.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0D);
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
     * Sets the active target the Task system uses for tracking
     */
    public void setAttackTarget(EntityLivingBase p_70624_1_)
    {
        super.setAttackTarget(p_70624_1_);

        if (p_70624_1_ == null)
        {
            this.setAngry(false);
        }
        else if (!this.isTamed())
        {
            this.setAngry(true);
        }
    }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
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

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
     //   this.playSound("mob.wolf.step", 0.15F, 1.0F);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setBoolean("Angry", this.isAngry());
        p_70014_1_.setByte("CollarColor", (byte)this.getCollarColor());
        p_70014_1_.setInteger("Type", getType());

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     *///TODO
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
        this.setAngry(p_70037_1_.getBoolean("Angry"));
	      setType(p_70037_1_.getInteger("Type"));

        if (p_70037_1_.hasKey("CollarColor", 99))
        {
            this.setCollarColor(p_70037_1_.getByte("CollarColor"));
        }
    }
    public int getType()
    {
      return this.dataWatcher.getWatchableObjectByte(13);
    }
    public void setType(int i)
    {
      this.dataWatcher.updateObject(13, Byte.valueOf((byte)i));
    }
    public IEntityLivingData onSpawnWithEgg(IEntityLivingData p_110161_1_)
    {
        p_110161_1_ = super.onSpawnWithEgg(p_110161_1_);

        if ( this.getRNG().nextInt(2) > 0)
        {
            this.setType(getRNG().nextInt(2));
        }
		return p_110161_1_;}

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return this.isAngry() ? "iat:Troodon-angry"  : "iat:Troodon-say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "iat:Troodon-hurt";
    }
    public void func_70918_i(boolean p_70918_1_)
    {
        if (p_70918_1_)
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
        return "iat:Troodon-hurt";
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    protected Item getDropItem()
    {
        return Items.feather;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
      /*  if (!this.worldObj.isRemote &&this.worldObj.isRaining()&&this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)))
        {

         int waterchoice=this.rand.nextInt(7);
         if(waterchoice==0){
                Item itemstack = this.getEquipmentInSlot(0).getItem();

                if (itemstack == Items.bucket)
                {
                	this.setCurrentItemOrArmor(0, new ItemStack(Items.water_bucket));
 
                }
            }
        }*/
        
        super.onLivingUpdate();
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
    
    @SideOnly(Side.CLIENT)
    public boolean getWolfShaking()
    {
        return this.isShaking;
    }

    /**
     * Used when calculating the amount of shading to apply while the wolf is shaking.
     */


    @SideOnly(Side.CLIENT)
    public float getShakeAngle(float p_70923_1_, float p_70923_2_)
    {
        float f2 = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * p_70923_1_ + p_70923_2_) / 1.8F;

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        else if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }

        return MathHelper.sin(f2 * (float)Math.PI) * MathHelper.sin(f2 * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
    }

    public float getEyeHeight()
    {
        return this.height * 0.8F;
    }

    @SideOnly(Side.CLIENT)
    public float getInterestedAngle(float p_70917_1_)
    {
        return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * p_70917_1_) * 0.15F * (float)Math.PI;
    }

    /**
     * The speed it takes to move the entityliving's rotationPitch through the faceEntity method. This is only currently
     * use in wolves.
     */
    public int getVerticalFaceSpeed()
    {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            Entity entity = p_70097_1_.getEntity();
            this.aiSit.setSitting(false);

            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
            {
                p_70097_2_ = (p_70097_2_ + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(p_70097_1_, p_70097_2_);
        }
    }

    public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        int i = this.isTamed() ? 4 : 2;
        
        return p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);

    }

    public void setTamed(boolean p_70903_1_)
    {
        super.setTamed(p_70903_1_);

        if (p_70903_1_)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(36.0D);
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0D);
        }
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer p_70085_1_)
    {
        ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();

        if (this.isTamed())
        {
        /*	 if (itemstack != null)
             {
             	this.setCurrentItemOrArmor(0, null);
             	this.dropItem(this.getEquipmentInSlot(0).getItem(), this.getEquipmentInSlot(0).getItemDamage());
             }*/
            if (itemstack != null)
            {
              
                	this.setCurrentItemOrArmor(0, itemstack);
                	System.out.println("Item Set!");

                
                    if (!p_70085_1_.capabilities.isCreativeMode)
                    {
                        --itemstack.stackSize;
                    }

                    if (itemstack.stackSize <= 0)
                    {
                        p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
                    }
            }
                
            else if (this.isTamed()&&this.getEquipmentInSlot(0)== null&&p_70085_1_.isSneaking())
            {
            	p_70085_1_.dropPlayerItemWithRandomChoice(new ItemStack(this.getEquipmentInSlot(0).getItem(), 1,this.getEquipmentInSlot(0).getItemDamage()), false);
            	System.out.println("Has Dropped Item!");

            	this.setCurrentItemOrArmor(0, null);
            }
                if (itemstack.getItem() instanceof ItemFood)
                {
                    ItemFood itemfood = (ItemFood)itemstack.getItem();

                    if (itemfood.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 20.0F)
                    {
                        if (!p_70085_1_.capabilities.isCreativeMode)
                        {
                            --itemstack.stackSize;
                        }

                        this.heal((float)itemfood.func_150905_g(itemstack));

                        if (itemstack.stackSize <= 0)
                        {
                            p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
                        }

                        return true;
                    }
                }
         
            }

            if (this.func_152114_e(p_70085_1_) && !this.worldObj.isRemote && !this.isBreedingItem(itemstack))
            {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.setPathToEntity((PathEntity)null);
                this.setTarget((Entity)null);
                this.setAttackTarget((EntityLivingBase)null);
            }
        
        



        else if (itemstack != null && itemstack.getItem() == IATstuff.GoldenNecklace && !this.isAngry())
        {
            if (!p_70085_1_.capabilities.isCreativeMode)
            {
                --itemstack.stackSize;
            }

            if (itemstack.stackSize <= 0)
            {
                p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack)null);
            }

            if (!this.worldObj.isRemote)
            {
                if (this.rand.nextInt(3) == 0)
                {
                    this.setTamed(true);
                    this.setPathToEntity((PathEntity)null);
                    this.setAttackTarget((EntityLivingBase)null);
                    this.aiSit.setSitting(true);
                    this.setHealth(20.0F);
                    this.func_152115_b(p_70085_1_.getUniqueID().toString());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                }//TODO
                else
                {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }

            return true;
        }
       

        return super.interact(p_70085_1_);
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte p_70103_1_)
    {
        if (p_70103_1_ == 8)
        {
            this.field_70928_h = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        }
        else
        {
            super.handleHealthUpdate(p_70103_1_);
        }
    }
    
    
    
    
    @SideOnly(Side.CLIENT)
    public float getTailRotation()
    {
        return this.isAngry() ? 1.5393804F : (this.isTamed() ? (0.55F - (20.0F - this.dataWatcher.getWatchableObjectFloat(18)) * 0.02F) * (float)Math.PI : ((float)Math.PI / 5F));
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack p_70877_1_)
    {
        return p_70877_1_ == null ? false : (!(p_70877_1_.getItem() instanceof ItemFood) ? false : ((ItemFood)p_70877_1_.getItem()).isWolfsFavoriteMeat());
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
    public void setAngry(boolean p_70916_1_)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (p_70916_1_)
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
    public void setCollarColor(int p_82185_1_)
    {
        this.dataWatcher.updateObject(20, Byte.valueOf((byte)(p_82185_1_ & 15)));
    }

    public EntityTroodon createChild(EntityAgeable p_90011_1_)
    {
        EntityTroodon entitywolf = new EntityTroodon(this.worldObj);
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
    public boolean canMateWith(EntityPrehistoricMob p_70878_1_)
    {
    	
        if (p_70878_1_ == this)
        {
            return false;
        }
       
            if( this.getType() == 0 && ((EntityTroodon) p_70878_1_).getType() == 1 && this.isTamed()&&  ((EntityTroodon) p_70878_1_).isTamed()){
            	return true;
            }if(this.getType() == 1 && ((EntityTroodon) p_70878_1_).getType() == 0 && this.isTamed() &&  ((EntityTroodon) p_70878_1_).isTamed()){
            	return true;
            }
            
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(p_70878_1_ instanceof EntityTroodon))
        {
            return false;
        }
    
        else
        {
            EntityTroodon entitywolf = (EntityTroodon)p_70878_1_;
            return !entitywolf.isTamed() ? false : (entitywolf.isSitting() ? false : this.isInLove() && entitywolf.isInLove());
        }
        
    }

    public boolean func_70922_bv()
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

    public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_)
    {
        if (!(p_142018_1_ instanceof EntityCreeper) && !(p_142018_1_ instanceof EntityGhast))
        {
            if (p_142018_1_ instanceof EntityTroodon)
            {
                EntityTroodon entitywolf = (EntityTroodon)p_142018_1_;

                if (entitywolf.isTamed() && entitywolf.getOwner() == p_142018_2_)
                {
                    return false;
                }
            }

            return p_142018_1_ instanceof EntityPlayer && p_142018_2_ instanceof EntityPlayer && !((EntityPlayer)p_142018_2_).canAttackPlayer((EntityPlayer)p_142018_1_) ? false : !(p_142018_1_ instanceof EntityHorse) || !((EntityHorse)p_142018_1_).isTame();
        }
        else
        {
            return false;
        }
    }
}