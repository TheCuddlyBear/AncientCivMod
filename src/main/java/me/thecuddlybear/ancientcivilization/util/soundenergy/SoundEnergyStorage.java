package me.thecuddlybear.ancientcivilization.util.soundenergy;

import me.thecuddlybear.ancientcivilization.util.capability.ISoundEnergyStorage;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.util.INBTSerializable;

public class SoundEnergyStorage implements ISoundEnergyStorage, INBTSerializable<Tag> {

    protected int energy;
    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;

    public SoundEnergyStorage(int capacity){this(capacity, capacity, capacity, 0);}

    public SoundEnergyStorage(int capacity, int maxTransfer) {this(capacity, maxTransfer, maxTransfer, 0);}

    public SoundEnergyStorage(int capacity, int maxReceive, int maxExtract) {this(capacity, maxReceive, maxExtract, 0);}

    public SoundEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy){
        this.capacity = capacity;
        this.maxExtract = maxExtract;
        this.maxReceive = maxReceive;
        this.energy = energy;
    }

    @Override
    public int receiveSoundEnergy(int maxReceive, boolean simulate) {
        if(!canReceive()) return 0;

        int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));
        if(!simulate){
            energy += energyReceived;
        }
        return energyReceived;
    }

    @Override
    public int extractSoundEnergy(int maxExtract, boolean simulate) {
        if(!canExtract()) return 0;

        int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));
        if(!simulate){
            energy -= energyExtracted;
        }
        return energyExtracted;
    }

    @Override
    public int getSoundEnergyStored() {
        return energy;
    }

    @Override
    public int getMaxEnergyStored() {
        return capacity;
    }

    @Override
    public boolean canExtract() {
        return this.maxExtract > 0;
    }

    @Override
    public boolean canReceive() {
        return this.maxReceive > 0;
    }

    @Override
    public Tag serializeNBT() {
        return IntTag.valueOf(this.getSoundEnergyStored());
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        if(!(nbt instanceof IntTag intNbt)) throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
        this.energy = intNbt.getAsInt();
    }
}
