package itsabouttime.common.worldgen;


import java.util.Arrays;
import java.util.List;
import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;


public class WorldGenTreeFern extends WorldGenAbstractTree
{
    private Block wood;
    private Block leaves;
    private int meta;
    private int Leafmeta;
    private List soilBlocks;
  //  private final int minTreeHeight;
   // private final int randomTreeHeight;


    public WorldGenTreeFern(Block wood,Block leaves, int Leafmeta, int meta, Block... i) 
    {
        super(false);

        this.wood = wood;
        this.leaves = leaves;
        this.meta = meta;
        this.Leafmeta =Leafmeta;
        //this.minTreeHeight = minTreeHeight;
        //this.randomTreeHeight = randomTreeHeight;
        this.soilBlocks = Arrays.asList(i);
    }


    @Override
    public boolean generate(World world, Random random, int x, int y, int z)
    {
        Block block;
        int height = random.nextInt(9)+5;


  

        	   for (int yi = 0; yi < height; ++yi)
               {
                   Block blocks = world.getBlock(x, y + yi, z);

                   if (blocks.isAir(world, x, y + yi, z) || blocks.isLeaves(world, x, y + yi, z) && world.getBlock(x, y - 1, z) == soilBlocks)
                   {
               world.setBlock( x, y + yi, z, wood, meta, 2);
                       
               world.setBlock(x, y+height-1, z, leaves,Leafmeta, 2);
               world.setBlock(x+1, y+height-1, z, leaves,Leafmeta, 2);
               world.setBlock(x+2, y+height-1, z, leaves,Leafmeta, 2);
               world.setBlock(x+2, y+height-2, z, leaves,Leafmeta, 2);

               world.setBlock(x-1, y+height-1, z, leaves,Leafmeta, 2);
               world.setBlock(x-2, y+height-1, z, leaves,Leafmeta, 2);
               world.setBlock(x-2, y+height-2, z, leaves,Leafmeta, 2);
               
               world.setBlock(x, y+height-1, z+1, leaves,Leafmeta, 2);
               world.setBlock(x, y+height-1, z+2, leaves,Leafmeta, 2);
               world.setBlock(x, y+height-2, z+2, leaves,Leafmeta, 2);
               
               world.setBlock(x, y+height-1, z-1, leaves,Leafmeta, 2);
               world.setBlock(x, y+height-1, z-2, leaves,Leafmeta, 2);
               world.setBlock(x, y+height-2, z-2, leaves,Leafmeta, 2);
              
               world.setBlock(x, y+height-1, z-1, leaves,Leafmeta, 2);
               world.setBlock(x, y+height-1, z+1, leaves,Leafmeta, 2);
               world.setBlock(x+1, y+height-1, z, leaves,Leafmeta, 2);
               world.setBlock(x+1, y+height-1, z, leaves,Leafmeta, 2);
               world.setBlock(x, y+height, z, leaves,Leafmeta, 2);

                   }
               }

               return true;
           }
}

