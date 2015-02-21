package iat.blocks;

import iat.core.ModBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockHorseTail extends Block implements IPlantable
{
	public BlockHorseTail(Material material)
	{
		super(material);
		float f = 0.13F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
		this.setTickRandomly(true);
	}

	/**
	 * Ticks the block if it's been scheduled
	 */
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		if (world.isAirBlock(x, y + 1, z))
		{
			int l;

			for (l = 1; world.getBlock(x, y - l, z) == this; ++l)
			{
				;
			}

			if (l < 3)
			{
				int i1 = world.getBlockMetadata(x, y, z);

				if (i1 == 15)
				{
					world.setBlock(x, y + 1, z, this);
					world.setBlockMetadataWithNotify(x, y, z, 0, 4);
					this.onNeighborBlockChange(world, x, y + 1, z, this);
				}
				else
				{
					world.setBlockMetadataWithNotify(x, y, z, i1 + 1, 4);
				}
			}
		}
	}

	/**
	 * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
	 */
	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y - 1, z);
		if(block == ModBlocks.horsetail || block == ModBlocks.low_Fern_Block || block == Blocks.grass
				|| block == Blocks.sand || block == Blocks.gravel || block == Blocks.dirt){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
	 * their own) Args: x, y, z, neighbor Block
	 */
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
	{
		this.neigborChange(world, x, y, z, block);
	}
	public boolean neigborChange(World world, int x, int y, int z, Block block){
		if (!this.canBlockStay(world, x, y, z))
		{
			this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockToAir(x, y, z);
			return false;
		}
		else
		{
			return true;
		}	
	}

	/**
	 * Can this block stay at this position.  Similar to canPlaceBlockAt except gets checked often with plants.
	 */
	public boolean canBlockStay(World world, int x, int y, int z)
	{
		return this.canPlaceBlockAt(world, x, y, z);
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	 * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube()
	{
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType()
	{
		return 1;
	}



	/**
	 * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
	 * when first determining what to render.
	 */
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess b, int x, int y, int z)
	{
		return 16777215;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z)
	{
		return EnumPlantType.Plains;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z)
	{
		return this;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z)
	{
		return world.getBlockMetadata(x, y, z);
	}
}