package com.chillaxmc.wantedlevel.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class WantedProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(IWanted.class)
    public static final Capability<IWanted> WANTED_CAP = null;
    private IWanted instance = WANTED_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == WANTED_CAP;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == WANTED_CAP ? WANTED_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return WANTED_CAP.getStorage().writeNBT(WANTED_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        WANTED_CAP.getStorage().readNBT(WANTED_CAP, this.instance, null, nbt);
    }
}
