package com.misterd95.purplerockmod.block;

import com.misterd95.purplerockmod.PurpleRockMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleRockBlock extends Block{

	public PurpleRockBlock(int id, Material material) {
		super(id, material);
		this.setCreativeTab(PurpleRockMod.purpleRockTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(PurpleRockMod.modid + ":" + this.getUnlocalizedName().substring(5));
	}

}
