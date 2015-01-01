package itsabouttime.common.biomes;

import itsabouttime.common.entities.EntityJellyfish;
import itsabouttime.common.entities.prehistoric.EntityAnomalocaris;
import itsabouttime.common.entities.prehistoric.EntityHaikouichthys;
import itsabouttime.common.entities.prehistoric.EntityHallucigenia;
import itsabouttime.common.entities.prehistoric.EntityOpabina;
import itsabouttime.common.entities.prehistoric.EntityPikaia;
import itsabouttime.common.entities.prehistoric.EntityTrilobite;
import itsabouttime.common.entities.prehistoric.EntityWaptia;
import itsabouttime.common.entities.prehistoric.EntityWixwaxia;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenCambrianSea extends BiomeGenBase{
	 public BiomeGenCambrianSea(int par1) {
		super(par1);
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityJellyfish.class, 19, 1, 7));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityTrilobite.class, 18, 2, 6));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityAnomalocaris.class, 16, 1, 1));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityOpabina.class, 17, 1, 2));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityHaikouichthys.class, 20, 4, 9));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityHallucigenia.class, 13, 1, 3));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityPikaia.class, 15, 1, 3));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWaptia.class, 16, 3, 7));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityWixwaxia.class, 13, 2, 6));
		
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