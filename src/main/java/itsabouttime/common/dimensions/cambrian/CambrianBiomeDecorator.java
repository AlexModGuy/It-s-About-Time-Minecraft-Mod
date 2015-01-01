package itsabouttime.common.dimensions.cambrian;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenWaterlily;

public class CambrianBiomeDecorator extends BiomeDecorator{
    
    public CambrianBiomeDecorator()
    {
        this.sandGen = new WorldGenSand(Blocks.sand, 7);
        this.dirtGen = new WorldGenMinable(Blocks.dirt, 32);
        this.gravelGen = new WorldGenMinable(Blocks.gravel, 32);
        this.coalGen = new WorldGenMinable(Blocks.coal_ore, 16);
        this.ironGen = new WorldGenMinable(Blocks.iron_ore, 8);
        this.goldGen = new WorldGenMinable(Blocks.gold_ore, 8);
        this.redstoneGen = new WorldGenMinable(Blocks.redstone_ore, 7);
        this.diamondGen = new WorldGenMinable(Blocks.diamond_ore, 7);
        this.lapisGen = new WorldGenMinable(Blocks.lapis_ore, 6);
        this.yellowFlowerGen = null;
        this.mushroomBrownGen = null;
        this.mushroomRedGen = null;
        this.flowersPerChunk = 0;
        this.grassPerChunk = 0;
        this.sandPerChunk = 1;
        this.sandPerChunk2 = 3;
        this.clayPerChunk = 1;
        this.generateLakes = false;
    }

}

 