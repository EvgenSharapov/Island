package org.example.island;

import org.example.animals.Animal;
import org.example.animals.poolAnimals.Rabbit;
import org.example.animals.poolAnimals.Wolf;

public class FactoryAnimals {
    AnimalCharacters animalCharacters=new AnimalCharacters();
    public Animal create(String type){
        switch (type){
            case "Wolf":return new Wolf(animalCharacters.WOLF_WEIGHT,false,false,1);
            case "Rabbit":return new Rabbit(animalCharacters.RABBIT_WEIGHT,false,false,1);
            default:return null;
        }
    }
}
