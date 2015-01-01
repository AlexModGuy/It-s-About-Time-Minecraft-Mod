package itsabouttime.common.biomes;

import itsabouttime.common.core.IATstuff;
import itsabouttime.common.worldgen.WorldGenPrototaxities;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BiomeGenDenovianSwamp extends BiomeGenBase
{
    protected static final WorldGenPrototaxities field_150631_aE = new WorldGenPrototaxities(IATstuff.OldLog, 2, Blocks.grass, Blocks.dirt, Blocks.mycelium, IATstuff.LushPodzol);

    public BiomeGenDenovianSwamp(int p_i1988_1_)
    {
        super(p_i1988_1_);
        this.topBlock= IATstuff.LushPodzol;
        this.fillerBlock= Blocks.dirt;
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.flowersPerChunk = 7;
        this.theBiomeDecorator.deadBushPerChunk = 0;
        this.theBiomeDecorator.mushroomsPerChunk = 8;
        this.theBiomeDecorator.reedsPerChunk = 0;
        this.theBiomeDecorator.clayPerChunk = 0;
        this.theBiomeDecorator.waterlilyPerChunk = 0;
        this.theBiomeDecorator.sandPerChunk2 = 0;
        this.theBiomeDecorator.sandPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 0;
        this.waterColorMultiplier = 14745518;
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntitySlime.class, 1, 1, 1));
        this.flowers.clear();
        this.addFlower(IATstuff.OldPlants, 0, 10);
        this.addFlower(IATstuff.OldPlants, 1, 20);
        this.addFlower(IATstuff.OldPlants, 2, 20);


    }

    public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
    {
        return this.field_150631_aE;
    }

    public String func_150572_a(Random p_150572_1_, int p_150572_2_, int p_150572_3_, int p_150572_4_)
    {
        return BlockFlower.field_149859_a[1];
    }


    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int p_150558_1_, int p_150558_2_, int p_150558_3_)
    {
        double d0 = plantNoise.func_151601_a((double)p_150558_1_ * 0.0225D, (double)p_150558_3_ * 0.0225D);
        return d0 < -0.1D ? 5011004 : 6975545;
    }

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int p_150571_1_, int p_150571_2_, int p_150571_3_)
    {
        return 6975545;
    }
}