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


public class ItemFossil extends Item

{
	private static final String[] fossils = new String[] {"Trilobite", "Waptia", "Anomalocaris", "Opabina", "Cameroceras", "Arandaspis"};
	private IIcon[] textures;

	public ItemFossil()
	{
		super();
		this.setHasSubtypes(true);
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
			textures[i] = iconRegister.registerIcon("iat:"+"fossil_" + fossils[i]);
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
			list.add( StatCollector.translateToLocal("Trilobite"));
			list.add( StatCollector.translateToLocal("521 MYA - 250 MYA"));
			list.add( StatCollector.translateToLocal("message.fossil.science" + ":"+ "\u00a7o" + " Eldredgeops Rana"));
			break;
		case 1:
			list.add( StatCollector.translateToLocal("Waptia"));
			list.add( StatCollector.translateToLocal("505 MYA"));
			list.add( StatCollector.translateToLocal("message.fossil.science" + ":"+ "\u00a7o" + " Waptia fieldensis"));
			break;
		case 2:
			list.add( StatCollector.translateToLocal("Anomalocaris"));
			list.add( StatCollector.translateToLocal("515 MYA - 540 MYA"));
			list.add( StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Anomalocaris Canadensis"));
			break;
		case 3:
			list.add(StatCollector.translateToLocal("Opabina"));
			list.add(StatCollector.translateToLocal("515 MYA - 250 MYA"));
			list.add(StatCollector.translateToLocal("message.fossil.science" + ":"+ "\u00a7o" + " Opabinia Regalis"));
			break;
		case 4:
			list.add( StatCollector.translateToLocal("Cameroceras"));
			list.add( StatCollector.translateToLocal("470 MYA – 460 MYA"));
			list.add( StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Cameroceras Trentonense"));
			break;
		case 5:
			list.add( StatCollector.translateToLocal("Arandaspis"));
			list.add( StatCollector.translateToLocal("480 MYA – 470 MYA"));
			list.add( StatCollector.translateToLocal("Scientific Name:" +"\u00a7o" + " Arandaspis Prionotolepis"));
			break;

		}
	}

}

