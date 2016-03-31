package net.coolgametube.computercraft.peripherals.notifications.handler;

import dan200.computercraft.api.ComputerCraftAPI;
import net.coolgametube.computercraft.peripherals.notifications.Blocks;
import net.coolgametube.computercraft.peripherals.notifications.main;
import net.coolgametube.computercraft.peripherals.notifications.notiBlock;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class baseHandler {
	@EventHandler
	public void PreInit(FMLPreInitializationEvent e) {
		Blocks.createBlocks();
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e) {
		ComputerCraftAPI.registerPeripheralProvider(net.coolgametube.computercraft.peripherals.notifications.Blocks.BnotiBlock);
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent e) {

	}
	
	@EventHandler
	public void LoadComplete(FMLLoadCompleteEvent e) {

	}
}
