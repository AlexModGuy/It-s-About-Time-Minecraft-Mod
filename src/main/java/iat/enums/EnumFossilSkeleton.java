package iat.enums;

import net.minecraft.item.Item;
import iat.ProxyCommon;

public enum EnumFossilSkeleton {

	Compsognathus("Compsognathus", 0.7F, 0.5F);
	
	public String name;
	public Item fossilItem;
	public Item fossilBrokenItem;
	public float xsize;
	public float ysize;

	private EnumFossilSkeleton(String name, float xsize, float ysize){
		this.name= name;
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
