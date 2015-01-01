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


public class ItemFossils extends Item

{
	private static final String[] fossils = new String[] {"Trilobite", "Orthocone", "Brontoscoprio", "Dunkleosteus", "Meganura", "Dimetrodon", "Coelophysis", "Feather", "Trex", "Terrorbird", "Human"};
	private IIcon[] textures;
	
	public ItemFossils()
	{
		super();
		this.setHasSubtypes(true);
	}
	

	
	@Override
	public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
    {
		for (int i = 0; i < fossils.length; ++i) 
		{
			if (i != 11)
			{
				list.add(new ItemStack(item, 1, i));
			}
		}
    }

	@Override
	public void registerIcons(IIconRegister iconRegister)
	{
		textures = new IIcon[fossils.length];

		for (int i = 0; i < fossils.length; ++i) 
		{
			textures[i] = iconRegister.registerIcon("iat:"+"fossil" + fossils[i]);
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
        case 0:
            list.add( StatCollector.translateToLocal("Trilobite.desc"));
            list.add( StatCollector.translateToLocal("Trilobite.per"));
            list.add( StatCollector.translateToLocal("Scientific Name:"+ "\u00a7o" + " Eldredgeops Rana"));

            break;
        case 1:
            list.add(StatCollector.translateToLocal("Orthocone.desc"));
            list.add(StatCollector.translateToLocal("Orthocone.per"));
            list.add(StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Orthoceratidea Regulare"));

            break;
        case 2:
            list.add( StatCollector.translateToLocal("Brontoscoprio.desc"));
            list.add( StatCollector.translateToLocal("Brontoscoprio.per"));
            list.add( StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Brontoscorpio Anglicus"));
            break;
        case 3:
            list.add( StatCollector.translateToLocal("Dunkleosteus.desc"));
            list.add( StatCollector.translateToLocal("Dunkleosteus.per"));
            list.add( StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Dinichthys Terrelli"));
            break;
        case 4:
            list.add( StatCollector.translateToLocal("Meganura.desc"));
            list.add( StatCollector.translateToLocal("Meganura.per"));
            list.add( StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Meganeura Brongniarti"));
            break;
        case 5:
            list.add( StatCollector.translateToLocal("Dimetrodon.desc"));
            list.add( StatCollector.translateToLocal("Dimetrodon.per"));
            list.add( StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Dimetrodon Limbatus"));
            break;
        case 6:
            list.add( StatCollector.translateToLocal("Coelophysis.desc"));
            list.add( StatCollector.translateToLocal("Coelophysis.per"));
            list.add( StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Coelophysis Bauri"));
            break;
        case 7:
            list.add( StatCollector.translateToLocal("Feather.desc"));
            list.add( StatCollector.translateToLocal("Feather.per"));
            list.add( StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Archaeopteryx Lithographica"));
            break;
        case 8:
            list.add( StatCollector.translateToLocal("Trex.desc"));
            list.add( StatCollector.translateToLocal("Trex.per"));
            list.add( StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Tyrannosaurus Rex"));
            break;
        case 9:
            list.add( StatCollector.translateToLocal("Terrorbird.desc"));
            list.add( StatCollector.translateToLocal("Terrorbird.per"));
            list.add( StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Phorusrhacos Longissimus"));
            break;
            
        case 10:
            list.add( StatCollector.translateToLocal("Human.desc"));
            list.add( StatCollector.translateToLocal("Human.per"));
            list.add( StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Homo Sapien"));
            break;
        }
    }


	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		int meta = itemStack.getItemDamage();
		if (meta < 0 || meta >= fossils.length) 
		{
			meta = 0;
		}

		return super.getUnlocalizedName() + "." + fossils[meta];
	}
}

