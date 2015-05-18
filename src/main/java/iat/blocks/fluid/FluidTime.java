package iat.blocks.fluid;

import iat.blocks.BlockTimeFluid;
import iat.core.ModBlocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;


public class FluidTime extends Fluid
{
	public FluidTime(String fluidName) 
	{
		super(fluidName);
		this.setViscosity(120);
		this.setLuminosity(1);
		this.setTemperature(-2);
		this.setDensity(3);
		this.setIcons(BlockTimeFluid.stillIcon, BlockTimeFluid.flowingIcon);
	}
	protected Block block = ModBlocks.fluidTimeBlock;


}
