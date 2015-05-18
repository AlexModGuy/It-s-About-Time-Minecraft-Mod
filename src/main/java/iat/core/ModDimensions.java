package iat.core;

import iat.ConfigOptions;
import iat.world.worldProvider.WorldProviderCretaceous;
import iat.world.worldProvider.WorldProviderNowhere;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

	public static int Dim_nowhere = ConfigOptions.Dim_nowhere;
	public static int Dim_cambrian = ConfigOptions.Dim_cambrian;
	public static int Dim_ordovician = ConfigOptions.Dim_ordovician;
	public static int Dim_silurian = ConfigOptions.Dim_silurian;
	public static int Dim_devonian= ConfigOptions.Dim_devonian;
	public static int Dim_carboniferous = ConfigOptions.Dim_carboniferous;
	public static int Dim_permian = ConfigOptions.Dim_permian;
	public static int Dim_triassic = ConfigOptions.Dim_triassic;
	public static int Dim_jurassic = ConfigOptions.Dim_jurassic;
	public static int Dim_cretaceous = ConfigOptions.Dim_cretaceous;
	public static int Dim_paleogene = ConfigOptions.Dim_paleogene;
	public static int Dim_neogene = ConfigOptions.Dim_neogene;

	public static void init() {
		initializeDimensions();
	}
	public static void initializeDimensions(){
		DimensionManager.registerProviderType(Dim_nowhere, WorldProviderNowhere.class, false);
		DimensionManager.registerProviderType(Dim_cretaceous, WorldProviderCretaceous.class, false);
		DimensionManager.registerDimension(Dim_nowhere, Dim_nowhere);
		DimensionManager.registerDimension(Dim_cretaceous, Dim_cretaceous);

	}
	
}
