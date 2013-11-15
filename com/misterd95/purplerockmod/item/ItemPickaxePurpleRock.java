package com.misterd95.purplerockmod.item;

import com.misterd95.purplerockmod.PurpleRockMod;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPickaxePurpleRock extends ItemPickaxe{

	public ItemPickaxePurpleRock(int id, EnumToolMaterial toolMaterial) {
		super(id, toolMaterial);
		
		this.setCreativeTab(PurpleRockMod.purpleRockTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(PurpleRockMod.modid + ":" + this.getUnlocalizedName().substring(5));
	}

}
