package iat.client.gui;

import iat.entities.tile.TileEntityCleaningTable;
import iat.inventory.ContainerCleaningTable;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCleaningTable extends GuiContainer
{
	private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("iat:textures/gui/fossil_Cleaner.png");
	private TileEntityCleaningTable tileFurnace;

	public GuiCleaningTable(InventoryPlayer playerInv, TileEntityCleaningTable tileEntity)
	{
		super(new ContainerCleaningTable(playerInv, tileEntity));
		this.tileFurnace = tileEntity;
	}

	/**
	 * Draw the foreground layer for the GuiContainer (everything in front of the items)
	 */
	protected void drawGuiContainerForegroundLayer(int x, int y)
	{
		String s = this.tileFurnace.hasCustomInventoryName() ? this.tileFurnace.getInventoryName() : I18n.format(this.tileFurnace.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float x, int y, int z)
	{
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		if (this.tileFurnace.isBurning())
		{
			int i1 = this.tileFurnace.getBurnTimeRemainingScaled(13);
			this.drawTexturedModalRect(k + 57, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
		}
	}
}