package net.coolgametube.computercraft.peripherals.notifications;

import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class notiBlock extends BlockContainer implements IPeripheralProvider, ITileEntityProvider{
	public notiBlock() {
		super(Material.glass);
		this.setUnlocalizedName("notifyBlock");
		this.setLightLevel(.0f);
		this.isBlockContainer = true;
		this.setCreativeTab(CreativeTabs.tabAllSearch);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		GameRegistry.registerTileEntity(TileEntityNotiBlock.class, "notifyBlock");
	}
	
	/*@Override
	public boolean hasTileEntity() {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityNotiBlock();
	}*/
	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		return new TileEntityNotiBlock();
	}
	
	public static final PropertyInteger COLOR = PropertyInteger.create("color", 0, 15);
	@Override
	protected BlockState createBlockState() {
		return new BlockState(this, new IProperty[] {COLOR});
	}
	
	@Override
	public int getRenderType() {
		return 3;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		if(meta==0){
			if(!(this.getLightValue() == .0f)){
				this.setLightLevel(.0f);
			}
		}else {
			if(!(this.getLightValue() == 1f)){
				this.setLightLevel(1f);
			}
		}
	    return getDefaultState().withProperty(COLOR, Integer.valueOf(meta));
	}


	@Override
	public int getMetaFromState(IBlockState state)
	{
	    return ((Integer)state.getValue(COLOR)).intValue();
	}
	
	public Block setLightOpacity(int f) {
		this.lightOpacity = f;
		return this;
	}
	
	@Override
	public IPeripheral getPeripheral(World world, BlockPos pos, EnumFacing side) {
		TileEntity entity = world.getTileEntity(pos);
		if (entity instanceof TileEntityNotiBlock) {
		return (IPeripheral)entity;
		}
		return null;
	}
}
