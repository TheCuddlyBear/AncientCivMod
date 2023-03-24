package me.thecuddlybear.ancientcivilization.block;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.BlockPositionSource;
import net.minecraft.world.level.gameevent.vibrations.VibrationListener;
import org.slf4j.Logger;

public class SculkEnergyStorageBlockEntity extends BlockEntity implements VibrationListener.VibrationListenerConfig {
    private static final Logger LOGGER = LogUtils.getLogger();
    private VibrationListener listener;
    private int lastVibrationFrequency;

    public SculkEnergyStorageBlockEntity(BlockPos pPos, BlockState pBlockState){
        super(BlockEntityType.SCULK_SENSOR, pPos, pBlockState);
        this.listener = new VibrationListener(new BlockPositionSource(this.worldPosition), ((SculkEnergyStorageBlock)pBlockState.getBlock()).getListenerRange(), this);
    }


}
