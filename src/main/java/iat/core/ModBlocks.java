package iat.core;

import cpw.mods.fml.common.registry.GameRegistry;
import iat.ItsAboutTime;
import iat.blocks.BlockCleaningTable;
import iat.blocks.BlockFossil;
import iat.blocks.BlockGrid;
import iat.blocks.BlockHorseTail;
import iat.blocks.BlockMatterConverter;
import iat.blocks.BlockPlaster;
import iat.blocks.BlockPlasterFossil;
import iat.blocks.BlockPlasterWall;
import iat.blocks.BlockLowFern;
import iat.blocks.BlockPrehistoricWood_1;
import iat.blocks.BlockTimeRift;
import iat.entities.tile.TileEntityCleaningTable;
import iat.entities.tile.TileEntityMatterConverter;
import iat.entities.tile.TileEntityTimeRift;
import iat.items.blocks.ItemCambrianBlock;
import iat.items.blocks.ItemCarboniferousBlock;
import iat.items.blocks.ItemCleaningTable;
import iat.items.blocks.ItemCretaceousBlock;
import iat.items.blocks.ItemDevonianBlock;
import iat.items.blocks.ItemJurassicBlock;
import iat.items.blocks.ItemMatterConverterBlock;
import iat.items.blocks.ItemNeogeneBlock;
import iat.items.blocks.ItemNowhereBlock;
import iat.items.blocks.ItemOrdovicianBlock;
import iat.items.blocks.ItemPaleogeneBlock;
import iat.items.blocks.ItemPermianBlock;
import iat.items.blocks.ItemRiftCreatorBlock;
import iat.items.blocks.ItemSilurianBlock;
import iat.items.blocks.ItemTriassicBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class ModBlocks {

	public static Block fossil_Ore_Cambrian;
	public static Block fossil_Ore_Ordovician;
	public static Block fossil_Ore_Silurian;
	public static Block fossil_Ore_Devonian;
	public static Block fossil_Ore_Carboniferous;
	public static Block fossil_Ore_Permian;
	public static Block fossil_Ore_Triassic;
	public static Block fossil_Ore_Jurassic;
	public static Block fossil_Ore_Cretaceous;
	public static Block fossil_Ore_Paleogene;
	public static Block fossil_Ore_Neogene;
	public static Block plastered_Fossil_Cambrian;
	public static Block plastered_Fossil_Ordovician;
	public static Block plastered_Fossil_Silurian;
	public static Block plastered_Fossil_Devonian;
	public static Block plastered_Fossil_Carboniferous;
	public static Block plastered_Fossil_Permian;
	public static Block plastered_Fossil_Triassic;
	public static Block plastered_Fossil_Jurassic;
	public static Block plastered_Fossil_Cretaceous;
	public static Block plastered_Fossil_Paleogene;
	public static Block plastered_Fossil_Neogene;
	public static Block cleaning_Table_Off;
	public static Block cleaning_Table_On;
	public static Block plaster;
	public static Block plaster_Wall;
	public static Block Matter_converter_on;
	public static Block Matter_converter_off;
	public static Block timeRift_nowhere;
	public static Block timeRift_cambrian;
	public static Block timeRift_cretaceous;
	public static Block low_Fern_Block;
	public static Block horsetail;
	public static Block pre_Log_1;

	public static Block grid;

	public static void init() {
		initializeBlocks();
		register();
	}
	public static void initializeBlocks(){
		plastered_Fossil_Cambrian = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		plastered_Fossil_Ordovician = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		plastered_Fossil_Silurian = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		plastered_Fossil_Devonian = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		plastered_Fossil_Carboniferous = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		plastered_Fossil_Permian = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		plastered_Fossil_Triassic = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		plastered_Fossil_Jurassic = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		plastered_Fossil_Cretaceous = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		plastered_Fossil_Paleogene = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		plastered_Fossil_Neogene = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		fossil_Ore_Cambrian = new BlockFossil(Material.rock, plastered_Fossil_Cambrian).setBlockTextureName("iat:fossil_Ore").setBlockName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab).setHardness(3F).setResistance(15F);
		fossil_Ore_Ordovician = new BlockFossil(Material.rock, plastered_Fossil_Ordovician).setBlockTextureName("iat:fossil_Ore").setBlockName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab).setHardness(3F).setResistance(15F);
		fossil_Ore_Silurian = new BlockFossil(Material.rock, plastered_Fossil_Silurian).setBlockTextureName("iat:fossil_Ore").setBlockName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab).setHardness(3F).setResistance(15F);
		fossil_Ore_Devonian = new BlockFossil(Material.rock, plastered_Fossil_Devonian).setBlockTextureName("iat:fossil_Ore").setBlockName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab).setHardness(3F).setResistance(15F);
		fossil_Ore_Carboniferous = new BlockFossil(Material.rock, plastered_Fossil_Carboniferous).setBlockTextureName("iat:fossil_Ore").setBlockName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab).setHardness(3F).setResistance(15F);
		fossil_Ore_Permian = new BlockFossil(Material.rock, plastered_Fossil_Permian).setBlockTextureName("iat:fossil_Ore").setBlockName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab).setHardness(3F).setResistance(15F);
		fossil_Ore_Triassic = new BlockFossil(Material.rock, plastered_Fossil_Triassic).setBlockTextureName("iat:fossil_Ore").setBlockName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab).setHardness(3F).setResistance(15F);
		fossil_Ore_Jurassic = new BlockFossil(Material.rock, plastered_Fossil_Jurassic).setBlockTextureName("iat:fossil_Ore").setBlockName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab).setHardness(3F).setResistance(15F);
		fossil_Ore_Cretaceous = new BlockFossil(Material.rock, plastered_Fossil_Cretaceous).setBlockTextureName("iat:fossil_Ore").setBlockName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab).setHardness(3F).setResistance(15F);
		fossil_Ore_Paleogene = new BlockFossil(Material.rock, plastered_Fossil_Paleogene).setBlockTextureName("iat:fossil_Ore").setBlockName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab).setHardness(3F).setResistance(15F);
		fossil_Ore_Neogene = new BlockFossil(Material.rock, plastered_Fossil_Neogene).setBlockTextureName("iat:fossil_Ore").setBlockName("iat.fossil").setCreativeTab(ItsAboutTime.iatTab).setHardness(3F).setResistance(15F);
		cleaning_Table_Off = new BlockCleaningTable(Material.wood, false).setBlockTextureName("log_oak_top").setBlockName("iat.cleaning_Table").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(5F).setStepSound(Block.soundTypeWood);
		cleaning_Table_On = new BlockCleaningTable(Material.wood, true).setBlockTextureName("log_oak_top").setBlockName("iat.cleaning_Table").setHardness(2F).setResistance(5F).setStepSound(Block.soundTypeWood);
		plaster = new BlockPlaster(Material.clay).setBlockTextureName("iat:plaster_Block").setBlockName("iat.plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(0.7F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		plaster_Wall = new BlockPlasterWall(plaster).setBlockTextureName("iat:plaster_Block").setBlockName("iat.plaster_Wall").setCreativeTab(ItsAboutTime.iatTab).setHardness(0.5F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		Matter_converter_on = new BlockMatterConverter(Material.iron, true).setBlockName("iat.matter_converter").setHardness(5F).setResistance(15F).setStepSound(Block.soundTypeMetal);
		Matter_converter_off = new BlockMatterConverter(Material.iron, false).setBlockName("iat.matter_converter").setHardness(5F).setResistance(15F).setCreativeTab(ItsAboutTime.iatTab).setStepSound(Block.soundTypeMetal);
		timeRift_nowhere = new BlockTimeRift(Material.portal, ModDimensions.Dim_nowhere).setBlockName("iat.timeRift").setHardness(2F).setResistance(1000F).setLightLevel(0.5F).setCreativeTab(ItsAboutTime.iatTab);
		timeRift_cretaceous = new BlockTimeRift(Material.portal, ModDimensions.Dim_cretaceous).setBlockName("iat.timeRift").setHardness(2F).setResistance(1000F).setLightLevel(0.5F).setCreativeTab(ItsAboutTime.iatTab);
		low_Fern_Block = new BlockLowFern().setBlockName("iat.low_Fern").setBlockTextureName("iat:low_Fern").setCreativeTab(ItsAboutTime.iatTab).setHardness(0.6F);
		horsetail = new BlockHorseTail(Material.plants).setBlockName("iat.horsetail").setBlockTextureName("iat:horsetail").setCreativeTab(ItsAboutTime.iatTab).setHardness(0.3F).setStepSound(Block.soundTypeGrass);
		//pre_Log_1 = new BlockPrehistoricWood_1().setBlockName("iat.log").setBlockTextureName("iat:log").setCreativeTab(ItsAboutTime.iatTab).setHardness(0.3F).setStepSound(Block.soundTypeGrass);
		grid = new BlockGrid(Material.rock).setBlockUnbreakable().setBlockTextureName("iat:grid").setBlockName("iat.grid").setCreativeTab(ItsAboutTime.iatTab);
	}
	public static void register(){
		GameRegistry.registerBlock(fossil_Ore_Cambrian, ItemCambrianBlock.class, "fossil_Ore_Cambrian");
		GameRegistry.registerBlock(fossil_Ore_Ordovician, ItemOrdovicianBlock.class, "fossil_Ore_Ordovician");
		GameRegistry.registerBlock(fossil_Ore_Silurian, ItemSilurianBlock.class, "fossil_Ore_Silurian");
		GameRegistry.registerBlock(fossil_Ore_Devonian, ItemDevonianBlock.class, "fossil_Ore_Devonian");
		GameRegistry.registerBlock(fossil_Ore_Carboniferous, ItemCarboniferousBlock.class, "fossil_Ore_Carboniferous");
		GameRegistry.registerBlock(fossil_Ore_Permian, ItemPermianBlock.class, "fossil_Ore_Permian");
		GameRegistry.registerBlock(fossil_Ore_Triassic, ItemTriassicBlock.class, "fossil_Ore_Triassic");
		GameRegistry.registerBlock(fossil_Ore_Jurassic, ItemJurassicBlock.class, "fossil_Ore_Jurassic");
		GameRegistry.registerBlock(fossil_Ore_Cretaceous, ItemCretaceousBlock.class, "fossil_Ore_Cretaceous");
		GameRegistry.registerBlock(fossil_Ore_Paleogene, ItemPaleogeneBlock.class, "fossil_Ore_Paleogene");
		GameRegistry.registerBlock(fossil_Ore_Neogene, ItemNeogeneBlock.class, "fossil_Ore_Neogene");
		GameRegistry.registerBlock(plastered_Fossil_Cambrian, ItemCambrianBlock.class, "plastered_Fossil_Cambrian");
		GameRegistry.registerBlock(plastered_Fossil_Ordovician, ItemOrdovicianBlock.class, "plastered_Fossil_Ordovician");
		GameRegistry.registerBlock(plastered_Fossil_Silurian, ItemSilurianBlock.class, "plastered_Fossil_Silurian");
		GameRegistry.registerBlock(plastered_Fossil_Devonian, ItemDevonianBlock.class, "plastered_Fossil_Devonian");
		GameRegistry.registerBlock(plastered_Fossil_Carboniferous, ItemCarboniferousBlock.class, "plastered_Fossil_Carboniferous");
		GameRegistry.registerBlock(plastered_Fossil_Permian, ItemPermianBlock.class, "plastered_Fossil_Permian");
		GameRegistry.registerBlock(plastered_Fossil_Triassic, ItemTriassicBlock.class, "plastered_Fossil_Triassic");
		GameRegistry.registerBlock(plastered_Fossil_Jurassic, ItemJurassicBlock.class, "plastered_Fossil_Jurassic");
		GameRegistry.registerBlock(plastered_Fossil_Cretaceous, ItemCretaceousBlock.class, "plastered_Fossil_Cretaceous");
		GameRegistry.registerBlock(plastered_Fossil_Paleogene, ItemPaleogeneBlock.class, "plastered_Fossil_Paleogene");
		GameRegistry.registerBlock(plastered_Fossil_Neogene, ItemNeogeneBlock.class, "plastered_Fossil_Neogene");
		GameRegistry.registerBlock(cleaning_Table_Off, ItemCleaningTable.class, "cleaning_Table_Off");
		GameRegistry.registerBlock(cleaning_Table_On, ItemCleaningTable.class, "cleaning_Table_On");
		GameRegistry.registerBlock(plaster, "plaster");
		GameRegistry.registerBlock(plaster_Wall, "plaster_Wall");
		GameRegistry.registerBlock(Matter_converter_off, ItemMatterConverterBlock.class, "Matter_converter_off");
		GameRegistry.registerBlock(Matter_converter_on, ItemMatterConverterBlock.class, "Matter_converter_on");
		GameRegistry.registerBlock(timeRift_nowhere, ItemNowhereBlock.class, "timeRift_nowhere");
		GameRegistry.registerBlock(timeRift_cretaceous, ItemCretaceousBlock.class, "timeRift_cretaceous");
		
		GameRegistry.registerBlock(low_Fern_Block, "low_Fern_Block");
		GameRegistry.registerBlock(horsetail, "horsetail");

		GameRegistry.registerBlock(grid, "grid");
		
		GameRegistry.registerTileEntity(TileEntityTimeRift.class, "TileEntityTimeRift");
		GameRegistry.registerTileEntity(TileEntityMatterConverter.class, "TileEntityMatterConverter");
		GameRegistry.registerTileEntity(TileEntityCleaningTable.class, "TileEntityCleaningTable");

	}
}
