package com.misterd95.purplerockmod.item;

import com.misterd95.purplerockmod.PurpleRockMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PurpleRockModItem extends Item{

	public PurpleRockModItem(int id) {
		super(id);
		this.setCreativeTab(PurpleRockMod.purpleRockTab);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(PurpleRockMod.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
