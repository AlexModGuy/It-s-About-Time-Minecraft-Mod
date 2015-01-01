package itsabouttime.client.gui;

import itsabouttime.common.core.IATstuff;
import itsabouttime.common.entities.EntityTimeMachine;
import itsabouttime.common.inventory.InventoryTimeMachine;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GuiTimeMachineInventory extends GuiContainer
{
    private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("iat:textures/gui/TimeMachine.png");
    private EntityTimeMachine timemachine;
    private InventoryTimeMachine inv;
    private GuiButton travelBtn;

    public GuiTimeMachineInventory(InventoryPlayer p_i1091_1_, EntityTimeMachine p_i1091_2_,InventoryTimeMachine inventory)
    {
        super(new ContainerTimeMachineInventory(p_i1091_1_, p_i1091_2_, inventory));
        this.timemachine = p_i1091_2_;
        this.inv = inventory;
   
    }
    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        this.buttonList.add(this.travelBtn = new GuiButton(0,this.width/3+59, this.height / 5 +59 ,94, 20, I18n.format("container.TM.TravelBtn", new Object[0])));
        super.initGui();
    }
    private  String getName()
    {
		return "container.TM";
    
    }
    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {

        this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
        this.fontRendererObj.drawString(I18n.format(getName(), new Object[1]), this.xSize / 2 - this.fontRendererObj.getStringWidth(getName()) / 2, 6, 0XF0d467);

    }

    private void updateButtons()
    {
    	if(inv.getStackInSlot(1) == new ItemStack(IATstuff.TimeGem)){
        this.travelBtn.visible = true;
    }
    	else{
            this.travelBtn.visible = false;

    	}
    
    }
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);


    }
}