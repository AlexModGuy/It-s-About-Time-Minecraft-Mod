package iat.entities.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;

public class MobAIWatchClosestWhenAwake extends EntityAIBase
{
    private EntityTameable theWatcher;
    /** The closest entity which is being watched by this one. */
    protected Entity closestEntity;
    /** This is the Maximum distance that the AI will look for the Entity */
    private float maxDistanceForPlayer;
    private int lookTime;
    private float randomWatchChance;
    private Class watchedClass;
    private static final String __OBFID = "CL_00001592";

    public MobAIWatchClosestWhenAwake(EntityTameable mob, Class mobThatIsWatched, float watchDistance)
    {
        this.theWatcher = mob;
        this.watchedClass = mobThatIsWatched;
        this.maxDistanceForPlayer = watchDistance;
        this.randomWatchChance = 0.02F;
        this.setMutexBits(2);
    }

    public MobAIWatchClosestWhenAwake(EntityTameable mob, Class watchedClass, float watchDistance, float chanceOfWatch)
    {
        this.theWatcher = mob;
        this.watchedClass = watchedClass;
        this.maxDistanceForPlayer = watchDistance;
        this.randomWatchChance = chanceOfWatch;
        this.setMutexBits(2);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.theWatcher.getRNG().nextFloat() >= this.randomWatchChance)
        {
            return false;
        }
        else
        {
            if (this.theWatcher.getAttackTarget() != null)
            {
                this.closestEntity = this.theWatcher.getAttackTarget();
            }
            if (this.theWatcher.isSitting())
            {
                return false;
            }
            if (this.watchedClass == EntityPlayer.class)
            {
                this.closestEntity = this.theWatcher.worldObj.getClosestPlayerToEntity(this.theWatcher, (double)this.maxDistanceForPlayer);
            }
            else
            {
                this.closestEntity = this.theWatcher.worldObj.findNearestEntityWithinAABB(this.watchedClass, this.theWatcher.boundingBox.expand((double)this.maxDistanceForPlayer, 3.0D, (double)this.maxDistanceForPlayer), this.theWatcher);
            }

            return this.closestEntity != null;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.closestEntity.isEntityAlive() ? false : (this.theWatcher.getDistanceSqToEntity(this.closestEntity) > (double)(this.maxDistanceForPlayer * this.maxDistanceForPlayer) ? false : this.lookTime > 0);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.lookTime = 40 + this.theWatcher.getRNG().nextInt(40);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.closestEntity = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        this.theWatcher.getLookHelper().setLookPosition(this.closestEntity.posX, this.closestEntity.posY + (double)this.closestEntity.getEyeHeight(), this.closestEntity.posZ, 10.0F, (float)this.theWatcher.getVerticalFaceSpeed());
        --this.lookTime;
    }
}