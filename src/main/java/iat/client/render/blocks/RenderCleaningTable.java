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
	public static final ResourceLocation texture = new ResourceLocation("iat:textures/models/cleaner_Table.png");
	private ModelCleaningTable model;
	EntityItem pickaxeEntity = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, new ItemStack(Items.iron_pickaxe, 1, 0));
	EntityItem inputEntity;

	public RenderCleaningTable(){
		this.model = new ModelCleaningTable();
	}

	public void renderTileEntityCleaningTableAt(TileEntityCleaningTable tileentity, double x, double y, double z, float f) {
		int i = 0;
		if (tileentity.hasWorldObj())
		{
			i = tileentity.getBlockMetadata();
		}
		short short1 = 0;
		if (i == 2)
		{

			short1 = 180;
		}
		if (i == 3){
			short1 = 0;
		}
		if (i == 4)
		{
			short1 = 90;
		}
		if (i == 5)
		{
			short1 = -90;
		}
		GL11.glPushMatrix();
		GL11.glTranslatef(0f, 0f,0f);
		GL11.glTranslated((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
		this.bindTexture(texture);
		if(tileentity.isBurning()){
			this.model.render(0.0625F, true);
		}
		else{
			this.model.render(0.0625F, false);
		}
		
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		pickaxeEntity.hoverStart = 0.0F;
		RenderItem.renderInFrame = true;
		GL11.glTranslatef((float)x + 0.8F, (float)y + 0.719F, (float)z + 0.65F);
		GL11.glRotatef(180, 0F, 1F, 1F);
		GL11.glScalef(0.8F, 0.8F, 0.8F);
		RenderManager.instance.renderEntityWithPosYaw(pickaxeEntity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
		RenderItem.renderInFrame = false;
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		GL11.glPushMatrix();
			if(tileentity.getStackInSlot(0) != null){
				if(tileentity.getStackInSlot(0).getItem() != null){
					inputEntity = new EntityItem(Minecraft.getMinecraft().theWorld, 0D, 0D, 0D, new ItemStack(((TileEntityCleaningTable) tileentity).getStackInSlot(0).getItem(), 1 , ((TileEntityCleaningTable) tileentity).getStackInSlot(0).getItemDamage()));
					GL11.glPushMatrix();
					inputEntity.hoverStart = 0.0F;
					RenderItem.renderInFrame = true;
					GL11.glTranslatef((float)x + 0.5F, (float)y + 0.619F, (float)z + 0.37F);
					GL11.glRotatef(180, 0F, 1F, 1F);
					GL11.glScalef(0.8F, 0.8F, 0.8F);
					RenderManager.instance.renderEntityWithPosYaw(inputEntity, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F);
					RenderItem.renderInFrame = false;
					GL11.glPopMatrix();

				}
			}
		}
	


	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		renderTileEntityCleaningTableAt((TileEntityCleaningTable)tileentity, x, y, z, f);
	}
}
