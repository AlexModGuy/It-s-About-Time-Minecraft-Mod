package itsabouttime.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBasic extends Block
{
    private final MapColor field_150202_a;
    private static final String __OBFID = "CL_00000268";

    public BlockBasic(MapColor p_i45414_1_, Material mat)
    {
        super(mat);
        this.field_150202_a = p_i45414_1_;
    }

    public MapColor getMapColor(int p_149728_1_)
    {
        return this.field_150202_a;
    }
}