package itsabouttime.common.entities.prehistoric;

import thehippomaster.AnimationAPI.AnimationAPI;
import thehippomaster.AnimationAPI.IAnimatedEntity;
import itsabouttime.common.entities.ai.AIDilophosaurusTailSwag;
import itsabouttime.common.entities.ai.AIMouthSay;
import itsabouttime.common.entities.ai.EntityAIPrehistoricMate;
import itsabouttime.common.entities.prehistoric.technical.EntityPehistoricAnimal;
import itsabouttime.common.entities.prehistoric.technical.EntityPrehistoricMob;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIControlledByPlayer;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.AchievementList;
import net.minecraft.world.World;

public class EntityCoelophysis extends EntityPrehistoricMob implements  IAnimatedEntity 
{
    /** AI task for player control. */
    private int animID;
    private int animTick;
    public EntityCoelophysis(World p_i1689_1_)
    {
        super(p_i1689_1_);
        this.setSize(1F, 1.2F);
        animID = 0;
        animTick = 0;
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.carrot_on_a_stick, false));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.carrot, false));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAnimal.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));


    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(14.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.37D);
    }




    


    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
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
    

   
    protected String getLivingSound()
    {
    	 if(animID != 0) animTick++;
         if(animID == 0) AnimationAPI.sendAnimPacket(this, 67);

        return "iat:Coelophysis-say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
    	 if(animID != 0) animTick++;
         if(animID == 0) AnimationAPI.sendAnimPacket(this, 67);
        return "iat:Coelophysis-hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
    	 if(animID != 0) animTick++;
         if(animID == 0) AnimationAPI.sendAnimPacket(this, 67);
        return "iat:Coelophysis-death";
    }

   

    

    
    
    




    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float p_70069_1_)
    {
        super.fall(p_70069_1_);

        if (p_70069_1_ > 5.0F && this.riddenByEntity instanceof EntityPlayer)
        {
            ((EntityPlayer)this.riddenByEntity).triggerAchievement(AchievementList.flyPig);
        }
    }

    public EntityCoelophysis createChild(EntityAgeable p_90011_1_)
    {
        return new EntityCoelophysis(this.worldObj);
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack p_70877_1_)
    {
        return p_70877_1_ != null && p_70877_1_.getItem() == Items.rotten_flesh;
    }

    
}