package com.chillaxmc.wantedlevel.storage;

import com.chillaxmc.wantedlevel.capability.IWanted;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class WantedStorage implements Capability.IStorage<IWanted> {

    @Nullable
    @Override
    public NBTBase writeNBT(Capability capability, IWanted instance, EnumFacing side) {
        System.out.println("Writing wanted " + instance.getWanted());
        return new NBTTagInt(instance.getWanted());
    }

    @Override
    public void readNBT(Capability capability, IWanted instance, EnumFacing side, NBTBase nbt) {
        int thevalue = ((NBTPrimitive) nbt).getInt();
        System.out.println("Reading wanted " + thevalue);
        instance.set(thevalue);
    }
}
