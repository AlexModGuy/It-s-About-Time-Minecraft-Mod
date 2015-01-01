package itsabouttime.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;


public class BlockBuilder extends Block{
	private Block blocks;

	public BlockBuilder(Material material, Block PortalBlock){

		super(material);
		this.blocks = PortalBlock;
			this.setHarvestLevel("pickaxe", 3);
this.setHardness(3f);
this.setResistance(5f);

	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float sideX, float sideY, float sideZ)
	 {
	 //Super
	 super.onBlockActivated(world, x, y, z, player, meta, sideX, sideY, sideZ);

	 //Sets the block to air on the x, y, and z coords from where you placed the block
	 world.setBlockToAir(x, y, z);

	 //Sets the block on the x, y, and z coords starting from where you placed the block
	 world.setBlock(x, y, z, Blocks.quartz_block);
	 //Air
	 world.setBlockToAir(x, y+1, z);
	 world.setBlockToAir(x+1, y+1, z);
	 world.setBlockToAir(x+2, y+1, z);
	 world.setBlockToAir(x-1, y+1, z);
	 world.setBlockToAir(x-2, y+1, z);
	
	 world.setBlockToAir(x, y+1, z-1);
	 world.setBlockToAir(x+1, y+1, z-1);
	 world.setBlockToAir(x+2, y+1, z-1);
	 world.setBlockToAir(x-1, y+1, z-1);
	 world.setBlockToAir(x-2, y+1, z-1);
	 
	 world.setBlockToAir(x, y+1, z-2);
	 world.setBlockToAir(x+1, y+1, z-2);
	 world.setBlockToAir(x+2, y+1, z-2);
	 world.setBlockToAir(x-1, y+1, z-2);
	 world.setBlockToAir(x-2, y+1, z-2);
	 
	 world.setBlockToAir(x, y+1, z-3);
	 world.setBlockToAir(x+1, y+1, z-3);
	 world.setBlockToAir(x+2, y+1, z-3);
	 world.setBlockToAir(x-1, y+1, z-3);
	 world.setBlockToAir(x-2, y+1, z-3);
	 
	 world.setBlockToAir(x, y+1, z-4);
	 world.setBlockToAir(x+1, y+1, z-4);
	 world.setBlockToAir(x+2, y+1, z-4);
	 world.setBlockToAir(x-1, y+1, z-4);
	 world.setBlockToAir(x-2, y+1, z-4);
	 
	 
	 
	 world.setBlockToAir(x, y+2, z);
	 world.setBlockToAir(x+1, y+2, z);
	 world.setBlockToAir(x+2, y+2, z);
	 world.setBlockToAir(x-1, y+2, z);
	 world.setBlockToAir(x-2, y+2, z);
	
	 world.setBlockToAir(x, y+2, z-1);
	 world.setBlockToAir(x+1, y+2, z-1);
	 world.setBlockToAir(x+2, y+2, z-1);
	 world.setBlockToAir(x-1, y+2, z-1);
	 world.setBlockToAir(x-2, y+2, z-1);
	 
	 world.setBlockToAir(x, y+2, z-2);
	 world.setBlockToAir(x+1, y+2, z-2);
	 world.setBlockToAir(x+2, y+2, z-2);
	 world.setBlockToAir(x-1, y+2, z-2);
	 world.setBlockToAir(x-2, y+2, z-2);
	 
	 world.setBlockToAir(x, y+2, z-3);
	 world.setBlockToAir(x+1, y+2, z-3);
	 world.setBlockToAir(x+2, y+2, z-3);
	 world.setBlockToAir(x-1, y+2, z-3);
	 world.setBlockToAir(x-2, y+2, z-3);
	 
	 world.setBlockToAir(x, y+2, z-4);
	 world.setBlockToAir(x+1, y+2, z-4);
	 world.setBlockToAir(x+2, y+2, z-4);
	 world.setBlockToAir(x-1, y+2, z-4);
	 world.setBlockToAir(x-2, y+2, z-4);
	 
	 
	 
	 world.setBlockToAir(x, y+3, z);
	 world.setBlockToAir(x+1, y+3, z);
	 world.setBlockToAir(x+2, y+3, z);
	 world.setBlockToAir(x-1, y+3, z);
	 world.setBlockToAir(x-2, y+3, z);
	
	 world.setBlockToAir(x, y+3, z-1);
	 world.setBlockToAir(x+1, y+3, z-1);
	 world.setBlockToAir(x+2, y+3, z-1);
	 world.setBlockToAir(x-1, y+3, z-1);
	 world.setBlockToAir(x-2, y+3, z-1);
	 
	 world.setBlockToAir(x, y+3, z-2);
	 world.setBlockToAir(x+1, y+3, z-2);
	 world.setBlockToAir(x+2, y+3, z-2);
	 world.setBlockToAir(x-1, y+3, z-2);
	 world.setBlockToAir(x-2, y+3, z-2);
	 
	 world.setBlockToAir(x, y+3, z-3);
	 world.setBlockToAir(x+1, y+3, z-3);
	 world.setBlockToAir(x+2, y+3, z-3);
	 world.setBlockToAir(x-1, y+3, z-3);
	 world.setBlockToAir(x-2, y+3, z-3);
	 
	 world.setBlockToAir(x, y+3, z-4);
	 world.setBlockToAir(x+1, y+3, z-4);
	 world.setBlockToAir(x+2, y+3, z-4);
	 world.setBlockToAir(x-1, y+3, z-4);
	 world.setBlockToAir(x-2, y+3, z-4);
	 
	 
	
//top	 world.setBlock(x, y + 1, z, Blocks.redstone_block);
	
	//under world.setBlock(x, y - 1, z, Blocks.lapis_block);
	 
	//sides 
	 world.setBlock(x+1, y , z,Blocks.quartz_block); 
	 world.setBlock(x+2, y , z, Blocks.quartz_block);
	 world.setBlock(x-1, y , z, Blocks.quartz_block);
	 world.setBlock(x-2, y , z, Blocks.quartz_block);
	 
	 world.setBlock(x, y, z-1,  Blocks.stone_slab, 7, 1);
	 world.setBlock(x+1, y , z-1,  Blocks.stone_slab, 7, 1); 
	 world.setBlock(x+2, y , z-1 , Blocks.quartz_block);
	 world.setBlock(x-1, y , z-1,  Blocks.stone_slab, 7, 1);
	 world.setBlock(x-2, y , z-1, Blocks.quartz_block);
	 
	 
	 //
	 world.setBlock(x, y, z-2, Blocks.glowstone);
	 world.setBlock(x+1, y , z-2,  Blocks.stone_slab, 7, 1); 
	 world.setBlock(x+2, y , z-2 , Blocks.quartz_block);
	 world.setBlock(x-1, y , z-2,  Blocks.stone_slab, 7, 1);
	 world.setBlock(x-2, y , z-2, Blocks.quartz_block);
	 //
	 world.setBlock(x, y, z-3,  Blocks.stone_slab, 7, 1);
	 world.setBlock(x+1, y , z-3,  Blocks.stone_slab, 7, 1); 
	 world.setBlock(x+2, y , z-3 , Blocks.quartz_block);
	 world.setBlock(x-1, y , z-3, Blocks.stone_slab, 7, 1);
	 world.setBlock(x-2, y , z-3, Blocks.quartz_block);
	 //
	 world.setBlock(x, y, z-4, Blocks.quartz_block);
	 world.setBlock(x+1, y , z-4, Blocks.quartz_block); 
	 world.setBlock(x+2, y , z-4 , Blocks.quartz_block);
	 world.setBlock(x-1, y , z-4, Blocks.quartz_block);
	 world.setBlock(x-2, y , z-4, Blocks.quartz_block);
	 

	 
	 
	 
	 
	 
	 
	 
	 world.setBlock(x, y+1, z-2, blocks);
	 world.setBlock(x, y+2, z-2, blocks);
	 world.setBlock(x, y+3, z-2, Blocks.glowstone);
	 
	 world.setBlock(x+2, y+1 , z , Blocks.quartz_block,2, 3);
	 world.setBlock(x-2, y+1 , z , Blocks.quartz_block,2, 3);
	 world.setBlock(x+2, y+1 , z-4 , Blocks.quartz_block,2, 3);
	 world.setBlock(x-2, y+1 , z-4 , Blocks.quartz_block,2, 3);
	 
	 world.setBlock(x+2, y+2 , z , Blocks.quartz_block,2, 3);
	 world.setBlock(x-2, y+2 , z , Blocks.quartz_block,2, 3);
	 world.setBlock(x+2, y+2 , z-4 , Blocks.quartz_block,2, 3);
	 world.setBlock(x-2, y+2 , z-4 , Blocks.quartz_block,2, 3);
	 
	 world.setBlock(x+2, y+3 , z , Blocks.quartz_block,2, 3);
	 world.setBlock(x-2, y+3 , z , Blocks.quartz_block,2, 3);
	 world.setBlock(x+2, y+3 , z-4 , Blocks.quartz_block,2, 3);
	 world.setBlock(x-2, y+3 , z-4 , Blocks.quartz_block,2, 3);
	 
	 world.setBlock(x+1, y+4 , z, Blocks.quartz_block); 
	 world.setBlock(x+2, y+4 , z, Blocks.quartz_block);
	 world.setBlock(x-1, y+4 , z, Blocks.quartz_block);
	 world.setBlock(x-2, y+4 , z, Blocks.quartz_block);
	 
	 world.setBlock(x, y+4, z-1, Blocks.quartz_block);
	 world.setBlock(x+1, y+4 , z-1, Blocks.quartz_block); 
	 world.setBlock(x+2, y+4 , z-1 , Blocks.quartz_block);
	 world.setBlock(x-1, y+4 , z-1, Blocks.quartz_block);
	 world.setBlock(x-2, y+4 , z-1, Blocks.quartz_block);
	 
	 world.setBlock(x, y+4, z, Blocks.quartz_block);
	 world.setBlock(x, y+4, z-2, Blocks.quartz_block);
	 world.setBlock(x+1, y+4 , z-2, Blocks.quartz_block); 
	 world.setBlock(x+2, y+4 , z-2 , Blocks.quartz_block);
	 world.setBlock(x-1, y+4 , z-2, Blocks.quartz_block);
	 world.setBlock(x-2, y+4 , z-2, Blocks.quartz_block);
	 
	 world.setBlock(x, y+4, z-3, Blocks.quartz_block);
	 world.setBlock(x+1, y+4 , z-3, Blocks.quartz_block); 
	 world.setBlock(x+2, y+4 , z-3 , Blocks.quartz_block);
	 world.setBlock(x-1, y+4 , z-3, Blocks.quartz_block);
	 world.setBlock(x-2, y+4 , z-3, Blocks.quartz_block);
	 
	 world.setBlock(x, y+4, z-4, Blocks.quartz_block);
	 world.setBlock(x+1, y+4 , z-4, Blocks.quartz_block); 
	 world.setBlock(x+2, y+4 , z-4 , Blocks.quartz_block);
	 world.setBlock(x-1, y+4 , z-4, Blocks.quartz_block);
	 world.setBlock(x-2, y+4 , z-4, Blocks.quartz_block);
	// front world.setBlock(x, y , z+1, Blocks.bookshelf);
	 
	// back world.setBlock(x, y , z-1, Blocks.diamond_block);


	 
	return true;
}
}
