package itsabouttime.common.blocks.fluid;


import itsabouttime.common.blocks.BlockTarFluid;
import itsabouttime.common.core.IATstuff;

import java.util.Random;



import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;


public class TarFluid extends Fluid
{
	public TarFluid(String fluidName) 
	{
		super(fluidName);
this.setViscosity(6000);

		this.setIcons(BlockTarFluid.LiquidTarStillIcon, BlockTarFluid.LiquidTarFlowingIcon);
	}
	 protected Block block = IATstuff.BlockTarFluid;
	 
	
}
