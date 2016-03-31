package net.coolgametube.computercraft.peripherals.notifications;

import dan200.computercraft.api.ComputerCraftAPI;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Blocks {
	
	public static String modid = main.MODID;
	
	public static notiBlock BnotiBlock = new notiBlock();
	
	private static void registerBlock(Block b, String n) {
		main.regularPrint("Register block: \""+n+"\"");
		GameRegistry.registerBlock(b,n);
		GameRegistry.addRecipe(new ItemStack(BnotiBlock, 1), new Object [] {
			"AAA", "RGB", "WLW",
			'A', net.minecraft.init.Blocks.glass,
			'R', new ItemStack(net.minecraft.init.Blocks.wool, 1, 14),
			'G', new ItemStack(net.minecraft.init.Blocks.wool, 1, 13),
			'B', new ItemStack(net.minecraft.init.Blocks.wool, 1, 11),
			'W', net.minecraft.init.Blocks.planks,
			'L', net.minecraft.init.Blocks.redstone_lamp
		});
	}
	
	private static void regRenderer(Block block) {
		main.regularPrint("Register blockmodel: \""+block.getUnlocalizedName()+"\"");
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void createBlocks() {
		ComputerCraftAPI.registerPeripheralProvider(new PeripheralProvider());
		registerBlock(BnotiBlock, "notifyBlock");
	}
	
	public static void addBlockRenderers() {
		regRenderer(BnotiBlock);
	}
}
