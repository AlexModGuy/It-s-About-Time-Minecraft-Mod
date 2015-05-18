package iat.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockMud extends BlockBasic{

	public BlockMud(Material material, String harvestTool, int harvestStrength,
			float durability, float resistance) {
		super(material, harvestTool, harvestStrength, durability, resistance);
	}
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        float f = 0.125F;
        return AxisAlignedBB.getBoundingBox((double)x, (double)y, (double)z, (double)(x + 1), (double)((float)(y + 1) - f), (double)(z + 1));
    }
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
	{
			entity.motionX *= 0.4D;
			entity.motionZ *= 0.4D;
	}

}
