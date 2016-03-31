package net.coolgametube.computercraft.peripherals.notifications;

import java.io.IOException;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.common.registry.GameData;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;

public class TileEntityNotiBlock extends TileEntity implements IPeripheral{
		public TileEntityNotiBlock() {
			this.peripheral = new notiBlockPeripheral(this);
		}
		
		private notiBlockPeripheral peripheral;
		private int ticksSinceSync;

	    @Override
		public synchronized void detach(IComputerAccess icomputeraccess) // tried sync and without
	    {
	    	peripheral.detach(icomputeraccess);
	    }
	    
		@Override
		public void attach(IComputerAccess computer) {
			peripheral.attach(computer);
		}

	    @Override
		public String getType()
	    {
	        return "notifylight";
	    }

	    @Override
		public String[] getMethodNames()
	    {
	        return new String [] {"setColor", "getColor"};
	    }
     @Override
     public Object[] callMethod(IComputerAccess computer,ILuaContext context, int method, Object[] arguments) throws LuaException,	
     InterruptedException {
	    	switch(method) {
	    		case 0: {
	    			if(arguments.length < 1) {
	    				throw new LuaException("too few arguments");
	    			}else {
	    				if(arguments[0] instanceof Double){
	    					Double[] vaildColors = {(double) 1,(double) 2,(double) 4,(double) 8,(double) 16,(double) 32,(double) 64,(double) 128,(double) 256,(double) 512,(double) 1024,(double) 2048,(double) 4096,(double) 8192,(double) 16384,(double) 32768};
		    				boolean isVaildColor = false;
		    				for (int i = 0; i < vaildColors.length; i++) {
								if(arguments[0].equals(vaildColors[i])){
									isVaildColor = true;
								}
							}
		    				if(isVaildColor) {
		    					setColor(new Double(arguments[0].toString()));
		    				} else {
		    					throw new LuaException("invalid color");
		    				}
	    				} else {
	    					throw new LuaException("bad argument (expected number)");
	    				}
	    			}
	    		}
	    		case 1: {
	    			return new Object[] {(double)getColor()};
	    		}
	    	}
	    	return new Object[0];
	    }
     	
		@Override
		public boolean equals(IPeripheral other) {
			return peripheral.equals(other);
		}
		
		public double getColor() {
			int colorID = (int)worldObj.getBlockState(pos).getValue(notiBlock.COLOR).intValue();
			int colorCode;
			switch(colorID) {
				case 0: {colorCode = 32768; break;}
				case 1: {colorCode = 1; break;}
				case 2: {colorCode = 2; break;}
				case 3: {colorCode = 4; break;}
				case 4: {colorCode = 8; break;}
				case 5: {colorCode = 16; break;}
				case 6: {colorCode = 32; break;}
				case 7: {colorCode = 64; break;}
				case 8: {colorCode = 128; break;}
				case 9: {colorCode = 256; break;}
				case 10: {colorCode = 512; break;}
				case 11: {colorCode = 1024; break;}
				case 12: {colorCode = 2048; break;}
				case 13: {colorCode = 4096; break;}
				case 14: {colorCode = 8102; break;}
				case 15: {colorCode = 16384; break;}
				default: {colorCode = 32768; break;}
			}
			return (double)colorCode;
		}
		
		public boolean setColor(double color) {
			int colorID;
			switch((int)color) {
				case 1: {colorID = 15; break;}
				case 2: {colorID = 1; break;}
				case 4: {colorID = 2; break;}
				case 8: {colorID = 3; break;}
				case 16: {colorID = 4; break;}
				case 32: {colorID = 5; break;}
				case 64: {colorID = 6; break;}
				case 128: {colorID = 7; break;}
				case 256: {colorID = 8; break;}
				case 512: {colorID = 9; break;}
				case 1024: {colorID = 10; break;}
				case 2048: {colorID = 11; break;}
				case 4096: {colorID = 12; break;}
				case 8192: {colorID = 13; break;}
				case 16384: {colorID = 14; break;}
				case 32768: {colorID = 0; break;}
				default: {colorID = 0; break;}
			}
			worldObj.setBlockState(this.pos, worldObj.getBlockState(this.pos) .withProperty(notiBlock.COLOR, Integer.valueOf(colorID)));
			return true;
		}
		
}
