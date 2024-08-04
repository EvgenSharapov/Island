package org.example.island.characters;

public class IslandCharacters {
    private static IslandCharacters ourInstance = new IslandCharacters();

    public static IslandCharacters getInstance() {
        return ourInstance;
    }
    private IslandCharacters() {
    }
    public static final int CHANCE_REPRODUCTION=2;//30%
    public static final int START_AGE=1;

    public static final int WIDTH = 9;
    public static final int HEIGHT = 9;

}
