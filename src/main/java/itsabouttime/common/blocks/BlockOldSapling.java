package itsabouttime.common.blocks;

import itsabouttime.common.core.IATstuff;
import itsabouttime.common.worldgen.WorldGenArchaeopterisTree;
import itsabouttime.common.worldgen.WorldGenBjuviaTree;
import itsabouttime.common.worldgen.WorldGenCarbonTree1;
import itsabouttime.common.worldgen.WorldGenCarbonTree2;
import itsabouttime.common.worldgen.WorldGenCarbonTree3;
import itsabouttime.common.worldgen.WorldGenCarbonTree4;
import itsabouttime.common.worldgen.WorldGenHugeArchaeopterisTree;
import itsabouttime.common.worldgen.WorldGenPrototaxities;
import itsabouttime.common.worldgen.WorldGenEgypt;
import itsabouttime.common.worldgen.WorldGenTreeFern;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenCanopyTree;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenMegaJungle;
import net.minecraft.world.gen.feature.WorldGenMegaPineTree;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenSavannaTree;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockOldSapling extends BlockSapling{
	
	public static final String[] customSaplings = new String[] {"Progymnosperm", "Lepidodendron", "Prototaxites", "TreeFern", "Archaeopteris","Bjuvia"};
    private static final IIcon[] iconLength = new IIcon[customSaplings.length];
  

    public BlockOldSapling() {
    	super();
    	float f = 0.4F;
    	this.setHardness(0.0F);
    	this.stepSound = soundTypeGrass;
    	this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
    	}

    

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World world, int x, int y, int z, Random random)
    {
        if (!world.isRemote)
        {
            super.updateTick(world, x, y, z, random);

            if (world.getBlockLightValue(x, y + 1, z) >= 9 && random.nextInt(7) == 0)
            {
                this.func_149879_c(world, x, y, z, random);
            }
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        meta &= 7;
        return iconLength[MathHelper.clamp_int(meta, 0, 5)];
    }
//markOrGrowMarked
    public void func_149879_c(World world, int x, int y, int z, Random random)
    {
        int l = world.getBlockMetadata(x, y, z);

        if ((l & 8) == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, l | 8, 4);
        }
        else
        {
            this.func_149878_d(world, x, y, z, random);
        }
    }

//grow tree
    @Override
    public void func_149878_d(World world, int x, int y, int z, Random random)
    {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, random, x, y, z)) return;
        int l = world.getBlockMetadata(x, y, z) & 7;
        int i1 = 0;
        int j1 = 0;
    	Object object = null;
        boolean flag = false;
        int rand;

        switch (l)
        {
            case 0:
            	rand = random.nextInt(1);

            	if (rand == 0) object = new WorldGenCarbonTree3(IATstuff.OldLog,IATstuff.OldLeaves,0, 0, Blocks.grass, Blocks.dirt, Blocks.mycelium, IATstuff.LushPodzol);
            	else object =new WorldGenCarbonTree4(IATstuff.OldLog,IATstuff.OldLeaves,0, 0, Blocks.grass, Blocks.dirt, Blocks.mycelium, IATstuff.LushPodzol);
                break;
            case 1:
            	rand = random.nextInt(1);

            	if (rand == 0) object = new WorldGenCarbonTree2(IATstuff.OldLog,IATstuff.OldLeaves,1,1, Blocks.grass, Blocks.dirt, Blocks.mycelium, IATstuff.LushPodzol);
            	else object =new WorldGenCarbonTree1(IATstuff.OldLog,IATstuff.OldLeaves,1, 1, Blocks.grass, Blocks.dirt, Blocks.mycelium, IATstuff.LushPodzol);
                break;
            case 2:
                object = new WorldGenPrototaxities(IATstuff.OldLog, 2, Blocks.grass, Blocks.dirt, Blocks.mycelium, IATstuff.LushPodzol);
            	//object = new WorldGenSphinx();
				break;

            case 3:
                object = new WorldGenTreeFern(IATstuff.TreeFernLog,IATstuff.OldLeaves,2,0, Blocks.grass, Blocks.dirt, Blocks.mycelium, IATstuff.LushPodzol);

                break;
            case 4:
            	rand = random.nextInt(4);

       //     	if (rand == 0) object = new WorldGenHugeArchaeopterisTree(IATStuff.OldLog,IATStuff.OldLeaves,1,1, Blocks.grass, Blocks.dirt, Blocks.mycelium, IATStuff.LushPodzol);
            //	else object =new WorldGenArchaeopterisTree(IATStuff.OldLog,IATStuff.OldLeaves,1, 1, Blocks.grass, Blocks.dirt, Blocks.mycelium, IATStuff.LushPodzol);
                object = new WorldGenArchaeopterisTree(IATstuff.OldLog,IATstuff.OldLeaves,3,3, Blocks.grass, Blocks.dirt, Blocks.mycelium, IATstuff.LushPodzol);
   
                break;
            case 5:
                object = new WorldGenBjuviaTree(IATstuff.OldLog2,IATstuff.OldLeaves,4,0, Blocks.grass, Blocks.dirt, Blocks.mycelium, IATstuff.LushPodzol);

            	 break;
        }

        Block block = Blocks.air;

        if (flag)
        {
            world.setBlock(x + i1, y, z + j1, block, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1, block, 0, 4);
            world.setBlock(x + i1, y, z + j1 + 1, block, 0, 4);
            world.setBlock(x + i1 + 1, y, z + j1 + 1, block, 0, 4);
        }
        else
        {
            world.setBlock(x, y, z, block, 0, 4);
        }

        if (!((WorldGenerator)object).generate(world, random, x + i1, y, z + j1))
        {
            if (flag)
            {
                world.setBlock(x + i1, y, z + j1, this, l, 4);
                world.setBlock(x + i1 + 1, y, z + j1, this, l, 4);
                world.setBlock(x + i1, y, z + j1 + 1, this, l, 4);
                world.setBlock(x + i1 + 1, y, z + j1 + 1, this, l, 4);
            }
            else
            {
                world.setBlock(x, y, z, this, l, 4);
            }
        }
    }
    @Override
  public boolean canPlaceBlockOnSide(World world, int x, int y, int z, int side)
  {
    	Block block = world.getBlock(x, y - 1, z);
    	
  return   block == Blocks.grass || block == Blocks.dirt || block == Blocks.farmland|| block == IATstuff.LushPodzol|| block == IATstuff.PrehistoricPodzol|| block.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);

  }
//is same sapling
    public boolean func_149880_a(World world, int x, int y, int z, int par1)
    {
        return world.getBlock(x, y, z) == this && (world.getBlockMetadata(x, y, z) & 7) == par1;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int p_149692_1_)
    {
        return MathHelper.clamp_int(p_149692_1_ & 7, 0, 5);
    }

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tabs, List list)
    {
    	for (int i = 0; i < customSaplings.length; i++){
    		list.add(new ItemStack(item, 1,i));}
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconregister)
    {
        for (int i = 0; i < customSaplings.length; ++i)
        {
            iconLength[i] = iconregister.registerIcon("iat:" + "Sapling_" + customSaplings[i]);
        }
    }

    public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_)
    {
        return true;
    }

    public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_)
    {
        return (double)p_149852_1_.rand.nextFloat() < 0.45D;
    }

    public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_)
    {
        this.func_149879_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
    }
}
