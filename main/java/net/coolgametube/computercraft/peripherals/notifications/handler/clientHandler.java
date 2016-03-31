package net.coolgametube.computercraft.peripherals.notifications.handler;

import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.coolgametube.computercraft.peripherals.notifications.Blocks;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class clientHandler extends baseHandler{
	@Override
	public void PreInit(FMLPreInitializationEvent e) {
	    super.PreInit(e);

	}
	
	@Override
	public void Init(FMLInitializationEvent e) {
	    super.Init(e);

	    Blocks.addBlockRenderers();
	}
	
	@Override
	public void PostInit(FMLPostInitializationEvent e) {
	    super.PostInit(e);
	}
	
	@EventHandler
	public void LoadComplete(FMLLoadCompleteEvent e) {
		super.LoadComplete(e);
	}
}
