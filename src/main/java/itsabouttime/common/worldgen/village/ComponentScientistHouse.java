package itsabouttime.common.worldgen.village;


import static net.minecraftforge.common.ChestGenHooks.VILLAGE_BLACKSMITH;
import itsabouttime.iat;
import itsabouttime.common.core.IATstuff;
import itsabouttime.common.core.IATentities;

import java.util.List;
import java.util.Random;









import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import net.minecraftforge.common.ChestGenHooks;



public class ComponentScientistHouse extends StructureVillagePieces.House1
{
    private int averageGroundLevel = -1;
    private boolean isRoofAccessible;


    public ComponentScientistHouse()
    {

    }
    


    public ComponentScientistHouse(Start villagePiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super();
        this.coordBaseMode = par5;
        this.boundingBox = par4StructureBoundingBox;
    }


    public static ComponentScientistHouse buildComponent (Start villagePiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5)
    {
        StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, 7, 6, 7, p4);
        return canVillageGoDeeper(structureboundingbox) && StructureComponent.findIntersecting(pieces, structureboundingbox) == null ? new ComponentScientistHouse(villagePiece, p5, random,
                structureboundingbox, p4) : null;
    }


  
    @Override
    public boolean addComponentParts (World p_74875_1_, Random random, StructureBoundingBox p_74875_3_)
    {
        if (this.field_143015_k < 0)
        {
            this.field_143015_k = this.getAverageGroundLevel(p_74875_1_, p_74875_3_);

            if (this.field_143015_k < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 7 - 1, 0);
        }

        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 1, 1, 7, 4, 4, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 1, 6, 8, 4, 10, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 0, 6, 8, 0, 10, Blocks.dirt, Blocks.dirt, false);
        this.placeBlockAtCurrentPosition(p_74875_1_, IATstuff.SilurianCobble, 0, 6, 0, 6, p_74875_3_);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 2, 1, 6, 2, 1, 10, Blocks.fence, Blocks.fence, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 1, 6, 8, 1, 10, Blocks.fence, Blocks.fence, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 3, 1, 10, 7, 1, 10, Blocks.fence, Blocks.fence, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 1, 7, 0, 4, Blocks.planks, Blocks.planks, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 0, 0, 0, 3, 5, IATstuff.SilurianCobble, IATstuff.SilurianCobble, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 8, 0, 0, 8, 3, 5, IATstuff.SilurianCobble, IATstuff.SilurianCobble, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 0, 7, 1, 0, IATstuff.SilurianCobble, IATstuff.SilurianCobble, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 0, 5, 7, 1, 5, IATstuff.SilurianCobble, IATstuff.SilurianCobble, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 0, 7, 3, 0, Blocks.planks, Blocks.planks, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 1, 2, 5, 7, 3, 5, Blocks.planks, Blocks.planks, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 4, 1, 8, 4, 1, Blocks.planks, Blocks.planks, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 4, 4, 8, 4, 4, Blocks.planks, Blocks.planks, false);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 0, 5, 2, 8, 5, 3, Blocks.planks, Blocks.planks, false);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 0, 4, 2, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 0, 4, 3, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 8, 4, 2, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 8, 4, 3, p_74875_3_);
        int i = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
        int j = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
        int k;
        int l;

        for (k = -1; k <= 2; ++k)
        {
            for (l = 0; l <= 8; ++l)
            {
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, i, l, 4 + k, k, p_74875_3_);
                this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, j, l, 4 + k, 5 - k, p_74875_3_);
            }
        }

        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 0, 2, 1, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 0, 2, 4, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 8, 2, 1, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.log, 0, 8, 2, 4, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 2, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 0, 2, 3, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 8, 2, 2, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 8, 2, 3, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 2, 2, 5, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 3, 2, 5, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 5, 2, 0, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.glass_pane, 0, 6, 2, 5, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.fence, 0, 2, 1, 3, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.wooden_pressure_plate, 0, 2, 2, 3, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.planks, 0, 1, 1, 4, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 3), 2, 1, 4, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.oak_stairs, this.getMetadataWithOffset(Blocks.oak_stairs, 1), 1, 1, 3, p_74875_3_);
        this.fillWithBlocks(p_74875_1_, p_74875_3_, 5, 0, 1, 7, 0, 3, Blocks.double_stone_slab, Blocks.double_stone_slab, false);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.double_stone_slab, 0, 6, 1, 1, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.double_stone_slab, 0, 6, 1, 2, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 2, 1, 0, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 2, 2, 0, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 2, 3, 1, p_74875_3_);
        this.placeDoorAtCurrentPosition(p_74875_1_, p_74875_3_, random, 2, 1, 0, this.getMetadataWithOffset(Blocks.wooden_door, 1));

        if (this.getBlockAtCurrentPosition(p_74875_1_, 2, 0, -1, p_74875_3_).getMaterial() == Material.air && this.getBlockAtCurrentPosition(p_74875_1_, 2, -1, -1, p_74875_3_).getMaterial() != Material.air)
        {
            this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.stone_stairs, this.getMetadataWithOffset(Blocks.stone_stairs, 3), 2, 0, -1, p_74875_3_);
        }

        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 6, 1, 5, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.air, 0, 6, 2, 5, p_74875_3_);
        this.placeBlockAtCurrentPosition(p_74875_1_, Blocks.torch, 0, 6, 3, 4, p_74875_3_);
        this.placeDoorAtCurrentPosition(p_74875_1_, p_74875_3_, random, 6, 1, 5, this.getMetadataWithOffset(Blocks.wooden_door, 1));

        for (k = 0; k < 5; ++k)
        {
            for (l = 0; l < 9; ++l)
            {
                this.clearCurrentPositionBlocksUpwards(p_74875_1_, l, 7, k, p_74875_3_);
                this.func_151554_b(p_74875_1_, IATstuff.SilurianCobble, 0, l, -1, k, p_74875_3_);
            }
        }

        this.spawnVillagers(p_74875_1_, p_74875_3_, 4, 1, 2, 2);
        return true;
    }

    






        

    /**
     * Returns the villager type to spawn in this component, based on the number
     * of villagers already spawned.
     */
    @Override
    protected int getVillagerType (int par1)
    {
        return IATentities.VillagerID;
    }
}
