package itsabouttime.common.items;

import itsabouttime.iat;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class ItemOldFruit extends Item

{
	private static final String[] Fruit = new String[] {"Trilobite"};
	private IIcon[] textures;
	
	public ItemOldFruit()
	{
		super();
		this.setHasSubtypes(true);
	}
	

	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
    {
		for (int i = 0; i < Fruit.length; ++i) 
		{
			//change to number of fossils
			if (i != 1)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
    }

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		textures = new IIcon[Fruit.length];

		for (int i = 0; i < Fruit.length; ++i) 
		{
			textures[i] = iconRegister.registerIcon("iat:"+"Fruit_" + Fruit[i]);
		}
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
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int meta = itemStack.getItemDamage();
		if (meta < 0 || meta >= Fruit.length) 
		{
			meta = 0;
		}

		return super.getUnlocalizedName() + "." + Fruit[meta];
	}
}

