package itsabouttime.common.worldgen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;


public class WorldGenCoral extends WorldGenerator
{
    public Block plant;
    public Block soil;
    public int meta;

    public WorldGenCoral(Block plant, int meta, Block soil)
    {
    	this.plant = plant;
        this.meta = meta;
        this.soil=soil;	
    }
    
    public WorldGenCoral(Block plant, int meta, Block soil, Block EXTRA)
    {
        
    }


    @Override
	public boolean generate(World world, Random random, int x, int y, int z)
    {
        for (int l = 0; l < 64; ++l)
        {
            int i1 = x + random.nextInt(8) - random.nextInt(8);
            int j1 = y + random.nextInt(4) - random.nextInt(4);
            int k1 = z + random.nextInt(8) - random.nextInt(8);

            if (world.getBlock(i1, j1, k1) == Blocks.water &&world.getBlock(i1, j1+1, k1) == Blocks.water &&  (!world.provider.hasNoSky || j1 < 255) && world.getBlock(i1, j1 - 1, k1) == soil &&
            this.plant.canReplace(world, i1, j1, k1, 0, new ItemStack(plant, 1, meta)))
            {
                world.setBlock(i1, j1, k1, this.plant, this.meta, 2);
            }
        }

        return true;
    }
    	
	
}
