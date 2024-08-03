package org.example.island;

import org.example.animals.Animal;
import org.example.animals.poolAnimals.*;
import org.example.island.characters.AnimalCharacters;

public class FactoryAnimals {
    AnimalCharacters animalCharacters=new AnimalCharacters();
    public Animal create(String type){
        switch (type){
            case "Wolf":return new Wolf(animalCharacters.WOLF_WEIGHT,false,false,1);
            case "Rabbit":return new Rabbit(animalCharacters.RABBIT_WEIGHT,false,false,1);
            case "Fox":return new Fox(animalCharacters.FOX_WEIGHT,false,false,1);
            case "Boa":return new Boa(animalCharacters.BOA_WEIGHT,false,false,1);
            case "Eagle":return new Eagle(animalCharacters.EAGLE_WEIGHT,false,false,1);
            case "Duck":return new Duck(animalCharacters.DUCK_WEIGHT,false,false,1);
            case "Bear":return new Bear(animalCharacters.BEAR_WEIGHT,false,false,1);
            default:return null;
        }
    }
}
