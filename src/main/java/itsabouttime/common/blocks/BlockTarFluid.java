package itsabouttime.common.blocks;

import java.util.Random;

import itsabouttime.client.particle.TarBubbleHelper;
import itsabouttime.common.core.IATstuff;
import itsabouttime.common.core.IATachievements;
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
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTarFluid extends BlockFluidClassic{
	public static IIcon LiquidTarStillIcon;
	public static IIcon LiquidTarFlowingIcon;

	public BlockTarFluid(){
		super(IATstuff.fluidTar, IATstuff.materialFluidTar);
	this.setBlockTextureName("dragonborn:Tar");
	}
	
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
	
			  super.randomDisplayTick(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
			  if (p_149734_5_.nextInt(100) == 0)
		        {
		            p_149734_1_.playSound((double)p_149734_2_ + 0.5D, (double)p_149734_3_ + 0.5D, (double)p_149734_4_ + 0.5D, "liquid.lava", 0.1F, 10F, false);
		        }
			  if (p_149734_5_.nextInt(50) == 0)
		        {
		            p_149734_1_.playSound((double)p_149734_2_ + 0.5D, (double)p_149734_3_ + 0.5D, (double)p_149734_4_ + 0.5D, "liquid.lavapop", 0.1F, 10F, false);
		        }
		        if (p_149734_5_.nextInt(2) == 0)
		        {
		        	
		            p_149734_1_.spawnParticle("townaura", (double)((float)p_149734_2_ + p_149734_5_.nextFloat()), (double)((float)p_149734_3_ + 1.1F), (double)((float)p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
		            p_149734_1_.spawnParticle("tarbubble", (double)((float)p_149734_2_ + p_149734_5_.nextFloat()), (double)((float)p_149734_3_ + 1.1F), (double)((float)p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
		        }
		        if (p_149734_5_.nextInt(1) == 0)
		        {
	                TarBubbleHelper.spawnParticle("tarbubble",(double)((float)p_149734_2_ + p_149734_5_.nextFloat()), (double)((float)p_149734_3_ + 1.1F), (double)((float)p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
	
		        }
		}
	
	@Override
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
		int meta = world.getBlockMetadata(x, y, z);
		if (entity instanceof EntityLivingBase)
			if((entity instanceof Entity || entity instanceof EntityPlayer) && entity.getEyeHeight()+entity.posY >= y && entity.getEyeHeight()+entity.posY <=y+1)
				entity.attackEntityFrom(DamageSource.inWall, 1.0F);
		{
		

		

	{
		entity.setInWeb();
	}
}


		if (entity instanceof EntityPlayer&&entity.isInsideOfMaterial(IATstuff.materialFluidTar)&&entity.isDead)
		{
		((EntityPlayer)entity).triggerAchievement(IATachievements.AchTarDrown);
		}
	}
	  @Override
      public IIcon getIcon(int side, int meta) {
              return (side == 0 || side == 1)? LiquidTarStillIcon : LiquidTarFlowingIcon;
      }
      
      @SideOnly(Side.CLIENT)
      @Override
      public void registerBlockIcons(IIconRegister register) {
              LiquidTarStillIcon = register.registerIcon("iat:Tar");
              LiquidTarFlowingIcon = register.registerIcon("iat:Tar_Flow");
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