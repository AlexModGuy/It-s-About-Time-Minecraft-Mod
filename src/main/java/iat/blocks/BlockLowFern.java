package iat.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLowFern extends Block
{
    @SideOnly(Side.CLIENT)
    private IIcon field_150200_a;
    @SideOnly(Side.CLIENT)
    private IIcon field_150199_b;

    public BlockLowFern()
    {
        super(Material.grass);
        this.setTickRandomly(true);
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 1 ? this.field_150200_a : (p_149691_1_ == 0 ? Blocks.dirt.getBlockTextureFromSide(p_149691_1_) : this.blockIcon);
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        if (!p_149674_1_.isRemote)
        {
            if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && p_149674_1_.getBlockLightOpacity(p_149674_2_, p_149674_3_ + 1, p_149674_4_) > 2)
            {
                p_149674_1_.setBlock(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.dirt);
            }
            else if (p_149674_1_.getBlockLightValue(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9)
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
                    int j1 = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
                    int k1 = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
                    Block block = p_149674_1_.getBlock(i1, j1 + 1, k1);

                    if (p_149674_1_.getBlock(i1, j1, k1) == Blocks.dirt && p_149674_1_.getBlockMetadata(i1, j1, k1) == 0 && p_149674_1_.getBlockLightValue(i1, j1 + 1, k1) >= 4 && p_149674_1_.getBlockLightOpacity(i1, j1 + 1, k1) <= 2)
                    {
                        p_149674_1_.setBlock(i1, j1, k1, this);
                    }
                }
            }
        }
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Blocks.dirt.getItemDropped(0, p_149650_2_, p_149650_3_);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
    {
        if (p_149673_5_ == 1)
        {
            return this.field_150200_a;
        }
        else if (p_149673_5_ == 0)
        {
            return Blocks.dirt.getBlockTextureFromSide(p_149673_5_);
        }
        else
        {
            Material material = p_149673_1_.getBlock(p_149673_2_, p_149673_3_ + 1, p_149673_4_).getMaterial();
            return material != Material.snow && material != Material.craftedSnow ? this.blockIcon : this.field_150199_b;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon("iat:low_Fern_side");
        this.field_150200_a = p_149651_1_.registerIcon("iat:low_Fern_top");
        this.field_150199_b = p_149651_1_.registerIcon("grass_side_snowed");
    }

  
}