package itsabouttime.client.gui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
public class GuiBookButton extends GuiButton
{
private int IconIndexHeight;
private int IconIndexWidth;
public GuiBookButton(int id, int xPosition, int yPosition, int par4)
{
super(id, xPosition, yPosition, 32, 32, "iat:textures/gui/book/book1");
for (; par4 > 7;)
{
par4 -= 8;
IconIndexHeight++;
}
IconIndexWidth = par4;
}
public void drawButton(Minecraft par1Minecraft, int par2, int par3) {}
}