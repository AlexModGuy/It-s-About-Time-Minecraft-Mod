package itsabouttime.common.biomes;

import itsabouttime.common.entities.EntityJellyfish;
import itsabouttime.common.entities.prehistoric.EntityAmmonite;
import itsabouttime.common.entities.prehistoric.EntityArandaspidis;
import itsabouttime.common.entities.prehistoric.EntityConodont;
import itsabouttime.common.entities.prehistoric.EntityCyclonema;
import itsabouttime.common.entities.prehistoric.EntityHorseShoeCrab;
import itsabouttime.common.entities.prehistoric.EntityMegalograptus;
import itsabouttime.common.entities.prehistoric.EntityOrthocone;
import itsabouttime.common.entities.prehistoric.EntityTrilobite;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenOrdovicianSea extends BiomeGenBase{
	 public BiomeGenOrdovicianSea(int par1) {
		super(par1);
		
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableCaveCreatureList.clear();
		
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityAmmonite.class, 18, 2, 6));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityJellyfish.class, 19, 1, 7));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityTrilobite.class, 18, 2, 6));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityArandaspidis.class, 16, 1, 3));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityConodont.class, 16, 1, 3));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityCyclonema.class, 17, 1, 3));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityHorseShoeCrab.class, 17, 1, 4));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityMegalograptus.class, 15, 1, 2));
        this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityOrthocone.class, 19, 1, 7));

		
		
		
		
		
		
		
		
		
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