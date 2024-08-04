package org.example.animals.poolAnimals;

import org.example.animals.Predator;
import org.example.island.characters.AnimalCharacters;

public class Boa extends Predator {

    public Boa(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age,AnimalCharacters.getInstance().BOA_MAX_EAT);
    }

    @Override
    public String toString() {
        return "Boa";}

}

