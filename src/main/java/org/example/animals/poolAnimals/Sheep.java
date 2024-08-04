package org.example.animals.poolAnimals;

import org.example.animals.Herbivore;
import org.example.island.characters.AnimalCharacters;

public class Sheep extends Herbivore {
    public Sheep(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age, AnimalCharacters.getInstance().SHEEP_MAX_EAT);
    }

    @Override
    public String toString() {
        return "Sheep";
    }
}
