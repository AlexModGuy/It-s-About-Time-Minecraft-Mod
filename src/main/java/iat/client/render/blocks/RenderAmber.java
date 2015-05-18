package iat.client.render.blocks;


import iat.client.models.blocks.ModelBlock;
import iat.client.models.entities.ModelCompsognathus;
import iat.entities.tile.TileEntityAmber;

import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.model.ModelSilverfish;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;


public class RenderAmber extends TileEntitySpecialRenderer {
	public static final ResourceLocation texture = new ResourceLocation("iat:textures/blocks/models/amber.png");
	public static final ResourceLocation textureSilverfish = new ResourceLocation("textures/entity/silverfish.png");
	public static final ResourceLocation textureSpider = new ResourceLocation("textures/entity/spider/spider.png");
	public static final ResourceLocation textureCompsognathus = new ResourceLocation("iat:textures/models/compsognathus.png");

	public int scale;

	private ModelBlock model;
	private ModelSilverfish modelSilverfish;
	private ModelSpider modelSpider;
	private ModelCompsognathus modelCompsognathus;

	public RenderAmber(){
		this.model = new ModelBlock();
		modelSilverfish = new ModelSilverfish();
		modelSpider = new ModelSpider();
		modelCompsognathus = new ModelCompsognathus();
	}
	public void renderTileEntityAt(TileEntityAmber tileEntity, double x, double y, double z, float i)
	{
		int i1 = 0;
		if (tileEntity.hasWorldObj())
		{
			i1 = tileEntity.getBlockMetadata();
		}
		short short1 = 0;
		if (i1 == 2)
		{

			short1 = 360;
		}

		if (i1 == 3){
			short1 = 180;
		}

		if (i1 == 4)
		{
			short1 = 90;
		}

		if (i1 == 5)
		{
			short1 = -90;
		}
		
		GL11.glPushMatrix();
		GL11.glTranslatef(0f, 0f,0f);
		GL11.glTranslated((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		GL11.glRotatef((float)short1 * -1F, 0.0F, 1.0F, 0.0F);
		GL11.glPushMatrix();
		if(tileEntity.getAmberID() == 0){
			GL11.glPushMatrix();

			this.bindTexture(textureSilverfish);
			GL11.glScalef(0.9F, 0.9F, 0.9F);
			GL11.glTranslated(0, -0.3D, -0.23D);

			modelSilverfish.render((Entity)null, 0, 0, 0, 0, 0, 0.0625F);
			GL11.glPopMatrix();

		}
		if(tileEntity.getAmberID() == 1){
			GL11.glPushMatrix();

			this.bindTexture(textureSpider);
			GL11.glScalef(0.45F, 0.45F, 0.45F);
			GL11.glTranslated(0, 1.14D, 0);

			modelSpider.render((Entity)null, 0, 0, 0, 0, 0, 0.0625F);
			GL11.glPopMatrix();

		}
		if(tileEntity.getAmberID() == 2){
			GL11.glPushMatrix();

			this.bindTexture(textureCompsognathus);
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			GL11.glTranslated(0, 1.14D, 0);
			modelCompsognathus.renderAmber(0.0625F);
			GL11.glPopMatrix();

		}
		
		
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		this.bindTexture(texture);
		this.model.render(0.0625F);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

	}


	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float i)
	{
		this.renderTileEntityAt((TileEntityAmber)tileEntity, x, y, z, i);
	}
}
