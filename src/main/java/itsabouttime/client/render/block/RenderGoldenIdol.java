package itsabouttime.client.render.block;

import itsabouttime.client.model.prehistoric.ModelCeolophysis;
import itsabouttime.client.model.prehistoric.ModelWaptia;

import java.util.List;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;


public class RenderGoldenIdol extends TileEntitySpecialRenderer {
	public static final ResourceLocation texture = new ResourceLocation("iat:textures/entity/Ceolophysis/GoldCeolophysis.png");
	



	
	
	private ModelWaptia model;
	
	public RenderGoldenIdol(){
		this.model = new ModelWaptia();
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f) {
		GL11.glPushMatrix();
        GL11.glTranslatef(0f, -0.89f,0f);

		GL11.glTranslated((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
        GL11.glScalef(0.4f, 0.4f, 0.4f);

		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(texture);
		model.renderModel(0.625F);
		GL11.glPushMatrix();

		GL11.glPopMatrix();
		
		GL11.glPopMatrix();
		
	}

}
