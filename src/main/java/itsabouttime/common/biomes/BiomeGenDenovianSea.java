package itsabouttime.common.biomes;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenDenovianSea extends BiomeGenBase{
	 public BiomeGenDenovianSea(int par1) {
		super(par1);
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
	this.topBlock =Blocks.sand;
		this.fillerBlock = Blocks.sand;
		 this.theBiomeDecorator.dirtGen = null;
		 this.theBiomeDecorator.reedsPerChunk = 0;
	
		 this.theBiomeDecorator.mushroomsPerChunk =0;
		 this.theBiomeDecorator.coalGen = null;
		 this.theBiomeDecorator.redstoneGen = null;
}
	 public void genTerrainBlocks(World world, Random random, Block[] block, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_)
	    {
	        super.genBiomeTerrain(world, random, block, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
	        
	    }
	 
}