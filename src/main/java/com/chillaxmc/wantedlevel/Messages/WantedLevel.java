package com.chillaxmc.wantedlevel.Messages;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class WantedLevel implements IMessage {
    // A default constructor is always required
    public WantedLevel(){}

    public int getToSend() {
        return toSend;
    }

    public void setToSend(int toSend) {
        this.toSend = toSend;
    }

    private int toSend;
    public WantedLevel(int toSend) {
        this.toSend = toSend;
    }

    @Override public void toBytes(ByteBuf buf) {
        // Writes the int into the buf
        buf.writeInt(toSend);
    }

    @Override public void fromBytes(ByteBuf buf) {
        // Reads the int back from the buf. Note that if you have multiple values, you must read in the same order you wrote.
        toSend = buf.readInt();
    }
}