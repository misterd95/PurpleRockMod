package com.misterd95.purplerockmod.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.misterd95.purplerockmod.PurpleRockMod;
import com.misterd95.purplerockmod.container.ContainerObsidianSmelter;
import com.misterd95.purplerockmod.tileentity.TileEntityObsidianSmelter;

public class GuiObsidianSmelter extends GuiContainer{
	
	public static final ResourceLocation texture = new ResourceLocation(PurpleRockMod.modid, "textures/gui/obsidianSmelter.png");

	public TileEntityObsidianSmelter obsidianSmelter;
	
	public GuiObsidianSmelter(InventoryPlayer inventoryPlayer, TileEntityObsidianSmelter entity) {
		super(new ContainerObsidianSmelter(inventoryPlayer, entity));
		
		this.obsidianSmelter = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2){
		String name = this.obsidianSmelter.isInvNameLocalized() ? this.obsidianSmelter.getInvName() : I18n.getString(this.obsidianSmelter.getInvName());
		
		this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6, 4210752);
		this.fontRenderer.drawString(I18n.getString("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	
	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1f, 1f, 1f, 1f);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(this.obsidianSmelter.isBurning()){
			int k = this.obsidianSmelter.getBurnTimeRemainingScaled(12);
			drawTexturedModalRect(guiLeft + 56, guiTop + 36 + 12 - k, 176, 12 - k, 14, k + 2);
		}
		int k = this.obsidianSmelter.getCookProgressScaled(52);
		drawTexturedModalRect(guiLeft + 83, guiTop + 17, 176, 13, 52, k + 1);
	}

}
