package com.chillaxmc.wantedlevel.capability;

public class Wanted implements IWanted {

    private int wanted = 0;
    private final int MAX_WANTED = 5;
    private final int MIN_WANTED = 0;

    public void add(int points) {
        if((this.wanted + points) >= MAX_WANTED){
            this.wanted = MAX_WANTED;
        } else {
            this.wanted += points;
        }
    }

    public void remove(int points) {
        if((this.wanted - points) <= MIN_WANTED){
            this.wanted = MIN_WANTED;
        } else {
            this.wanted -= points;
        }
    }

    public void set(int points) {
        if(points >= MAX_WANTED)
            this.wanted = MAX_WANTED;
        else if(points <= MIN_WANTED)
            this.wanted = MIN_WANTED;
        else
            this.wanted = points;
    }

    public void clear(int points) {
        this.wanted = MIN_WANTED;
    }

    public int getWanted() {
        return this.wanted;
    }

}
