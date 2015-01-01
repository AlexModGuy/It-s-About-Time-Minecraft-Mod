package itsabouttime.common.entities.prehistoric.technical;

import itsabouttime.common.core.IATstuff;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPrehistoricSeaCrawler extends EntityPrehistoricWaterMob{

	public EntityPrehistoricSeaCrawler(World par1World) {
		super(par1World);
	}
	
	 public boolean canBreatheUnderwater()
	    {
	        return true;
	    }
	
	
}