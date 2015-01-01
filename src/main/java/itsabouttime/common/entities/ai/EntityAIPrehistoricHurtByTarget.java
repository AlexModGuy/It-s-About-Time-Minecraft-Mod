package itsabouttime.common.entities.ai;

import itsabouttime.common.entities.prehistoric.technical.EntityPehistoricAnimal;
import itsabouttime.common.entities.prehistoric.technical.EntityPrehistoricMob;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.util.AxisAlignedBB;

public class EntityAIPrehistoricHurtByTarget extends EntityAITarget
{
    boolean entityCallsForHelp;
    private int field_142052_b;
    private static final String __OBFID = "CL_00001619";

    public EntityAIPrehistoricHurtByTarget(EntityPrehistoricMob p_i1660_1_, boolean p_i1660_2_)
    {
        super(p_i1660_1_, false);
        this.entityCallsForHelp = p_i1660_2_;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        int i = this.taskOwner.func_142015_aE();
        return i != this.field_142052_b && this.isSuitableTarget(this.taskOwner.getAITarget(), false);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.taskOwner.getAITarget());
        this.field_142052_b = this.taskOwner.func_142015_aE();

        if (this.entityCallsForHelp)
        {
            double d0 = this.getTargetDistance();
            List list = this.taskOwner.worldObj.getEntitiesWithinAABB(this.taskOwner.getClass(), AxisAlignedBB.getBoundingBox(this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, this.taskOwner.posX + 1.0D, this.taskOwner.posY + 1.0D, this.taskOwner.posZ + 1.0D).expand(d0, 10.0D, d0));
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                EntityPrehistoricMob EntityPehistoriMob = (EntityPrehistoricMob)iterator.next();

                if (this.taskOwner != EntityPehistoriMob && EntityPehistoriMob.getAttackTarget() == null && !EntityPehistoriMob.isOnSameTeam(this.taskOwner.getAITarget()))
                {
                	EntityPehistoriMob.setAttackTarget(this.taskOwner.getAITarget());
                }
            }
        }

        super.startExecuting();
    }
}