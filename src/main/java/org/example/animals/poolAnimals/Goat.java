package org.example.animals.poolAnimals;

import org.example.animals.Herbivore;
import org.example.island.characters.AnimalCharacters;

public class Goat extends Herbivore {
    public Goat(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age, AnimalCharacters.getInstance().GOAT_MAX_EAT);
    }

    @Override
    public String toString() {
        return "Goat";
    }
}
