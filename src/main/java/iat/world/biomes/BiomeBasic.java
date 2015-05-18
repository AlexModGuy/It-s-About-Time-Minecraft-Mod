package iat.world.biomes;

import iat.core.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeBasic extends BiomeGenBase{

	public BiomeBasic(int id, Block topBlock, Block fillerBlock, boolean clearAnimals, int lifeSelector) {
		super(id);
		this.topBlock = topBlock;
		this.fillerBlock = fillerBlock;

		if(clearAnimals){
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();

		}


	}

}
