
package iat.world.structure;

import iat.core.ModBlocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructurePit extends WorldGenerator
{
	protected Block[] GetValidSpawnBlocks()
	{
		return new Block[]
		{
			ModBlocks.grid,
		};
	}

	public boolean LocationIsValidSpawn(World world, int x, int y, int z)
	{
		int distanceToAir = 0;
		Block checkBlock = world.getBlock(x, y, z);

		while (checkBlock != Blocks.air)
		{
			distanceToAir++;
			checkBlock = world.getBlock(x, y + distanceToAir, z);
		}

		if (distanceToAir > 1)
		{
			return false;
		}

		y += distanceToAir - 1;

		Block block = world.getBlock(x, y, z);
		Block blockAbove = world.getBlock(x, y + 1, z);
		Block blockBelow = world.getBlock(x, y - 1, z);

		for (Block i : GetValidSpawnBlocks())
		{
			if (blockAbove != Blocks.air)
			{
				return false;
			}
			if (block == i)
			{
				return true;
			}
			else if (block == Blocks.snow_layer && blockBelow == i)
			{
				return true;
			}
			else if (block.getMaterial() == Material.plants && blockBelow == i)
			{
				return true;
			}
		}
		return false;
	}

	public boolean generate(World world, Random rand, int x, int y, int z)
	{
		int i = rand.nextInt(1);

		if(i == 0)
		{
		    generate_r0(world, rand, x, y, z);
		}

       return true;

	}

	public boolean generate_r0(World world, Random rand, int x, int y, int z)
	{
		if(!LocationIsValidSpawn(world, x + 6, y, z + 6))
		{
			return false;
		}

		world.setBlock(x + 0, y + 0, z + 0, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 0, z + 0, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 2, y + 0, z + 0, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 3, y + 0, z + 0, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 4, y + 0, z + 0, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 5, y + 0, z + 0, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 6, y + 0, z + 0, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 7, y + 0, z + 0, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 8, y + 0, z + 0, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 9, y + 0, z + 0, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 10, y + 0, z + 0, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 11, y + 0, z + 0, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 0, y + 0, z + 1, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 0, z + 1, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 2, y + 0, z + 1, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 3, y + 0, z + 1, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 4, y + 0, z + 1, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 5, y + 0, z + 1, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 6, y + 0, z + 1, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 7, y + 0, z + 1, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 8, y + 0, z + 1, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 9, y + 0, z + 1, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 10, y + 0, z + 1, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 11, y + 0, z + 1, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 0, y + 0, z + 2, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 0, z + 2, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 2, y + 0, z + 2, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 3, y + 0, z + 2, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 4, y + 0, z + 2, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 5, y + 0, z + 2, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 6, y + 0, z + 2, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 7, y + 0, z + 2, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 8, y + 0, z + 2, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 9, y + 0, z + 2, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 10, y + 0, z + 2, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 11, y + 0, z + 2, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 0, y + 0, z + 3, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 0, z + 3, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 2, y + 0, z + 3, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 3, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 5, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 6, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 7, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 8, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 9, y + 0, z + 3, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 10, y + 0, z + 3, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 11, y + 0, z + 3, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 0, y + 0, z + 4, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 0, z + 4, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 2, y + 0, z + 4, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 3, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + 0, z + 4, Blocks.bedrock, 0, 3);
		world.setBlock(x + 5, y + 0, z + 4, Blocks.bedrock, 0, 3);
		world.setBlock(x + 6, y + 0, z + 4, Blocks.bedrock, 0, 3);
		world.setBlock(x + 7, y + 0, z + 4, Blocks.bedrock, 0, 3);
		world.setBlock(x + 8, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 9, y + 0, z + 4, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 10, y + 0, z + 4, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 11, y + 0, z + 4, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 0, y + 0, z + 5, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 0, z + 5, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 2, y + 0, z + 5, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 3, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + 0, z + 5, Blocks.bedrock, 0, 3);
		world.setBlock(x + 5, y + 0, z + 5, Blocks.bedrock, 0, 3);
		world.setBlock(x + 6, y + 0, z + 5, Blocks.bedrock, 0, 3);
		world.setBlock(x + 7, y + 0, z + 5, Blocks.bedrock, 0, 3);
		world.setBlock(x + 8, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 9, y + 0, z + 5, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 10, y + 0, z + 5, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 11, y + 0, z + 5, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 0, y + 0, z + 6, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 0, z + 6, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 2, y + 0, z + 6, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 3, y + 0, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + 0, z + 6, Blocks.bedrock, 0, 3);
		world.setBlock(x + 5, y + 0, z + 6, Blocks.bedrock, 0, 3);
		world.setBlock(x + 6, y + 0, z + 6, Blocks.bedrock, 0, 3);
		world.setBlock(x + 7, y + 0, z + 6, Blocks.bedrock, 0, 3);
		world.setBlock(x + 8, y + 0, z + 6, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 9, y + 0, z + 6, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 10, y + 0, z + 6, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 11, y + 0, z + 6, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 0, y + 0, z + 7, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 0, z + 7, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 2, y + 0, z + 7, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 3, y + 0, z + 7, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + 0, z + 7, Blocks.bedrock, 0, 3);
		world.setBlock(x + 5, y + 0, z + 7, Blocks.bedrock, 0, 3);
		world.setBlock(x + 6, y + 0, z + 7, Blocks.bedrock, 0, 3);
		world.setBlock(x + 7, y + 0, z + 7, Blocks.bedrock, 0, 3);
		world.setBlock(x + 8, y + 0, z + 7, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 9, y + 0, z + 7, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 10, y + 0, z + 7, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 11, y + 0, z + 7, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 0, y + 0, z + 8, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 0, z + 8, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 2, y + 0, z + 8, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 3, y + 0, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 4, y + 0, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 5, y + 0, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 6, y + 0, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 7, y + 0, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 8, y + 0, z + 8, Blocks.cobblestone, 0, 3);
		world.setBlock(x + 9, y + 0, z + 8, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 10, y + 0, z + 8, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 11, y + 0, z + 8, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 0, y + 0, z + 9, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 0, z + 9, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 2, y + 0, z + 9, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 3, y + 0, z + 9, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 4, y + 0, z + 9, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 5, y + 0, z + 9, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 6, y + 0, z + 9, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 7, y + 0, z + 9, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 8, y + 0, z + 9, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 9, y + 0, z + 9, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 10, y + 0, z + 9, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 11, y + 0, z + 9, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 0, y + 0, z + 10, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 0, z + 10, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 2, y + 0, z + 10, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 3, y + 0, z + 10, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 4, y + 0, z + 10, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 5, y + 0, z + 10, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 6, y + 0, z + 10, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 7, y + 0, z + 10, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 8, y + 0, z + 10, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 9, y + 0, z + 10, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 10, y + 0, z + 10, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 11, y + 0, z + 10, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 0, y + 0, z + 11, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 0, z + 11, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 2, y + 0, z + 11, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 3, y + 0, z + 11, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 4, y + 0, z + 11, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 5, y + 0, z + 11, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 6, y + 0, z + 11, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 7, y + 0, z + 11, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 8, y + 0, z + 11, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 9, y + 0, z + 11, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 10, y + 0, z + 11, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 11, y + 0, z + 11, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 1, y + 1, z + 1, Blocks.stone_brick_stairs, 0, 3);
		world.setBlock(x + 2, y + 1, z + 1, Blocks.stone_brick_stairs, 2, 3);
		world.setBlock(x + 3, y + 1, z + 1, Blocks.stone_brick_stairs, 2, 3);
		world.setBlock(x + 4, y + 1, z + 1, Blocks.stone_brick_stairs, 2, 3);
		world.setBlock(x + 5, y + 1, z + 1, Blocks.stone_brick_stairs, 2, 3);
		world.setBlock(x + 6, y + 1, z + 1, Blocks.stone_brick_stairs, 2, 3);
		world.setBlock(x + 7, y + 1, z + 1, Blocks.stone_brick_stairs, 2, 3);
		world.setBlock(x + 8, y + 1, z + 1, Blocks.stone_brick_stairs, 2, 3);
		world.setBlock(x + 9, y + 1, z + 1, Blocks.stone_brick_stairs, 2, 3);
		world.setBlock(x + 10, y + 1, z + 1, Blocks.stone_brick_stairs, 2, 3);
		world.setBlock(x + 1, y + 1, z + 2, Blocks.stone_brick_stairs, 0, 3);
		world.setBlock(x + 2, y + 1, z + 2, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 3, y + 1, z + 2, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 4, y + 1, z + 2, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 5, y + 1, z + 2, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 6, y + 1, z + 2, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 7, y + 1, z + 2, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 8, y + 1, z + 2, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 9, y + 1, z + 2, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 10, y + 1, z + 2, Blocks.stone_brick_stairs, 1, 3);
		world.setBlock(x + 1, y + 1, z + 3, Blocks.stone_brick_stairs, 0, 3);
		world.setBlock(x + 2, y + 1, z + 3, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 3, y + 1, z + 3, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 4, y + 1, z + 3, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 5, y + 1, z + 3, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 6, y + 1, z + 3, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 7, y + 1, z + 3, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 8, y + 1, z + 3, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 9, y + 1, z + 3, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 10, y + 1, z + 3, Blocks.stone_brick_stairs, 1, 3);
		world.setBlock(x + 1, y + 1, z + 4, Blocks.stone_brick_stairs, 0, 3);
		world.setBlock(x + 2, y + 1, z + 4, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 3, y + 1, z + 4, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 4, y + 1, z + 4, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 5, y + 1, z + 4, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 6, y + 1, z + 4, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 7, y + 1, z + 4, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 8, y + 1, z + 4, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 9, y + 1, z + 4, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 10, y + 1, z + 4, Blocks.stone_brick_stairs, 1, 3);
		world.setBlock(x + 1, y + 1, z + 5, Blocks.stone_brick_stairs, 0, 3);
		world.setBlock(x + 2, y + 1, z + 5, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 3, y + 1, z + 5, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 4, y + 1, z + 5, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 5, y + 1, z + 5, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 6, y + 1, z + 5, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 7, y + 1, z + 5, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 8, y + 1, z + 5, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 9, y + 1, z + 5, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 10, y + 1, z + 5, Blocks.stone_brick_stairs, 1, 3);
		world.setBlock(x + 1, y + 1, z + 6, Blocks.stone_brick_stairs, 0, 3);
		world.setBlock(x + 2, y + 1, z + 6, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 3, y + 1, z + 6, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 4, y + 1, z + 6, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 5, y + 1, z + 6, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 6, y + 1, z + 6, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 7, y + 1, z + 6, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 8, y + 1, z + 6, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 9, y + 1, z + 6, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 10, y + 1, z + 6, Blocks.stone_brick_stairs, 1, 3);
		world.setBlock(x + 1, y + 1, z + 7, Blocks.stone_brick_stairs, 0, 3);
		world.setBlock(x + 2, y + 1, z + 7, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 3, y + 1, z + 7, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 4, y + 1, z + 7, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 5, y + 1, z + 7, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 6, y + 1, z + 7, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 7, y + 1, z + 7, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 8, y + 1, z + 7, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 9, y + 1, z + 7, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 10, y + 1, z + 7, Blocks.stone_brick_stairs, 1, 3);
		world.setBlock(x + 1, y + 1, z + 8, Blocks.stone_brick_stairs, 0, 3);
		world.setBlock(x + 2, y + 1, z + 8, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 3, y + 1, z + 8, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 4, y + 1, z + 8, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 5, y + 1, z + 8, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 6, y + 1, z + 8, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 7, y + 1, z + 8, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 8, y + 1, z + 8, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 9, y + 1, z + 8, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 10, y + 1, z + 8, Blocks.stone_brick_stairs, 1, 3);
		world.setBlock(x + 1, y + 1, z + 9, Blocks.stone_brick_stairs, 0, 3);
		world.setBlock(x + 2, y + 1, z + 9, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 3, y + 1, z + 9, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 4, y + 1, z + 9, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 5, y + 1, z + 9, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 6, y + 1, z + 9, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 7, y + 1, z + 9, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 8, y + 1, z + 9, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 9, y + 1, z + 9, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 10, y + 1, z + 9, Blocks.stone_brick_stairs, 1, 3);
		world.setBlock(x + 1, y + 1, z + 10, Blocks.stone_brick_stairs, 0, 3);
		world.setBlock(x + 2, y + 1, z + 10, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 3, y + 1, z + 10, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 4, y + 1, z + 10, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 5, y + 1, z + 10, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 6, y + 1, z + 10, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 7, y + 1, z + 10, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 8, y + 1, z + 10, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 9, y + 1, z + 10, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 10, y + 1, z + 10, Blocks.stone_brick_stairs, 1, 3);
		world.setBlock(x + 2, y + 2, z + 2, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 3, y + 2, z + 2, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 4, y + 2, z + 2, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 5, y + 2, z + 2, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 6, y + 2, z + 2, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 7, y + 2, z + 2, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 8, y + 2, z + 2, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 9, y + 2, z + 2, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 2, y + 2, z + 3, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 3, y + 2, z + 3, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 4, y + 2, z + 3, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 5, y + 2, z + 3, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 6, y + 2, z + 3, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 7, y + 2, z + 3, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 8, y + 2, z + 3, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 9, y + 2, z + 3, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 2, y + 2, z + 4, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 3, y + 2, z + 4, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 4, y + 2, z + 4, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 5, y + 2, z + 4, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 6, y + 2, z + 4, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 7, y + 2, z + 4, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 8, y + 2, z + 4, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 9, y + 2, z + 4, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 2, y + 2, z + 5, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 3, y + 2, z + 5, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 4, y + 2, z + 5, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 5, y + 2, z + 5, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 6, y + 2, z + 5, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 7, y + 2, z + 5, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 8, y + 2, z + 5, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 9, y + 2, z + 5, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 2, y + 2, z + 6, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 3, y + 2, z + 6, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 4, y + 2, z + 6, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 5, y + 2, z + 6, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 6, y + 2, z + 6, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 7, y + 2, z + 6, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 8, y + 2, z + 6, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 9, y + 2, z + 6, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 2, y + 2, z + 7, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 3, y + 2, z + 7, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 4, y + 2, z + 7, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 5, y + 2, z + 7, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 6, y + 2, z + 7, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 7, y + 2, z + 7, ModBlocks.fluidTimeBlock, 0, 3);
		world.setBlock(x + 8, y + 2, z + 7, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 9, y + 2, z + 7, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 2, y + 2, z + 8, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 3, y + 2, z + 8, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 4, y + 2, z + 8, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 5, y + 2, z + 8, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 6, y + 2, z + 8, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 7, y + 2, z + 8, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 8, y + 2, z + 8, Blocks.stonebrick, 3, 3);
		world.setBlock(x + 9, y + 2, z + 8, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 2, y + 2, z + 9, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 3, y + 2, z + 9, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 4, y + 2, z + 9, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 5, y + 2, z + 9, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 6, y + 2, z + 9, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 7, y + 2, z + 9, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 8, y + 2, z + 9, Blocks.stone_slab, 0, 3);
		world.setBlock(x + 9, y + 2, z + 9, Blocks.stone_slab, 0, 3);
		return true;

	}

}