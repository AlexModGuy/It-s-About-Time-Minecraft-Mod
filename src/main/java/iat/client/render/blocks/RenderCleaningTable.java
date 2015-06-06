package iat.client.render.blocks;

import iat.client.models.blocks.ModelCleaningTable;
import iat.entities.tile.TileEntityCleaningTable;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;


public class RenderCleaningTable extends TileEntitySpecialRenderer {
	public static final ResourceLocation texture = new ResourceLocation("iat:textures/models/texture.png");

	private ModelCleaningTable model;

	public RenderCleaningTable(){
		this.model = new ModelCleaningTable();
	}

	public void renderTileEntityCleaningTableAt(TileEntityCleaningTable tileentity, double x, double y, double z, float f) {
		int i = 0;
		
		GL11.glPushMatrix();
		GL11.glTranslatef(0f, 0f,0f);
		GL11.glTranslated((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		GL11.glPushMatrix();
		this.bindTexture(texture);
		this.model.render(null, 0, 0, 0, 0, 0, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

		
	}



	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		renderTileEntityCleaningTableAt((TileEntityCleaningTable)tileentity, x, y, z, f);
	}
}
