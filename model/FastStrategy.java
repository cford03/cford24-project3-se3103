package model;

public class FastStrategy implements PlayStrategy {
    @Override
    public int getDelay() {
        return 100; // Fast speed
    }

    @Override
    public int getScoreBonus() {
        return 20;
    }

    @Override
    public int getFPS() {
        return 12;
    }

    @Override
    public String getName() {
        return "FAST";
    }

}
