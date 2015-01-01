package itsabouttime.client.render.block;

import itsabouttime.client.model.prehistoric.ModelCeolophysis;
import itsabouttime.client.model.prehistoric.ModelStromatolite;
import itsabouttime.client.model.prehistoric.ModelTreeFernLog;

import java.util.List;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;


public class RenderTimeRift extends TileEntitySpecialRenderer {

	public RenderTimeRift(){
	}
	
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y,
			double z, float f) {
        Tessellator tessellator = Tessellator.instance;
        Random random = new Random(432L);

		GL11.glPushMatrix();
        GL11.glTranslatef(0f, 0f,0f);

		GL11.glTranslated((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);

		GL11.glRotatef(180, 0F, 0F, 1F);
		
		GL11.glPushMatrix();
		
 		GL11.glPopMatrix();

     }

}
