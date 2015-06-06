package iat.core;

import cpw.mods.fml.common.registry.GameRegistry;
import iat.ItsAboutTime;
import iat.blocks.BlockAmber;
import iat.blocks.BlockBasic;
import iat.blocks.BlockCleaningTable;
import iat.blocks.BlockFossil;
import iat.blocks.BlockGinkoNut;
import iat.blocks.BlockGrid;
import iat.blocks.BlockHorseTail;
import iat.blocks.BlockMatterConverter;
import iat.blocks.BlockMud;
import iat.blocks.BlockPlaster;
import iat.blocks.BlockPlasterFossil;
import iat.blocks.BlockPlasterWall;
import iat.blocks.BlockLowFern;
import iat.blocks.BlockPrehistoricLeaves;
import iat.blocks.BlockPrehistoricSapling;
import iat.blocks.BlockPrehistoricWood;
import iat.blocks.BlockTimeFluid;
import iat.blocks.BlockTimeRift;
import iat.blocks.fluid.FluidTime;
import iat.entities.tile.TileEntityCleaningTable;
import iat.entities.tile.TileEntityMatterConverter;
import iat.entities.tile.TileEntityTimeRift;
import iat.enums.EnumFossilSkeleton;
import iat.enums.EnumPrehistoricTrees;
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
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

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
	public static Block amber_Silverfish;
	public static Block amber_Spider;
	public static Block amber_Compsognathus;
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
	public static Block mud;
	public static Block dried_Mud;
	public static Block low_Fern_Block;
	public static Block horsetail;
	public static Block grid;
	public static Block fluidTimeBlock;
	public static Block ginkoNut;

	public static Fluid fluidTime;
	public static Material materialFluidTime;

	public static void init() {
		initializeBlocks();
		register();
	}
	public static void initializeBlocks(){
		plastered_Fossil_Cambrian = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F);
		plastered_Fossil_Ordovician = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F);
		plastered_Fossil_Silurian = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F);
		plastered_Fossil_Devonian = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F);
		plastered_Fossil_Carboniferous = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F);
		plastered_Fossil_Permian = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F);
		plastered_Fossil_Triassic = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F);
		plastered_Fossil_Jurassic = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F);
		plastered_Fossil_Cretaceous = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F);
		plastered_Fossil_Paleogene = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F);
		plastered_Fossil_Neogene = new BlockPlasterFossil(Material.clay).setBlockTextureName("iat:plaster_Fossil").setBlockName("iat.fossil_Plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(15F);
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
		amber_Silverfish = new BlockAmber(Material.rock, 0).setBlockTextureName("iat:amber").setBlockName("iat.amber").setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeGlass);
		amber_Spider = new BlockAmber(Material.rock, 1).setBlockTextureName("iat:amber").setBlockName("iat.amber").setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeGlass);
		amber_Compsognathus = new BlockAmber(Material.rock, 2).setBlockTextureName("iat:amber").setBlockName("iat.amber").setHardness(3F).setResistance(5F).setStepSound(Block.soundTypeGlass);
		cleaning_Table_Off = new BlockCleaningTable(Material.wood, false).setBlockTextureName("log_oak_top").setBlockName("iat.cleaning_Table").setCreativeTab(ItsAboutTime.iatTab).setHardness(2F).setResistance(5F).setStepSound(Block.soundTypeWood);
		cleaning_Table_On = new BlockCleaningTable(Material.wood, true).setBlockTextureName("log_oak_top").setBlockName("iat.cleaning_Table").setHardness(2F).setResistance(5F).setStepSound(Block.soundTypeWood);
		plaster = new BlockPlaster(Material.clay).setBlockTextureName("iat:plaster_Block").setBlockName("iat.plaster").setCreativeTab(ItsAboutTime.iatTab).setHardness(0.7F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		plaster_Wall = new BlockPlasterWall(plaster).setBlockTextureName("iat:plaster_Block").setBlockName("iat.plaster_Wall").setCreativeTab(ItsAboutTime.iatTab).setHardness(0.5F).setResistance(15F).setStepSound(Block.soundTypeGravel);
		Matter_converter_on = new BlockMatterConverter(Material.iron, true).setBlockName("iat.matter_converter").setHardness(5F).setResistance(15F).setStepSound(Block.soundTypeMetal);
		Matter_converter_off = new BlockMatterConverter(Material.iron, false).setBlockName("iat.matter_converter").setHardness(5F).setResistance(15F).setCreativeTab(ItsAboutTime.iatTab).setStepSound(Block.soundTypeMetal);
		timeRift_nowhere = new BlockTimeRift(Material.portal, ModDimensions.Dim_nowhere).setBlockName("iat.timeRift").setHardness(2F).setResistance(1000F).setLightLevel(0.5F).setCreativeTab(ItsAboutTime.iatTab);
		timeRift_cretaceous = new BlockTimeRift(Material.portal, ModDimensions.Dim_cretaceous).setBlockName("iat.timeRift").setHardness(2F).setResistance(1000F).setLightLevel(0.5F).setCreativeTab(ItsAboutTime.iatTab);
		mud = new BlockMud(Material.ground, "spade", 1, 0.8F, 1F).setBlockName("iat.mud").setBlockTextureName("iat:mud").setStepSound(Block.soundTypeGravel).setCreativeTab(ItsAboutTime.iatTab);
		dried_Mud = new BlockBasic(Material.ground, "pickaxe", 1, 0.5F, 3.5F).setBlockName("iat.dried_Mud").setBlockTextureName("iat:dried_Mud").setCreativeTab(ItsAboutTime.iatTab);
		low_Fern_Block = new BlockLowFern().setBlockName("iat.low_Fern").setBlockTextureName("iat:low_Fern").setCreativeTab(ItsAboutTime.iatTab).setHardness(0.6F).setStepSound(Block.soundTypeGrass);
		horsetail = new BlockHorseTail(Material.plants).setBlockName("iat.horsetail").setBlockTextureName("iat:horsetail").setCreativeTab(ItsAboutTime.iatTab).setHardness(0.3F).setStepSound(Block.soundTypeGrass);
		for (int i = 0; i < EnumPrehistoricTrees.values().length; i++) {
			EnumPrehistoricTrees.values()[i].logBlock = new BlockPrehistoricWood("iat:log_" + EnumPrehistoricTrees.values()[i].name()).setBlockName("iat.log." + EnumPrehistoricTrees.values()[i].name()).setCreativeTab(ItsAboutTime.iatTab).setStepSound(Block.soundTypeWood);
			EnumPrehistoricTrees.values()[i].leavesBlock = new BlockPrehistoricLeaves("iat:leaves_" + EnumPrehistoricTrees.values()[i].name()).setBlockName("iat.leaves." + EnumPrehistoricTrees.values()[i].name()).setCreativeTab(ItsAboutTime.iatTab).setStepSound(Block.soundTypeGrass);
			EnumPrehistoricTrees.values()[i].saplingBlock = new BlockPrehistoricSapling(EnumPrehistoricTrees.values()[i].tree, "iat:sapling_" + EnumPrehistoricTrees.values()[i].name()).setBlockName("iat.sapling." + EnumPrehistoricTrees.values()[i].name()).setCreativeTab(ItsAboutTime.iatTab).setStepSound(Block.soundTypeGrass);
		}
		ginkoNut = new BlockGinkoNut().setHardness(0.3F).setBlockName("iat.ginkoNut");
		grid = new BlockGrid(Material.rock).setBlockUnbreakable().setBlockTextureName("iat:grid").setBlockName("iat.grid").setCreativeTab(ItsAboutTime.iatTab);
		fluidTime = new FluidTime("fluidTime").setBlock(fluidTimeBlock).setUnlocalizedName("fluidTime");
		FluidRegistry.registerFluid(fluidTime);
		materialFluidTime = new MaterialLiquid(MapColor.limeColor);
		fluidTimeBlock=new BlockTimeFluid(fluidTime, materialFluidTime).setBlockName("iat.fluid_Time");
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
		GameRegistry.registerBlock(amber_Silverfish, "amber_Silverfish");
		GameRegistry.registerBlock(amber_Spider, "amber_Spider");
		GameRegistry.registerBlock(amber_Compsognathus, "amber_Compsognathus");
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
		//GameRegistry.registerBlock(timeRift_nowhere, ItemNowhereBlock.class, "timeRift_nowhere");
		GameRegistry.registerBlock(timeRift_cretaceous, ItemCretaceousBlock.class, "timeRift_cretaceous");
		for (int i = 0; i < EnumPrehistoricTrees.values().length; i++) {
			GameRegistry.registerBlock(EnumPrehistoricTrees.values()[i].logBlock, "log_" + EnumPrehistoricTrees.values()[i].name());
			GameRegistry.registerBlock(EnumPrehistoricTrees.values()[i].leavesBlock, "leaves_" + EnumPrehistoricTrees.values()[i].name());
			GameRegistry.registerBlock(EnumPrehistoricTrees.values()[i].saplingBlock, "sapling_" + EnumPrehistoricTrees.values()[i].name());
		}
	//	GameRegistry.registerBlock(ginkoNut, "ginkoNut");
		GameRegistry.registerBlock(low_Fern_Block, "low_Fern_Block");
		GameRegistry.registerBlock(mud, "mud");
		GameRegistry.registerBlock(dried_Mud, "dried_Mud");

		GameRegistry.registerBlock(horsetail, "horsetail");
		GameRegistry.registerBlock(grid, "grid");
		GameRegistry.registerBlock(fluidTimeBlock, "fluidTimeBlock");

		GameRegistry.registerTileEntity(TileEntityTimeRift.class, "TileEntityTimeRift");
		GameRegistry.registerTileEntity(TileEntityMatterConverter.class, "TileEntityMatterConverter");
		GameRegistry.registerTileEntity(TileEntityCleaningTable.class, "TileEntityCleaningTable");

	}
}
