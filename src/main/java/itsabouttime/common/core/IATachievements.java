package itsabouttime.common.core;

import java.util.Random;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class IATachievements {
	
public static Achievement AchBook;
public static Achievement AchTarBoiler;
public static Achievement AchTarDroplet;
public static Achievement AchTar;
public static Achievement AchTarDrown;
public static Achievement AchShale;
public static Achievement AchFossil;

public static Achievement AchTimeStoneCam;
public static Achievement AchTimeStoneOrd;
public static Achievement AchTimeStoneSil;
public static Achievement AchTimeStoneDen;
public static Achievement AchTimeStoneCar;
public static Achievement AchTimeStonePer;
public static Achievement AchTimeStoneTri;
public static Achievement AchTimeStoneJur;
public static Achievement AchTimeStoneCre;
public static Achievement AchTimeStonePal;
public static Achievement AchTimeStoneNeo;

public static Achievement AchTimeCoreCam;
public static Achievement AchTimeCoreOrd;
public static Achievement AchTimeCoreSil;
public static Achievement AchTimeCoreDen;
public static Achievement AchTimeCoreCar;
public static Achievement AchTimeCorePer;
public static Achievement AchTimeCoreTri;
public static Achievement AchTimeCoreJur;
public static Achievement AchTimeCoreCre;
public static Achievement AchTimeCorePal;
public static Achievement AchTimeCoreNeo;

public static Achievement AchTimeCore;
public static Achievement AchTimeMachine;
public static Achievement AchWaptia;
public static Achievement AchCake;
public static Achievement AchFish;

public static final int WILDCARD_VALUE = Short.MAX_VALUE;


public static void init()
{
	register();
	gameRegister();
}
private static void register()
{
	AchBook =  new Achievement("achievement.Book", "Book",  0, 0, new ItemStack(IATstuff.FossilBook), (Achievement)null).registerStat();
	AchTarBoiler = new Achievement("achievement.TarDistillery", "TarDistillery",  -2, -2, new ItemStack(IATstuff.TarDistilleryOn), (Achievement)AchBook).registerStat();
	AchTarDroplet = new Achievement("achievement.TarDroplet", "TarDroplet",  -2, -4, new ItemStack(IATstuff.TarDroplet), (Achievement)AchTarBoiler).registerStat();
	AchTar = new Achievement("achievement.Tar", "Tar",  -2, -6, new ItemStack(IATstuff.TarBucket), (Achievement)AchTarDroplet).registerStat();
	AchTarDrown = new Achievement("achievement.TarDrown", "TarDrown",  -4, -6, new ItemStack(IATstuff.BlockTarFluid), (Achievement)AchTar).registerStat();
	AchShale = new Achievement("achievement.Shale", "Shale",  0, 4, new ItemStack(IATstuff.Shale), (Achievement)AchBook).registerStat();
	AchFossil = new Achievement("achievement.Fossil", "Fossil",  2, 4, new ItemStack(IATstuff.CreativeTabIcon1), (Achievement)AchShale).registerStat();
	
	AchTimeStoneCam = new Achievement("achievement.TimeStoneCam", "TimeStoneCam",  6, -6, new ItemStack(IATstuff.TimeGem, 1, 0), (Achievement)AchFossil).registerStat();
	AchTimeStoneOrd = new Achievement("achievement.TimeStoneOrd", "TimeStoneOrd",  6, -4, new ItemStack(IATstuff.TimeGem, 1, 1), (Achievement)AchFossil).registerStat();
	AchTimeStoneSil = new Achievement("achievement.TimeStoneSil", "TimeStoneSil",  6, -2, new ItemStack(IATstuff.TimeGem, 1, 2), (Achievement)AchFossil).registerStat();
	AchTimeStoneDen = new Achievement("achievement.TimeStoneDen", "TimeStoneDen",  6, 0, new ItemStack(IATstuff.TimeGem, 1, 3), (Achievement)AchFossil).registerStat();
	AchTimeStoneCar = new Achievement("achievement.TimeStoneCar", "TimeStoneCar",  6, 2, new ItemStack(IATstuff.TimeGem, 1, 4), (Achievement)AchFossil).registerStat();
	AchTimeStonePer = new Achievement("achievement.TimeStonePer", "TimeStonePer",  6, 4, new ItemStack(IATstuff.TimeGem, 1, 5), (Achievement)AchFossil).registerStat();
	AchTimeStoneTri = new Achievement("achievement.TimeStoneTri", "TimeStoneTri",  6, 6, new ItemStack(IATstuff.TimeGem, 1, 6), (Achievement)AchFossil).registerStat();
	AchTimeStoneJur = new Achievement("achievement.TimeStoneJur", "TimeStoneJur",  6, 8, new ItemStack(IATstuff.TimeGem, 1, 6), (Achievement)AchFossil).registerStat();
	AchTimeStoneCre = new Achievement("achievement.TimeStoneCre", "TimeStoneCre",  6, 10, new ItemStack(IATstuff.TimeGem, 1, 8), (Achievement)AchFossil).registerStat();
	AchTimeStonePal = new Achievement("achievement.TimeStonePal", "TimeStonePal",  6, 12, new ItemStack(IATstuff.TimeGem, 1, 9), (Achievement)AchFossil).registerStat();
	AchTimeStoneNeo = new Achievement("achievement.TimeStoneNeo", "TimeStoneNeo",  6, 14, new ItemStack(IATstuff.TimeGem, 1, 10), (Achievement)AchFossil).registerStat();
	
	AchTimeCoreCam = new Achievement("achievement.TimeCoreCam", "TimeCoreCam",  8, -6, new ItemStack(IATstuff.TimeGem, 1, 0), (Achievement)AchFossil).registerStat();
	AchTimeCoreOrd = new Achievement("achievement.TimeCoreOrd", "TimeCoreOrd",  8, -4, new ItemStack(IATstuff.TimeGem, 1, 1), (Achievement)AchFossil).registerStat();
	AchTimeCoreSil = new Achievement("achievement.TimeCoreSil", "TimeCoreSil",  8, -2, new ItemStack(IATstuff.TimeGem, 1, 2), (Achievement)AchFossil).registerStat();
	AchTimeCoreDen = new Achievement("achievement.TimeCoreDen", "TimeCoreDen",  8, 0, new ItemStack(IATstuff.TimeGem, 1, 3), (Achievement)AchFossil).registerStat();
	AchTimeCoreCar = new Achievement("achievement.TimeCoreCar", "TimeCoreCar",  8, 2, new ItemStack(IATstuff.TimeGem, 1, 4), (Achievement)AchFossil).registerStat();
	AchTimeCorePer = new Achievement("achievement.TimeCorePer", "TimeCorePer",  8, 4, new ItemStack(IATstuff.TimeGem, 1, 5), (Achievement)AchFossil).registerStat();
	AchTimeCoreTri = new Achievement("achievement.TimeCoreTri", "TimeCoreTri",  8, 6, new ItemStack(IATstuff.TimeGem, 1, 8), (Achievement)AchFossil).registerStat();
	AchTimeCoreJur = new Achievement("achievement.TimeCoreJur", "TimeCoreJur",  8, 8, new ItemStack(IATstuff.TimeGem, 1, 8), (Achievement)AchFossil).registerStat();
	AchTimeCoreCre = new Achievement("achievement.TimeCoreCre", "TimeCoreCre",  8, 10, new ItemStack(IATstuff.TimeGem, 1, 8), (Achievement)AchFossil).registerStat();
	AchTimeCorePal = new Achievement("achievement.TimeCorePal", "TimeCorePal",  8, 12, new ItemStack(IATstuff.TimeGem, 1, 9), (Achievement)AchFossil).registerStat();
	AchTimeCoreNeo = new Achievement("achievement.TimeCoreNeo", "TimeCoreNeo",  8, 14, new ItemStack(IATstuff.TimeGem, 1, 10), (Achievement)AchFossil).registerStat();
	
	AchievementPage.registerAchievementPage(new AchievementPage("It's About Time!", new Achievement[]{AchBook,AchTarBoiler,AchTarDroplet,AchTar,AchTarDrown, AchShale, 
	AchFossil,AchTimeStoneCam,AchTimeStoneOrd,AchTimeStoneSil,AchTimeStoneDen,AchTimeStoneCar,AchTimeStonePer,AchTimeStoneTri,AchTimeStoneJur,AchTimeStoneCre,AchTimeStonePal,
	AchTimeStoneNeo,AchTimeCoreCam,AchTimeCoreOrd,AchTimeCoreSil,AchTimeCoreDen,AchTimeCoreCar,AchTimeCorePer,AchTimeCoreTri,AchTimeCoreJur,AchTimeCoreCre,AchTimeCorePal,
	AchTimeCoreNeo})); 
	
}
private static void gameRegister() {
}

}