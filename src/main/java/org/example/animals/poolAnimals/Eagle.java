package org.example.animals.poolAnimals;

import org.example.animals.Predator;
import org.example.island.characters.AnimalCharacters;

public class Eagle extends Predator {

    public Eagle(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age,AnimalCharacters.getInstance().EAGLE_MAX_EAT);
    }

    @Override
    public String toString() {
        return "Eagle";}

}
