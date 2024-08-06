package org.example.island.characters;

import org.example.vegetation.Vegetation;

import java.util.HashMap;
import java.util.Map;

public class VegetationCharacters {
    private static VegetationCharacters ourInstance = new VegetationCharacters() {
    };

    public static VegetationCharacters getInstance() {
        return ourInstance;
    }
    private VegetationCharacters() {
    }


    public Map<String, Integer> vegetationInCage = new HashMap<>() {{
        put(HERB_NAME, HERB_MAX_IN_CAGE);
        put(BERRIES_NAME, BERRIES_MAX_IN_CAGE);
        put(MUSHROOM_NAME,MUSHROOM_MAX_IN_CAGE);
    }};

    public static final String HERB_NAME="Herb";
    public static final double HERB_WEIGHT=5;
    public static final int HERB_MAX_IN_CAGE=1200;
    public static final String BERRIES_NAME="Berries";
    public static final double BERRIES_WEIGHT=15;
    public static final int BERRIES_MAX_IN_CAGE=1200;
    public static final String MUSHROOM_NAME="Mushroom";
    public static final double MUSHROOM_WEIGHT=25;
    public static final int MUSHROOM_MAX_IN_CAGE=1200;

}
