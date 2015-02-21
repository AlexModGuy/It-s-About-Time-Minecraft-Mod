package iat.items;

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


public class ItemAmber extends Item

{
	private static final String[] fossils = new String[] {"Spider", "Compsognathus"};
	private IIcon[] textures;
    private IIcon theIcon;

	public ItemAmber()
	{
		super();
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
		return y > 1 ? this.theIcon : super.getIconFromDamageForRenderPass(x, y);
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
			list.add( StatCollector.translateToLocal("Spider"));
			list.add( StatCollector.translateToLocal("319 MYA – 256 MYTC"));
			list.add( StatCollector.translateToLocal("message.fossil.science" + ":"+ "\u00a7o" + "Badumna Russusoculus"));
			break;
		case 1:
			list.add( StatCollector.translateToLocal("Compsognathus"));
			list.add( StatCollector.translateToLocal("150.8 MYA"));
			list.add( StatCollector.translateToLocal("message.fossil.science" + ":"+ "\u00a7o" + " Compsognathus Longipes"));
			break;


		}
	}

}

