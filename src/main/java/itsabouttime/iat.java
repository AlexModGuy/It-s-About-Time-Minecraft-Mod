package itsabouttime;

import org.lwjgl.input.Keyboard;

import itsabouttime.common.core.IATstuff;
import itsabouttime.common.core.IATachievements;
import itsabouttime.common.core.IATbiomes;
import itsabouttime.common.core.IATentities;
import itsabouttime.common.core.IATmisc;
import itsabouttime.common.dimensions.cambrian.WorldProviderCambrian;
import itsabouttime.common.dimensions.denovian.WorldProviderDenovian;
import itsabouttime.common.dimensions.ordovician.WorldProviderOrdovician;
import itsabouttime.common.dimensions.silurian.WorldProviderSilurian;
import itsabouttime.common.entities.VillagerScientistTradeHandler;
import itsabouttime.common.entities.prehistoric.EntityTrilobite;
import itsabouttime.common.event.EventTar;
import itsabouttime.common.handler.EntityHandler;
import itsabouttime.common.handler.GuiHandler;
import itsabouttime.common.worldgen.StructureHandler;
import itsabouttime.common.worldgen.WorldGenCoral;
import itsabouttime.common.worldgen.village.ComponentScientistHouse;
import itsabouttime.common.worldgen.village.VillageScientistHouseHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

@Mod(modid = iat.MODID, version = iat.VERSION)
public class iat
{
	/*TODO List:
	 * 1.Remove Grass, Reeds and Flowers from Dimensions
	 * 2.Add Attack AI toWaterPreditors(Anomacalraris)
	 * 3.Fix Buggy Model Animations
	 * 4.Find Way to Have Small Hitboxed-animals swim underwater
	 * 5.Get Lush Podzol overlay to work
	 */
	
	//This Is the Main Class, but I also use it for dimensional things.
    public static final String MODID = "itsabouttime";
    public static final String VERSION = "Pre-Release";
	
    public static KeyBinding TimeMachineInv;
    
	public static final int dimensionIdCambrian = 666;
	public static final int dimnsionIdOrdovician= 665;
	public static final int dimensionIdSilurian = 664;
	public static final int dimensionIdDenovian = 663;

	public static final int guiIDBook1 = 667;
	public static final int guiIdTarDistillery = 666;
	public static final int guiIdTimeMachine = 668;

	
	@Instance(MODID)
	public static iat instance;
	    
	@SidedProxy(clientSide = "itsabouttime.ProxyClient", serverSide = "itsabouttime.ProxyCommon")
	public static ProxyCommon proxy;

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	TimeMachineInv = new KeyBinding("key.timeMachineInv", Keyboard.KEY_Z, "key.categories.inventory");
        
	IATstuff.init();
	IATentities.init();
	IATmisc.init();
	IATbiomes.init();
	IATachievements.init();
	
	DimensionManager.registerProviderType(dimensionIdCambrian, WorldProviderCambrian.class, false);
	DimensionManager.registerDimension(dimensionIdCambrian, dimensionIdCambrian);
	
	DimensionManager.registerProviderType(dimnsionIdOrdovician, WorldProviderOrdovician.class, false);
	DimensionManager.registerDimension(dimnsionIdOrdovician, dimnsionIdOrdovician);

	DimensionManager.registerProviderType(dimensionIdSilurian, WorldProviderSilurian.class, false);
	DimensionManager.registerDimension(dimensionIdSilurian, dimensionIdSilurian);

	DimensionManager.registerProviderType(dimensionIdDenovian, WorldProviderDenovian.class, false);
	DimensionManager.registerDimension(dimensionIdDenovian, dimensionIdDenovian);
	


	proxy.registerRenderStuff();
	proxy.drawCircle();
//Still haven't gotten time machine key binding to work....
  ClientRegistry.registerKeyBinding(TimeMachineInv);
    }
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	GameRegistry.registerWorldGenerator(new StructureHandler(), 100);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	    MinecraftForge.EVENT_BUS.register(new EventTar(Minecraft.getMinecraft()));
		}
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
    }

