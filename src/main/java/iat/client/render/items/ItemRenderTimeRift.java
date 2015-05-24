package iat.client.render.items;

import iat.client.render.blocks.RenderTimeRift;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

public class ItemRenderTimeRift implements IItemRenderer {
	TileEntitySpecialRenderer render;
	private TileEntity entity;
	public ItemRenderTimeRift(TileEntitySpecialRenderer render, TileEntity entity) {
		this.entity = entity;
		this.render = render;
	}
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		if(type == IItemRenderer.ItemRenderType.ENTITY){
			GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
		}
		float rot = (float) (720.0 * (System.currentTimeMillis() & 0x3FFFL) / 0x3FFFL);
		GL11.glPushMatrix();
		((RenderTimeRift) this.render).renderItemAt(this.entity, 0.0D, 0.0D, 0.0D, 0.0F, rot);
		GL11.glPopMatrix();

	}
}