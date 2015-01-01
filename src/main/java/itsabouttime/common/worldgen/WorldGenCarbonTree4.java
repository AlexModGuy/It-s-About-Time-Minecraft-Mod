package itsabouttime.common.worldgen;


import java.util.Arrays;
import java.util.List;
import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;


public class WorldGenCarbonTree4 extends WorldGenAbstractTree
{
    private Block wood;
    private Block leaves;
    private int meta;
    private int Leafmeta;
    private List soilBlocks;
  //  private final int minTreeHeight;
   // private final int randomTreeHeight;


    public WorldGenCarbonTree4(Block wood,Block leaves, int Leafmeta, int meta, Block... i) 
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
        int height = random.nextInt(5)+4;


  

        	   for (int yi = 0; yi < height; ++yi)
               {
                   Block blocks = world.getBlock(x, y + yi, z);

                   if (blocks.isAir(world, x, y + yi, z) || blocks.isLeaves(world, x, y + yi, z) && world.getBlock(x, y - 1, z) == soilBlocks)
                   {
               world.setBlock( x, y + yi, z, wood, meta, 2);
               
               world.setBlock( x, y+height, z, wood, meta, 2);
               world.setBlock( x, y+height + 1, z, wood, meta, 2);
               world.setBlock( x, y +height+ 2, z, wood, meta, 2);
               world.setBlock( x, y +height+ 3, z, wood, meta, 2);
               world.setBlock( x, y +height+ 4, z, wood, meta, 2);
               world.setBlock( x, y +height+ 5, z, wood, meta, 2);
               world.setBlock( x, y +height+ 6, z, wood, meta, 2);
               world.setBlock( x, y +height+ 7, z, wood, meta, 2);
//TopLeaves
               world.setBlock( x+1, y +height+ 5, z, leaves, meta, 2);
               world.setBlock( x+1, y +height+ 6, z, leaves, meta, 2);
               world.setBlock( x+1, y +height+ 7, z, leaves, meta, 2);
         
               world.setBlock( x-1, y+height + 5, z, leaves, meta, 2);
               world.setBlock( x-1, y +height+ 6, z, leaves, meta, 2);
               world.setBlock( x-1, y +height+ 7, z, leaves, meta, 2);
             
               world.setBlock( x, y+height + 5, z+1, leaves, meta, 2);
               world.setBlock( x, y +height+ 6, z+1, leaves, meta, 2);
               world.setBlock( x, y +height+ 7, z+1, leaves, meta, 2);
               
               world.setBlock( x, y+height + 5, z-1, leaves, meta, 2);
               world.setBlock( x, y +height+ 6, z-1, leaves, meta, 2);
               world.setBlock( x, y +height+ 7, z-1, leaves, meta, 2);
               
               world.setBlock( x, y +height+ 8, z, leaves, meta, 2);

               //Extra     
               world.setBlock(x, y+height-1, z+ 1, wood, meta, 2);
               world.setBlock(x, y+height-1, z-1, wood, meta, 2);
               
               world.setBlock(x, y+height-1, z + 2, wood, meta, 2);
               world.setBlock(x, y+height-1, z-2, wood, meta, 2);


               world.setBlock(x , y+height, z+2, wood, meta, 2);
               world.setBlock(x, y+height+1, z + 2, wood, meta, 2);
               world.setBlock(x, y+height+2, z+2, wood, meta, 2);
               world.setBlock(x, y+height+2, z+3, wood, meta, 2);
               world.setBlock(x, y+height+3, z+3, wood, meta, 2);
               world.setBlock(x, y+height+3, z+4, wood, meta, 2);
               world.setBlock(x, y+height+4, z+4, wood, meta, 2);
       
               world.setBlock(x, y+height, z - 2, wood, meta, 2);
               world.setBlock(x, y+height+1, z-2, wood, meta, 2);
               world.setBlock(x, y+height+2, z-2, wood, meta, 2);
               world.setBlock(x, y+height+2, z-3, wood, meta, 2);
               world.setBlock(x, y+height+3, z-3, wood, meta, 2);
               world.setBlock(x, y+height+3, z-4, wood, meta, 2);
               world.setBlock(x, y+height+4, z-4, wood, meta, 2);
              
               //Right Arm
               world.setBlock(x, y+height+6, z + 4, leaves, meta, 2);
               world.setBlock(x, y+height+5, z+4, wood, meta, 2);
               world.setBlock(x, y+height+4, z+4, wood, meta, 2);
               world.setBlock(x, y+height+3, z+4, wood, meta, 2);

               world.setBlock(x +1, y+height+5, z + 4, leaves, meta, 2);
               world.setBlock(x + 1, y+height+4, z+4, leaves, meta, 2);
               world.setBlock(x + 1, y+height+3, z+4, leaves, meta, 2);
               
               world.setBlock(x-1, y+height+5, z+4, leaves, meta, 2);
               world.setBlock(x-1, y+height+4, z+4, leaves, meta, 2);
               world.setBlock(x-1, y+height+3, z+4, leaves, meta, 2);
               
               world.setBlock(x, y+height+3, z+5, leaves, meta, 2);
               world.setBlock(x, y+height+2, z+4, leaves, meta, 2);
               
               world.setBlock(x, y+height+4, z+3, leaves, meta, 2);
               world.setBlock(x, y+height+5, z+3, leaves, meta, 2);
               
               world.setBlock(x, y+height+4, z+5, leaves, meta, 2);
               world.setBlock(x, y+height+5, z+5, leaves, meta, 2);
               //LeftArm  
               world.setBlock(x, y+height+6, z - 4, leaves, meta, 2);
               world.setBlock(x, y+height+5, z-4, wood, meta, 2);
               world.setBlock(x, y+height+4, z-4, wood, meta, 2);
               world.setBlock(x, y+height+3, z-4, wood, meta, 2);

               world.setBlock(x +1, y+height+5, z - 4, leaves, meta, 2);
               world.setBlock(x + 1, y+height+4, z-4, leaves, meta, 2);
               world.setBlock(x + 1, y+height+3, z-4, leaves, meta, 2);
               
               world.setBlock(x-1, y+height+5, z-4, leaves, meta, 2);
               world.setBlock(x-1, y+height+4, z-4, leaves, meta, 2);
               world.setBlock(x-1, y+height+3, z-4, leaves, meta, 2);
               
               world.setBlock(x, y+height+3, z-5, leaves, meta, 2);
               world.setBlock(x, y+height+2, z-4, leaves, meta, 2);
               
               world.setBlock(x, y+height+4, z-3, leaves, meta, 2);
               world.setBlock(x, y+height+5, z-3, leaves, meta, 2);
               
               world.setBlock(x, y+height+4, z-5, leaves, meta, 2);
               world.setBlock(x, y+height+5, z-5, leaves, meta, 2);
                   }
               }

               return true;
           }
}

