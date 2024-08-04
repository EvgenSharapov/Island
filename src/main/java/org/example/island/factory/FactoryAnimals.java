package org.example.island.factory;

import org.example.animals.Animal;
import org.example.animals.poolAnimals.*;
import static org.example.island.characters.AnimalCharacters.*;
import static org.example.island.characters.IslandCharacters.*;


public class FactoryAnimals {
    public Animal create(String type){
        switch (type){
            case "Wolf":return new Wolf(WOLF_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "Rabbit":return new Rabbit(RABBIT_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "Fox":return new Fox(FOX_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "Boa":return new Boa(BOA_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "Eagle":return new Eagle(EAGLE_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "Duck":return new Duck(DUCK_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "Bear":return new Bear(BEAR_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "Horse":return new Horse(HORSE_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "Deer":return new Deer(DEER_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "Mouse":return new Mouse(MOUSE_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "Goat":return new Goat(GOAT_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "Sheep":return new Sheep(SHEEP_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "WildBoar":return new WildBoar(WILD_BOAR_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            case "Buffalo":return new Buffalo(BUFFALO_WEIGHT,false,START_IS_REPRODUCTION,START_AGE);
            default:return null;
        }
    }
}
