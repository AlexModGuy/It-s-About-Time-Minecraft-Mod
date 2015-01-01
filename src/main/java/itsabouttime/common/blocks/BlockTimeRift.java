package itsabouttime.common.blocks;

import itsabouttime.iat;
import itsabouttime.common.core.IATstuff;
import itsabouttime.common.dimensions.Teleporter_Prehistoric;
import itsabouttime.common.tileentities.TileEntityTimeRift;
import itsabouttime.common.tileentities.TileEntityTreeFernLog;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTimeRift extends BlockContainer
{

// This is the portal class. Most of this code comes from the Vanilla Portal, so alot of it is unused, And I havn't a clue of what most of this stuff does, but it really doesn't matter because it it dead code.	
	
    public static final int[][] field_150001_a = new int[][] {new int[0], {3, 1}, {2, 0}};

    public BlockTimeRift(Material glass)
    {
        super(Material.portal);
        this.setTickRandomly(true);
        
    }
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        super.updateTick(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_5_);

        if (p_149674_1_.provider.isSurfaceWorld() && p_149674_1_.getGameRules().getGameRuleBooleanValue("doMobSpawning") && p_149674_5_.nextInt(2000) < p_149674_1_.difficultySetting.getDifficultyId())
        {
            int l;

            for (l = p_149674_3_; !World.doesBlockHaveSolidTopSurface(p_149674_1_, p_149674_2_, l, p_149674_4_) && l > 0; --l)
            {
                ;
            }

            if (l > 0 && !p_149674_1_.getBlock(p_149674_2_, l + 1, p_149674_4_).isNormalCube())
            {
                Entity entity = ItemMonsterPlacer.spawnCreature(p_149674_1_, 57, (double)p_149674_2_ + 0.5D, (double)l + 1.1D, (double)p_149674_4_ + 0.5D);

                if (entity != null)
                {
                    entity.timeUntilPortal = entity.getPortalCooldown();
                }
            }
        }
    }


    //TODO
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
    	
        if (entity.ridingEntity == null && entity.riddenByEntity == null && entity instanceof EntityPlayerMP)
        {EntityPlayerMP player = (EntityPlayerMP) entity;
        FMLCommonHandler.instance().getMinecraftServerInstance();
        MinecraftServer server = MinecraftServer.getServer();
           if(player.timeUntilPortal > 0){
        	   player.timeUntilPortal = 10;
           }else if(player.dimension != iat.dimnsionIdOrdovician){
        	   player.timeUntilPortal = 10;
        	   player.mcServer.getConfigurationManager().transferPlayerToDimension(player, iat.dimnsionIdOrdovician, new Teleporter_Prehistoric(server.worldServerForDimension(iat.dimnsionIdOrdovician)));
           }else{
        	   player.timeUntilPortal = 10;
        	   player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new Teleporter_Prehistoric(server.worldServerForDimension(0)));
           }
        }
    }

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_)
    {
        if (p_149734_5_.nextInt(100) == 0)
        {
            p_149734_1_.playSound((double)p_149734_2_ + 0.5D, (double)p_149734_3_ + 0.5D, (double)p_149734_4_ + 0.5D, "portal.portal", 0.5F, p_149734_5_.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int l = 0; l < 4; ++l)
        {
            double d0 = (double)((float)p_149734_2_ + p_149734_5_.nextFloat());
            double d1 = (double)((float)p_149734_3_ + p_149734_5_.nextFloat());
            double d2 = (double)((float)p_149734_4_ + p_149734_5_.nextFloat());
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            int i1 = p_149734_5_.nextInt(2) * 2 - 1;
            d3 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
            d4 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;
            d5 = ((double)p_149734_5_.nextFloat() - 0.5D) * 0.5D;

            if (p_149734_1_.getBlock(p_149734_2_ - 1, p_149734_3_, p_149734_4_) != this && p_149734_1_.getBlock(p_149734_2_ + 1, p_149734_3_, p_149734_4_) != this)
            {
                d0 = (double)p_149734_2_ + 0.5D + 0.25D * (double)i1;
                d3 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
            }
            else
            {
                d2 = (double)p_149734_4_ + 0.5D + 0.25D * (double)i1;
                d5 = (double)(p_149734_5_.nextFloat() * 2.0F * (float)i1);
            }

            p_149734_1_.spawnParticle("null", d0, d1, d2, d3, d4, d5);
        }
    }

    public static int func_149999_b(int p_149999_0_)
    {
        return p_149999_0_ & 3;
    }

    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Item.getItemById(0);
    }

    public static class Size
        {
            private final World field_150867_a;
            private final int field_150865_b;
            private final int field_150866_c;
            private final int field_150863_d;
            private int field_150864_e = 0;
            private ChunkCoordinates field_150861_f;
            private int field_150862_g;
            private int field_150868_h;
            private static final String __OBFID = "CL_00000285";

           public Size(World world, int x, int y, int z, int i)
            {
                this.field_150867_a = world;
                this.field_150865_b = i;
                this.field_150863_d = BlockTimeRift.field_150001_a[i][0];
                this.field_150866_c = BlockTimeRift.field_150001_a[i][1];

                for (int i1 = y; y > i1 - 21 && y > 0 && this.func_150857_a(world.getBlock(x, y - 1, z)); --y)
                {
                    ;
                }

                int j1 = this.func_150853_a(x, y, z, this.field_150863_d) - 1;

                if (j1 >= 0)
                {
                    this.field_150861_f = new ChunkCoordinates(x + j1 * Direction.offsetX[this.field_150863_d], y, z + j1 * Direction.offsetZ[this.field_150863_d]);
                    this.field_150868_h = this.func_150853_a(this.field_150861_f.posX, this.field_150861_f.posY, this.field_150861_f.posZ, this.field_150866_c);

                    if (this.field_150868_h < 2 || this.field_150868_h > 21)
                    {
                        this.field_150861_f = null;
                        this.field_150868_h = 0;
                    }
                }

                if (this.field_150861_f != null)
                {
                    this.field_150862_g = this.func_150858_a();
                }
            }

            protected int func_150853_a(int p_150853_1_, int p_150853_2_, int p_150853_3_, int p_150853_4_)
            {
                int j1 = Direction.offsetX[p_150853_4_];
                int k1 = Direction.offsetZ[p_150853_4_];
                int i1;
                Block block;

                for (i1 = 0; i1 < 22; ++i1)
                {
                    block = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_, p_150853_3_ + k1 * i1);

                    if (!this.func_150857_a(block))
                    {
                        break;
                    }

                    Block block1 = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_ - 1, p_150853_3_ + k1 * i1);

                    if (block1 != IATstuff.Shale)
                    {
                        break;
                    }
                }

                block = this.field_150867_a.getBlock(p_150853_1_ + j1 * i1, p_150853_2_, p_150853_3_ + k1 * i1);
                return block == IATstuff.Shale ? i1 : 0;
            }

            

            protected int func_150858_a()
            {
                int i;
                int j;
                int k;
                int l;
                label56:

                for (this.field_150862_g = 0; this.field_150862_g < 21; ++this.field_150862_g)
                {
                    i = this.field_150861_f.posY + this.field_150862_g;

                    for (j = 0; j < this.field_150868_h; ++j)
                    {
                        k = this.field_150861_f.posX + j * Direction.offsetX[BlockTimeRift.field_150001_a[this.field_150865_b][1]];
                        l = this.field_150861_f.posZ + j * Direction.offsetZ[BlockTimeRift.field_150001_a[this.field_150865_b][1]];
                        Block block = this.field_150867_a.getBlock(k, i, l);

                        if (!this.func_150857_a(block))
                        {
                            break label56;
                        }

                        if (block == IATstuff.OrdovicianPortal)
                        {
                            ++this.field_150864_e;
                        }

                        if (j == 0)
                        {
                            block = this.field_150867_a.getBlock(k + Direction.offsetX[BlockTimeRift.field_150001_a[this.field_150865_b][0]], i, l + Direction.offsetZ[BlockTimeRift.field_150001_a[this.field_150865_b][0]]);

                            if (block != IATstuff.Shale)
                            {
                                break label56;
                            }
                        }
                        else if (j == this.field_150868_h - 1)
                        {
                            block = this.field_150867_a.getBlock(k + Direction.offsetX[BlockTimeRift.field_150001_a[this.field_150865_b][1]], i, l + Direction.offsetZ[BlockTimeRift.field_150001_a[this.field_150865_b][1]]);

                            if (block != IATstuff.Shale)
                            {
                                break label56;
                            }
                        }
                    }
                }

                for (i = 0; i < this.field_150868_h; ++i)
                {
                    j = this.field_150861_f.posX + i * Direction.offsetX[BlockTimeRift.field_150001_a[this.field_150865_b][1]];
                    k = this.field_150861_f.posY + this.field_150862_g;
                    l = this.field_150861_f.posZ + i * Direction.offsetZ[BlockTimeRift.field_150001_a[this.field_150865_b][1]];

                    if (this.field_150867_a.getBlock(j, k, l) != IATstuff.Shale)
                    {
                        this.field_150862_g = 0;
                        break;
                    }
                }

                if (this.field_150862_g <= 21 && this.field_150862_g >= 3)
                {
                    return this.field_150862_g;
                }
                else
                {
                    this.field_150861_f = null;
                    this.field_150868_h = 0;
                    this.field_150862_g = 0;
                    return 0;
                }
            }

            protected boolean func_150857_a(Block p_150857_1_)
            {
                return p_150857_1_.getMaterial() == Material.air || p_150857_1_ == Blocks.ice || p_150857_1_ == IATstuff.OrdovicianPortal;
            }

            public boolean func_150860_b()
            {
                return this.field_150861_f != null && this.field_150868_h >= 2 && this.field_150868_h <= 21 && this.field_150862_g >= 3 && this.field_150862_g <= 21;
            }

            public void func_150859_c()
            {
                for (int i = 0; i < this.field_150868_h; ++i)
                {
                    int j = this.field_150861_f.posX + Direction.offsetX[this.field_150866_c] * i;
                    int k = this.field_150861_f.posZ + Direction.offsetZ[this.field_150866_c] * i;

                    for (int l = 0; l < this.field_150862_g; ++l)
                    {
                        int i1 = this.field_150861_f.posY + l;
                        this.field_150867_a.setBlock(j, i1, k, Blocks.portal, this.field_150865_b, 2);
                    }
                }
            }
        }

    public int getRenderType()
    {
        return -46;
    }
    public boolean isOpaqueCube()
    {
    return false;
    }
    public boolean renderAsNormalBlock()
    {
    return false;
    }
    public TileEntity createNewTileEntity(World var1, int var2)
    {
    return new TileEntityTimeRift();
    }
   
}