package org.example.island.characters;

public class IslandCharacters {
    private static IslandCharacters ourInstance = new IslandCharacters();

    public static IslandCharacters getInstance() {
        return ourInstance;
    }
    private IslandCharacters() {
    }
    public static final int CHANCE_REPRODUCTION=4;//40%
    public static final int CHANCE_REPRODUCTION_VEGETATION=5;//40%
    public static final int DEATH_AGE=10;
    public static final int DEATH_WEIGHT=65;//65%
    public static final double WEIGHT_LOSS_PER_TURN=0.93;//10%
    public static final boolean START_IS_REPRODUCTION=false;

    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public static final int NUMBER_TURN_SIMULATION_ISLAND=60;
    public static final int START_POPULATION_ANIMAL=15;//5%

    public static final int START_POPULATION_VEGETATION=40;//23%
    public static final int POPULATION_VEGETATION_IN_EMPTY=10;//5%
}
