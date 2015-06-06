package iat.items;

import iat.blocks.BlockPrehistoricWood;
import iat.core.ModBlocks;
import iat.enums.EnumPrehistoricTrees;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGinkoNut extends Item {

	 public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int j, float k, float l, float i)
	    {
	        if (!player.canPlayerEdit(x, y, z, j, item))
	        {
	            return false;
	        }
	       
	                Block block = world.getBlock(x, y, z);
	                int i1 = world.getBlockMetadata(x, y, z);

	                if (block == EnumPrehistoricTrees.Ginko.leavesBlock)
	                {
	                    if (j == 0)
	                    {
	                        return false;
	                    }

	                    if (j == 1)
	                    {
	                        return false;
	                    }

	                    if (j == 2)
	                    {
	                        --z;
	                    }

	                    if (j == 3)
	                    {
	                        ++z;
	                    }

	                    if (j == 4)
	                    {
	                        --x;
	                    }

	                    if (j == 5)
	                    {
	                        ++x;
	                    }

	                    if (world.isAirBlock(x, y, z))
	                    {
	                        int j1 = ModBlocks.ginkoNut.onBlockPlaced(world, x, y, z, j, k, l, i, 0);
	                        world.setBlock(x, y, z, ModBlocks.ginkoNut, j1, 2);

	                        if (!player.capabilities.isCreativeMode)
	                        {
	                            --item.stackSize;
	                        }
	                    }

	                    return true;
	                }
	            

	            return false;
	        }
	    
}
