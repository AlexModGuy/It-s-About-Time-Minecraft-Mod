package itsabouttime.common.core;

import itsabouttime.client.render.item.ItemMusicDisc;
import itsabouttime.common.blocks.BlockBasic;
import itsabouttime.common.blocks.BlockBuilder;
import itsabouttime.common.blocks.BlockCambrianPortal;
import itsabouttime.common.blocks.BlockCambrianStone;
import itsabouttime.common.blocks.BlockColoredEmpty;
import itsabouttime.common.blocks.BlockDenovianPortal;
import itsabouttime.common.blocks.BlockFishBowl;
import itsabouttime.common.blocks.BlockGemBlock;
import itsabouttime.common.blocks.BlockGoldenIdol;
import itsabouttime.common.blocks.BlockLushPodzol;
import itsabouttime.common.blocks.BlockNewCoral;
import itsabouttime.common.blocks.BlockOldCoral;
import itsabouttime.common.blocks.BlockOldLeaves;
import itsabouttime.common.blocks.BlockOldLog;
import itsabouttime.common.blocks.BlockOldLog2;
import itsabouttime.common.blocks.BlockOldPlanks;
import itsabouttime.common.blocks.BlockOldPlanksSlab;
import itsabouttime.common.blocks.BlockOldPlants;
import itsabouttime.common.blocks.BlockOldSapling;
import itsabouttime.common.blocks.BlockOrdovicianPortal;
import itsabouttime.common.blocks.BlockOrdovicianStone;
import itsabouttime.common.blocks.BlockPrehistoricPodzol;
import itsabouttime.common.blocks.BlockShale;
import itsabouttime.common.blocks.BlockSilurianPortal;
import itsabouttime.common.blocks.BlockSilurianStone;
import itsabouttime.common.blocks.BlockStromatolite;
import itsabouttime.common.blocks.BlockTarDistillery;
import itsabouttime.common.blocks.BlockTimeRift;
import itsabouttime.common.blocks.BlockTreeFernLog;
import itsabouttime.common.blocks.fluid.TarFluid;
import itsabouttime.common.event.BucketEvent;
import itsabouttime.common.itemblocks.ItemColoredEmptyBlock;
import itsabouttime.common.itemblocks.ItemGemBlock;
import itsabouttime.common.itemblocks.ItemGoldIdolBlock;
import itsabouttime.common.itemblocks.ItemNewCoralBlock;
import itsabouttime.common.itemblocks.ItemOldCoralBlock;
import itsabouttime.common.itemblocks.ItemOldLeafBlock;
import itsabouttime.common.itemblocks.ItemOldLogBlock;
import itsabouttime.common.itemblocks.ItemOldLogBlock2;
import itsabouttime.common.itemblocks.ItemOldPlanksBlock;
import itsabouttime.common.itemblocks.ItemOldPlanksDoubleSlabBlock;
import itsabouttime.common.itemblocks.ItemOldPlanksSlabBlock;
import itsabouttime.common.itemblocks.ItemOldPlantsBlock;
import itsabouttime.common.itemblocks.ItemOldSaplingsBlock;
import itsabouttime.common.items.ItemArmorPlates;
import itsabouttime.common.items.ItemCreativeTabIcon;
import itsabouttime.common.items.ItemInsects;
import itsabouttime.common.items.ItemTimeMachine;
import itsabouttime.common.items.ItemEyes;
import itsabouttime.common.items.ItemFossilBook;
import itsabouttime.common.items.ItemFossils;
import itsabouttime.common.items.ItemOldFruit;
import itsabouttime.common.items.ItemTimeGem;
import itsabouttime.common.items.MyFood1Item;
import itsabouttime.common.items.armor.AnomalocarisArmor;
import itsabouttime.common.items.armor.NecklaceArmor;
import itsabouttime.common.items.armor.OpabinaArmor;
import itsabouttime.common.items.armor.TimeApperal;
import itsabouttime.common.items.armor.TrilobiteArmor;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class IATstuff {
	
	public static ArmorMaterial Necklace;
	public static ArmorMaterial TimeApperal;
public static ArmorMaterial TrilobiteArmor;
public static ArmorMaterial AnomalocarisArmor;
public static ArmorMaterial OpabinaArmor;

public static Item FossilBook;
public static Item Fossils;
public static Item TimeGem;
public static Item TimeMachine;
public static Item CreativeTabIcon1;
public static Item CreativeTabIcon2;

public static Item Insects;
public static Item AraucariaFruitI;
public static Item ArmorPlates;
public static Item Eyes;
public static Item TarDroplet;

public static Item TrilobiteHelmet;
public static Item TrilobiteChest;
public static Item TrilobiteLegs;
public static Item TrilobiteBoots;

public static Item AnomalocarisHelmet;
public static Item AnomalocarisChest;
public static Item AnomalocarisLegs;
public static Item AnomalocarisBoots;

public static Item GoldenNecklace;
public static Item TimeGoggles;
public static Item TimeChest;
public static Item TimeBoots;

public static Item OpabinaHelmet;
public static Item OpabinaChest;
public static Item OpabinaLegs;
public static Item OpabinaBoots;
public static Item MyFood1;
public static Item OldKey;
public static Item record_Oddysey;
public static Item record_Celldweller;

public static Item TarBucket;

public static Block BlockTarFluid;
public static Fluid fluidTar;
public static Material materialFluidTar;

public static Block OrganicMatter;
public static Block TarDistilleryOn;
public static Block TarDistilleryIdle;
public static Block Shale;
public static Block FossilSand;
public static Block GemBlock;
public static Block TimeRift;

public static Block CambrianStone;
public static Block OrdovicianStone;
public static Block SilurianStone;

public static Block CambrianCobble;
public static Block OrdovicianCobble;
public static Block SilurianCobble;

public static Block LushPodzol;
public static Block PrehistoricPodzol;
public static Block OldPlants;

public static Block OldSapling;
public static Block OldLog;
public static Block TreeFernLog;
public static Block OldLog2;
public static Block OldLeaves;
public static Block OldPlanks;
public static Block OldPlanksSlab;
public static Block OldPlanksDoubleSlab;

public static Block OldCoral;
public static Block NewCoral;
public static Block AraucariaFruit;
public static Block CambrianPortal;
public static Block OrdovicianPortal;
public static Block SilurianPortal;
public static Block DenovianPortal;

public static Block CambrianBuilder;
public static Block OrdovicianBuilder;
public static Block SilurianBuilder;
public static Block DenovianBuilder;

public static Block GoldenIdol;
public static Block Stromatolite;
public static Block FishBowl;

public static Block Emptyness;
public static Block ColoredEmptyness;

public static final int WILDCARD_VALUE = Short.MAX_VALUE;

	public static void init()
	{
		registerItems();
		gameRegisterItems();
		setFireInfo();
	}

	private static void registerItems()
	{
		Necklace= EnumHelper.addArmorMaterial("TimeApperal", 15, new int[]{0, 1, 0, 0}, 50);
		TimeApperal= EnumHelper.addArmorMaterial("TimeApperal", 30, new int[]{2, 5, 4, 1}, 25);
		TrilobiteArmor = EnumHelper.addArmorMaterial("TrilobiteArmor", 15, new int[]{2, 5, 4, 1}, 15);
		AnomalocarisArmor = EnumHelper.addArmorMaterial("AnomalocarisArmor", 17, new int[]{4, 7, 5, 2}, 17);
		OpabinaArmor = EnumHelper.addArmorMaterial("OpabinaArmor", 16, new int[]{3, 6, 5, 2}, 16);
		
		FossilBook = new ItemFossilBook().setTextureName("iat:Book_Trilobite").setUnlocalizedName("Book_Trilobite");
		
		TrilobiteHelmet = new TrilobiteArmor(TrilobiteArmor, 0, 0).setUnlocalizedName("TrilobiteHelmet").setTextureName("iat:Armor_Helmet_Trilobite");
		TrilobiteChest = new TrilobiteArmor(TrilobiteArmor, 0, 1).setUnlocalizedName("TrilobiteChest").setTextureName("iat:Armor_Chest_Trilobite");
		TrilobiteLegs = new TrilobiteArmor(TrilobiteArmor, 0, 2).setUnlocalizedName("TrilobiteLegs").setTextureName("iat:Armor_Leg_Trilobite");
		TrilobiteBoots = new TrilobiteArmor(TrilobiteArmor, 0, 3).setUnlocalizedName("TrilobiteBoots").setTextureName("iat:Armor_Boots_Trilobite");

		OpabinaHelmet = new OpabinaArmor(OpabinaArmor, 0, 0).setUnlocalizedName("OpabinaHelmet").setTextureName("iat:Armor_Helmet_Opabina");
		OpabinaChest = new OpabinaArmor(OpabinaArmor, 0, 1).setUnlocalizedName("OpabinaChest").setTextureName("iat:Armor_Chest_Opabina");
		OpabinaLegs = new OpabinaArmor(OpabinaArmor, 0, 2).setUnlocalizedName("OpabinaLegs").setTextureName("iat:Armor_Leg_Opabina");
		OpabinaBoots = new OpabinaArmor(OpabinaArmor, 0, 3).setUnlocalizedName("OpabinaBoots").setTextureName("iat:Armor_Boots_Opabina");

		AnomalocarisHelmet = new AnomalocarisArmor(AnomalocarisArmor, 0, 0).setUnlocalizedName("AnomalocarisHelmet").setTextureName("iat:Armor_Helmet_Anomalocaris");
		AnomalocarisChest = new AnomalocarisArmor(AnomalocarisArmor, 0, 1).setUnlocalizedName("AnomalocarisChest").setTextureName("iat:Armor_Chest_Anomalocaris");
		AnomalocarisLegs = new AnomalocarisArmor(AnomalocarisArmor, 0, 2).setUnlocalizedName("AnomalocarisLegs").setTextureName("iat:Armor_Leg_Anomalocaris");
		AnomalocarisBoots = new AnomalocarisArmor(AnomalocarisArmor, 0, 3).setUnlocalizedName("AnomalocarisBoots").setTextureName("iat:Armor_Boots_Anomalocaris");
		
		GoldenNecklace = new NecklaceArmor(Necklace, 0, 1).setUnlocalizedName("GoldenNecklace").setTextureName("iat:Necklace");
		TimeGoggles = new TimeApperal(TimeApperal, 0, 0).setUnlocalizedName("TimeGoggles").setTextureName("iat:Armor_Helmet_Goggles");
		TimeChest = new TimeApperal(TimeApperal, 0, 1).setUnlocalizedName("TimeChest").setTextureName("iat:Armor_Chest_Castiel");
		TimeBoots = new TimeApperal(TimeApperal, 0, 3).setUnlocalizedName("TimeBoots").setTextureName("iat:Armor_Boots_Time");
		
		MyFood1 = new MyFood1Item().setUnlocalizedName("MyFood1");
		
		TarDroplet = new Item().setTextureName("iat:TarDroplet").setUnlocalizedName("TarDroplet");
		Fossils = new ItemFossils().setUnlocalizedName("fossils");
		TimeGem = new ItemTimeGem().setUnlocalizedName("TimeGem");
		TimeMachine = new ItemTimeMachine(null).setTextureName("iat:TimeMachine").setUnlocalizedName("TimeMachine");
		CreativeTabIcon1 = new Item().setTextureName("iat:CreativeTabIcon").setUnlocalizedName("CreativeTabIcon");
		CreativeTabIcon2 = new Item().setTextureName("iat:PresentCreativeTabIcon").setUnlocalizedName("CreativeTabIcon");

		Insects = new ItemInsects().setUnlocalizedName("Insect");
		AraucariaFruitI = new ItemOldFruit().setUnlocalizedName("OldFruit");
		ArmorPlates = new ItemArmorPlates().setUnlocalizedName("ArmorPlates");
		Eyes = new ItemEyes().setUnlocalizedName("Eyes");
		
		fluidTar= new TarFluid("tar").setBlock(BlockTarFluid);
		FluidRegistry.registerFluid(fluidTar);
		materialFluidTar =new MaterialLiquid(MapColor.blackColor);
		BlockTarFluid=new itsabouttime.common.blocks.BlockTarFluid().setBlockName("fluid_Tar");
		
		OldKey = new Item().setUnlocalizedName("OldKey").setTextureName("iat:Key");
		record_Oddysey= new ItemMusicDisc("Oddysey").setUnlocalizedName("record_Oddysey");
		record_Celldweller= new ItemMusicDisc("Celldweller").setUnlocalizedName("record_Celldweller");
		TarBucket = new ItemBucket(IATstuff.BlockTarFluid).setUnlocalizedName("TarBucket").setTextureName("iat:Bucket_Tar").setContainerItem(Items.bucket);
		FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("tar", FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(TarBucket), new ItemStack(Items.bucket));
		
	
		OrganicMatter = new BlockBasic(MapColor.grassColor, Material.ground).setHardness(0.5F).setResistance(0.0F).setStepSound(Block.soundTypeGrass).setBlockName("OrganicMatter").setBlockTextureName("iat:OrganicMatter");
		TarDistilleryOn = new BlockTarDistillery(true).setBlockName("TarDistilleryOn").setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeMetal);
		TarDistilleryIdle = new BlockTarDistillery(false).setBlockName("TarDistilleryIdle").setHardness(1.5F).setResistance(10.0F).setStepSound(Block.soundTypeMetal);
		Shale = new BlockShale(Material.rock).setBlockName("Shale").setHardness(3.0F).setResistance(13.0F);

		FossilSand=new BlockShale(Material.sand).setBlockName("SandFossil").setHardness(0.5F);
		GemBlock = new BlockGemBlock().setBlockName("GemBlock").setHardness(5F).setResistance(10.0F);
		TimeRift = new BlockTimeRift(Material.portal).setHardness(0.0F).setResistance(6000000.0F).setStepSound(Block.soundTypeGlass).setBlockName("TimeRift");

		CambrianStone=new BlockCambrianStone().setHardness(1.5F).setResistance(10.0F).setBlockName("CambrianStone").setBlockTextureName("iat:CambrianStone");
		OrdovicianStone=new BlockOrdovicianStone().setHardness(1.5F).setResistance(10.0F).setBlockName("OrdovicianStone").setBlockTextureName("iat:OrdovicianStone");
		SilurianStone=new BlockSilurianStone().setHardness(1.5F).setResistance(10.0F).setBlockName("SilurianStone").setBlockTextureName("iat:SilurianStone");

		OrdovicianCobble =new BlockOrdovicianStone().setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setBlockName("OrdovicianCobble").setBlockTextureName("iat:OrdovicianCobble");
		SilurianCobble =new BlockSilurianStone().setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setBlockName("SilurianCobble").setBlockTextureName("iat:SilurianCobble");
		CambrianCobble =new BlockCambrianStone().setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setBlockName("CambrianCobble").setBlockTextureName("iat:CambrianCobble");
		
		LushPodzol=new BlockLushPodzol().setBlockName("LushPodzol").setStepSound(Block.soundTypeGrass).setHardness(0.6F);
		PrehistoricPodzol=new BlockPrehistoricPodzol().setBlockName("PrehistoricPodzol").setStepSound(Block.soundTypeGrass).setHardness(0.6F);
		OldPlants = new BlockOldPlants().setBlockName("OldPlants").setStepSound(Block.soundTypeGrass);
		OldCoral = new BlockOldCoral().setBlockName("OldCoral").setStepSound(Block.soundTypeGrass);
		NewCoral=new BlockNewCoral().setBlockName("NewCoral").setStepSound(Block.soundTypeGrass);
		OldSapling=new BlockOldSapling().setBlockName("OldSapling").setStepSound(Block.soundTypeGrass);
		OldLeaves =new BlockOldLeaves().setBlockName("OldLeaves").setStepSound(Block.soundTypeGrass);
		OldLog =new BlockOldLog().setBlockName("OldLog").setStepSound(Block.soundTypeWood);
		OldLog2 =new BlockOldLog2().setBlockName("OldLog2").setStepSound(Block.soundTypeWood);
		TreeFernLog=new BlockTreeFernLog(Material.wood).setBlockName("TreeFernLog").setBlockTextureName("iat:TreeFern").setStepSound(Block.soundTypeWood);
		OldPlanks=new BlockOldPlanks().setBlockName("OldPlanks").setStepSound(Block.soundTypeWood);
		OldPlanksDoubleSlab=new BlockOldPlanksSlab(true).setBlockName("OldPlanksDouble").setStepSound(Block.soundTypeWood);
		OldPlanksSlab=new BlockOldPlanksSlab(false).setBlockName("OldPlanksSlab").setStepSound(Block.soundTypeWood);
		CambrianPortal = new BlockCambrianPortal(Material.portal).setBlockName("CambrianPortal");
		OrdovicianPortal=new BlockOrdovicianPortal(Material.portal).setBlockName("OrdovicianPortal");
		SilurianPortal=new BlockSilurianPortal(Material.portal).setBlockName("SilurianPortal");
		DenovianPortal=new BlockDenovianPortal(Material.portal).setBlockName("DenovianPortal");
		
		CambrianBuilder= new BlockBuilder(Material.iron, IATstuff.CambrianPortal).setBlockTextureName("iat:CambrianBuilder").setBlockName("CambrianBuilder");
		OrdovicianBuilder = new BlockBuilder(Material.iron, IATstuff.OrdovicianPortal).setBlockTextureName("iat:OrdovicianBuilder").setBlockName("OrdovicianBuilder");
		SilurianBuilder=new BlockBuilder(Material.iron, IATstuff.SilurianPortal).setBlockTextureName("iat:SilurianBuilder").setBlockName("SilurianBuilder");
		DenovianBuilder=new BlockBuilder(Material.iron, IATstuff.DenovianPortal).setBlockTextureName("iat:DenovianBuilder").setBlockName("DenovianBuilder");

		GoldenIdol=new BlockGoldenIdol(Material.glass).setBlockName("GoldenIdol").setBlockTextureName("gold_block");
		Stromatolite=new BlockStromatolite(Material.rock).setHardness(2.0F).setResistance(10.0F).setBlockName("Stromatolite").setBlockTextureName("iat:Stromatolite");
		FishBowl = new BlockFishBowl(Material.glass).setHardness(2.0F).setResistance(5.0F).setBlockName("FishBowl").setBlockTextureName("glass");
		BucketEvent.INSTANCE.buckets.put(BlockTarFluid, TarBucket);
		MinecraftForge.EVENT_BUS.register(BucketEvent.INSTANCE);
		
		Emptyness=new BlockBasic(MapColor.adobeColor, Material.anvil).setBlockTextureName("iat:Void_White").setBlockName("Emptyness").setResistance(6000000.0F).setHardness(30F);
		ColoredEmptyness=new BlockColoredEmpty().setBlockName("Emptyness").setResistance(6000000.0F).setHardness(30F);

		}
	private static void gameRegisterItems() {



		GameRegistry.registerItem(FossilBook, "FossilBook");
		GameRegistry.registerItem(TarDroplet, "TarDroplet");
		GameRegistry.registerItem(Fossils, "Fossils");
		
		GameRegistry.registerItem(TimeGem, "TimeGem");
		GameRegistry.registerItem(TimeMachine, "TimeMachine");
		GameRegistry.registerItem(GoldenNecklace, "GoldenNecklace");
		GameRegistry.registerItem(TimeGoggles, "TimeGoggles");
		GameRegistry.registerItem(TimeChest, "TimeChest");
		GameRegistry.registerItem(TimeBoots, "TimeBoots");
		GameRegistry.registerItem(CreativeTabIcon1, "CreativeTabIcon1");
		GameRegistry.registerItem(CreativeTabIcon2, "CreativeTabIcon2");
		GameRegistry.registerItem(Insects, "Insects");
		GameRegistry.registerItem(ArmorPlates, "ArmorPlates");
		GameRegistry.registerItem(Eyes, "Eyes");
		GameRegistry.registerItem(MyFood1, "MyFood1");
		GameRegistry.registerItem(record_Oddysey, "record_Oddysey");
		GameRegistry.registerItem(record_Celldweller, "record_Celldweller");
		GameRegistry.registerItem(OldKey, "OldKey");

		
		GameRegistry.registerItem(TrilobiteHelmet, "TrilobiteHelmet");
		GameRegistry.registerItem(TrilobiteChest, "TrilobiteChest");
		GameRegistry.registerItem(TrilobiteLegs, "TrilobiteLegs");
		GameRegistry.registerItem(TrilobiteBoots, "TrilobiteBoots");
		
		GameRegistry.registerItem(OpabinaHelmet, "OpabinaHelmet");
		GameRegistry.registerItem(OpabinaChest, "OpabinaChest");
		GameRegistry.registerItem(OpabinaLegs, "OpabinaLegs");
		GameRegistry.registerItem(OpabinaBoots, "OpabinaBoots");
		
		GameRegistry.registerItem(AnomalocarisHelmet, "AnomalocarisHelmet");
		GameRegistry.registerItem(AnomalocarisChest, "AnomalocarisChest");
		GameRegistry.registerItem(AnomalocarisLegs, "AnomalocarisLegs");
		GameRegistry.registerItem(AnomalocarisBoots, "AnomalocarisBoots");
		
		GameRegistry.registerBlock(OrganicMatter, "OrganicMatter");
		GameRegistry.registerBlock(TarDistilleryIdle,"TarDistilleryIdle");
		GameRegistry.registerBlock(TarDistilleryOn,"TarDistilleryOn");

		GameRegistry.registerBlock(Shale, "Shale");
		GameRegistry.registerBlock(FossilSand, "FossilSand");

		GameRegistry.registerBlock(GemBlock, ItemGemBlock.class, GemBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(TimeRift, "TimeRift");
		GameRegistry.registerBlock(CambrianBuilder, "CambrianBuilder");
		GameRegistry.registerBlock(OrdovicianBuilder, "OrdovicianBuilder");
		GameRegistry.registerBlock(SilurianBuilder, "SilurianBuilder");
		GameRegistry.registerBlock(DenovianBuilder, "DenovianBuilder");
		GameRegistry.registerBlock(CambrianPortal, "CambrianPortal");
		GameRegistry.registerBlock(OrdovicianPortal, "OrdovicianPortal");
		GameRegistry.registerBlock(SilurianPortal, "SilurianPortal");
		GameRegistry.registerBlock(DenovianPortal, "DenovianPortal");
		GameRegistry.registerBlock(CambrianStone, "CambrianStone");
		GameRegistry.registerBlock(OrdovicianStone, "OrdovicianStone");
		GameRegistry.registerBlock(SilurianStone, "SilurianStone");
		GameRegistry.registerBlock(CambrianCobble, "CambrianCobble");
		GameRegistry.registerBlock(OrdovicianCobble, "OrdovicianCobble");
		GameRegistry.registerBlock(SilurianCobble, "SilurianCobble");
		GameRegistry.registerBlock(OldPlants, ItemOldPlantsBlock.class, OldPlants.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(OldCoral, ItemOldCoralBlock.class, OldCoral.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(NewCoral, ItemNewCoralBlock.class, NewCoral.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(Stromatolite, "Stromatolite");
		GameRegistry.registerBlock(OldSapling, ItemOldSaplingsBlock.class, OldSapling.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(OldLog, ItemOldLogBlock.class, OldLog.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(TreeFernLog, "TreeFernLog");
		GameRegistry.registerBlock(OldLog2, ItemOldLogBlock2.class, OldLog2.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(OldPlanks,ItemOldPlanksBlock.class, OldPlanks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(OldPlanksSlab,ItemOldPlanksSlabBlock.class, OldPlanksSlab.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(OldPlanksDoubleSlab,ItemOldPlanksDoubleSlabBlock.class, OldPlanksDoubleSlab.getUnlocalizedName().substring(5));

		GameRegistry.registerBlock(OldLeaves, ItemOldLeafBlock.class, OldLeaves.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(LushPodzol, "LushPodzol");
		GameRegistry.registerBlock(PrehistoricPodzol, "PrehistoricPodzol");
		
		GameRegistry.registerItem(TarBucket, "TarBucket");
		GameRegistry.registerBlock(BlockTarFluid, "Tar");

		GameRegistry.registerBlock(FishBowl, "FishBowl");
		GameRegistry.registerBlock(GoldenIdol, ItemGoldIdolBlock.class, "GoldenIdol");
		GameRegistry.registerBlock(Emptyness, "Emptyness");
		GameRegistry.registerBlock(ColoredEmptyness, ItemColoredEmptyBlock.class, "ColoredEmptyness");


		GameRegistry.addShapedRecipe(new ItemStack(OldPlanksSlab, 1, 0), new Object []{ "XXX" ,'X', new ItemStack(OldPlanks,1,0)});
		GameRegistry.addShapedRecipe(new ItemStack(OldPlanksSlab, 1, 1), new Object []{ "XXX" ,'X', new ItemStack(OldPlanks,1,1)});
		GameRegistry.addShapedRecipe(new ItemStack(OldPlanksSlab, 1, 2), new Object []{ "XXX" ,'X', new ItemStack(OldPlanks,1,2)});
		GameRegistry.addShapedRecipe(new ItemStack(OldPlanksSlab, 1, 3), new Object []{ "XXX" ,'X', new ItemStack(OldPlanks,1,3)});
		GameRegistry.addShapedRecipe(new ItemStack(GoldenNecklace, 1, 0), new Object []{ "XXX" , "X X","XYX",'X', Items.gold_ingot,'Y', Items.emerald});

    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IATstuff.OldKey, 1, 0), "ffc","  g","  g",'g',"ingotIron", 'c', "bioFossil", 'f', Blocks.iron_bars));
    	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(IATstuff.OrganicMatter, 1, 0), "ggg","ggg","ggg",'g',"organicMatter"));
		GameRegistry.addShapedRecipe(new ItemStack(TarBucket, 1, 0), new Object []{"XXX", "XYX", "XXX", 'Y',Items.bucket,'X', IATstuff.TarDroplet});
    	//
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 1),new ItemStack(IATstuff.NewCoral, 1, 4));
    	//
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 10),new ItemStack(IATstuff.NewCoral, 1, 1));
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 9),new ItemStack(IATstuff.NewCoral, 1, 3));
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 11),new ItemStack(IATstuff.NewCoral, 1, 2));
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 4),new ItemStack(IATstuff.NewCoral, 1, 0));

    	
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 11),new ItemStack(IATstuff.OldCoral, 1, 0));
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 4),new ItemStack(IATstuff.OldCoral, 1, 1));
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 9),new ItemStack(IATstuff.OldCoral, 1, 2));
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 5),new ItemStack(IATstuff.OldCoral, 1, 3));
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 10),new ItemStack(IATstuff.OldCoral, 1, 4));
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.dye, 2, 1),new ItemStack(IATstuff.OldCoral, 1, 5));
    	
		GameRegistry.addShapedRecipe(new ItemStack(TimeGem, 1, 0), new Object []{"XZX", "XYX", "XZX", 'Y',Items.nether_star, 'Z',Items.diamond, 'X', new ItemStack(Fossils, 1, 0)});
		GameRegistry.addShapedRecipe(new ItemStack(TimeGem, 1, 1), new Object []{"XZX", "XYX", "XZX", 'Y',Items.nether_star, 'Z',Items.diamond, 'X', new ItemStack(Fossils, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(TimeGem, 1, 2), new Object []{"XZX", "XYX", "XZX", 'Y',Items.nether_star, 'Z',Items.diamond, 'X', new ItemStack(Fossils, 1, 2)});
		GameRegistry.addShapedRecipe(new ItemStack(TimeGem, 1, 3), new Object []{"XZX", "XYX", "XZX", 'Y',Items.nether_star, 'Z',Items.diamond, 'X', new ItemStack(Fossils, 1, 3)});
		GameRegistry.addShapedRecipe(new ItemStack(TimeGem, 1, 4), new Object []{"XZX", "XYX", "XZX", 'Y',Items.nether_star, 'Z',Items.diamond, 'X', new ItemStack(Fossils, 1, 4)});
		GameRegistry.addShapedRecipe(new ItemStack(TimeGem, 1, 5), new Object []{"XZX", "XYX", "XZX", 'Y',Items.nether_star, 'Z',Items.diamond, 'X', new ItemStack(Fossils, 1, 5)});
		GameRegistry.addShapedRecipe(new ItemStack(TimeGem, 1, 6), new Object []{"XZX", "XYX", "XZX", 'Y',Items.nether_star, 'Z',Items.diamond, 'X', new ItemStack(Fossils, 1, 6)});
		GameRegistry.addShapedRecipe(new ItemStack(TimeGem, 1, 7), new Object []{"XZX", "XYX", "XZX", 'Y',Items.nether_star, 'Z',Items.diamond, 'X', new ItemStack(Fossils, 1, 7)});
		GameRegistry.addShapedRecipe(new ItemStack(TimeGem, 1, 8), new Object []{"XZX", "XYX", "XZX", 'Y',Items.nether_star, 'Z',Items.diamond, 'X', new ItemStack(Fossils, 1, 8)});
		GameRegistry.addShapedRecipe(new ItemStack(TimeGem, 1, 9), new Object []{"XZX", "XYX", "XZX", 'Y',Items.nether_star, 'Z',Items.diamond, 'X', new ItemStack(Fossils, 1, 9)});
		GameRegistry.addShapedRecipe(new ItemStack(TimeGem, 1, 10), new Object []{"XZX", "XYX", "XZX", 'Y',Items.nether_star, 'Z',Items.diamond, 'X', new ItemStack(Fossils, 1, 10)});

		GameRegistry.addShapedRecipe(new ItemStack(GemBlock, 1, 0), new Object []{"XZX", "ZYZ", "XZX", 'Y',new ItemStack(TimeGem, 1, 0), 'X',Blocks.iron_block, 'Z', Blocks.quartz_block});
		GameRegistry.addShapedRecipe(new ItemStack(GemBlock, 1, 1), new Object []{"XZX", "ZYZ", "XZX", 'Y',new ItemStack(TimeGem, 1, 1), 'X',Blocks.iron_block, 'Z', Blocks.quartz_block});
		GameRegistry.addShapedRecipe(new ItemStack(GemBlock, 1, 2), new Object []{"XZX", "ZYZ", "XZX", 'Y',new ItemStack(TimeGem, 1, 2), 'X',Blocks.iron_block, 'Z', Blocks.quartz_block});
		GameRegistry.addShapedRecipe(new ItemStack(GemBlock, 1, 3), new Object []{"XZX", "ZYZ", "XZX", 'Y',new ItemStack(TimeGem, 1, 3), 'X',Blocks.iron_block, 'Z', Blocks.quartz_block});
		GameRegistry.addShapedRecipe(new ItemStack(GemBlock, 1, 4), new Object []{"XZX", "ZYZ", "XZX", 'Y',new ItemStack(TimeGem, 1, 4), 'X',Blocks.iron_block, 'Z', Blocks.quartz_block});
		GameRegistry.addShapedRecipe(new ItemStack(GemBlock, 1, 5), new Object []{"XZX", "ZYZ", "XZX", 'Y',new ItemStack(TimeGem, 1, 5), 'X',Blocks.iron_block, 'Z', Blocks.quartz_block});
		GameRegistry.addShapedRecipe(new ItemStack(GemBlock, 1, 6), new Object []{"XZX", "ZYZ", "XZX", 'Y',new ItemStack(TimeGem, 1, 6), 'X',Blocks.iron_block, 'Z', Blocks.quartz_block});
		GameRegistry.addShapedRecipe(new ItemStack(GemBlock, 1, 7), new Object []{"XZX", "ZYZ", "XZX", 'Y',new ItemStack(TimeGem, 1, 7), 'X',Blocks.iron_block, 'Z', Blocks.quartz_block});
		GameRegistry.addShapedRecipe(new ItemStack(GemBlock, 1, 8), new Object []{"XZX", "ZYZ", "XZX", 'Y',new ItemStack(TimeGem, 1, 8), 'X',Blocks.iron_block, 'Z', Blocks.quartz_block});
		GameRegistry.addShapedRecipe(new ItemStack(GemBlock, 1, 9), new Object []{"XZX", "ZYZ", "XZX", 'Y',new ItemStack(TimeGem, 1, 9), 'X',Blocks.iron_block, 'Z', Blocks.quartz_block});
		GameRegistry.addShapedRecipe(new ItemStack(GemBlock, 1,10), new Object []{"XZX", "ZYZ", "XZX", 'Y',new ItemStack(TimeGem, 1, 10), 'X',Blocks.iron_block, 'Z', Blocks.quartz_block});

		GameRegistry.addShapedRecipe(new ItemStack(CambrianBuilder), new Object []{"XZX", "QYQ", "XZX", 'Y',new ItemStack(GemBlock, 1, 0),'Q', new ItemStack(Blocks.quartz_block, 1, 2), 'X',Blocks.quartz_block, 'Z', Blocks.glowstone});
		GameRegistry.addShapedRecipe(new ItemStack(OrdovicianBuilder), new Object []{"XZX", "QYQ", "XZX", 'Y',new ItemStack(GemBlock, 1, 1),'Q', new ItemStack(Blocks.quartz_block, 1, 2), 'X',Blocks.quartz_block, 'Z', Blocks.glowstone});
		GameRegistry.addShapedRecipe(new ItemStack(SilurianBuilder), new Object []{"XZX", "QYQ", "XZX", 'Y',new ItemStack(GemBlock, 1, 2),'Q', new ItemStack(Blocks.quartz_block, 1, 2), 'X',Blocks.quartz_block, 'Z', Blocks.glowstone});
		GameRegistry.addShapedRecipe(new ItemStack(DenovianBuilder), new Object []{"XZX", "QYQ", "XZX", 'Y',new ItemStack(GemBlock, 1, 3),'Q', new ItemStack(Blocks.quartz_block, 1, 2), 'X',Blocks.quartz_block, 'Z', Blocks.glowstone});
		
		GameRegistry.addShapedRecipe(new ItemStack(AnomalocarisHelmet), new Object []{"XZX", "Z Z", 'X',new ItemStack(Eyes, 1, 1),'Z', new ItemStack(ArmorPlates,1,1)});
		GameRegistry.addShapedRecipe(new ItemStack(AnomalocarisChest), new Object []{"X X", "XXX","ZXZ", 'X',new ItemStack(ArmorPlates, 1, 1),'Z', new ItemStack(Items.string)});
		GameRegistry.addShapedRecipe(new ItemStack(AnomalocarisLegs), new Object []{"XXX", "X X","X X", 'X',new ItemStack(ArmorPlates, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(AnomalocarisBoots), new Object []{"X X", "X X", 'X',new ItemStack(ArmorPlates, 1, 1)});

	
		GameRegistry.addSmelting(new ItemStack(MyFood1, 1, 0), new ItemStack(MyFood1, 1,1),  0.35F);
		GameRegistry.addSmelting(new ItemStack(MyFood1, 1, 2), new ItemStack(MyFood1, 1,3),  0.35F);
		GameRegistry.addSmelting(new ItemStack(MyFood1, 1, 4), new ItemStack(MyFood1, 1,5),  0.35F);
		GameRegistry.addSmelting(new ItemStack(MyFood1, 1, 6), new ItemStack(MyFood1, 1,7),  0.35F);

		
		
		//OreDictionary.registerOre("dyeBlue", new ItemStack(BlueDye));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.sugar));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.reeds));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.rotten_flesh));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.apple));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.baked_potato));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.beef));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.bone));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.bread));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.cake));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.carrot));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.carrot_on_a_stick));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.chicken));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.clay_ball));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.coal));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.cooked_beef));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.cooked_chicken));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.cooked_fished));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.cooked_porkchop));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.dye));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.egg));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.ender_eye));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.ender_pearl));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.feather));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.fermented_spider_eye));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.fish));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.flint));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.ghast_tear));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.gunpowder));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.item_frame));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.lead));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.leather));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.leather_boots));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.leather_chestplate));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.leather_helmet));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.leather_leggings));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.magma_cream));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.melon));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.melon_seeds));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.mushroom_stew));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.bowl));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.book));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.boat));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.name_tag));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.bow));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.nether_wart));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.painting));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.paper));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.poisonous_potato));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.porkchop));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.potato));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.pumpkin_pie));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.pumpkin_seeds));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.saddle));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.sign));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.skull));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.slime_ball));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.snowball));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.spider_eye));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.stick));
		OreDictionary.registerOre("organicMatter", new ItemStack(Items.string));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.acacia_stairs));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.birch_stairs));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.bookshelf));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.brown_mushroom_block));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.cactus));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.carpet));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.clay));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.coal_block));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.dark_oak_stairs));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.dirt));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.dragon_egg));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.deadbush));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.double_plant));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.double_wooden_slab));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.fence));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.fence_gate));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.glowstone));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.gravel));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.grass));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.hay_block));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.ice));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.jungle_stairs));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.ladder));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.lapis_block));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.lever));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.lit_pumpkin));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.log, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.log2));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.leaves));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.leaves2));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.melon_block));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.oak_stairs));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.planks));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.pumpkin));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.red_mushroom_block));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.sapling));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.snow));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.snow_layer));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.soul_sand));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.sponge));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.spruce_stairs));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.sand));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.vine));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.waterlily));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.red_flower));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.yellow_flower));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.web));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.wooden_button));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.wooden_pressure_plate));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.wooden_slab));
		OreDictionary.registerOre("organicMatter", new ItemStack(Blocks.wool));
		OreDictionary.registerOre("bucketIron", new ItemStack(Items.bucket));

		OreDictionary.registerOre("logWood",     new ItemStack(IATstuff.OldLog, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("logWood",     new ItemStack(IATstuff.TreeFernLog, 1, 0));
		
		OreDictionary.registerOre("plankWood",     new ItemStack(IATstuff.OldPlanks, 1, WILDCARD_VALUE));
		OreDictionary.registerOre("bioFossil",     new ItemStack(IATstuff.Fossils, 1, WILDCARD_VALUE));

			
		
		
		
		
		
		
		


	}
	private static void setFireInfo() {
		Blocks.fire.setFireInfo(OldLeaves, 30, 60);
		Blocks.fire.setFireInfo(OldLog, 5, 20);
		Blocks.fire.setFireInfo(TreeFernLog, 5, 20);
		Blocks.fire.setFireInfo(OldPlanks, 5, 20);
		Blocks.fire.setFireInfo(OldPlanksSlab, 5, 20);
		Blocks.fire.setFireInfo(OldPlanksDoubleSlab, 5, 20);
		Blocks.fire.setFireInfo(OldPlants, 60,100);
		Blocks.fire.setFireInfo(BlockTarFluid, 60,100);		
	}
	
}
