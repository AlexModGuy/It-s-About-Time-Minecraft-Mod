package itsabouttime.client.render.block;

import itsabouttime.client.model.prehistoric.ModelCeolophysis;
import itsabouttime.client.model.prehistoric.ModelFishBowl;
import itsabouttime.client.model.prehistoric.ModelGuiyu;
import itsabouttime.client.renderer.entity.prehistoric.RenderGuiyu;
import itsabouttime.common.entities.prehistoric.EntityGuiyu;
import itsabouttime.common.tileentities.TileEntityFishBowl;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;


public class RenderFishBowl extends TileEntitySpecialRenderer {
	public static final ResourceLocation texture = new ResourceLocation("iat:textures/entity/FishBowl.png");
	public static final ResourceLocation Guiyi = new ResourceLocation("iat:textures/entity/Guiyu.png");




	private ModelGuiyu renderGuiyu = new ModelGuiyu();
	private ModelFishBowl model;
	
	public RenderFishBowl(){
		this.model = new ModelFishBowl();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f) {
		
		GL11.glPushMatrix();

		float rot = 0.0F;
		if (tileentity.getWorldObj() != null)
		{
		rot = tileentity.getWorldObj().getWorldTime() % 360L;
		}
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float) x + 0.5F, (float) y + 0.5F, (float) z + 0.5F);
		GL11.glRotatef(-180F, 0.2F, 0.0F, 0.0F);
		GL11.glTranslatef(0.0F, -0.75F, 0F);
		GL11.glScalef(0.50F, 0.50F, 0.50F);
		GL11.glRotatef(rot, 0.0F, 0.05F, 0.0F);
		this.bindTexture(Guiyi);

		renderGuiyu.render((Entity) null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

	
		GL11.glPushMatrix();
        GL11.glTranslatef(0f, 0f,0f);

		GL11.glTranslated((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);

		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(texture);
		
		GL11.glPushMatrix();
		this.model.renderModel(0.0625F);

		GL11.glPopMatrix();
		
		GL11.glPopMatrix();
		
		
		
	}

}
