package iat;

import iat.core.ModBiomes;
import iat.core.ModBlocks;
import iat.core.ModDimensions;
import iat.core.ModEntities;
import iat.core.ModItems;
import iat.core.ModRecipes;
import iat.misc.CreativeTabsIat;
import iat.misc.GuiHandler;

import org.lwjgl.input.Keyboard;










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

@Mod(modid = ItsAboutTime.MODID, version = ItsAboutTime.VERSION)
public class ItsAboutTime
{

	public static final String MODID = "itsabouttime";
	public static final String VERSION = "Pre-Release";
	public static CreativeTabs iatTab;
	public static final int GUIMatterConverterID = 1;
	public static final int GUICleaningTableID = 2;

	@Instance(MODID)
	public static ItsAboutTime instance;

	@SidedProxy(clientSide = "iat.ProxyClient", serverSide = "iat.ProxyCommon")
	public static ProxyCommon proxy;

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		iatTab = new CreativeTabsIat(CreativeTabs.getNextID(), "iat.creativeTab");
		proxy.registerRenderStuff();	
		ModItems.init();
		ModBlocks.init();
		ModDimensions.init();
		ModBiomes.init();
		ModEntities.init();
		ModRecipes.init();
		proxy.drawCircle( new ResourceLocation("iat:textures/blocks/grid.png"));
		proxy.drawCylinder( new ResourceLocation("iat:textures/blocks/grid.png"));
	}
	@EventHandler
	public void load(FMLInitializationEvent event)
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
	}
}

