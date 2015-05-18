package iat.blocks;

import java.util.Random;

import iat.core.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTimeFluid extends BlockFluidClassic{
	public static IIcon stillIcon;
	public static IIcon flowingIcon;

	public BlockTimeFluid(Fluid fluid, Material material){
		super(fluid, material);
	}
	
	
	  @Override
      public IIcon getIcon(int side, int meta) {
              return (side == 0 || side == 1)? stillIcon : flowingIcon;
      }
      
      @SideOnly(Side.CLIENT)
      @Override
      public void registerBlockIcons(IIconRegister register) {
              stillIcon = register.registerIcon("iat:compressedSpaceTime_Still");
              flowingIcon = register.registerIcon("iat:compressedSpaceTime_Flow");
      }
  	
  	@Override
  	
  	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
  	{
  		if (entity instanceof EntityLivingBase){
  			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.confusion.id, 100, 6));
  		}

  }
      @Override
      public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
              if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
              return super.canDisplace(world, x, y, z);
      }
      
      @Override
      public boolean displaceIfPossible(World world, int x, int y, int z) {
              if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
              return super.displaceIfPossible(world, x, y, z);
      }
}