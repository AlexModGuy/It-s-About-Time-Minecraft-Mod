package iat.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import iat.core.ModDimensions;
import iat.entities.particles.EntityGalaxyFX;
//import iat.entities.particles.EntityGlowingFX;
import iat.entities.particles.EntityTimeRiftFX;
import iat.entities.tile.TileEntityTimeRift;
import iat.misc.IatTeleporter;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockTimeRift extends BlockContainer {
	int dimensionID;
	public boolean hasGalaxy;
	public BlockTimeRift(Material mat, int dimension) {
		super(mat);
		this.dimensionID = dimension;

	}
	public int getRenderType()
	{
		return -27;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon("iat:time_Rift");
	}
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return new TileEntityTimeRift();
	}
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase base, ItemStack stack) {
		this.setHasGalaxy(false);
	}

	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB bb, List list, Entity entity) {}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand)
	{
		super.randomDisplayTick(world, x, y, z, rand);

		if (rand.nextInt(60) == 0)
		{
			world.playSound((double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, "iat:world.rift", 1.5F, rand.nextFloat() * 0.4F + 0.8F, false);
		}
		for (int l = x - 2; l <= x + 2; ++l)
		{
			for (int i1 = z - 2; i1 <= z + 2; ++i1)
			{
				if (l > x - 2 && l < x + 2 && i1 == z - 1)
				{
					i1 = z + 2;
				}

				if (rand.nextInt(16) == 0)
				{
					for (int j1 = y; j1 <= y + 1; ++j1)
					{

						if (!world.isAirBlock((l - x) / 2 + x, j1, (i1 - z) / 2 + z))
						{
							break;
						}

						EntityFX particle1 = new EntityTimeRiftFX(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, (double)((float)(l - x) + rand.nextFloat()) - 0.5D, (double)((float)(j1 - y) - rand.nextFloat() - 1.0F), (double)((float)(i1 - z) + rand.nextFloat()) - 0.5D);
						Minecraft.getMinecraft().effectRenderer.addEffect(particle1); 

					}
				}

			}
		}
		if(!hasGalaxy){
			EntityFX particle2 = new EntityGalaxyFX(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D);
			//Minecraft.getMinecraft().effectRenderer.addEffect(particle2);
			this.setHasGalaxy(true);

		}
	}
	public void setHasGalaxy(boolean state) {

		hasGalaxy = state;

	}
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if ((par5Entity.ridingEntity == null) && (par5Entity.riddenByEntity == null) && (par5Entity instanceof EntityPlayerMP))
		{
			EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;

			if (thePlayer.timeUntilPortal > 0)
			{
				thePlayer.timeUntilPortal = 10;
			}
			else if (thePlayer.dimension != dimensionID)
			{
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, dimensionID, new IatTeleporter(thePlayer.mcServer.worldServerForDimension(dimensionID)));
			}
			else
			{
				thePlayer.timeUntilPortal = 10;
				thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new IatTeleporter(thePlayer.mcServer.worldServerForDimension(0)));
			}
		}
	}


}
