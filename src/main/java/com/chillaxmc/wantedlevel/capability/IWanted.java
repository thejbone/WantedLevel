package com.chillaxmc.wantedlevel.capability;

public interface IWanted {

    public void add(int points);
    public void remove(int points);
    public void set(int points);
    public void clear(int points);

    public int getWanted();

}
