package org.example.animals.poolAnimals;

import org.example.animals.Herbivore;
import org.example.island.characters.AnimalCharacters;

public class Rabbit extends Herbivore {
    public Rabbit(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age,AnimalCharacters.getInstance().RABBIT_MAX_EAT);
    }

    @Override
    public String toString() {
        return "Rabbit";
    }
}
