package org.example.animals.poolAnimals;

import org.example.animals.Herbivore;
import org.example.island.characters.AnimalCharacters;

public class Duck extends Herbivore {
    public Duck(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age,AnimalCharacters.getInstance().DUCK_MAX_EAT);
    }

    @Override
    public String toString() {
        return "Duck";
    }
}
