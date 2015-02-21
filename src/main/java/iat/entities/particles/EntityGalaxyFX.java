package iat.entities.particles;

import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityGalaxyFX extends EntityFX{

	private static final ResourceLocation texture = new ResourceLocation("iat:textures/misc/galaxy.png");
	private static final ResourceLocation particles = new ResourceLocation("textures/particle/particles.png");

	public EntityGalaxyFX(World world, double x, double y, double z) {
		super(world, x, y, z);


	}
	public EntityGalaxyFX(World world, double x, double y, double z, double motionX, double motionY, double motionZ)
	{
		super(world, x, y, z, motionX, motionY, motionZ);
		this.motionX = motionX;
		this.motionY = motionY;
		this.motionZ = motionZ;
		this.noClip = true;
	}
	@SideOnly(Side.CLIENT)
	public float getBrightness(float p_70013_1_)
	{
		return 1.0F;
	}
	public void renderParticle(Tessellator tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		 float rot = this.worldObj.getWorldTime() % 360L;
		tessellator.draw();
		GL11.glPushMatrix();
		GL11.glDepthMask(false);
		GL11.glEnable(3042);

		GL11.glPushMatrix();
		GL11.glRotatef(rot, 0.00F, 0.00F, 0.50F);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		float sizeFactor = 1F * particleScale;
		float var13 = (float)(prevPosX + (posX - prevPosX) * par2 - EntityFX.interpPosX);
		float var14 = (float)(prevPosY + (posY - prevPosY) * par2 - EntityFX.interpPosY);
		float var15 = (float)(prevPosZ + (posZ - prevPosZ) * par2 - EntityFX.interpPosZ);
		tessellator.startDrawingQuads();
		tessellator.setBrightness(240);
		tessellator.setColorRGBA_F(particleRed, particleGreen, particleBlue, 1.0F);
		tessellator.addVertexWithUV(var13 - par3 * sizeFactor - par6 * sizeFactor, var14 - par4 * sizeFactor, var15 - par5 * sizeFactor - par7 * sizeFactor, 0.0D, 1.0D);
		tessellator.addVertexWithUV(var13 - par3 * sizeFactor + par6 * sizeFactor, var14 + par4 * sizeFactor, var15 - par5 * sizeFactor + par7 * sizeFactor, 1.0D, 1.0D);
		tessellator.addVertexWithUV(var13 + par3 * sizeFactor + par6 * sizeFactor, var14 + par4 * sizeFactor, var15 + par5 * sizeFactor + par7 * sizeFactor, 1.0D, 0.0D);
		tessellator.addVertexWithUV(var13 + par3 * sizeFactor - par6 * sizeFactor, var14 - par4 * sizeFactor, var15 + par5 * sizeFactor - par7 * sizeFactor, 0.0D, 0.0D);
		tessellator.draw();
		GL11.glDisable(3042);
		GL11.glDepthMask(true);
		GL11.glPopMatrix();
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(particles);
		tessellator.startDrawingQuads();
	}
	@SideOnly(Side.CLIENT)
	public void onUpdate()
	{
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
		this.moveEntity(0, 0, 0);
		int x = MathHelper.floor_double(this.posX);
		int y = MathHelper.floor_double(this.posY);
		int z = MathHelper.floor_double(this.posZ);
		if(this.worldObj.getBlock(x, y, z) == Blocks.air){
			this.setDead();
		}
		if (this.posY == this.prevPosY)
		{
			this.motionX *= 1.1D;
			this.motionZ *= 1.1D;
		}

	}

}
