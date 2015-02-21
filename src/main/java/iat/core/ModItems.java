package iat.core;

import cpw.mods.fml.common.registry.GameRegistry;
import iat.ItsAboutTime;
import iat.items.ItemAmber;
import iat.items.ItemFossil;
import iat.items.ItemFossilBroken;
import iat.items.ItemModAxe;
import iat.items.ItemModPickaxe;
import iat.items.ItemModSpade;
import iat.items.ItemTimeCrystal;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSword;

public class ModItems {

	public static Item fossil_Shard;
	public static Item fossil_Broken;
	public static Item fossil;
	public static Item amber;
	public static Item plaster_Ball;
	public static Item time_Crystal;
	public static Item time_Shovel;
	public static Item time_Pickaxe;
	public static Item time_Axe;
	public static Item time_Sword;
	public static Item time_Hoe;
	
	public static ToolMaterial timeToolMaterial;


	public static void init() {
		initializeItems();
		register();
	}
	public static void initializeItems(){
		
		timeToolMaterial = EnumHelper.addToolMaterial("timeToolMaterial", 6, 1620, 8.0F, 4.0F, 7);
		fossil_Shard = new Item().setUnlocalizedName("iat.fossil_Shard").setTextureName("iat:fossil").setCreativeTab(ItsAboutTime.iatTab);
		fossil_Broken = new ItemFossilBroken().setUnlocalizedName("iat.fossil_Broken").setCreativeTab(ItsAboutTime.iatTab);
		fossil = new ItemFossil().setUnlocalizedName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab);
		amber = new ItemAmber().setUnlocalizedName("iat.amber").setCreativeTab(ItsAboutTime.iatTab);
		plaster_Ball = new Item().setUnlocalizedName("iat.plaster_Ball").setTextureName("iat:plaster").setCreativeTab(ItsAboutTime.iatTab);
		time_Crystal = new ItemTimeCrystal().setUnlocalizedName("iat.time_Crystal").setTextureName("iat:time_Crystal").setCreativeTab(ItsAboutTime.iatTab);
		time_Shovel = new ItemModSpade(timeToolMaterial).setUnlocalizedName("iat.time_Shovel").setTextureName("iat:time_Shovel").setCreativeTab(ItsAboutTime.iatTab);
		time_Pickaxe = new ItemModPickaxe(timeToolMaterial).setUnlocalizedName("iat.time_Pickaxe").setTextureName("iat:time_Pickaxe").setCreativeTab(ItsAboutTime.iatTab);
		time_Axe = new ItemModAxe(timeToolMaterial).setUnlocalizedName("iat.time_Axe").setTextureName("iat:time_Axe").setCreativeTab(ItsAboutTime.iatTab);
		time_Sword = new ItemSword(timeToolMaterial).setUnlocalizedName("iat.time_Sword").setTextureName("iat:time_Sword").setCreativeTab(ItsAboutTime.iatTab);
		time_Hoe = new ItemHoe(timeToolMaterial).setUnlocalizedName("iat.time_Hoe").setTextureName("iat:time_Hoe").setCreativeTab(ItsAboutTime.iatTab);

	}
	public static void register(){
		GameRegistry.registerItem(fossil_Shard, "fossil_Shard");
		GameRegistry.registerItem(fossil_Broken, "fossil_Broken");
		GameRegistry.registerItem(fossil, "fossil");
		GameRegistry.registerItem(amber, "amber");
		GameRegistry.registerItem(plaster_Ball, "plaster_Ball");
		GameRegistry.registerItem(time_Crystal, "time_Crystal");
		GameRegistry.registerItem(time_Shovel, "time_Shovel");
		GameRegistry.registerItem(time_Pickaxe, "time_Pickaxe");
		GameRegistry.registerItem(time_Axe, "time_Axe");
		GameRegistry.registerItem(time_Sword, "time_Sword");
		GameRegistry.registerItem(time_Hoe, "time_Hoe");

	}
}
