package itsabouttime.common.entities.prehistoric.technical;

import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPrehistoricAnphibianCrawler extends EntityPehistoricAnimal{

	public EntityPrehistoricAnphibianCrawler(World p_i1681_1_) {
		super(p_i1681_1_);
	}
	@Override
	public boolean canBreatheUnderwater()
	{
	    return true;
	}
	 public boolean getCanSpawnHere()
	    {
	        int i = MathHelper.floor_double(this.posX);
	        int j = MathHelper.floor_double(this.boundingBox.minY);
	        int k = MathHelper.floor_double(this.posZ);
	        return this.worldObj.getBlock(i, j , k) == Blocks.water && this.worldObj.getFullBlockLightValue(i, j, k) > 8 && super.getCanSpawnHere();
	    }
}
