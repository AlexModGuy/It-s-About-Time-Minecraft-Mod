package iat.core;

import iat.world.biomes.BiomeNowhere;
import net.minecraft.world.biome.BiomeGenBase;

public class ModBiomes {
	
public static BiomeGenBase biomeNowhere;

public static BiomeGenBase biomeCretaceousSwamp;
public static BiomeGenBase biomeCretaceousPlains;
public static BiomeGenBase biomeCretaceousOakForest;
public static BiomeGenBase biomeCretaceousRedwoodForest;
public static BiomeGenBase biomeCretaceousDesert;
public static BiomeGenBase biomeCretaceousWateringHole;
public static BiomeGenBase biomeCretaceousDeadland;
public static BiomeGenBase biomeCretaceousDunes;
public static BiomeGenBase biomeCretaceousArctic;
public static BiomeGenBase biomeCretaceousRainforest;
public static BiomeGenBase biomeCretaceousGrassPatch;
public static BiomeGenBase biomeCretaceousHorsetailForest;
public static BiomeGenBase biomeCretaceousFernForest;
public static BiomeGenBase biomeCretaceousScrubland;
public static BiomeGenBase biomeCretaceousDenseScrubland;
public static BiomeGenBase biomeCretaceousDenseForest;
public static BiomeGenBase biomeCretaceousBog;
public static BiomeGenBase biomeCretaceousShallows;
public static BiomeGenBase biomeCretaceousSea;

	public static void init() {
		initializeBiomes();
		register();
	}
	public static void initializeBiomes(){
		biomeNowhere = new BiomeNowhere(57).setColor(0X0A0026).setTemperatureRainfall(0F, 0F);
	}
	public static void register(){

	}
}
