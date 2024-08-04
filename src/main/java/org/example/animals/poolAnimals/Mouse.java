package org.example.animals.poolAnimals;

import org.example.animals.Herbivore;
import org.example.island.characters.AnimalCharacters;

public class Mouse extends Herbivore {
    public Mouse(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age, AnimalCharacters.getInstance().DEER_MAX_EAT);
    }

    @Override
    public String toString() {
        return "Mouse";
    }
}

