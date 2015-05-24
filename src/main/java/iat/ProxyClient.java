package iat;

import iat.client.models.armor.ModelPheromoneArmor;
import iat.client.render.blocks.RenderAmber;
import iat.client.render.blocks.RenderCleaningTable;
import iat.client.render.blocks.RenderTimeRift;
import iat.client.render.entities.RenderCarnotaurus;
import iat.client.render.entities.RenderCompsognathus;
import iat.client.render.entities.RenderSpinosaurus;
import iat.client.render.entities.RenderTrilobite;
import iat.client.render.entities.RenderVelociraptor;
import iat.client.render.entities.RenderCeolophysis;
import iat.client.render.items.ItemRenderCleaningTable;
import iat.client.render.items.ItemRenderTimeRift;
import iat.client.render.items.ItemRendererFossil;
import iat.core.ModBlocks;
import iat.entities.mob.EntityCarnotaurus;
import iat.entities.mob.EntityCoelophysis;
import iat.entities.mob.EntityCompsognathus;
import iat.entities.mob.EntitySpinosaurus;
import iat.entities.mob.EntityTrilobite;
import iat.entities.mob.EntityVelociraptor;
import iat.entities.tile.TileEntityAmber;
import iat.entities.tile.TileEntityCleaningTable;
import iat.entities.tile.TileEntityTimeRift;
import iat.enums.EnumFossilSkeleton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ProxyClient extends ProxyCommon {

	public static int sphereId;
	public static int secondSphereId;
	public static int cylinderId;
	public static int secondcylinderId;
	private static final ModelPheromoneArmor pheromoneChest = new ModelPheromoneArmor(1.0f);
	private static final ModelPheromoneArmor pheromoneLegs = new ModelPheromoneArmor(1.0f);

	@Override
	public void registerRenderStuff(){
//		

		RenderingRegistry.registerEntityRenderingHandler(EntityTrilobite.class, new RenderTrilobite());
		RenderingRegistry.registerEntityRenderingHandler(EntityCompsognathus.class, new RenderCompsognathus());
		RenderingRegistry.registerEntityRenderingHandler(EntityCarnotaurus.class, new RenderCarnotaurus());
		RenderingRegistry.registerEntityRenderingHandler(EntityVelociraptor.class, new RenderVelociraptor());
		RenderingRegistry.registerEntityRenderingHandler(EntityCoelophysis.class, new RenderCeolophysis());
		RenderingRegistry.registerEntityRenderingHandler(EntitySpinosaurus.class, new RenderSpinosaurus());

		for (int i = 0; i < EnumFossilSkeleton.values().length; i++) {
			MinecraftForgeClient.registerItemRenderer(EnumFossilSkeleton.values()[i].fossilItem, (IItemRenderer)new ItemRendererFossil(EnumFossilSkeleton.values()[i].model, EnumFossilSkeleton.values()[i].name, false));
			MinecraftForgeClient.registerItemRenderer(EnumFossilSkeleton.values()[i].fossilBrokenItem, (IItemRenderer)new ItemRendererFossil(EnumFossilSkeleton.values()[i].model, EnumFossilSkeleton.values()[i].name, true));
		}
		TileEntitySpecialRenderer render = new RenderTimeRift();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTimeRift.class, render);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.timeRift_nowhere),new ItemRenderTimeRift(render, new TileEntityTimeRift()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.timeRift_cretaceous),new ItemRenderTimeRift(render, new TileEntityTimeRift()));

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAmber.class, new RenderAmber());

		TileEntitySpecialRenderer render1 = new RenderCleaningTable();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCleaningTable.class, render1);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cleaning_Table_Off),new ItemRenderCleaningTable(render1, new TileEntityCleaningTable()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cleaning_Table_On),new ItemRenderCleaningTable(render1, new TileEntityCleaningTable()));
	}

	public ModelBiped getArmorModel(int id){

		switch (id) { 
		case 0:
			return pheromoneChest; 
		case 1:
			return pheromoneLegs;
		default:
			break;
		}
		return pheromoneChest;
	} 

	public  void drawCircle(ResourceLocation texture) {
		Sphere sphere = new Sphere();
		sphere.setDrawStyle(GLU.GLU_FILL);
		sphere.setNormals(GLU.GLU_SMOOTH);
		sphere.setOrientation(GLU.GLU_OUTSIDE);
		sphereId = GL11.glGenLists(1);
		GL11.glNewList(sphereId, GL11.GL_COMPILE);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		sphere.draw(0.5F, 32, 32);
		GL11.glEndList();
		sphere.setDrawStyle(GLU.GLU_FILL);		
		sphere.setNormals(GLU.GLU_SMOOTH);
		sphere.setOrientation(GLU.GLU_INSIDE);
		secondSphereId = GL11.glGenLists(2);
		GL11.glNewList(secondSphereId, GL11.GL_COMPILE);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		sphere.draw(0.49F, 32, 32);
		GL11.glEndList();	
	}

	public void drawCylinder(ResourceLocation texture) {
		Cylinder cylinder = new Cylinder();
		cylinder.setDrawStyle(GLU.GLU_FILL);
		cylinder.setNormals(GLU.GLU_SMOOTH);
		cylinder.setOrientation(GLU.GLU_OUTSIDE);
		cylinderId = GL11.glGenLists(1);
		GL11.glNewList(cylinderId, GL11.GL_COMPILE);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		cylinder.draw(0.5F, 0.5F, 10, 10, 2);
		GL11.glEndList();
		cylinder.setDrawStyle(GLU.GLU_FILL);		
		cylinder.setNormals(GLU.GLU_SMOOTH);
		cylinder.setOrientation(GLU.GLU_INSIDE);
		secondcylinderId = GL11.glGenLists(2);
		GL11.glNewList(secondcylinderId, GL11.GL_COMPILE);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		cylinder.draw(0.49F, 0.49F, 10, 10, 2);
		GL11.glEndList();	
	}

}


