package iat;

import net.minecraftforge.common.config.Configuration;

public class ConfigOptions
{
	public static int Dim_nowhere;
	public static int Dim_cambrian;
	public static int Dim_ordovician;
	public static int Dim_silurian;
	public static int Dim_devonian;
	public static int Dim_carboniferous;
	public static int Dim_permian;
	public static int Dim_triassic;
	public static int Dim_jurassic;
	public static int Dim_cretaceous;
	public static int Dim_paleogene;
	public static int Dim_neogene;

    public static int biomeIDNowhere;
    public static int biomeCretaceousDry;
    
    public static boolean disableTrilobite;
    public static boolean disableCeolophysis;
    public static boolean disableCompsognathus;
    public static boolean disableDilodocus;
    public static boolean disableDilophosaurus;
    public static boolean disablePsittacosaurus;
    public static boolean disableCarnotaurus;
    public static boolean disableTroodon;
    public static boolean disableTriceratops;
	public static boolean disableVelociraptor;


    public static void init(Configuration config)
    {
    	Dim_nowhere = config.get("Dimension IDs", "Nowhere Dimension ID:", -57).getInt();
    	Dim_cambrian = config.get("Dimension IDs", "Cambrian Dimension ID:", -58).getInt();
    	Dim_ordovician = config.get("Dimension IDs", "Ordovician Dimension ID:", -59).getInt();
    	Dim_silurian = config.get("Dimension IDs", "Silurian Dimension ID:", -60).getInt();
    	Dim_devonian = config.get("Dimension IDs", "Denovian Dimension ID:", -61).getInt();
    	Dim_carboniferous = config.get("Dimension IDs", "Carboniferous Dimension ID:", -62).getInt();
    	Dim_permian = config.get("Dimension IDs", "Permian Dimension ID:", -63).getInt();
    	Dim_triassic = config.get("Dimension IDs", "Triassic Dimension ID:", -64).getInt();
    	Dim_jurassic = config.get("Dimension IDs", "Jurassic Dimension ID:", -65).getInt();
    	Dim_cretaceous = config.get("Dimension IDs", "Cretaceous Dimension ID:", -66).getInt();
    	Dim_paleogene = config.get("Dimension IDs", "Paleogene Dimension ID:", -67).getInt();
    	Dim_neogene = config.get("Dimension IDs", "Neogene Dimension ID:", -68).getInt();

    	biomeIDNowhere = config.get("Biome IDs", "Nowhere Biome ID:", 57).getInt();
    	biomeCretaceousDry = config.get("Biome IDs", "Dry Cretaceous Biome ID:", 58).getInt();
    	
    	disableTrilobite = config.get("Disable Mobs(use with other mods with duplicate animals)", "Disable Trilobite", false).getBoolean(false);
    	disableCeolophysis = config.get("Disable Mobs(use with other mods with duplicate animals)", "Disable Ceolophysis", false).getBoolean(false);
    	disableCompsognathus = config.get("Disable Mobs(use with other mods with duplicate animals)", "Disable Compsognathus", false).getBoolean(false);
    	disableDilodocus = config.get("Disable Mobs(use with other mods with duplicate animals)", "Disable Compsognathus", false).getBoolean(false);
    	disableDilophosaurus = config.get("Disable Mobs(use with other mods with duplicate animals)", "Disable Dilophosaurus", false).getBoolean(false);
    	disablePsittacosaurus = config.get("Disable Mobs(use with other mods with duplicate animals)", "Disable Psittacosaurus", false).getBoolean(false);
    	disableCarnotaurus = config.get("Disable Mobs(use with other mods with duplicate animals)", "Disable Carnotaurus", false).getBoolean(false);
    	disableTroodon = config.get("Disable Mobs(use with other mods with duplicate animals)", "Disable Troodon", false).getBoolean(false);
    	disableTriceratops = config.get("Disable Mobs(use with other mods with duplicate animals)", "Disable Triceratops", false).getBoolean(false);
    	disableVelociraptor = config.get("Disable Mobs(use with other mods with duplicate animals)", "Disable Velociraptor", false).getBoolean(false);

    }

}
