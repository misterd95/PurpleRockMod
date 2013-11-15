package com.misterd95.purplerockmod.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.misterd95.purplerockmod.PurpleRockMod;
import com.misterd95.purplerockmod.container.ContainerObsidianSmelter;
import com.misterd95.purplerockmod.tileentity.TileEntityObsidianSmelter;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{
	
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
			case PurpleRockMod.guiIdObsidianSmelter:
				if(entity instanceof TileEntityObsidianSmelter){
					return new ContainerObsidianSmelter(player.inventory, (TileEntityObsidianSmelter) entity);
				}
			}
		}
		
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getBlockTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
			case PurpleRockMod.guiIdObsidianSmelter:
				if(entity instanceof TileEntityObsidianSmelter){
					return new GuiObsidianSmelter(player.inventory, (TileEntityObsidianSmelter) entity);
				}
			}
		}
		
		return null;
	}

}
