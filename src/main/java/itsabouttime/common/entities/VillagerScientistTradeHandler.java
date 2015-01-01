package itsabouttime.common.entities;

 import itsabouttime.common.core.IATstuff;

import java.util.Random;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;

 public class VillagerScientistTradeHandler implements IVillageTradeHandler {

 public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipes, Random random) {
 
	// Trade 1 emeralds and 1 apples for a Anomacalaris Armor plate
 recipes.add(new MerchantRecipe(

		 new ItemStack(Items.apple, 1),
		 new ItemStack(Items.emerald, 1),
		 new ItemStack(IATstuff.ArmorPlates,2, 3)));
 //Trade 16 wheat for 1 Glowstone Block
	recipes.addToListWithCheck(new MerchantRecipe(new ItemStack(Items.wheat,    16), new ItemStack(Item.getItemFromBlock(Blocks.glowstone), 1)));
	


 }
}