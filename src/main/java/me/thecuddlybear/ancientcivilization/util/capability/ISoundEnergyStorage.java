package me.thecuddlybear.ancientcivilization.util.capability;

import net.minecraftforge.common.capabilities.AutoRegisterCapability;

@AutoRegisterCapability
public interface ISoundEnergyStorage {

    int receiveSoundEnergy(int maxReceive, boolean simulate);

    int extractSoundEnergy(int maxExtract, boolean simulate);

    int getSoundEnergyStored();

    int getMaxEnergyStored();

    boolean canExtract();

    boolean canReceive();

}
