package itsabouttime.common.core;

import cpw.mods.fml.common.registry.GameRegistry;
import itsabouttime.common.biomes.BiomeGenCambrianBeach;
import itsabouttime.common.biomes.BiomeGenCambrianSea;
import itsabouttime.common.biomes.BiomeGenDenovianBeach;
import itsabouttime.common.biomes.BiomeGenDenovianForest;
import itsabouttime.common.biomes.BiomeGenDenovianSea;
import itsabouttime.common.biomes.BiomeGenDenovianSwamp;
import itsabouttime.common.biomes.BiomeGenOrdovicianBeach;
import itsabouttime.common.biomes.BiomeGenOrdovicianSea;
import itsabouttime.common.biomes.BiomeGenSilurianBeach;
import itsabouttime.common.biomes.BiomeGenSilurianSea;
import itsabouttime.common.worldgen.IAToreGen;
import net.minecraft.world.biome.BiomeGenBase;

public class IATbiomes {
//TODO:Stop flower,Reed,And MushroomGen.
	 protected static final BiomeGenBase.Height height_Default = new BiomeGenBase.Height(0.1F, 0.2F);
	    protected static final BiomeGenBase.Height height_ShallowWaters = new BiomeGenBase.Height(-0.5F, 0.0F);
	    protected static final BiomeGenBase.Height height_Oceans = new BiomeGenBase.Height(-1.0F, 0.1F);
	    protected static final BiomeGenBase.Height height_DeepOceans = new BiomeGenBase.Height(-1.8F, 0.1F);
	    protected static final BiomeGenBase.Height height_LowPlains = new BiomeGenBase.Height(0.125F, 0.05F);
	    protected static final BiomeGenBase.Height height_MidPlains = new BiomeGenBase.Height(0.2F, 0.2F);
	    protected static final BiomeGenBase.Height height_LowHills = new BiomeGenBase.Height(0.45F, 0.3F);
	    protected static final BiomeGenBase.Height height_HighPlateaus = new BiomeGenBase.Height(1.5F, 0.025F);
	    protected static final BiomeGenBase.Height height_MidHills = new BiomeGenBase.Height(1.0F, 0.5F);
	    protected static final BiomeGenBase.Height height_Shores = new BiomeGenBase.Height(0.0F, 0.025F);
	    protected static final BiomeGenBase.Height height_RockyWaters = new BiomeGenBase.Height(0.1F, 0.8F);
	    protected static final BiomeGenBase.Height height_LowIslands = new BiomeGenBase.Height(0.2F, 0.3F);
	    protected static final BiomeGenBase.Height height_PartiallySubmerged = new BiomeGenBase.Height(-0.2F, 0.1F);
	   
	public static BiomeGenBase CambrianBeach;
	public static BiomeGenBase CambrianSea;
	public static BiomeGenBase CambrianHills;
	public static BiomeGenBase CambrianRiver;
	
	public static BiomeGenBase OrdovicianBeach;
	public static BiomeGenBase OrdovicianSea;
	public static BiomeGenBase OrdovicianHills;
	public static BiomeGenBase OrdovicianRiver;
	
	public static BiomeGenBase SilurianBeach;
	public static BiomeGenBase SilurianSea;
	public static BiomeGenBase SilurianHills;
	public static BiomeGenBase SilurianRiver;

	
	public static BiomeGenBase DenovianSwamp;
	public static BiomeGenBase DenovianBeach;
	public static BiomeGenBase DenovianHills;
	public static BiomeGenBase DenovianForest;
	public static BiomeGenBase DenovianSea;
	public static BiomeGenBase DenovianRiver;
	public static void init()
	{
		register();
		gameRegister();
	}
	private static void register()
	{
		CambrianBeach = new BiomeGenCambrianBeach(67).setBiomeName("Cambrian Lowlands").setColor(0XFF8438).setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
		CambrianHills = new BiomeGenCambrianBeach(68).setBiomeName("Cambrian Hills").setColor(0XFF8438).setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setHeight(height_LowHills);
		CambrianRiver =new BiomeGenCambrianSea(69).setBiomeName("Cambrian Shallows").setColor(0X6FC6E8).setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setHeight(height_ShallowWaters);
		CambrianSea = new BiomeGenCambrianSea(70).setBiomeName("Cambrian Sea").setColor(0X6FC6E8).setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setHeight(height_Oceans);

		OrdovicianBeach = new BiomeGenOrdovicianBeach(71).setBiomeName("Ordovician Lowlands").setColor(0XDBCB7B).setDisableRain().setTemperatureRainfall(2.0F, 0.0F);
		OrdovicianHills=new BiomeGenOrdovicianBeach(72).setBiomeName("Ordovician Hills").setColor(0XDBCB7B).setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setHeight(height_LowHills);
		OrdovicianRiver=new BiomeGenOrdovicianSea(73).setBiomeName("Ordovician Shallows").setColor(0X6FC6E8).setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setHeight(height_ShallowWaters);
		OrdovicianSea = new BiomeGenOrdovicianSea(74).setBiomeName("Ordovician Sea").setColor(0X6FC6E8).setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setHeight(height_Oceans);

		SilurianBeach=new BiomeGenSilurianBeach(75).setBiomeName("Silurian Lowlands").setColor(0X797660);
		SilurianHills=new BiomeGenSilurianBeach(76).setBiomeName("Silurian Hills").setColor(0X797660);
		SilurianRiver=new BiomeGenSilurianSea(77).setBiomeName("Silurian Shallows").setColor(0X6FC6E8).setHeight(height_ShallowWaters);
		SilurianSea=new BiomeGenSilurianSea(78).setBiomeName("Silurian Sea").setColor(0X6FC6E8).setHeight(height_Oceans);
		
		DenovianSwamp=new BiomeGenDenovianSwamp(79).setBiomeName("Denovian Swamp").setColor(0X341C49).setHeight(height_PartiallySubmerged).setTemperatureRainfall(0.8F, 0.9F);
		DenovianBeach=new BiomeGenDenovianBeach(80, 1).setBiomeName("Denovian Lowands").setColor(0XC64F00).setTemperatureRainfall(0.2F, 0.3F);
		DenovianHills=new BiomeGenDenovianBeach(81, 1).setBiomeName("Denovian Hills").setColor(0XC64F00).setTemperatureRainfall(0.2F, 0.3F).setHeight(height_LowHills);
		DenovianForest=new BiomeGenDenovianForest(82).setBiomeName("Fungal Denovian Forest").setColor(0XC64F00).setTemperatureRainfall(0.3F, 0.8F);
		DenovianSea=new BiomeGenDenovianSea(83).setBiomeName("Denovian Sea").setColor(0X6FC6E8).setHeight(height_Oceans);
		DenovianRiver=new BiomeGenDenovianSea(84).setBiomeName("Denovian hallows").setColor(0X6FC6E8).setHeight(height_ShallowWaters);

		

	}
	private static void gameRegister() {
		GameRegistry.registerWorldGenerator(new IAToreGen(), 1);	
	
	}

	
}
