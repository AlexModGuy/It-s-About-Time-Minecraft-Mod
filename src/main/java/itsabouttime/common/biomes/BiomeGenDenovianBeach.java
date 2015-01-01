package itsabouttime.common.biomes;

import itsabouttime.common.core.IATstuff;
import itsabouttime.common.core.IATbiomes;
import itsabouttime.common.worldgen.WorldGenPrototaxities;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBlockBlob;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenTaiga1;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenDenovianBeach extends BiomeGenBase
{
    private static final WorldGenPrototaxities field_150641_aE = new WorldGenPrototaxities(IATstuff.OldLog, 2, Blocks.grass, Blocks.dirt, Blocks.mycelium, IATstuff.LushPodzol);
    private static final WorldGenBlockBlob field_150643_aG = new WorldGenBlockBlob(Blocks.mossy_cobblestone, 0);
    private int field_150644_aH;
    private static final String __OBFID = "CL_00000186";

    public BiomeGenDenovianBeach(int p_i45385_1_, int p_i45385_2_)
    {
        super(p_i45385_1_);
        this.field_150644_aH = p_i45385_2_;
this.spawnableCaveCreatureList.clear();       
this.spawnableCreatureList.clear();
this.spawnableMonsterList.clear();
this.spawnableWaterCreatureList.clear();
this.theBiomeDecorator.treesPerChunk = 1;
this.topBlock = IATstuff.PrehistoricPodzol;
this.fillerBlock = Blocks.dirt;
this.theBiomeDecorator.grassPerChunk = 1;
this.theBiomeDecorator.mushroomsPerChunk = 1;
this.theBiomeDecorator.grassPerChunk = 0;
this.theBiomeDecorator.deadBushPerChunk = 1;
this.theBiomeDecorator.mushroomsPerChunk = 3;
        }
    

    public WorldGenAbstractTree func_150567_a(Random p_150567_1_)
    {
    	return this.field_150641_aE;
    }

  
    
    
    
    
    
    
    
    
    
    
  /*S*/  public WorldGenerator getRandomWorldGenForGrass(Random p_76730_1_)
    {
        return p_76730_1_.nextInt(100) > 0 ? new WorldGenTallGrass(IATstuff.OldPlants, 2) : new WorldGenTallGrass(IATstuff.OldPlants, 1);
    }
  	@Override
    public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        int k;
        int l;
        int i1;
        int j1;

       
            k = p_76728_2_.nextInt(3);

            for (l = 0; l < k; ++l)
            {
                i1 = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
                j1 = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
                int k1 = p_76728_1_.getHeightValue(i1, j1);
                field_150643_aG.generate(p_76728_1_, p_76728_2_, i1, k1, j1);
            }

        super.decorate(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
    }
//*/
    public void genTerrainBlocks(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_)
    {

        this.genBiomeTerrain(p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
    }

}