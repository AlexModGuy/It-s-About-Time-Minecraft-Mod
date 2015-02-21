package iat.core;

import iat.world.worldProvider.WorldProviderCretaceous;
import iat.world.worldProvider.WorldProviderNowhere;
import net.minecraftforge.common.DimensionManager;

public class ModDimensions {

	public static int Dim_nowhere = -57;
	public static int Dim_cambrian = -58;
	public static int Dim_ordovician = -59;
	public static int Dim_silurian = -60;
	public static int Dim_devonian= -61;
	public static int Dim_carboniferous = -62;
	public static int Dim_permian = -63;
	public static int Dim_triassic = -64;
	public static int Dim_jurassic = -65;
	public static int Dim_cretaceous = -66;
	public static int Dim_paleogene = -67;
	public static int Dim_neogene = -68;

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
