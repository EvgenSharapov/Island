package org.example.island;

import org.example.animals.Animal;
import org.example.animals.Rabbit;
import org.example.animals.Wolf;

public class FactoryAnimals {
    public Animal create(String type){
        switch (type){
            case "Wolf":return new Wolf();
            case "Rabbit":return new Rabbit();
            default:return null;
        }
    }
}
