package org.example.island.characters;

public class IslandCharacters {
    private static IslandCharacters ourInstance = new IslandCharacters();

    public static IslandCharacters getInstance() {
        return ourInstance;
    }
    private IslandCharacters() {
    }
    public static final int CHANCE_REPRODUCTION=2;//30%
    public static final int CHANCE_REPRODUCTION_VEGETATION=9;//90%
    public static final int START_AGE=1;
    public static final int DEATH_AGE=12;
    public static final int DEATH_WEIGHT=65;//65%
    public static final double WEIGHT_LOSS_PER_TURN=0.9;
    public static final boolean START_IS_REPRODUCTION=false;

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

}
