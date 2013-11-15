package com.misterd95.purplerockmod;

import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	public int getBurnTime(ItemStack fuel) {
		//if(fuel.itemID == PurpleRockMod.mysteriousSubstance.blockID) return 400;
		
		//if(fuel.itemID == PurpleRockMod.mysteriousSubstance.blockID) return (fuel.stackSize * 25); 
		
		return 0;
	}

}
