package iat.world.biomes;

import iat.core.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeNowhere extends BiomeGenBase{

	public BiomeNowhere(int id) {
		super(id);
		this.topBlock = ModBlocks.grid;
        this.fillerBlock = Blocks.air;
		this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableCaveCreatureList.clear();
	}

}
