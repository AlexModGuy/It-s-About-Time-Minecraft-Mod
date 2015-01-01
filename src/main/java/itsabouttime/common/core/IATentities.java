package itsabouttime.common.core;

import itsabouttime.iat;
import itsabouttime.common.entities.EntityFlightTest;
import itsabouttime.common.entities.EntityGoldIdol;
import itsabouttime.common.entities.EntityJellyfish;
import itsabouttime.common.entities.EntityRisingBlock;
import itsabouttime.common.entities.EntityTest;
import itsabouttime.common.entities.EntityTimeMachine;
import itsabouttime.common.entities.VillagerScientistTradeHandler;
import itsabouttime.common.entities.prehistoric.EntityAmmonite;
import itsabouttime.common.entities.prehistoric.EntityAnomalocaris;
import itsabouttime.common.entities.prehistoric.EntityArandaspidis;
import itsabouttime.common.entities.prehistoric.EntityBothriolepis;
import itsabouttime.common.entities.prehistoric.EntityBrontoscorpio;
import itsabouttime.common.entities.prehistoric.EntityCephalaspis;
import itsabouttime.common.entities.prehistoric.EntityCoelacanth;
import itsabouttime.common.entities.prehistoric.EntityCoelophysis;
import itsabouttime.common.entities.prehistoric.EntityCompy;
import itsabouttime.common.entities.prehistoric.EntityConodont;
import itsabouttime.common.entities.prehistoric.EntityCyclonema;
import itsabouttime.common.entities.prehistoric.EntityDilophosaurus;
import itsabouttime.common.entities.prehistoric.EntityDiplodocus;
import itsabouttime.common.entities.prehistoric.EntityGuiyu;
import itsabouttime.common.entities.prehistoric.EntityHaikouichthys;
import itsabouttime.common.entities.prehistoric.EntityHallucigenia;
import itsabouttime.common.entities.prehistoric.EntityHorseShoeCrab;
import itsabouttime.common.entities.prehistoric.EntityMegalograptus;
import itsabouttime.common.entities.prehistoric.EntityMeganura;
import itsabouttime.common.entities.prehistoric.EntityOpabina;
import itsabouttime.common.entities.prehistoric.EntityOrthocone;
import itsabouttime.common.entities.prehistoric.EntityPikaia;
import itsabouttime.common.entities.prehistoric.EntityPsittacosaurus;
import itsabouttime.common.entities.prehistoric.EntityTiktaalik;
import itsabouttime.common.entities.prehistoric.EntityTrilobite;
import itsabouttime.common.entities.prehistoric.EntityTroodon;
import itsabouttime.common.entities.prehistoric.EntityVelociraptor;
import itsabouttime.common.entities.prehistoric.EntityWaptia;
import itsabouttime.common.entities.prehistoric.EntityWixwaxia;
import itsabouttime.common.handler.EntityHandler;
import itsabouttime.common.worldgen.village.ComponentScientistHouse;
import itsabouttime.common.worldgen.village.VillageScientistHouseHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import cpw.mods.fml.common.registry.VillagerRegistry;

public class IATentities {

	public static final int VillagerID = 44;
	
	public static void init()
	{
		register();
		gameRegister();
	}
	private static void register()
	{
		//Villagers in a nutshell
		VillagerRegistry.instance().registerVillageCreationHandler(new VillageScientistHouseHandler());
		MapGenStructureIO.func_143031_a(ComponentScientistHouse.class, "itsabouttimeScientistHouseHandler");

		VillagerRegistry.instance().registerVillagerId(VillagerID);
		 VillagerScientistTradeHandler newTradeHandler = new VillagerScientistTradeHandler();
		 VillagerRegistry.instance().registerVillageTradeHandler(VillagerID, newTradeHandler);
		 VillagerRegistry.instance().getRegisteredVillagers(); 

	}
	private static void gameRegister() {
		//EXAMPLE:	EntityHandler.registerSpawnable(EntityDragon.class, "EnderDragon", 0X000000, 0XB5009C);
		EntityHandler.registerUnspawnable(EntityTimeMachine.class, "TimeMachine");
		EntityHandler.registerSpawnable(EntityJellyfish.class, "IATJellyfish", 0XFEC4C4, 0XFFB27F);
		EntityHandler.registerSpawnable(EntityTrilobite.class, "IATTrilobite", 0X80513C, 0X8A4C31);
		EntityHandler.registerSpawnable(EntityAnomalocaris.class, "IATAnomalocaris", 0X225585,0XAA9287 );
		EntityHandler.registerSpawnable(EntityOpabina.class, "IATOpabina", 0X7A7B9B, 0X7A7B9B);
		EntityHandler.registerSpawnable(EntityHaikouichthys.class, "IATHaikouichthys", 0X47EF00, 0XB6FF00);
		EntityHandler.registerSpawnable(EntityPikaia.class, "IATPikaia", 0X05135B, 0X001384);
		EntityHandler.registerSpawnable(EntityWixwaxia.class, "IATWixwaxia",  0X726F59, 0XC549FF);
		EntityHandler.registerSpawnable(EntityHallucigenia.class, "IATHallucigenia", 0XE6F878, 0XEDFFDE);
		EntityHandler.registerSpawnable(EntityWaptia.class, "IATWaptia", 0XBBB2F4, 0XF59EE0);
		
		EntityHandler.registerSpawnable(EntityOrthocone.class, "IATOrthrocone", 0X854848, 0XC8A9A9);
		EntityHandler.registerSpawnable(EntityArandaspidis.class, "IATArandaspidis", 0X9C8D76, 0X9B7B4C);
		EntityHandler.registerSpawnable(EntityConodont.class, "IATConodont",  0XFFD709,0XFFB582);
		EntityHandler.registerSpawnable(EntityAmmonite.class, "IATAmmonite", 0X7F582F, 0X8B0000);
		EntityHandler.registerSpawnable(EntityCyclonema.class, "IATCyclonema", 0XA29EA7, 0X8A62C6);
		EntityHandler.registerSpawnable(EntityMegalograptus.class, "IATMegalograptus", 0XA3692C, 0XA3692C);
		EntityHandler.registerSpawnable(EntityHorseShoeCrab.class, "IATHorseShoeCrab", 0X462712, 0X925329);
		
		EntityHandler.registerSpawnable(EntityCephalaspis.class, "IATCephalaspis", 0XADCE43, 0XC1CF44);
		EntityHandler.registerSpawnable(EntityGuiyu.class, "IATGuiyu", 0X1A1717, 0X70251D);
		EntityHandler.registerSpawnable(EntityBrontoscorpio.class, "IATBrontoscorpio", 0X93734E, 0XC69D7B);
		EntityHandler.registerSpawnable(EntityCoelacanth.class, "IATCoelacanth", 0X354A54, 0XCDC8A8);

		
		EntityHandler.registerSpawnable(EntityBothriolepis.class, "IATBothriolepis", 0X0C0C0C, 0X000000);
		EntityHandler.registerSpawnable(EntityTiktaalik.class, "IATTiktaalik", 0X309B20, 0X5BA160);
		
		EntityHandler.registerSpawnable(EntityMeganura.class, "IATMeganura", 0XABE400, 0XC0F5FE);
		
		EntityHandler.registerSpawnable(EntityCoelophysis.class, "IATCoelophysis", 0X233117, 0X7D000A);
		
		EntityHandler.registerSpawnable(EntityDilophosaurus.class, "IATDilophosaurus", 0XE7C642, 0X10637B);
		EntityHandler.registerSpawnable(EntityDiplodocus.class, "IATDiplodocus", 0X869699, 0X10637B);
		EntityHandler.registerSpawnable(EntityCompy.class, "IATCompsognathus", 0X6D7021, 0XB79D49);
		
		EntityHandler.registerSpawnable(EntityPsittacosaurus.class, "IATPsittacosaurus", 0X804A2B, 0X3E3B37);
		EntityHandler.registerSpawnable(EntityVelociraptor.class, "IATVelociraptor", 0XC0A47E, 0XEACB75);
		EntityHandler.registerSpawnable(EntityTroodon.class, "IATTroodon", 0X2F577E, 0XFFD800);

		
		EntityHandler.registerUnspawnable(EntityGoldIdol.class, "IATGoldIdol");
		
		EntityHandler.registerUnspawnable(EntityRisingBlock.class, "RisingBlock");

		//3More
	}}
