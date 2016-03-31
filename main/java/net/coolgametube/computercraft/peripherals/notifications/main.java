package net.coolgametube.computercraft.peripherals.notifications;

import net.coolgametube.computercraft.peripherals.notifications.handler.baseHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import dan200.computercraft.api.*;
import dan200.computercraft.api.peripheral.IPeripheralProvider;

@Mod(modid = main.MODID, version = main.VERSION, dependencies = "required-after:ComputerCraft")
public class main {
	public static final String MODID = "ccppnotify";
	public static final String VERSION = "0";
	public static String routine = null;
	
	public static void regularPrint(String s) {
		System.out.println("["+routine+"] "+s);
	}
	
	@SidedProxy(clientSide="net.coolgametube.computercraft.peripherals.notifications.handler.clientHandler", serverSide="net.coolgametube.computercraft.peripherals.notifications.handler.baseHandler")
	public static baseHandler proxy;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent e) {
		main.routine = "PRE-INIT";
		System.out.println("[PRE-INIT] Start pre-initalization");
		proxy.PreInit(e);
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent e) {
		main.routine = "INIT";
		System.out.println("[INIT] Start initalization");
		proxy.Init(e);
	}

	@EventHandler
	public void PostInit(FMLPostInitializationEvent e) {
		main.routine = "POST-INIT";
		System.out.println("[POST-INIT] Start post-initalization");
		proxy.PostInit(e);
	}
	
	@EventHandler
	public void LoadComplete(FMLLoadCompleteEvent e) {
		main.routine = "INGAME";
		main.regularPrint("Loading complete!");
		proxy.LoadComplete(e);
	}
}
