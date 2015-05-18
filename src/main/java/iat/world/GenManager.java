package iat.world;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import iat.core.ModBiomes;
import iat.world.structure.StructurePit;

import java.util.Random;


public class GenManager implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{

		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(chunkX, chunkZ);

		if(biome == ModBiomes.biomeNowhere)
		{
				int Xcoord0 = chunkX * 16 + random.nextInt(16);
				int Ycoord0 = random.nextInt(100);
				int Zcoord0 = chunkZ * 16 + random.nextInt(16);
				new StructurePit().generate(world, random, Xcoord0, Ycoord0, Zcoord0);
			
		}

	}
}