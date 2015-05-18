package iat.core;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class ModAchievements {
	
	public static Achievement plasterAch;
	public static Achievement plasterBlockAch;
	public static Achievement plasterWallAch;
	public static Achievement fossilAch;
	public static Achievement fossilWrappedAch;
	public static Achievement matterConverterAch;
	public static Achievement crystalAch;
	public static Achievement crystalToolAch;

	public static void init(){
		plasterAch =  new Achievement("achievement.plaster", "plaster",  0, 0, new ItemStack(ModItems.plaster_Ball), (Achievement)null).registerStat();
		plasterBlockAch = new Achievement("achievement.plasterBlock", "plasterBlock",  -2, 0, new ItemStack(ModBlocks.plaster), (Achievement)plasterAch).registerStat();
		plasterWallAch = new Achievement("achievement.plasterWall", "plasterWall",  -2, 2, new ItemStack(ModBlocks.plaster_Wall), (Achievement)plasterBlockAch).registerStat();
		fossilAch = new Achievement("achievement.fossil", "fossil",  -2, -2, new ItemStack(ModBlocks.fossil_Ore_Cambrian), (Achievement)null).registerStat();
		fossilWrappedAch = new Achievement("achievement.fossilWrapped", "fossilWrapped",  0, -2, new ItemStack(ModBlocks.plastered_Fossil_Cambrian), (Achievement)plasterAch).registerStat();
		matterConverterAch = new Achievement("achievement.matterConverter", "matterConverter",  2, 0, new ItemStack(ModBlocks.Matter_converter_on), (Achievement)null).registerStat();
		crystalAch = new Achievement("achievement.crystal", "crystal",  0, 2, new ItemStack(ModItems.time_Crystal), (Achievement)matterConverterAch).registerStat();
		crystalToolAch = new Achievement("achievement.crystalTool", "crystalTool",  -2, 4, new ItemStack(ModItems.time_Sword), (Achievement)crystalAch).registerStat();

		AchievementPage.registerAchievementPage(new AchievementPage("It's About Time!", 
		new Achievement[]{plasterAch, plasterBlockAch, plasterWallAch, fossilAch, fossilWrappedAch, matterConverterAch, crystalAch, crystalToolAch}));

	}

}
