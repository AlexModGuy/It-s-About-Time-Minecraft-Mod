package itsabouttime.common.worldgen;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenThyrixDen extends WorldGenerator
{

    public boolean generate(World worldObj, Random rand, int x, int y, int z)
    { if(worldObj.getFullBlockLightValue(x, y, z) < 13)
    {
    worldObj.setBlock(x, y-1, z, Blocks.air);
    worldObj.setBlock(x, y-2, z, Blocks.air);	
    worldObj.setBlock(x, y-3, z, Blocks.air);	
    int sideChoice =rand.nextInt(3);
    if(sideChoice==0){
    	worldObj.setBlock(x, y-3, z-1, Blocks.air);
    	
    	worldObj.setBlock(x-1, y-4, z-2, Blocks.air);
    	worldObj.setBlock(x-1, y-4, z-3, Blocks.air);
    	worldObj.setBlock(x-1, y-4, z-4, Blocks.air);
    	worldObj.setBlock(x, y-4, z-2, Blocks.air);
    	worldObj.setBlock(x, y-4, z-3, Blocks.air);
    	worldObj.setBlock(x, y-4, z-4, Blocks.air);
    	worldObj.setBlock(x+1, y-4, z-2, Blocks.air);
    	worldObj.setBlock(x+1, y-4, z-3, Blocks.air);
    	worldObj.setBlock(x+1, y-4, z-4, Blocks.air);
    	
    	worldObj.setBlock(x-1, y-5, z-2, Blocks.air);
    	worldObj.setBlock(x-1, y-5, z-3, Blocks.air);
    	worldObj.setBlock(x-1, y-5, z-4, Blocks.air);
    	worldObj.setBlock(x, y-5, z-2, Blocks.air);
    	worldObj.setBlock(x, y-5, z-3, Blocks.air);
    	worldObj.setBlock(x, y-5, z-4, Blocks.air);
    	worldObj.setBlock(x+1, y-5, z-2, Blocks.air);
    	worldObj.setBlock(x+1, y-5, z-3, Blocks.air);
    	worldObj.setBlock(x+1, y-5, z-4, Blocks.air);
    	
    	worldObj.setBlock(x-1, y-3, z-2, Blocks.air);
    	worldObj.setBlock(x-1, y-3, z-3, Blocks.air);
    	worldObj.setBlock(x-1, y-3, z-4, Blocks.air);
    	worldObj.setBlock(x, y-3, z-2, Blocks.air);
    	worldObj.setBlock(x, y-3, z-3, Blocks.air);
    	worldObj.setBlock(x, y-3, z-4, Blocks.air);
    	worldObj.setBlock(x+1, y-3, z-2, Blocks.air);
    	worldObj.setBlock(x+1, y-3, z-3, Blocks.air);
    	worldObj.setBlock(x+1, y-3, z-4, Blocks.air);
    	
    	return true;
    }
    if(sideChoice==1){
    	worldObj.setBlock(x, y-3, z+1, Blocks.air);
    	
    	worldObj.setBlock(x-1, y-4, z+2, Blocks.air);
    	worldObj.setBlock(x-1, y-4, z+3, Blocks.air);
    	worldObj.setBlock(x-1, y-4, z+4, Blocks.air);
    	worldObj.setBlock(x, y-4, z+2, Blocks.air);
    	worldObj.setBlock(x, y-4, z+3, Blocks.air);
    	worldObj.setBlock(x, y-4, z+4, Blocks.air);
    	worldObj.setBlock(x+1, y-4, z+2, Blocks.air);
    	worldObj.setBlock(x+1, y-4, z+3, Blocks.air);
    	worldObj.setBlock(x+1, y-4, z+4, Blocks.air);
    	
    	worldObj.setBlock(x-1, y-5, z-2, Blocks.air);
    	worldObj.setBlock(x-1, y-5, z-3, Blocks.air);
    	worldObj.setBlock(x-1, y-5, z-4, Blocks.air);
    	worldObj.setBlock(x, y-5, z-2, Blocks.air);
    	worldObj.setBlock(x, y-5, z-3, Blocks.air);
    	worldObj.setBlock(x, y-5, z-4, Blocks.air);
    	worldObj.setBlock(x+1, y-5, z-2, Blocks.air);
    	worldObj.setBlock(x+1, y-5, z-3, Blocks.air);
    	worldObj.setBlock(x+1, y-5, z-4, Blocks.air);
    	
    	worldObj.setBlock(x-1, y-3, z-2, Blocks.air);
    	worldObj.setBlock(x-1, y-3, z-3, Blocks.air);
    	worldObj.setBlock(x-1, y-3, z-4, Blocks.air);
    	worldObj.setBlock(x, y-3, z-2, Blocks.air);
    	worldObj.setBlock(x, y-3, z-3, Blocks.air);
    	worldObj.setBlock(x, y-3, z-4, Blocks.air);
    	worldObj.setBlock(x+1, y-3, z-2, Blocks.air);
    	worldObj.setBlock(x+1, y-3, z-3, Blocks.air);
    	worldObj.setBlock(x+1, y-3, z-4, Blocks.air);
    	
    	return true;
    }
    }
    return true;

}
}