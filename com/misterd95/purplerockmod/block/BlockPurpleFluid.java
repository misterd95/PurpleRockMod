package com.misterd95.purplerockmod.block;

import com.misterd95.purplerockmod.PurpleRockMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.fluids.BlockFluidClassic;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPurpleFluid extends BlockFluidClassic{

	public BlockPurpleFluid(int id) {
		super(id, PurpleRockMod.fluidPurple, PurpleRockMod.materialPurple);
		
		this.setCreativeTab(PurpleRockMod.purpleRockTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(PurpleRockMod.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}
