package org.example.island.characters;

public class IslandCharacters {
    private static IslandCharacters ourInstance = new IslandCharacters();

    public static IslandCharacters getInstance() {
        return ourInstance;
    }
    private IslandCharacters() {
    }
    public static final int CHANCE_REPRODUCTION=3;//40%
    public static final int CHANCE_REPRODUCTION_VEGETATION=9;//100%
    public static final int MAX_START_AGE=9;
    public static final int DEATH_AGE=10;
    public static final int DEATH_WEIGHT=65;//65%
    public static final double WEIGHT_LOSS_PER_TURN=0.94;
    public static final boolean START_IS_REPRODUCTION=false;

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;

}
