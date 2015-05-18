package iat.items;

import iat.core.ModBlocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemAmber extends Item

{
	private Block placedBlock;
	private static final String[] fossils = new String[] {"Silverfish", "Spider", "Compsognathus"};
	private IIcon[] textures;
	private IIcon theIcon;

	public ItemAmber()
	{
		super();
        this.maxStackSize = 16;
		this.setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int x, int y)
	{
		return y > 0 ? super.getIconFromDamageForRenderPass(x, y) : this.theIcon;
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float x1, float y1, float z1)
	{
		if(this.getDamage(stack) == 0){
			placedBlock = ModBlocks.amber_Silverfish;
		}
		if(this.getDamage(stack) == 1){
			placedBlock = ModBlocks.amber_Spider;
		}
		if(this.getDamage(stack) == 2){
			placedBlock = ModBlocks.amber_Compsognathus;
		}
		
		Block block = world.getBlock(x, y, z);

		if (meta == 0)
		{
			--y;
		}

		if (meta == 1)
		{
			++y;
		}

		if (meta == 2)
		{
			--z;
		}

		if (meta == 3)
		{
			++z;
		}

		if (meta == 4)
		{
			--x;
		}

		if (meta == 5)
		{
			++x;
		}


		if (!player.canPlayerEdit(x, y, z, meta, stack))
		{
			return false;
		}
		else if (stack.stackSize == 0)
		{
			return false;
		}
		else
		{
			if (world.canPlaceEntityOnSide(this.placedBlock, x, y, z, false, meta, (Entity)null, stack))
			{
				int i1 = this.placedBlock.onBlockPlaced(world, x, y, z, meta, x1, y1, z1, 0);

				if (world.setBlock(x, y, z, this.placedBlock, i1, 3))
				{
					if (world.getBlock(x, y, z) == this.placedBlock)
					{
						this.placedBlock.onBlockPlacedBy(world, x, y, z, player, stack);
						this.placedBlock.onPostBlockPlaced(world, x, y, z, i1);
					}

					world.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), this.placedBlock.stepSound.func_150496_b(), (this.placedBlock.stepSound.getVolume() + 1.0F) / 2.0F, this.placedBlock.stepSound.getPitch() * 0.8F);
					--stack.stackSize;
				}
			}

			return true;
		}
	}
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
	{
		for (int i = 0; i < fossils.length; ++i) 
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		textures = new IIcon[fossils.length];

		for (int i = 0; i < fossils.length; ++i) 
		{
			textures[i] = iconRegister.registerIcon("iat:"+"amber_" + fossils[i]);
		}
		this.theIcon = iconRegister.registerIcon("iat:overlay_Amber");

	}

	@Override
	public IIcon getIconFromDamage(int meta)
	{
		if (meta < 0 || meta >= textures.length) 
		{
			meta = 0;
		}

		return textures[meta];
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add( StatCollector.translateToLocal("message.fossil.amber"));

		switch (stack.getItemDamage())
		{
		case 0:
			list.add( StatCollector.translateToLocal("Silverfish"));
			list.add( StatCollector.translateToLocal("300 MYA – 167 MYTC"));
			list.add( StatCollector.translateToLocal("message.fossil.science" + ":"+ "\u00a7o" + " Lepisma Saccharina"));
			break;
		case 1:
			list.add( StatCollector.translateToLocal("Spider"));
			list.add( StatCollector.translateToLocal("298 MYA – 256 MYTC"));
			list.add( StatCollector.translateToLocal("message.fossil.science" + ":"+ "\u00a7o" + " Badumna Russusoculus"));
			break;
		case 2:
			list.add( StatCollector.translateToLocal("Compsognathus"));
			list.add( StatCollector.translateToLocal("150.8 MYA"));
			list.add( StatCollector.translateToLocal("message.fossil.science" + ":"+ "\u00a7o" + " Compsognathus Longipes"));
			break;


		}
	}

}

