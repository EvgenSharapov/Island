package org.example.animals.poolAnimals;

import org.example.animals.Herbivore;
import org.example.island.characters.AnimalCharacters;
import org.example.vegetation.Vegetation;

public class Bug extends Herbivore {
    public Bug(double weight, boolean isEat, boolean isReproduction, int age) {
        super(weight, isEat, isReproduction, age, AnimalCharacters.BUG_MAX_EAT);
    }
    @Override
    public String toString() {
        return "Bug";
    }

    @Override
    public boolean eat(Vegetation vegetation) {
        super.setEat(true);
        return false;
    }
}
