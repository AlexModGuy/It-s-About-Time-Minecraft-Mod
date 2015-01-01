package itsabouttime.common.blocks;

import itsabouttime.common.core.IATstuff;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockCambrianStone extends Block
{

    public BlockCambrianStone()
    {
        super(Material.rock);
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(IATstuff.CambrianCobble);
    }
}