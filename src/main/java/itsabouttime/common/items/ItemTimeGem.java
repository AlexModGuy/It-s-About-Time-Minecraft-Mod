package itsabouttime.common.items;

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


public class ItemTimeGem extends Item

{
	private static final String[] fossils = new String[] {"Cambrian", "Ordovician", "Sillurian", "Denovian", "Carbonofibirous", "Permain", "Triassic", "Jurrasic", "Cretatious", "Palegene", "Neogene"};
	private IIcon[] textures;
	
	public ItemTimeGem()
	{
		super();
		this.setHasSubtypes(true);
		this.maxStackSize =1;
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
			textures[i] = iconRegister.registerIcon("iat:"+ fossils[i] + "Ruby");
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
          
            list.add( StatCollector.translateToLocal("Trilobite.per"));
         

            break;
        case 1:
           
            list.add(StatCollector.translateToLocal("Orthocone.per"));
           

            break;
        case 2:
         
            list.add( StatCollector.translateToLocal("Brontoscoprio.per"));
           
            break;
        case 3:
            
            list.add( StatCollector.translateToLocal("Dunkleosteus.per"));
        
            break;
        case 4:
           
            list.add( StatCollector.translateToLocal("Meganura.per"));

            break;
        case 5:
            list.add( StatCollector.translateToLocal("Dimetrodon.per"));
            break;
        case 6:
            list.add( StatCollector.translateToLocal("Coelophysis.per"));
            break;
        case 7:
            list.add( StatCollector.translateToLocal("Feather.per"));
            break;
        case 8:
            list.add( StatCollector.translateToLocal("Trex.per"));
            break;
        case 9:
            list.add( StatCollector.translateToLocal("Terrorbird.per"));
            break;
            
        case 10:
            list.add( StatCollector.translateToLocal("Human.per"));
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

