package com.misterd95.purplerockmod.item;

import com.misterd95.purplerockmod.PurpleRockMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHoePurpleRock extends ItemHoe{

	public ItemHoePurpleRock(int id, EnumToolMaterial toolMaterial) {
		super(id, toolMaterial);
		
		this.setCreativeTab(PurpleRockMod.purpleRockTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(PurpleRockMod.modid + ":" + this.getUnlocalizedName().substring(5));
	}

}
