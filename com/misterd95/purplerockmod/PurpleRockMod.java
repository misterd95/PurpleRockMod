package com.misterd95.purplerockmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.misterd95.purplerockmod.block.BlockPurpleFluid;
import com.misterd95.purplerockmod.block.PurpleRockBlock;
import com.misterd95.purplerockmod.block.PurpleRockOre;
import com.misterd95.purplerockmod.block.mysteriousSubstance;
import com.misterd95.purplerockmod.block.obsidianSmelter;
import com.misterd95.purplerockmod.gui.GuiHandler;
import com.misterd95.purplerockmod.item.ItemAxePurpleRock;
import com.misterd95.purplerockmod.item.ItemHoePurpleRock;
import com.misterd95.purplerockmod.item.ItemPickaxePurpleRock;
import com.misterd95.purplerockmod.item.ItemShovelPurpleRock;
import com.misterd95.purplerockmod.item.ItemSwordPurpleRock;
import com.misterd95.purplerockmod.item.PurpleRockModItem;
import com.misterd95.purplerockmod.tileentity.TileEntityObsidianSmelter;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = PurpleRockMod.modid, name = "Purple Rock Mod", version = "Pre-Alpha v 0.01")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)

public class PurpleRockMod {
	
	public static final String modid = "purplerockmod";
	
	@Instance(modid)
	public static PurpleRockMod instance;
	
	public static Block purpleRockOre;
	public static Block purpleRockBlock;
	
	public static Block purpleFluid;
	
	public static Block mysteriousSubstance;
	public static Block obsidianSmelterIdle;
	public static Block obsidainSmelterActive;
	
	public static EnumToolMaterial toolMaterialPurpleRock;
	
	public static Item purpleRockStone;
	public static Item refinedPurpleRock;
	public static Item obsidianBar;
	public static Item obsidianStick;
	
	public static Item itemAxePurpleRock;
	public static Item itemPickaxePurpleRock;
	public static Item itemShovelPurpleRock;
	public static Item itemSwordPurpleRock;
	public static Item itemHoePurpleRock;
	
	public static Fluid fluidPurple;
	
	public static Material materialPurple;
	
	public static CreativeTabs purpleRockTab;
	
	public static final int idFluidPurple = 1003;
	
	public static final int guiIdObsidianSmelter = 0;
	
	@EventHandler
	public void load(FMLInitializationEvent e){
		
		purpleRockTab = new CreativeTabs("purplerockmod"){
			@SideOnly(Side.CLIENT)
			public int getTabIconItemIndex(){
				return PurpleRockMod.purpleRockStone.itemID;
			}
			
		};
		LanguageRegistry.instance().addStringLocalization(purpleRockTab.getTranslatedTabLabel(), "Purple Rock Mod");
		
		//Fluids
		fluidPurple = new Fluid("purple").setBlockID(idFluidPurple);
		FluidRegistry.registerFluid(fluidPurple);
		
		//Materials
		materialPurple = new MaterialLiquid(MapColor.tntColor);
		
		//EnumToolMaterial
		toolMaterialPurpleRock = EnumHelper.addToolMaterial("PURPLEROCK", 4, 3200, 12.0F, 3.0F, 22);
		
		//blocks
		purpleRockOre = new PurpleRockOre(1000, Material.rock).setUnlocalizedName("purpleRockOre");
		registerBlock(purpleRockOre, "Purple Rock Ore");
		
		purpleRockBlock = new PurpleRockBlock(1001, Material.rock).setUnlocalizedName("purpleRockBlock");
		registerBlock(purpleRockBlock, "Purple Rock Block");
		
		mysteriousSubstance = new mysteriousSubstance(1002).setUnlocalizedName("mysteriousSubstance").setHardness(15F).setResistance(2F);
		registerBlock(mysteriousSubstance, "A Mysterious Substance");
		
		purpleFluid = new BlockPurpleFluid(idFluidPurple).setUnlocalizedName("purpleFluid");
		registerBlock(purpleFluid, "Purple...");
		
		obsidianSmelterIdle = new obsidianSmelter(1004, false).setUnlocalizedName("obsidianSmelterIdle").setHardness(50F).setCreativeTab(purpleRockTab);
		registerBlock(obsidianSmelterIdle, "Obsidian Smelter");
		
		obsidainSmelterActive = new obsidianSmelter(1005, true).setUnlocalizedName("obsidianSmelterActive").setHardness(50F).setLightValue(1F);
		registerBlock(obsidainSmelterActive, "Obsidian Smelter Active");
		
		//Items
		purpleRockStone = new PurpleRockModItem(9000).setUnlocalizedName("purpleRockStone");
		registerItem(purpleRockStone, "Purple Rock Stone");
		
		refinedPurpleRock = new PurpleRockModItem(9001).setUnlocalizedName("refinedPurpleRock");
		registerItem(refinedPurpleRock, "Refined Purple Rock");
		
		obsidianBar = new PurpleRockModItem(9002).setUnlocalizedName("obsidianBar");
		registerItem(obsidianBar, "Obsidian Bar");
		
		obsidianStick = new PurpleRockModItem(9003).setUnlocalizedName("obsidianStick");
		registerItem(obsidianStick, "Obsidian Stick");
				//tools
		itemAxePurpleRock = new ItemAxePurpleRock(9004, toolMaterialPurpleRock).setUnlocalizedName("axePurpleRock");
		registerItem(itemAxePurpleRock, " Purple Rock Axe");

		itemPickaxePurpleRock = new ItemPickaxePurpleRock(9005, toolMaterialPurpleRock).setUnlocalizedName("pickaxePurpleRock");
		registerItem(itemPickaxePurpleRock, " Purple Rock Pickaxe");
		
		itemShovelPurpleRock = new ItemShovelPurpleRock(9006, toolMaterialPurpleRock).setUnlocalizedName("shovelPurpleRock");
		registerItem(itemShovelPurpleRock, " Purple Rock Shovel");
		
		itemSwordPurpleRock = new ItemSwordPurpleRock(9007, toolMaterialPurpleRock).setUnlocalizedName("swordPurpleRock");
		registerItem(itemSwordPurpleRock, " Purple Rock Sword");
		
		itemHoePurpleRock = new ItemHoePurpleRock(9008, toolMaterialPurpleRock).setUnlocalizedName("hoePurpleRock");
		registerItem(itemHoePurpleRock, " Purple Rock Hoe");
		
		GameRegistry.registerFuelHandler(new FuelHandler());
		GameRegistry.registerTileEntity(TileEntityObsidianSmelter.class, "ObsidianSmelter");
		
		NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
		
		LanguageRegistry.instance().addStringLocalization("container.obsidianSmelter", "Obsidian Smelter");
		
		//Smelting Recipes
		//GameRegistry.addSmelting(Block.obsidian.blockID, new ItemStack(obsidianBar.itemID, 1, 0), 0.6F);
		//GameRegistry.addSmelting(PurpleRockMod.purpleRockBlock.blockID, new ItemStack(refinedPurpleRock, 2, 0), 1F);
		
		//Crafting Recipes
		GameRegistry.addRecipe(new ItemStack(purpleRockBlock, 1), new Object[]{
			"@@@",
			"@@@",
			"@@@", '@', purpleRockStone
		});
		
		GameRegistry.addRecipe(new ItemStack(purpleRockStone, 9), new Object[]{ "@", '@', purpleRockBlock});
		
		GameRegistry.addRecipe(new ItemStack(obsidianStick, 2), new Object[]{
			"@",
			"@", '@', obsidianBar
		});
		
		GameRegistry.addRecipe(new ItemStack(itemAxePurpleRock, 1), new Object[]{
			"@@ ",
			"@# ",
			" # ", '@', refinedPurpleRock, '#', obsidianStick
		});
		
		GameRegistry.addRecipe(new ItemStack(itemAxePurpleRock, 1), new Object[]{
			" @@",
			" #@",
			" # ", '@', refinedPurpleRock, '#', obsidianStick
		});

		GameRegistry.addRecipe(new ItemStack(itemPickaxePurpleRock, 1), new Object[]{
			"@@@",
			" # ",
			" # ", '@', refinedPurpleRock, '#', obsidianStick
		});
		
		GameRegistry.addRecipe(new ItemStack(itemShovelPurpleRock, 1), new Object[]{
			" @ ",
			" # ",
			" # ", '@', refinedPurpleRock, '#', obsidianStick
		});
		
		GameRegistry.addRecipe(new ItemStack(itemSwordPurpleRock, 1), new Object[]{
			" @ ",
			" @ ",
			" # ", '@', refinedPurpleRock, '#', obsidianStick
		});
		
		GameRegistry.addRecipe(new ItemStack(itemHoePurpleRock, 1), new Object[]{
			"@@ ",
			" # ",
			" # ", '@', refinedPurpleRock, '#', obsidianStick
		});
		
		GameRegistry.addRecipe(new ItemStack(itemHoePurpleRock, 1), new Object[]{
			" @@",
			" # ",
			" # ", '@', refinedPurpleRock, '#', obsidianStick
		});
		
	}
	
	public void registerBlock(Block block, String name){
		
		GameRegistry.registerBlock(block, block.getUnlocalizedName());
		LanguageRegistry.addName(block, name);
		
	}
	
	public void registerItem(Item item, String name){
		
		GameRegistry.registerItem(item, item.getUnlocalizedName());
		LanguageRegistry.addName(item, name);
		
	}

}
