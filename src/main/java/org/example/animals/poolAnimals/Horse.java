package org.example.animals.poolAnimals;

import org.example.animals.Herbivore;
import org.example.island.characters.AnimalCharacters;

public class Horse extends Herbivore {
    public Horse(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age,AnimalCharacters.getInstance().HORSE_MAX_EAT);
    }

    @Override
    public String toString() {
        return "Horse";
    }
}
