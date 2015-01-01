package itsabouttime.common.entities.prehistoric;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.IAnimals;

public interface ISmallWaterCritter extends IAnimals
{
    /** Entity selector for IMob types. */
    IEntitySelector mobSelector = new IEntitySelector()
    {
        /**
         * Return whether the specified entity is applicable to this filter.
         */
        public boolean isEntityApplicable(Entity p_82704_1_)
        {
            return p_82704_1_ instanceof ISmallWaterCritter;
        }
    };
}