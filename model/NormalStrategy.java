package model;

public class NormalStrategy implements PlayStrategy {
    @Override
    public int getDelay() {
        return 250; // Normal speed
    }

    @Override
    public int getScoreBonus() {
        return 10;
    }

    @Override
    public int getFPS() {
        return 4;
    }

    @Override
    public String getName() {
        return "NORMAL";
    }

}
