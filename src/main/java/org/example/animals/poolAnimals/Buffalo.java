package org.example.animals.poolAnimals;

import org.example.animals.Herbivore;
import org.example.island.characters.AnimalCharacters;

public class Buffalo extends Herbivore {
    public Buffalo(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age, AnimalCharacters.getInstance().BUFFALO_MAX_EAT);
    }

    @Override
    public String toString() {
        return "Buffalo";
    }
}
