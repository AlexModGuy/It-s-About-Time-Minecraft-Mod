package itsabouttime.client.particle;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class EntityTarBubbleFX extends EntityFX
{
private static final ResourceLocation texture = new ResourceLocation("iat:textures/misc/tarbubble.png");
private static final ResourceLocation particles = new ResourceLocation("textures/particle/particles.png");
private float lavaParticleScale;
private static final String __OBFID = "CL_00000912";
@SideOnly(Side.CLIENT)
public EntityTarBubbleFX(World p_i1215_1_, double p_i1215_2_, double p_i1215_4_, double p_i1215_6_)
{
    super(p_i1215_1_, p_i1215_2_, p_i1215_4_, p_i1215_6_, 0.0D, 0.0D, 0.0D);
    this.motionX *= 0;
    this.motionY *= 0.800000011920929D;
    this.motionZ *= 0D;
    this.motionY = (double)(this.rand.nextFloat() * 0.4F + 0.05F);
    this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
    this.particleScale = 1F;
    this.lavaParticleScale = this.particleScale;
    this.particleMaxAge = (int)(8.0D);
    this.noClip = false;
    this.setParticleTextureIndex(49);
}
@SideOnly(Side.CLIENT)
public int getBrightnessForRender(float p_70070_1_)
{
    float f1 = ((float)this.particleAge + p_70070_1_) / (float)this.particleMaxAge;

    if (f1 < 0.0F)
    {
        f1 = 0.0F;
    }

    if (f1 > 1.0F)
    {
        f1 = 1.0F;
    }

    int i = super.getBrightnessForRender(p_70070_1_);
    short short1 = 240;
    int j = i >> 16 & 255;
    return short1 | j << 16;
}

/**
 * Gets how bright this entity is.
 */
@SideOnly(Side.CLIENT)
public float getBrightness(float p_70013_1_)
{
    return 1.0F;
}
@SideOnly(Side.CLIENT)
public void onUpdate()
{
    this.prevPosX = this.posX;
    this.prevPosY = this.posY;
    this.prevPosZ = this.posZ;

    if (this.particleAge++ >= this.particleMaxAge)
    {
        this.setDead();
    }

    this.setParticleTextureIndex(7 - this.particleAge * 8 / this.particleMaxAge);
    this.moveEntity(this.motionX, this.motionY, this.motionZ);

    if (this.posY == this.prevPosY)
    {
        this.motionX *= 1.1D;
        this.motionZ *= 1.1D;
    }

    this.motionX *= 0.9;
    this.motionY *= 0.3599999785423279D;
    this.motionZ *= 0.9D;

    if (this.onGround)
    {
        this.motionX *= 0.71D;
        this.motionZ *= 0.71D;
    }
}
@Override
@SideOnly(Side.CLIENT)
public void renderParticle(Tessellator tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
{
tessellator.draw();
GL11.glPushMatrix();
GL11.glDepthMask(false);
GL11.glEnable(3042);
FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);
float sizeFactor = 0.1F * particleScale;
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
/**
* Called to update the entity's position/logic.
*/

}