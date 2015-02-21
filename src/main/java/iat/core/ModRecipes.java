package iat.core;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import iat.misc.EntityHandler;

public class ModRecipes {

	public static void init() {
		register();
	}

	public static void register(){

		GameRegistry.addRecipe(new ItemStack(ModItems.plaster_Ball, 5, 0), new Object[] {"XYX", "YXY", "XYX", Character.valueOf('X'), Items.clay_ball, Character.valueOf('Y'), Items.paper});
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.time_Shovel, 1, 0), new Object[] {"X", "Y", "Y", Character.valueOf('X'), ModItems.time_Crystal, Character.valueOf('Y'), "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.time_Pickaxe, 1, 0), new Object[] {"XXX", " Y ", " Y ", Character.valueOf('X'), ModItems.time_Crystal, Character.valueOf('Y'), "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.time_Axe, 1, 0), new Object[] {"XX ", "XY ", " Y ", Character.valueOf('X'), ModItems.time_Crystal, Character.valueOf('Y'), "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.time_Sword, 1, 0), new Object[] {"X", "X", "Y", Character.valueOf('X'), ModItems.time_Crystal, Character.valueOf('Y'), "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.time_Hoe, 1, 0), new Object[] {"XX ", " Y ", " Y ", Character.valueOf('X'), ModItems.time_Crystal, Character.valueOf('Y'), "stickWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.Matter_converter_off, 1, 0), new Object[] {"XYX", "ZUZ", "XVX", Character.valueOf('X'), "ingotIron", Character.valueOf('Y'), Blocks.hopper, Character.valueOf('Z'), Items.bucket, Character.valueOf('U'), "blockRedstone", Character.valueOf('V'), "gemDiamond"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.cleaning_Table_Off, 1, 0), new Object[] {"X  ", "ZYZ", "WZW", Character.valueOf('X'), Items.iron_pickaxe, Character.valueOf('Y'), Items.bucket, Character.valueOf('Z'), "plankWood", Character.valueOf('W'), "logWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.cleaning_Table_Off, 1, 0), new Object[] {"  X", "ZYZ", "WZW", Character.valueOf('X'), Items.iron_pickaxe, Character.valueOf('Y'), Items.bucket, Character.valueOf('Z'), "plankWood", Character.valueOf('W'), "logWood"}));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.plaster, 2, 0), new Object[] {"XX", "XX", Character.valueOf('X'), ModItems.plaster_Ball});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.plaster_Wall, 6, 0), new Object[] {"XXX", "XXX", Character.valueOf('X'), ModBlocks.plaster});

	}
}
