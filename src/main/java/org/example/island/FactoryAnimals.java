package org.example.island;

import org.example.animals.Animal;
import org.example.animals.poolAnimals.*;
import org.example.island.characters.AnimalCharacters;

public class FactoryAnimals {
    public Animal create(String type){
        switch (type){
            case "Wolf":return new Wolf(AnimalCharacters.getInstance().WOLF_WEIGHT,false,false,1);
            case "Rabbit":return new Rabbit(AnimalCharacters.getInstance().RABBIT_WEIGHT,false,false,1);
            case "Fox":return new Fox(AnimalCharacters.getInstance().FOX_WEIGHT,false,false,1);
            case "Boa":return new Boa(AnimalCharacters.getInstance().BOA_WEIGHT,false,false,1);
            case "Eagle":return new Eagle(AnimalCharacters.getInstance().EAGLE_WEIGHT,false,false,1);
            case "Duck":return new Duck(AnimalCharacters.getInstance().DUCK_WEIGHT,false,false,1);
            case "Bear":return new Bear(AnimalCharacters.getInstance().BEAR_WEIGHT,false,false,1);
            case "Horse":return new Horse(AnimalCharacters.getInstance().HORSE_WEIGHT,false,false,1);
            case "Deer":return new Deer(AnimalCharacters.getInstance().DEER_WEIGHT,false,false,1);
            case "Mouse":return new Mouse(AnimalCharacters.getInstance().MOUSE_WEIGHT,false,false,1);
            case "Goat":return new Goat(AnimalCharacters.getInstance().GOAT_WEIGHT,false,false,1);
            case "Sheep":return new Sheep(AnimalCharacters.getInstance().SHEEP_WEIGHT,false,false,1);
            case "WildBoar":return new WildBoar(AnimalCharacters.getInstance().WILD_BOAR_WEIGHT,false,false,1);
            case "Buffalo":return new Buffalo(AnimalCharacters.getInstance().BUFFALO_WEIGHT,false,false,1);
            default:return null;
        }
    }
}
