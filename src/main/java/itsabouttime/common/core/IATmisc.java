package itsabouttime.common.core;


import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IATmisc {
	public static  int WILDCARD_VALUE = Short.MAX_VALUE;

	
	public static CreativeTabs PastTab = new CreativeTabs("PastTab"){
		Random rand = new Random();

		   public Item getTabIconItem()
	        {
	            return IATstuff.CreativeTabIcon1;
	        }
		   }
	;
	public static CreativeTabs PresentTab = new CreativeTabs("CurrentTab"){
		Random rand = new Random();

		   public Item getTabIconItem()
	        {
	            return IATstuff.CreativeTabIcon2;
	        }
		   }
	;
	public static CreativeTabs FutureTab = new CreativeTabs("FutureTab"){
		Random rand = new Random();

		   public Item getTabIconItem()
	        {
	            return Items.ender_eye;
	        }
		   }
	;
	public static void init()
	{
		register();
		gameRegister();
	}

	private static void register()
	{
		//Creative Tab Setter. This is The Only way I have found to set Creative Tabs simply.
		IATstuff.TimeMachine.setCreativeTab(PresentTab);
		IATstuff.FossilBook.setCreativeTab(PresentTab);
		IATstuff.TarDroplet.setCreativeTab(PresentTab);
		IATstuff.Fossils.setCreativeTab(PresentTab);
		IATstuff.TimeGem.setCreativeTab(PresentTab);
		IATstuff.ArmorPlates.setCreativeTab(PastTab);
		IATstuff.Insects.setCreativeTab(PresentTab);
		IATstuff.Eyes.setCreativeTab(PastTab);
		IATstuff.TrilobiteHelmet.setCreativeTab(PastTab);
		IATstuff.TrilobiteChest.setCreativeTab(PastTab);
		IATstuff.TrilobiteLegs.setCreativeTab(PastTab);
		IATstuff.TrilobiteBoots.setCreativeTab(PastTab);
		IATstuff.OpabinaHelmet.setCreativeTab(PastTab);
		IATstuff.OpabinaChest.setCreativeTab(PastTab);
		IATstuff.OpabinaLegs.setCreativeTab(PastTab);
		IATstuff.OpabinaBoots.setCreativeTab(PastTab);
		IATstuff.AnomalocarisHelmet.setCreativeTab(PastTab);
		IATstuff.AnomalocarisChest.setCreativeTab(PastTab);
		IATstuff.AnomalocarisLegs.setCreativeTab(PastTab);
		IATstuff.AnomalocarisBoots.setCreativeTab(PastTab);
		IATstuff.GoldenNecklace.setCreativeTab(PresentTab);
		IATstuff.TimeGoggles.setCreativeTab(PresentTab);
		IATstuff.TimeChest.setCreativeTab(PresentTab);
		IATstuff.TimeBoots.setCreativeTab(PresentTab);
		IATstuff.TarBucket.setCreativeTab(PresentTab);
		IATstuff.MyFood1.setCreativeTab(PastTab);
		IATstuff.record_Oddysey.setCreativeTab(FutureTab);
		IATstuff.record_Celldweller.setCreativeTab(FutureTab);

		IATstuff.OldKey.setCreativeTab(PastTab);
		IATstuff.OrganicMatter.setCreativeTab(PresentTab);
		IATstuff.TarDistilleryIdle.setCreativeTab(PresentTab);
		IATstuff.Shale.setCreativeTab(PresentTab);
		IATstuff.FossilSand.setCreativeTab(PresentTab);
		IATstuff.GemBlock.setCreativeTab(PresentTab);
		IATstuff.TimeRift.setCreativeTab(PresentTab);
		IATstuff.CambrianStone.setCreativeTab(PastTab);
		IATstuff.OrdovicianStone.setCreativeTab(PastTab);
		IATstuff.SilurianStone.setCreativeTab(PastTab);  
		IATstuff.CambrianCobble.setCreativeTab(PastTab); 
		IATstuff.OrdovicianCobble.setCreativeTab(PastTab);
		IATstuff.SilurianCobble.setCreativeTab(PastTab);
		IATstuff.LushPodzol.setCreativeTab(PastTab);
		IATstuff.PrehistoricPodzol.setCreativeTab(PastTab);

		IATstuff.OldPlants.setCreativeTab(PastTab);
		IATstuff.OldCoral.setCreativeTab(PastTab);
		IATstuff.NewCoral.setCreativeTab(PresentTab);
		IATstuff.OldSapling.setCreativeTab(PastTab);
		IATstuff.OldLog.setCreativeTab(PastTab);
		IATstuff.TreeFernLog.setCreativeTab(PastTab);
		IATstuff.OldLog2.setCreativeTab(PastTab);
		IATstuff.OldLeaves.setCreativeTab(PastTab);
		IATstuff.OldPlanks.setCreativeTab(PastTab);
		IATstuff.OldPlanksSlab.setCreativeTab(PastTab);

		IATstuff.CambrianBuilder.setCreativeTab(PresentTab);
		IATstuff.OrdovicianBuilder.setCreativeTab(PresentTab);
		IATstuff.SilurianBuilder.setCreativeTab(PresentTab);
		IATstuff.DenovianBuilder.setCreativeTab(PresentTab);
		IATstuff.GoldenIdol.setCreativeTab(PresentTab);
		IATstuff.Stromatolite.setCreativeTab(PresentTab);
		IATstuff.FishBowl.setCreativeTab(PresentTab);
		IATstuff.Emptyness.setCreativeTab(PresentTab);
		IATstuff.ColoredEmptyness.setCreativeTab(PresentTab);

		
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.OldKey),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.OldKey),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.OldKey),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.OldKey),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.OldKey),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.OldKey),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.OldKey),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.OldKey),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.OldKey),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.OldKey),1,2,35));
		
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.FossilBook),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.FossilBook),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.FossilBook),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.FossilBook),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.FossilBook),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.FossilBook),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.FossilBook),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.FossilBook),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.FossilBook),1,2,35));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.FossilBook),1,2,35));
		
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Insects,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Insects,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Insects,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Insects,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Insects,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Insects,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Insects,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Insects,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Insects,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Insects,1,WILDCARD_VALUE),1,3,33));
		
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Fossils,1,WILDCARD_VALUE),1,5,33));
		ChestGenHooks.getInfo(ChestGenHooks.MINESHAFT_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Fossils,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_DESERT_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Fossils,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Fossils,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_DISPENSER).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Fossils,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Fossils,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Fossils,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Fossils,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.VILLAGE_BLACKSMITH).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Fossils,1,WILDCARD_VALUE),1,3,33));
		ChestGenHooks.getInfo(ChestGenHooks.BONUS_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(IATstuff.Fossils,1,WILDCARD_VALUE),1,3,33));
	
	}
	private static void gameRegister() {
	}

	
}
