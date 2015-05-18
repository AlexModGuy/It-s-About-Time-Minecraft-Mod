package iat.core;

import cpw.mods.fml.common.registry.GameRegistry;
import iat.ItsAboutTime;
import iat.items.ItemAmber;
import iat.items.ItemFossil;
import iat.items.ItemFossilBroken;
import iat.items.ItemModAxe;
import iat.items.ItemModPickaxe;
import iat.items.ItemModSpade;
import iat.items.ItemPheromoneArmor;
import iat.items.ItemRockPick;
import iat.items.ItemTimeCrystal;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import iat.enums.EnumFossilSkeleton;

public class ModItems {

	public static Item fossil_Shard;
	public static Item rockPick;
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
	public static Item pheromoneChest;
	public static Item bucket_Time;
	public static ToolMaterial timeToolMaterial;
	public static ArmorMaterial pheromoneArmor;



	public static void init() {
		initializeItems();
		register();
	}
	public static void initializeItems(){
		
		timeToolMaterial = EnumHelper.addToolMaterial("timeToolMaterial", 6, 1620, 8.0F, 4.0F, 7);
		pheromoneArmor = EnumHelper.addArmorMaterial("pheromoneArmor", 12, new int[]{2, 4, 2, 1}, 9);

		fossil_Shard = new Item().setUnlocalizedName("iat.fossil_Shard").setTextureName("iat:fossil").setCreativeTab(ItsAboutTime.iatTab);
		rockPick = new ItemRockPick().setUnlocalizedName("iat.rockPick").setTextureName("iat:rockPick").setCreativeTab(ItsAboutTime.iatTab);
		fossil_Broken = new ItemFossilBroken().setUnlocalizedName("iat.fossil_Broken").setCreativeTab(ItsAboutTime.iatTab);
		fossil = new ItemFossil().setUnlocalizedName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab);
		for (int i = 0; i < EnumFossilSkeleton.values().length; i++) {
			EnumFossilSkeleton.values()[i].fossilItem = new Item().setTextureName("iat:fossil").setUnlocalizedName("iat.fossil" + EnumFossilSkeleton.values()[i].name).setCreativeTab(ItsAboutTime.iatTab);
			EnumFossilSkeleton.values()[i].fossilBrokenItem = new Item().setTextureName("iat:fossil").setUnlocalizedName("iat.fossil_Broken" + EnumFossilSkeleton.values()[i].name).setCreativeTab(ItsAboutTime.iatTab);
		}
		amber = new ItemAmber().setUnlocalizedName("iat.amber").setCreativeTab(ItsAboutTime.iatTab);
		plaster_Ball = new Item().setUnlocalizedName("iat.plaster_Ball").setTextureName("iat:plaster").setCreativeTab(ItsAboutTime.iatTab);
		time_Crystal = new ItemTimeCrystal().setUnlocalizedName("iat.time_Crystal").setTextureName("iat:time_Crystal").setCreativeTab(ItsAboutTime.iatTab);
		time_Shovel = new ItemModSpade(timeToolMaterial).setUnlocalizedName("iat.time_Shovel").setTextureName("iat:time_Shovel").setCreativeTab(ItsAboutTime.iatTab);
		time_Pickaxe = new ItemModPickaxe(timeToolMaterial).setUnlocalizedName("iat.time_Pickaxe").setTextureName("iat:time_Pickaxe").setCreativeTab(ItsAboutTime.iatTab);
		time_Axe = new ItemModAxe(timeToolMaterial).setUnlocalizedName("iat.time_Axe").setTextureName("iat:time_Axe").setCreativeTab(ItsAboutTime.iatTab);
		time_Sword = new ItemSword(timeToolMaterial).setUnlocalizedName("iat.time_Sword").setTextureName("iat:time_Sword").setCreativeTab(ItsAboutTime.iatTab);
		time_Hoe = new ItemHoe(timeToolMaterial).setUnlocalizedName("iat.time_Hoe").setTextureName("iat:time_Hoe").setCreativeTab(ItsAboutTime.iatTab);
		pheromoneChest = new ItemPheromoneArmor(pheromoneArmor, 0, 1).setUnlocalizedName("iat.pheromoneCanester").setTextureName("iat:pheromoneCanester").setCreativeTab(ItsAboutTime.iatTab);
		bucket_Time = new ItemBucket(ModBlocks.fluidTimeBlock).setUnlocalizedName("iat.bucket_Time").setTextureName("iat:bucket_Time").setContainerItem(Items.bucket);

	}
	public static void register(){
		GameRegistry.registerItem(fossil_Shard, "fossil_Shard");
		GameRegistry.registerItem(rockPick, "rockPick");
		GameRegistry.registerItem(fossil_Broken, "fossil_Broken");
		GameRegistry.registerItem(fossil, "fossil");
		for (int i = 0; i < EnumFossilSkeleton.values().length; i++) {
			GameRegistry.registerItem(EnumFossilSkeleton.values()[i].fossilBrokenItem, "fossil" + EnumFossilSkeleton.values()[i].name);
			GameRegistry.registerItem(EnumFossilSkeleton.values()[i].fossilItem, "fossilBroken" + EnumFossilSkeleton.values()[i].name);
		}
		GameRegistry.registerItem(amber, "amber");
		GameRegistry.registerItem(plaster_Ball, "plaster_Ball");
		GameRegistry.registerItem(time_Crystal, "time_Crystal");
		GameRegistry.registerItem(time_Shovel, "time_Shovel");
		GameRegistry.registerItem(time_Pickaxe, "time_Pickaxe");
		GameRegistry.registerItem(time_Axe, "time_Axe");
		GameRegistry.registerItem(time_Sword, "time_Sword");
		GameRegistry.registerItem(time_Hoe, "time_Hoe");
		GameRegistry.registerItem(pheromoneChest, "pheromoneChest");
		GameRegistry.registerItem(bucket_Time, "bucket_Time");

	}
}
