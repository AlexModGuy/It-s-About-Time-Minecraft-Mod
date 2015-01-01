package itsabouttime.common.worldgen;

import itsabouttime.common.core.IATstuff;
import itsabouttime.common.core.IATbiomes;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class IAToreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
	switch(world.provider.dimensionId){
	
	
	case -1:
		
		
		generateNether(world, random, chunkX*16, chunkZ*16);
		
		
	case  0:
		
		
		generateSurface(world, random, chunkX*16, chunkZ*16);
		
		
	case 1:
		
		
		generateEnd(world, random, chunkX*16, chunkZ*16);
		
		
	}
	}

	private void generateNether(World world, Random random, int x, int y){
		
	}
	
	
	private void generateSurface(World world, Random random, int x, int y){
		
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, y);

		// this.YourBlock,meta, world, radom x, y, 16, 16, Vein Size:X+random.nextInt(Y), Chances To Spawn, Minimum Y cordinate(ALWAYS 2), Maximum(whatever Hight you would like. Diamonds are 16
	 this.addOreSpawn(IATstuff.Shale,Blocks.stone,0, world, random, x, y, 16, 16, 4+random.nextInt(5), 20, 2,60)	;
	 this.addOreSpawn(IATstuff.FossilSand,Blocks.sand,0, world, random, x, y, 16, 16, 4+random.nextInt(5), 20, 2,265)	;


	}
		 


	
	private void generateEnd(World world, Random random, int x, int y){
		
		}
	
	
	
	
	public void addOreSpawn(Block block,Block blockTarget, int meta, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY,int maxY){
		

		
		
		
		
		
		for(int i=0; i < chancesToSpawn; i++){
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, meta, maxVeinSize, blockTarget)).generate(world, random, posX, posY, posZ);
			
			

		}}}

	
	

