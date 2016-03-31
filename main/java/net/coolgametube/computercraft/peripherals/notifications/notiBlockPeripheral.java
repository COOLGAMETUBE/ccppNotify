package net.coolgametube.computercraft.peripherals.notifications;

import net.minecraft.tileentity.TileEntity;
import net.coolgametube.computercraft.peripherals.notifications.TileEntityNotiBlock;
import dan200.computercraft.api.peripheral.IPeripheral;

public class notiBlockPeripheral extends PeripheralBase implements IPeripheral {
	
	public notiBlockPeripheral(TileEntity tile) {
		super(tile);
	}
	
	@Override
	public String getType() {
		return "notifyLight";
	}
}