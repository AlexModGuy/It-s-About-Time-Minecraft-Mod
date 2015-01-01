package itsabouttime;

import itsabouttime.client.gui.GuiTimeMachineInventory;
import itsabouttime.client.model.ModelAnomalocarisArmor;
import itsabouttime.client.model.ModelJellyfish;
import itsabouttime.client.model.ModelTimeTravelerArmor;
import itsabouttime.client.model.ModelTrilobiteArmor1;
import itsabouttime.client.model.prehistoric.ModelAmmonite;
import itsabouttime.client.model.prehistoric.ModelBrontoscorpio;
import itsabouttime.client.model.prehistoric.ModelCompy;
import itsabouttime.client.model.prehistoric.ModelGiantOrthocone;
import itsabouttime.client.model.prehistoric.ModelHaikouichthys;
import itsabouttime.client.model.prehistoric.ModelTroodon;
import itsabouttime.client.model.prehistoric.ModelVelociraptor;
import itsabouttime.client.particle.EntityTarBubbleFX;
import itsabouttime.client.render.block.RenderFishBowl;
import itsabouttime.client.render.block.RenderGoldenIdol;
import itsabouttime.client.render.block.RenderStromatolite;
import itsabouttime.client.render.block.RenderTimeRift;
import itsabouttime.client.render.block.RenderTreeFernLog;
import itsabouttime.client.render.item.ItemRenderFishBowl;
import itsabouttime.client.render.item.ItemRenderGoldenIdol;
import itsabouttime.client.render.item.ItemRenderStromatolite;
import itsabouttime.client.render.item.ItemRenderTreeFernLog;
import itsabouttime.client.renderer.entity.RenderGoldIdol;
import itsabouttime.client.renderer.entity.RenderJellyfish;
import itsabouttime.client.renderer.entity.RenderTest;
import itsabouttime.client.renderer.entity.prehistoric.RenderAmmonite;
import itsabouttime.client.renderer.entity.prehistoric.RenderAnomalocaris;
import itsabouttime.client.renderer.entity.prehistoric.RenderArandaspidis;
import itsabouttime.client.renderer.entity.prehistoric.RenderBothriolepis;
import itsabouttime.client.renderer.entity.prehistoric.RenderBrontoscorpio;
import itsabouttime.client.renderer.entity.prehistoric.RenderCephalaspis;
import itsabouttime.client.renderer.entity.prehistoric.RenderCoclonema;
import itsabouttime.client.renderer.entity.prehistoric.RenderCoelacanth;
import itsabouttime.client.renderer.entity.prehistoric.RenderCoelophysis;
import itsabouttime.client.renderer.entity.prehistoric.RenderCompy;
import itsabouttime.client.renderer.entity.prehistoric.RenderDilophosaurus;
import itsabouttime.client.renderer.entity.prehistoric.RenderDiplodocus;
import itsabouttime.client.renderer.entity.prehistoric.RenderGuiyu;
import itsabouttime.client.renderer.entity.prehistoric.RenderHaikouichthys;
import itsabouttime.client.renderer.entity.prehistoric.RenderHallucigenia;
import itsabouttime.client.renderer.entity.prehistoric.RenderHorseShoeCrab;
import itsabouttime.client.renderer.entity.prehistoric.RenderMegalograptus;
import itsabouttime.client.renderer.entity.prehistoric.RenderMeganura;
import itsabouttime.client.renderer.entity.prehistoric.RenderOpabina;
import itsabouttime.client.renderer.entity.prehistoric.RenderOrthrocone;
import itsabouttime.client.renderer.entity.prehistoric.RenderPikaia;
import itsabouttime.client.renderer.entity.prehistoric.RenderPsittacosaurus;
import itsabouttime.client.renderer.entity.prehistoric.RenderTiktaalik;
import itsabouttime.client.renderer.entity.prehistoric.RenderTimeMachine;
import itsabouttime.client.renderer.entity.prehistoric.RenderTrilobite;
import itsabouttime.client.renderer.entity.prehistoric.RenderTroodon;
import itsabouttime.client.renderer.entity.prehistoric.RenderVelociraptor;
import itsabouttime.client.renderer.entity.prehistoric.RenderWaptia;
import itsabouttime.client.renderer.entity.prehistoric.RenderWixwaxia;
import itsabouttime.client.renderer.entity.prehistoric.renderConodont;
import itsabouttime.common.core.IATstuff;
import itsabouttime.common.core.IATentities;
import itsabouttime.common.entities.EntityGoldIdol;
import itsabouttime.common.entities.EntityJellyfish;
import itsabouttime.common.entities.EntityTest;
import itsabouttime.common.entities.EntityTimeMachine;
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
import itsabouttime.common.items.armor.TrilobiteArmor;
import itsabouttime.common.tileentities.TileEntityFishBowl;
import itsabouttime.common.tileentities.TileEntityGoldenIdol;
import itsabouttime.common.tileentities.TileEntityStromatolite;
import itsabouttime.common.tileentities.TileEntityTarDistillery;
import itsabouttime.common.tileentities.TileEntityTimeRift;
import itsabouttime.common.tileentities.TileEntityTreeFernLog;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.EntityBreakingFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.MinecraftForgeClient;
import akka.Main;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;

public class ProxyClient extends ProxyCommon{
	public static int sphereId;
	public static int SecondsphereId;

	private static final ModelTrilobiteArmor1 tutChest = new ModelTrilobiteArmor1(1.0f);
	private static final ModelTrilobiteArmor1 tutLegs = new ModelTrilobiteArmor1(0.5f);
	
	private static final ModelAnomalocarisArmor tutChest2 = new ModelAnomalocarisArmor(1.0f);
	private static final ModelAnomalocarisArmor tutLegs2 = new ModelAnomalocarisArmor(0.5f);
	private static final ModelTimeTravelerArmor tutChest3 = new ModelTimeTravelerArmor(0.01f);
	private static final ModelTimeTravelerArmor tutLegs3 = new ModelTimeTravelerArmor(0.5f);

public void registerRenderStuff(){
	this.addCapes();
	VillagerRegistry.instance().registerVillagerSkin(IATentities.VillagerID, new ResourceLocation("iat:textures/entity/Scientist.png"));
	RenderingRegistry.registerEntityRenderingHandler(EntityTimeMachine.class, new RenderTimeMachine());
	RenderingRegistry.registerEntityRenderingHandler(EntityJellyfish.class, new RenderJellyfish(new ModelJellyfish(), 0.3f));
	RenderingRegistry.registerEntityRenderingHandler(EntityTrilobite.class, new RenderTrilobite());
	RenderingRegistry.registerEntityRenderingHandler(EntityAnomalocaris.class, new RenderAnomalocaris());
	RenderingRegistry.registerEntityRenderingHandler(EntityOpabina.class, new RenderOpabina());
	RenderingRegistry.registerEntityRenderingHandler(EntityHaikouichthys.class, new RenderHaikouichthys());
	RenderingRegistry.registerEntityRenderingHandler(EntityWixwaxia.class, new RenderWixwaxia());
	RenderingRegistry.registerEntityRenderingHandler(EntityHallucigenia.class, new RenderHallucigenia());
	RenderingRegistry.registerEntityRenderingHandler(EntityOrthocone.class, new RenderOrthrocone( new ModelGiantOrthocone(), 0.3f));
	RenderingRegistry.registerEntityRenderingHandler(EntityArandaspidis.class, new RenderArandaspidis());
	RenderingRegistry.registerEntityRenderingHandler(EntityGoldIdol.class, new RenderGoldIdol());
	RenderingRegistry.registerEntityRenderingHandler(EntityConodont.class, new renderConodont());
	RenderingRegistry.registerEntityRenderingHandler(EntityAmmonite.class, new RenderAmmonite());
	RenderingRegistry.registerEntityRenderingHandler(EntityPikaia.class, new RenderPikaia());
	RenderingRegistry.registerEntityRenderingHandler(EntityWaptia.class, new RenderWaptia());
	RenderingRegistry.registerEntityRenderingHandler(EntityCyclonema.class, new RenderCoclonema());
	RenderingRegistry.registerEntityRenderingHandler(EntityMegalograptus.class, new RenderMegalograptus());
	RenderingRegistry.registerEntityRenderingHandler(EntityHorseShoeCrab.class, new RenderHorseShoeCrab());
	RenderingRegistry.registerEntityRenderingHandler(EntityCephalaspis.class, new RenderCephalaspis());
	RenderingRegistry.registerEntityRenderingHandler(EntityBothriolepis.class, new RenderBothriolepis());
	RenderingRegistry.registerEntityRenderingHandler(EntityGuiyu.class, new RenderGuiyu());
	RenderingRegistry.registerEntityRenderingHandler(EntityTiktaalik.class, new RenderTiktaalik());
	RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, new RenderVelociraptor(new ModelVelociraptor(), new ModelVelociraptor(), 0.3F));
	RenderingRegistry.registerEntityRenderingHandler(EntityBrontoscorpio.class, new RenderBrontoscorpio(new ModelBrontoscorpio(), new ModelBrontoscorpio(), 0.3F));
	RenderingRegistry.registerEntityRenderingHandler(EntityCompy.class, new RenderCompy());
	RenderingRegistry.registerEntityRenderingHandler(EntityTest.class, new RenderTest());
	RenderingRegistry.registerEntityRenderingHandler(EntityDilophosaurus.class, new RenderDilophosaurus());
	RenderingRegistry.registerEntityRenderingHandler(EntityMeganura.class, new RenderMeganura());
	RenderingRegistry.registerEntityRenderingHandler(EntityCoelophysis.class, new RenderCoelophysis());
	RenderingRegistry.registerEntityRenderingHandler(EntityTroodon.class, new RenderTroodon());
	RenderingRegistry.registerEntityRenderingHandler(EntityCoelacanth.class, new RenderCoelacanth());
	RenderingRegistry.registerEntityRenderingHandler(EntityPsittacosaurus.class, new RenderPsittacosaurus());
	RenderingRegistry.registerEntityRenderingHandler(EntityDiplodocus.class, new RenderDiplodocus());

	
//BLOCKS
	//GoldenIdol
	TileEntitySpecialRenderer render = new RenderGoldenIdol();
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGoldenIdol.class, render);
	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(IATstuff.GoldenIdol),new ItemRenderGoldenIdol(render, new TileEntityGoldenIdol()));
	GameRegistry.registerTileEntity(TileEntityGoldenIdol.class, "TileEntityGoldenIdol");
	//Stromatolite
	TileEntitySpecialRenderer render1 = new RenderStromatolite();
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityStromatolite.class, render1);
	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(IATstuff.Stromatolite),new ItemRenderStromatolite(render1, new TileEntityStromatolite()));
	GameRegistry.registerTileEntity(TileEntityStromatolite.class, "TileEntityStromatolite");
	//TreeFernLog
	TileEntitySpecialRenderer render2 = new RenderTreeFernLog();
	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTreeFernLog.class, render2);
	MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(IATstuff.TreeFernLog),new ItemRenderTreeFernLog(render2, new TileEntityTreeFernLog()));
	GameRegistry.registerTileEntity(TileEntityTreeFernLog.class, "TileEntityTreeFernLog");
	//TarDistillery
	GameRegistry.registerTileEntity(TileEntityTarDistillery.class, "TileEntityTarDistillery");
	//FishBowl
		TileEntitySpecialRenderer render3 = new RenderFishBowl();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFishBowl.class, render3);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(IATstuff.FishBowl),new ItemRenderFishBowl(render3, new TileEntityFishBowl()));
		GameRegistry.registerTileEntity(TileEntityFishBowl.class, "TileEntityFishBowl");
//TimeRift
		TileEntitySpecialRenderer render4 = new RenderTimeRift();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTimeRift.class, render4);
		//MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(IATStuff.FishBowl),new ItemRenderFishBowl(render4, new TileEntityFishBowl()));
		GameRegistry.registerTileEntity(TileEntityTimeRift.class, "TileEntityTimeRift");
		
	

}

@Override
public void openBook() {
	
}

@Override
public void drawCircle() {
	Sphere sphere = new Sphere();
	//GLU_POINT will render it as dots.
	//GLU_LINE will render as wireframe
	//GLU_SILHOUETTE will render as ?shadowed? wireframe
	//GLU_FILL as a solid.
	 sphere.setDrawStyle(GLU.GLU_FILL);
	//GLU_SMOOTH will try to smoothly apply lighting
	//GLU_FLAT will have a solid brightness per face, and will not shade.
	//GLU_NONE will be completely solid, and probably will have no depth to it's appearance.
	 sphere.setNormals(GLU.GLU_SMOOTH);
	//GLU_INSIDE will render as if you are inside the sphere, making it appear inside out.(Similar to how ender portals are rendered)
	 sphere.setOrientation(GLU.GLU_OUTSIDE);
	 sphereId = GL11.glGenLists(1);
	//Create a new list to hold our sphere data.
	 GL11.glNewList(sphereId, GL11.GL_COMPILE);
	//binds the texture 
	Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("iat:textures/entity/TimeSphere.png"));
	//The drawing the sphere is automattically doing is getting added to our list. Careful, the last 2 variables
	//control the detail, but have a massive impact on performance. 32x32 is a good balance on my machine.s
	sphere.draw(0.5F, 32, 32);
	GL11.glEndList();	
	
	//GLU_POINT will render it as dots.
		//GLU_LINE will render as wireframe
		//GLU_SILHOUETTE will render as ?shadowed? wireframe
		//GLU_FILL as a solid.
		 sphere.setDrawStyle(GLU.GLU_FILL);
		//GLU_SMOOTH will try to smoothly apply lighting
		//GLU_FLAT will have a solid brightness per face, and will not shade.
		//GLU_NONE will be completely solid, and probably will have no depth to it's appearance.
		 sphere.setNormals(GLU.GLU_SMOOTH);
		//GLU_INSIDE will render as if you are inside the sphere, making it appear inside out.(Similar to how ender portals are rendered)
		 sphere.setOrientation(GLU.GLU_INSIDE);
		 SecondsphereId = GL11.glGenLists(2);
		//Create a new list to hold our sphere data.
		 GL11.glNewList(SecondsphereId, GL11.GL_COMPILE);
		//binds the texture 
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("iat:textures/entity/TimeSphere.png"));
		//The drawing the sphere is automattically doing is getting added to our list. Careful, the last 2 variables
		//control the detail, but have a massive impact on performance. 32x32 is a good balance on my machine.s
		sphere.draw(0.49F, 32, 32);
		GL11.glEndList();	
}
@Override
public void spawnParticle(String string, double x, double y, double z)
{/*
	GLU.Sphere Sphere sphere = new Sphere();
	//GLU_POINT will render it as dots.
	//GLU_LINE will render as wireframe
	//GLU_SILHOUETTE will render as ?shadowed? wireframe
	//GLU_FILL as a solid.
	 sphere.setDrawStyle(GLU.GLU_FILL);
	//GLU_SMOOTH will try to smoothly apply lighting
	//GLU_FLAT will have a solid brightness per face, and will not shade.
	//GLU_NONE will be completely solid, and probably will have no depth to it's appearance.
	 sphere.setNormals(GLU.GLU_SMOOTH);
	//GLU_INSIDE will render as if you are inside the sphere, making it appear inside out.(Similar to how ender portals are rendered)
	 sphere.setOrientation(GLU.GLU_OUTSIDE);
	sphereId = GL11.glGenLists(1);
	//Create a new list to hold our sphere data.
	 GL11.glNewList(sphereId, GL11.GL_COMPILE);
	//binds the texture 
	Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("modid:textures/entity/sphere.png"));
	//The drawing the sphere is automattically doing is getting added to our list. Careful, the last 2 variables
	//control the detail, but have a massive impact on performance. 32x32 is a good balance on my machine.s
	sphere.draw(0.5F, 32, 32);
	GL11.glEndList();*/
}

@Override public ModelBiped getArmorModel(int id){ 
	switch (id) { 
	case 0:
	return tutChest; 
	case 1:
	return tutLegs;
	case 2:
		return tutChest2; 
		case 3:
		return tutLegs2;
		case 4:
			return tutChest3;
		case 5:
			return tutLegs3;
	default:
	break;
	}
	return tutChest; 
	
}

public static void addCapes() {
	String capeURL = "http://i1290.photobucket.com/albums/b533/Alexthe666/DBCape_zps702b7013.png";
	String[] owners = {"Alexthe666",  "ForgeDevName"};
	File Cape = new File("DBCape_zps702b7013.png");

	ThreadDownloadImageData image = new ThreadDownloadImageData(null, capeURL, null, null);
	
	for(String username : owners)
	{
		Minecraft.getMinecraft().renderEngine.loadTexture(new ResourceLocation("cloaks/"+ username), (ITextureObject)image);
		
	}
}
}