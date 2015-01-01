 package itsabouttime.common.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import itsabouttime.common.core.IATstuff;
import itsabouttime.common.core.IATbiomes;

import java.util.Random;


public class StructureHandler implements IWorldGenerator
{
 @Override
 public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
 {
	 
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);
 

		    if(BiomeDictionary.isBiomeOfType(biome, Type.PLAINS))
		    {
int Xcoord = chunkX * 16 + random.nextInt(16);
int Ycoord = random.nextInt(100);
int Zcoord = chunkZ * 16 + random.nextInt(16);

 new WorldGenGreek().generate(world, random, Xcoord, Ycoord, Zcoord);
		 }

		 
		    if(BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE))
		    {
 int Xcoord1 = chunkX * 16 + random.nextInt(16);
 int Ycoord1 = random.nextInt(100);
 int Zcoord1 = chunkZ * 16 + random.nextInt(16);

 new WorldGenAztec().generate(world, random, Xcoord1, Ycoord1, Zcoord1);
		    }
		    if(BiomeDictionary.isBiomeOfType(biome, Type.SANDY))
		    {
 //new WorldGenEgypt().generate(world, random, Xcoord1, Xcoord1, Xcoord1);
		    }
		    
		    if(BiomeDictionary.isBiomeOfType(biome, Type.BEACH))
		    {
		    	 int Xcoord1 = chunkX * 16 + random.nextInt(16);
		    	 int Ycoord1 = random.nextInt(100);
		    	 int Zcoord1 = chunkZ * 16 + random.nextInt(16);
		    	 
		    	 new WorldGenStromatolite(IATstuff.Stromatolite, 0).generate(world, random, Xcoord1, Ycoord1, Zcoord1);

		    }
 //Acording to Minecraft, Coral is a Structure???
 
 if(biome == IATbiomes.CambrianSea || biome == IATbiomes.CambrianRiver )
 {
int Xcoord2 = chunkX * 16 + random.nextInt(16);
int Ycoord2 = random.nextInt(100);
int Zcoord2 = chunkZ * 16 + random.nextInt(16);

int Xcoord3 = chunkX * 16 + random.nextInt(16);
int Ycoord3 = random.nextInt(100);
int Zcoord3 = chunkZ * 16 + random.nextInt(16);


new WorldGenCoral(Blocks.sponge, 0, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
new WorldGenCoral(IATstuff.OldCoral, 0, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
new WorldGenCoral(IATstuff.OldCoral, 1, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
new WorldGenCoral(IATstuff.OldCoral, 2, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
new WorldGenCoral(IATstuff.OldCoral, 3, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
new WorldGenCoral(IATstuff.OldCoral, 4, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);

new WorldGenCoral(Blocks.sponge, 0, Blocks.sand).generate(world, random, Xcoord3, Ycoord3, Zcoord3);
new WorldGenCoral(IATstuff.OldCoral, 0, Blocks.sand).generate(world, random, Xcoord3, Ycoord3, Zcoord3);
new WorldGenCoral(IATstuff.OldCoral, 1, Blocks.sand).generate(world, random, Xcoord3, Ycoord3, Zcoord3);
new WorldGenCoral(IATstuff.OldCoral, 2, Blocks.sand).generate(world, random, Xcoord3, Ycoord3, Zcoord3);
new WorldGenCoral(IATstuff.OldCoral, 3, Blocks.sand).generate(world, random, Xcoord3, Ycoord3, Zcoord3);
new WorldGenCoral(IATstuff.OldCoral, 4, Blocks.sand).generate(world, random, Xcoord3, Ycoord3, Zcoord3);

 }
 
 if(biome == IATbiomes.OrdovicianRiver || biome == IATbiomes.OrdovicianSea )
 {
	 int Xcoord2 = chunkX * 16 + random.nextInt(16);
	 int Ycoord2 = random.nextInt(100);
	 int Zcoord2 = chunkZ * 16 + random.nextInt(16);

	 int Xcoord3 = chunkX * 16 + random.nextInt(16);
	 int Ycoord3 = random.nextInt(100);
	 int Zcoord3 = chunkZ * 16 + random.nextInt(16);

	 
	 new WorldGenCoral(Blocks.sponge, 0, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	
	 new WorldGenCoral(IATstuff.OldCoral, 3, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.OldCoral, 4, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 0, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 1, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 2, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 3, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 4, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);

	 new WorldGenCoral(Blocks.sponge, 0, Blocks.sand).generate(world, random, Xcoord3, Ycoord3, Zcoord3);
	 
	 new WorldGenCoral(IATstuff.OldCoral, 3, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.OldCoral, 4, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 0, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 1, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 2, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 3, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 4, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new  WorldGenMyFlowers(IATstuff.OldPlants, 0).generate(world, random, Xcoord3, Ycoord3, Zcoord3);
	 
 }
 if(biome == IATbiomes.SilurianRiver || biome == IATbiomes.SilurianSea )
 {
	 int Xcoord2 = chunkX * 16 + random.nextInt(16);
	 int Ycoord2 = random.nextInt(100);
	 int Zcoord2 = chunkZ * 16 + random.nextInt(16);

	 int Xcoord3 = chunkX * 16 + random.nextInt(16);
	 int Ycoord3 = random.nextInt(100);
	 int Zcoord3 = chunkZ * 16 + random.nextInt(16);

	 
	 new WorldGenCoral(Blocks.sponge, 0, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	
	 new WorldGenCoral(IATstuff.OldCoral, 3, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.OldCoral, 4, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 0, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 1, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 2, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 3, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 4, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(Blocks.sponge, 0, Blocks.sand).generate(world, random, Xcoord3, Ycoord3, Zcoord3);
	 new WorldGenCoral(IATstuff.OldCoral, 3, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.OldCoral, 4, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 0, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 1, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 2, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 3, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new WorldGenCoral(IATstuff.NewCoral, 4, Blocks.sand).generate(world, random, Xcoord2, Ycoord2, Zcoord2);
	 new  WorldGenMyFlowers(IATstuff.OldPlants, 1).generate(world, random, Xcoord3, Ycoord3, Zcoord3);
	 
 }
 if(biome == IATbiomes.DenovianBeach || biome == IATbiomes.DenovianForest )
 {
	 int Xcoord2 = chunkX * 16 + random.nextInt(16);
	 int Ycoord2 = random.nextInt(100);
	 int Zcoord2 = chunkZ * 16 + random.nextInt(16);

	 int Xcoord3 = chunkX * 16 + random.nextInt(16);
	 int Ycoord3 = random.nextInt(100);
	 int Zcoord3 = chunkZ * 16 + random.nextInt(16);

	 
	 new  WorldGenMyFlowers(IATstuff.OldPlants, 2).generate(world, random, Xcoord3, Ycoord3, Zcoord3);
	 
 }
 }
}