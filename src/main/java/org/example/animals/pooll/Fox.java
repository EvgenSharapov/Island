package org.example.animals.pooll;

import org.example.animals.Predator;
import org.example.island.characters.AnimalCharacters;

public class Fox extends Predator {

    public Fox(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age,AnimalCharacters.getInstance().FOX_MAX_EAT);
    }

    @Override
    public String toString() {
        return "Fox";}

}

