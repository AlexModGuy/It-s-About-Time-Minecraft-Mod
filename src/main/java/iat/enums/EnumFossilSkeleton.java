package iat.enums;

import net.minecraft.item.Item;
import iat.ProxyCommon;
import iat.client.models.MowzieModelBase;
import iat.client.models.entities.*;

public enum EnumFossilSkeleton {

	Compsognathus(new ModelCompsognathus(), "Compsognathus", 0.7F, 0.5F);
	
	public MowzieModelBase model;
	public String name;
	public Item fossilItem;
	public Item fossilBrokenItem;
	public float xsize;
	public float ysize;

	private EnumFossilSkeleton(MowzieModelBase model, String name, float xsize, float ysize){
		this.model = model;
		this.name= name;
	}
	public static void init(ProxyCommon proxy)
	{

	}
	public static Item getCleanFossil(Item item, boolean isDirty)
	{
		for (int i = 0; i < values().length; i++)
		{	
			if(isDirty){
				if (values()[i].fossilBrokenItem == item)
				{
					return values()[i].fossilItem;
				}
			}else{
				if (values()[i].fossilItem == item)
				{
					return values()[i].fossilBrokenItem;
				}
			}
		}
		return null;
	}

}
