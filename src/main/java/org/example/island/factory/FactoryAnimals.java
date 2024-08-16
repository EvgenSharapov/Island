package org.example.island.factory;

import org.example.animals.Animal;
import org.example.animals.pooll.*;

import static org.example.island.characters.AnimalCharacters.*;
import static org.example.island.characters.IslandCharacters.*;


public class FactoryAnimals {
    public static Animal create(String type){
        switch (type){
            case "Wolf":return new Wolf(WOLF_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Rabbit":return new Rabbit(RABBIT_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Fox":return new Fox(FOX_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Boa":return new Boa(BOA_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Eagle":return new Eagle(EAGLE_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Duck":return new Duck(DUCK_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Bear":return new Bear(BEAR_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Horse":return new Horse(HORSE_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Deer":return new Deer(DEER_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Mouse":return new Mouse(MOUSE_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Goat":return new Goat(GOAT_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Sheep":return new Sheep(SHEEP_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "WildBoar":return new WildBoar(WILD_BOAR_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Buffalo":return new Buffalo(BUFFALO_WEIGHT,false,START_IS_REPRODUCTION,0);
            case "Bug":return new Bug(BUG_WEIGHT,false,START_IS_REPRODUCTION,0);
            default:return null;
        }
    }
}
