package org.example.island.factory;
import org.example.vegetation.Berries;
import org.example.vegetation.Herb;
import org.example.vegetation.Mushroom;
import org.example.vegetation.Vegetation;

import static org.example.island.characters.IslandCharacters.*;
import static org.example.island.characters.VegetationCharacters.*;

public class FactoryVegetation {
    public static Vegetation create(String type) {
        switch (type) {
            case "Herb":
                return new Herb(HERB_WEIGHT, START_IS_REPRODUCTION);
            case "Mushroom":
                return new Mushroom(MUSHROOM_WEIGHT, START_IS_REPRODUCTION);
            case "Berries":
                return new Berries(BERRIES_WEIGHT, START_IS_REPRODUCTION);
            default:
                return null;
        }
    }
}
