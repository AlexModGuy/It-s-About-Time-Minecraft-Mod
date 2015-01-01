package itsabouttime.common.worldgen;


import java.util.Arrays;
import java.util.List;
import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;


public class WorldGenPrototaxities extends WorldGenAbstractTree
{
    private Block wood;
    private Block leaves;
    private int meta;
    private List soilBlocks;
  //  private final int minTreeHeight;
   // private final int randomTreeHeight;


    public WorldGenPrototaxities(Block wood, int meta, Block... i) 
    {
        super(false);

        this.wood = wood;
        this.meta = meta;
        //this.minTreeHeight = minTreeHeight;
        //this.randomTreeHeight = randomTreeHeight;
        this.soilBlocks = Arrays.asList(i);
    }


    @Override
    public boolean generate(World world, Random random, int x, int y, int z)
    {
        Block block;
        int height = random.nextInt(3) + 4;


  

        	   for (int yi = 0; yi < height; ++yi)
               {
                   Block blocks = world.getBlock(x, y + yi, z);

                   if (blocks.isAir(world, x, y + yi, z) || blocks.isLeaves(world, x, y + yi, z) && world.getBlock(x, y - 1, z) == soilBlocks)
                   {
               world.setBlock( x, y + yi, z, wood, meta, 2);
                       

               world.setBlock(x - 1, y, z, wood, meta, 2);
               world.setBlock(x + 1, y, z, wood, meta, 2);
               world.setBlock(x, y, z - 1, wood, meta, 2);
               world.setBlock(x, y, z + 1, wood, meta, 2);

               world.setBlock(x - 1, y+1, z, wood, meta, 2);
                       world.setBlock(x + 1, y+1, z, wood, meta, 2);
                       world.setBlock(x, y+1, z - 1, wood, meta, 2);
                       world.setBlock(x, y+1, z + 1, wood, meta, 2);
                       
                   }
               }

               return true;
           }
}

