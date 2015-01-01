package itsabouttime.common.blocks;

import java.util.Random;

import itsabouttime.common.tileentities.TileEntityStromatolite;
import itsabouttime.common.tileentities.TileEntityTreeFernLog;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTreeFernLog extends BlockContainer{

	public BlockTreeFernLog(Material TreeFernLog) {
		  super(TreeFernLog);
	        this.setHardness(2.0F);
	        this.setStepSound(soundTypeWood);	
	        float f = 0.375F;
	        float f1 = f / 2.0F;
	        this.setBlockBounds(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, 1f, 0.5F + f1);

	        }
	 public int getRenderType()
	    {
	        return -44;
	    }
	    public boolean isOpaqueCube()
	    {
	    return false;
	    }
	    public boolean renderAsNormalBlock()
	    {
	    return false;
	    }
	    public TileEntity createNewTileEntity(World var1, int var2)
	    {
	    return new TileEntityTreeFernLog();
	    }
	    
	    
	    
	    
	    public int quantityDropped(Random p_149745_1_)
	    {
	        return 1;
	    }

	    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	    {
	        return Item.getItemFromBlock(this);
	    }

	    public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
	    {
	        byte b0 = 4;
	        int i1 = b0 + 1;

	        if (p_149749_1_.checkChunksExist(p_149749_2_ - i1, p_149749_3_ - i1, p_149749_4_ - i1, p_149749_2_ + i1, p_149749_3_ + i1, p_149749_4_ + i1))
	        {
	            for (int j1 = -b0; j1 <= b0; ++j1)
	            {
	                for (int k1 = -b0; k1 <= b0; ++k1)
	                {
	                    for (int l1 = -b0; l1 <= b0; ++l1)
	                    {
	                        Block block = p_149749_1_.getBlock(p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1);
	                        if (block.isLeaves(p_149749_1_, p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1))
	                        {
	                            block.beginLeavesDecay(p_149749_1_, p_149749_2_ + j1, p_149749_3_ + k1, p_149749_4_ + l1);
	                        }
	                    }
	                }
	            }
	        }
	    }
	    @Override
	    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
	    {
	        return true;
	    }

	    @Override
	    public boolean isWood(IBlockAccess world, int x, int y, int z)
	    {
	        return true;
	    }
}

