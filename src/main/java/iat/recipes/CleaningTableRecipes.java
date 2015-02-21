package iat.recipes;

import iat.core.ModBlocks;
import iat.core.ModItems;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class CleaningTableRecipes
{
	private static final CleaningTableRecipes smeltingBase = new CleaningTableRecipes();
	/** The list of smelting results. */
	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();
	/**
	 * Used to call methods addSmelting and getSmeltingResult.
	 */
	public static CleaningTableRecipes smelting()
	{
		return smeltingBase;
	}

	private CleaningTableRecipes()
	{

		this.blockSmelt(ModBlocks.plastered_Fossil_Cambrian, new ItemStack(ModItems.fossil_Broken, 1, randomizeMeta(0)), 0F);
		this.blockSmelt(ModBlocks.plastered_Fossil_Ordovician, new ItemStack(ModItems.fossil_Broken, 1, randomizeMeta(1)), 0F);

	}

	private int randomizeMeta(int i) {
		Random rand = new Random();
		switch(i){
		case 0:
			return rand.nextInt(3);
		case 1:
			return 2+ rand.nextInt(3);
		default:
			return 0;
		}
	}




	public void blockSmelt(Block block, ItemStack stack, float var1)
	{
		this.smelt(Item.getItemFromBlock(block), stack, var1);
	}

	public void smelt(Item item, ItemStack stack, float var1)
	{
		this.readSmelt(new ItemStack(item, 1, 32767), stack, var1);
	}

	public void readSmelt(ItemStack stack, ItemStack stackResult, float i)
	{
		this.smeltingList.put(stack, stackResult);
		this.experienceList.put(stackResult, Float.valueOf(i));
	}

	/**
	 * Returns the smelting result of an item.
	 */
	 public ItemStack getSmeltingResult(ItemStack stack)
	 {
		 Iterator iterator = this.smeltingList.entrySet().iterator();
		 Entry entry;

		 do
		 {
			 if (!iterator.hasNext())
			 {
				 return null;
			 }

			 entry = (Entry)iterator.next();
		 }
		 while (!this.checkSmelt(stack, (ItemStack)entry.getKey()));

		 return (ItemStack)entry.getValue();
	 }

	 private boolean checkSmelt(ItemStack stack, ItemStack stackResult)
	 {
		 return stackResult.getItem() == stack.getItem() && (stackResult.getItemDamage() == 32767 || stackResult.getItemDamage() == stack.getItemDamage());
	 }

	 public Map getSmeltingList()
	 {
		 return this.smeltingList;
	 }

	 public float giveXP(ItemStack stack)
	 {
		 float ret = stack.getItem().getSmeltingExperience(stack);
		 if (ret != -1) return ret;

		 Iterator iterator = this.experienceList.entrySet().iterator();
		 Entry entry;

		 do
		 {
			 if (!iterator.hasNext())
			 {
				 return 0.0F;
			 }

			 entry = (Entry)iterator.next();
		 }
		 while (!this.checkSmelt(stack, (ItemStack)entry.getKey()));

		 return ((Float)entry.getValue()).floatValue();
	 }
}