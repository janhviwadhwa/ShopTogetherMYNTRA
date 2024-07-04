package com.abc.shoptogethermyntra;

public class Dress {
    private int index;
    private int heartCount;
    private int starCount;

    public Dress(int index, int heartCount, int starCount) {
        this.index = index;
        this.heartCount = heartCount;
        this.starCount = starCount;
    }

    public int getHeartCount() {
        return heartCount;
    }

    public void setHeartCount(int heartCount) {
        this.heartCount = heartCount;
    }

    public int getStarCount() {
        return starCount;
    }

    public void setStarCount(int starCount) {
        this.starCount = starCount;
    }
}
