package iat.entities.mob.classification;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.IMob;

public interface IPrehistoric {
	  IEntitySelector mobSelector = new IEntitySelector()
	    {
	        /**
	         * Return whether the specified entity is applicable to this filter.
	         */
	        public boolean isEntityApplicable(Entity entity)
	        {
	            return entity instanceof IMob;
	        }
	    };
}
