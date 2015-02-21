package iat;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import iat.client.render.blocks.*;
import iat.client.render.entities.*;
import iat.client.render.items.*;
import iat.core.ModBlocks;
import iat.entities.mob.*;
import iat.entities.tile.*;
import cpw.mods.fml.client.registry.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

public class ProxyClient extends ProxyCommon {
	
	public static int sphereId;
	public static int secondSphereId;
	public static int cylinderId;
	public static int secondcylinderId;
	@Override
	public void registerRenderStuff(){

		RenderingRegistry.registerEntityRenderingHandler(EntityTrilobite.class, new RenderTrilobite());
		RenderingRegistry.registerEntityRenderingHandler(EntityCompsognathus.class, new RenderCompsognathus());

		TileEntitySpecialRenderer render = new RenderTimeRift();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTimeRift.class, render);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.timeRift_nowhere),new ItemRenderTimeRift(render, new TileEntityTimeRift()));
		
		TileEntitySpecialRenderer render1 = new RenderCleaningTable();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCleaningTable.class, render1);
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cleaning_Table_Off),new ItemRenderCleaningTable(render1, new TileEntityCleaningTable()));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.cleaning_Table_On),new ItemRenderCleaningTable(render1, new TileEntityCleaningTable()));
	}

	public ModelBiped getArmorModel(int id){

		return null; 
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


