package iat.blocks;



import iat.ItsAboutTime;
import iat.ProxyClient;
import iat.core.ModBlocks;
import iat.entities.particles.EntityTimeRiftFX;
import iat.entities.tile.TileEntityMatterConverter;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMatterConverter extends BlockContainer {

	private final boolean isActive;

	@SideOnly(Side.CLIENT)
	private IIcon iconFront;

	@SideOnly(Side.CLIENT)
	private IIcon iconTop;

	private static boolean keepInventory;
	private Random rand = new Random();

	public BlockMatterConverter(Material mat, boolean isActive) {
		super(mat);

		this.isActive = isActive;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		//SideTexture
		this.blockIcon = iconRegister.registerIcon("iat:matter_Converter_Side");
		//FrontTexture
		this.iconFront = iconRegister.registerIcon(this.isActive ? "iat:matter_Converter_Front_On" : "iat:matter_Converter_Front_Off");
		//Top&BottomTexture
		this.iconTop = iconRegister.registerIcon("iat:matter_Converter_Side");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return metadata == 0 && side == 3 ? this.iconFront : side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side == metadata ? this.iconFront : this.blockIcon));
		//return side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side != metadata ? this.blockIcon : this.iconFront));
	}

	public Item getItemDropped(int i, Random random, int j) {
		return Item.getItemFromBlock(ModBlocks.Matter_converter_off);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}

	private void setDefaultDirection(World world, int x, int y, int z) {
		if(!world.isRemote) {
			Block b1 = world.getBlock(x, y, z - 1);
			Block b2 = world.getBlock(x,  y,  z + 1);
			Block b3 = world.getBlock(x - 1, y, z);
			Block b4  = world.getBlock(x + 1, y, z);

			byte b0 = 3;

			if(b1.func_149730_j() && !b2.func_149730_j()) {
				b0 = 3;	
			}

			if(b2.func_149730_j() && !b1.func_149730_j()) {
				b0 = 2;	
			}

			if(b3.func_149730_j() && !b4.func_149730_j()) {
				b0 = 5;	
			}

			if(b4.func_149730_j() && !b3.func_149730_j()) {
				b0 = 4;	
			}

			world.setBlockMetadataWithNotify(x, y, x, b0, 2);
		}

	}


	@Override
	public boolean onBlockActivated(World var1, int var2, int var3, int var4, EntityPlayer player, int var6, float var7, float var8, float var9) {
		if (!player.isSneaking()) {
			player.openGui(ItsAboutTime.instance, ItsAboutTime.GUIMatterConverterID, var1, var2, var3, var4);
			return true;
		} else {
			return false;
		}
	}
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityMatterConverter();
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		super.randomDisplayTick(world, x, y, z, rand);

		if(this.isActive) {

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

								EntityFX particle = new EntityTimeRiftFX(world, (double)x + 0.5D, (double)y + 0.5D, (double)z + 0.5D, (double)((float)(l - x) + rand.nextFloat()) - 0.5D, (double)((float)(j1 - y) - rand.nextFloat() - 1.0F), (double)((float)(i1 - z) + rand.nextFloat()) - 0.5D);
								Minecraft.getMinecraft().effectRenderer.addEffect(particle);                        }
						}

					}
				}
			}
		}
	

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack) {
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.F) + 0.5D) & 3;

		if(l == 0) {
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}

		if(l == 1) {
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}

		if(l == 2) {
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}

		if(l == 3) {
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}

		if(itemstack.hasDisplayName()) {
			((TileEntityMatterConverter)world.getTileEntity(x, y, z)).func_145951_a(itemstack.getDisplayName());
		}
	}

	public static void updateDistilleryBlockState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord) {
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

		TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;

		if(active) {
			worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.Matter_converter_on);
		}else{
			worldObj.setBlock(xCoord, yCoord, zCoord, ModBlocks.Matter_converter_off);
		}

		keepInventory = false;

		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

		if(tileentity != null) {
			tileentity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block oldblock, int oldMetadata) {
		if(!keepInventory) {
			TileEntityMatterConverter tileentity = (TileEntityMatterConverter) world.getTileEntity(x, y, z);

			if(tileentity != null) {
				for(int i = 0; i < tileentity.getSizeInventory(); i++) {
					ItemStack itemstack = tileentity.getStackInSlot(i);

					if(itemstack != null) {
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

						while(itemstack.stackSize > 0) {
							int j = this.rand.nextInt(21) + 10;

							if(j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}

							itemstack.stackSize -= j;

							EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

							if(itemstack.hasTagCompound()) {
								item.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
							}

							world.spawnEntityInWorld(item);
						}
					}
				}

				world.func_147453_f(x, y, z, oldblock);
			}
		}

		super.breakBlock(world, x, y, z, oldblock, oldMetadata);
	}

	public Item getItem(World world, int x, int y, int z) {
		return Item.getItemFromBlock(ModBlocks.Matter_converter_off);
	}

}