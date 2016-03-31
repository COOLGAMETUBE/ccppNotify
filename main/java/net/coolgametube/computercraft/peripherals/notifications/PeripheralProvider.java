package net.coolgametube.computercraft.peripherals.notifications;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;

public class PeripheralProvider implements IPeripheralProvider
{
	
	@Override
    public IPeripheral getPeripheral(World world, BlockPos pos, EnumFacing side)
    {
        if(world.getTileEntity(pos) instanceof IPeripheral)
        {
            return (IPeripheral) world.getTileEntity(pos);
        }

        return null;
    }
	
}