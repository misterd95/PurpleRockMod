package com.misterd95.purplerockmod.block;

import com.misterd95.purplerockmod.PurpleRockMod;

import net.minecraft.block.BlockDragonEgg;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class mysteriousSubstance extends BlockDragonEgg{

	public mysteriousSubstance(int id) {
		super(id);
		this.setCreativeTab(PurpleRockMod.purpleRockTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(PurpleRockMod.modid + ":" + this.getUnlocalizedName().substring(5));
	}

}
