package itsabouttime.client.renderer.entity.prehistoric;

import itsabouttime.client.model.prehistoric.ModelPsittacosaurus;
import itsabouttime.common.entities.prehistoric.EntityPsittacosaurus;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPsittacosaurus
  extends RenderLiving
{
  private static final ResourceLocation Texture1 = new ResourceLocation( "iat:textures/entity/Psittacosaurus/Psittacosaurus.png");
  private static final ResourceLocation Texture2 = new ResourceLocation( "iat:textures/entity/Psittacosaurus/PsittacosaurusFlaming.png");

  public RenderPsittacosaurus()
  {
    super(new ModelPsittacosaurus(), 0.3F);
  }
  
  protected ResourceLocation getEntityTextures(EntityPsittacosaurus tr)
  {
    switch (tr.getType())
    {
    case 0: 
    default: 
      return Texture1;
    case 1: 
      return Texture2;

    }
  }

  protected ResourceLocation getEntityTexture(Entity entity)
  {
    return getEntityTextures((EntityPsittacosaurus)entity);
  }
  
}
