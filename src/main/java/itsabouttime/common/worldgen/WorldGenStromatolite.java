package itsabouttime.common.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenStromatolite extends WorldGenerator
{
	 private Block field_150547_a;
	    public int metas;
    private static final String __OBFID = "CL_00000429";
    public WorldGenStromatolite(Block p_i45451_1_, int meta)
    {
    	this.field_150547_a = p_i45451_1_;
    	this.metas = meta;	
    }
    public boolean generate(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_)
    {
    	
        for (int l = 0; l < 20; ++l)
        {
            int i1 = p_76484_3_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
            int j1 = p_76484_4_;
            int k1 = p_76484_5_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);

            if (p_76484_1_.isAirBlock(i1, p_76484_4_, k1) && (p_76484_1_.getBlock(i1 - 1, p_76484_4_ - 1, k1).getMaterial() == Material.water || p_76484_1_.getBlock(i1 + 1, p_76484_4_ - 1, k1).getMaterial() == Material.water || p_76484_1_.getBlock(i1, p_76484_4_ - 1, k1 - 1).getMaterial() == Material.water || p_76484_1_.getBlock(i1, p_76484_4_ - 1, k1 + 1).getMaterial() == Material.water))
            {
                int l1 = 2 + p_76484_2_.nextInt(p_76484_2_.nextInt(3) + 1);

                for (int i2 = 0; i2 < l1; ++i2)
                {
                    if (Blocks.reeds.canBlockStay(p_76484_1_, i1, j1 + i2, k1)&& p_76484_1_.getBlock(i1, j1, k1) == Blocks.sand )
                    {
                        p_76484_1_.setBlock(i1, j1 + i2, k1, field_150547_a, metas, 2);
                    }
                }
            }
        }

        return true;
    }

	
}