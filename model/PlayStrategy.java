package model;

public interface PlayStrategy {
    int getDelay();  // delay in millisecond
    int getScoreBonus();
    int getFPS();
    String getName();
}

