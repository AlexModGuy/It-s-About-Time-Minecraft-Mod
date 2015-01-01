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


public class ItemArmorPlates extends Item

{
	private static final String[] Plates = new String[] {"Trilobite", "Anomalocaris", "Opabina"};
	private IIcon[] textures;
	
	public ItemArmorPlates()
	{
		super();
		this.setHasSubtypes(true);
	}
	

	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
    {
		for (int i = 0; i < Plates.length; ++i) 
		{
			if (i != 3)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
    }

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		textures = new IIcon[Plates.length];

		for (int i = 0; i < Plates.length; ++i) 
		{
			textures[i] = iconRegister.registerIcon("iat:"+"Plate_" + Plates[i]);
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
    @SideOnly(Side.CLIENT)
    public void addInformation (ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        switch (stack.getItemDamage())
        {
        // Carapace
        case 0:
            list.add( StatCollector.translateToLocal("Trilobite"));

            break;
        case 1:
            list.add(StatCollector.translateToLocal("Anomalocaris"));

            break;
        case 2:
            list.add( StatCollector.translateToLocal("Opabina"));
            break;
      
        }
    }


	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int meta = itemStack.getItemDamage();
		if (meta < 0 || meta >= Plates.length) 
		{
			meta = 0;
		}

		return super.getUnlocalizedName() + "." + Plates[meta];
	}
}

