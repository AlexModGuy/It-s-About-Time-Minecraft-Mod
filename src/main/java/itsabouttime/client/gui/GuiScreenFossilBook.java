package itsabouttime.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Items;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringTranslate;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class GuiScreenFossilBook extends GuiScreen
{
private static final ResourceLocation texture = new ResourceLocation("iat:textures/gui/book/Book1.png");
private RenderItem itemRender;
int update = 0;

String line = null;
private int bookImageWidth = 192;
private int bookImageHeight = 192;
public  GuiScreenFossilBook.NextPageButton buttonNextPage;
public  GuiScreenFossilBook.NextPageButton buttonPreviousPage;
public int pages;
public int AmountOfPages = 5;
public GuiBookButton buttonIcon;
public void initGui()
{
buttonList.clear();
int i = (this.width - this.bookImageWidth) / 2;
byte b0 = 3;
this.buttonList.add(this.buttonNextPage = new GuiScreenFossilBook.NextPageButton(1, i + 38,  230, false));
this.buttonList.add(this.buttonPreviousPage = new GuiScreenFossilBook.NextPageButton(2, i + 120,230, true));
addButtonByPage(pages);
}
public void addTextByPage(int page)
{
	int k = (this.width - this.bookImageWidth) / 2;
	byte b0 = 2;
	int var5 = (this.width - this.bookImageWidth) / 2;
	int var6 = ((this.height - this.bookImageHeight) / 2) - 10;
	this.drawTexturedModalRect(var5, var6, 0, 0, this.bookImageWidth, this.bookImageHeight);
	int var1 = (this.width - this.bookImageWidth) / 2;
	int var2 = (this.height - this.bookImageHeight) / 2;
	int var3 = 0;
if (page == 0)
{
	this.mc.getTextureManager().bindTexture(new ResourceLocation("iat:textures/gui/book/book1_page1.png"));
	drawTexture(var5, var6, 256, 256);

}
if (page == 1){
	  //fontRendererObj.drawString("12345678912345678912",256, 100, 0X007599, false);
		fontRendererObj.drawString("Welcome! If you are ", 256, 108, 0, false);
		fontRendererObj.drawString("reading this it is  ", 256, 116, 0, false);
		fontRendererObj.drawString("probably because you", 256, 124, 0, false);
		fontRendererObj.drawString("want to learn how to", 256, 132, 0, false);
		
		fontRendererObj.drawString("be a paleontologist.", 256, 140, 0, false);
		fontRendererObj.drawString("Paleontology is the ", 256, 148, 0, false);
		fontRendererObj.drawString("study of prehistoric", 256, 156, 0, false);
		fontRendererObj.drawString("life. To do this,   ", 256, 164, 0, false);
		fontRendererObj.drawString("most paleontologists", 256, 172, 0, false);
		fontRendererObj.drawString("collect fossils. You", 256, 180, 0, false);
		fontRendererObj.drawString("can find fossils in ", 256, 188, 0, false);
		fontRendererObj.drawString("soild rock, in the  ", 256, 196, 0, false);
		fontRendererObj.drawString("form of shale. Shale", 256, 204, 0, false);
		fontRendererObj.drawString("is described on the ", 256, 212, 0, false);
		fontRendererObj.drawString("next page.          ", 256, 220, 0, false);
	

}
if (page == 2){
  //fontRendererObj.drawString("12345678912345678912",256, 100, 0X007599, false);
	fontRendererObj.drawString("Tool:", 256, 148, 0XFF0000, false);
	fontRendererObj.drawString("Strength:", 256, 156, 0XFFD800, false);
	fontRendererObj.drawString("Drops:", 256, 172, 0X3DCE00, false);
	fontRendererObj.drawString("Spawns:", 256, 180, 0X002AFF, false);
	fontRendererObj.drawString("Bio:", 256, 196, 0XFF6A00, false);
	
	
	fontRendererObj.drawString("      Iron Pickaxe ", 256, 148, 0, false);
	fontRendererObj.drawString("            Equal to ", 256, 156, 0, false);
	fontRendererObj.drawString("Iron Ore         ", 256, 164, 0, false);
	fontRendererObj.drawString("        Fossils     ", 256, 172, 0, false);
	fontRendererObj.drawString("          Overworld, ", 256, 180, 0, false);
	fontRendererObj.drawString("underground       ", 256, 188, 0, false);
	fontRendererObj.drawString("                    ", 256, 196, 0, false);
	fontRendererObj.drawString("Shale Generates     ", 256, 204, 0, false);
	fontRendererObj.drawString("Deep in the earth. It", 256, 212, 0, false);
	fontRendererObj.drawString("is used for fossils.", 256, 220, 0, false);



		this.mc.getTextureManager().bindTexture(icons);
		drawTexture(var5 + 63, var6+8, 60, 60);

}
if (page == 2){
	  //fontRendererObj.drawString("12345678912345678912",256, 100, 0X007599, false);
		fontRendererObj.drawString("Tool:", 256, 148, 0XFF0000, false);
		fontRendererObj.drawString("Strength:", 256, 156, 0XFFD800, false);
		fontRendererObj.drawString("Drops:", 256, 172, 0X3DCE00, false);
		fontRendererObj.drawString("Spawns:", 256, 180, 0X002AFF, false);
		fontRendererObj.drawString("Bio:", 256, 196, 0XFF6A00, false);
		
		
		fontRendererObj.drawString("      Iron Pickaxe ", 256, 148, 0, false);
		fontRendererObj.drawString("            Equal to ", 256, 156, 0, false);
		fontRendererObj.drawString("Iron Ore         ", 256, 164, 0, false);
		fontRendererObj.drawString("        Fossils     ", 256, 172, 0, false);
		fontRendererObj.drawString("          Overworld, ", 256, 180, 0, false);
		fontRendererObj.drawString("underground       ", 256, 188, 0, false);
		fontRendererObj.drawString("                    ", 256, 196, 0, false);
		fontRendererObj.drawString("Shale Generates     ", 256, 204, 0, false);
		fontRendererObj.drawString("Deep in the earth. It", 256, 212, 0, false);
		fontRendererObj.drawString("is used for fossils.", 256, 220, 0, false);



			this.mc.getTextureManager().bindTexture(new ResourceLocation("iat:textures/gui/book/Shale.png"));
			drawTexture(var5 + 63, var6+8, 60, 60);

	}
}
/**
 * Draws a texture at the given location, with the specified size
 * @param x Location X
 * @param y Location Y
 * @param w Draw Width
 * @param h Draw Height
 */
public void drawTexture(int x, int y, int w, int h)
{
    GL11.glColor4f(1F, 1F, 1F, 1F);
    Tessellator tessellator = Tessellator.instance;
    tessellator.startDrawingQuads();
    tessellator.addVertexWithUV(x + 0, y + h, this.zLevel, 0D, 1D);
    tessellator.addVertexWithUV(x + w, y + h, this.zLevel, 1D, 1D);
    tessellator.addVertexWithUV(x + w, y + 0, this.zLevel, 1D, 0D);
    tessellator.addVertexWithUV(x + 0, y + 0, this.zLevel, 0D, 0D);
    tessellator.draw();
}

public void addButtonByPage(int page)
{
int var1 = (this.width - this.bookImageWidth) / 2;
int var2 = (this.height - this.bookImageHeight) / 2;

if (page == 0)
{

}
}

@Override
public void actionPerformed(GuiButton button)
{
if (button.id == 2 && pages < AmountOfPages)
{
pages += 1;
}

else {}
if (button.id == 1 && pages > 0)
{
pages -= 1;
}
else {}
this.initGui();
this.updateScreen();
}
public void drawScreen(int par1, int par2, float par3)
{
GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
this.mc.renderEngine.bindTexture(texture);

int k = (this.width - this.bookImageWidth) / 2;
byte b0 = 2;
int var5 = (this.width - this.bookImageWidth) / 2;
int var6 = ((this.height - this.bookImageHeight) / 2) - 10;
this.drawTexturedModalRect(var5, var6, 0, 0, this.bookImageWidth, this.bookImageHeight);
int var1 = (this.width - this.bookImageWidth) / 2;
int var2 = (this.height - this.bookImageHeight) / 2;
int var3 = 0;

addTextByPage(pages);
fontRendererObj.drawString(Integer.toString(pages + 1), var1 + 89 - var3, var2 + 145, 0x2b2b2b, false);
super.drawScreen(par1, par2, par3);
}

public boolean doesGuiPauseGame()
{
return false;
}
@SideOnly(Side.CLIENT)
static class NextPageButton extends GuiButton
    {
        private final boolean field_146151_o;
        private static final String __OBFID = "CL_00000745";

        public NextPageButton(int p_i1079_1_, int p_i1079_2_, int p_i1079_3_, boolean p_i1079_4_)
        {
            super(p_i1079_1_, p_i1079_2_, p_i1079_3_, 23, 13, "");
            this.field_146151_o = p_i1079_4_;
        }

        /**
         * Draws this button to the screen.
         */
        public void drawButton(Minecraft p_146112_1_, int p_146112_2_, int p_146112_3_)
        {
            if (this.visible)
            {
                boolean flag = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                p_146112_1_.getTextureManager().bindTexture(texture);
                int k = 0;
                int l = 192;

                if (flag)
                {
                    k += 23;
                }

                if (!this.field_146151_o)
                {
                    l += 13;
                }

                this.drawTexturedModalRect(this.xPosition, this.yPosition, k, l, 23, 13);
            }
        }
    }
/**
* Called when the screen is unloaded. Used to disable keyboard repeat events
*/
public void onGuiClosed()
{
super.onGuiClosed();
}
}