package org.example.animals.pooll;

import org.example.animals.Predator;
import org.example.island.characters.AnimalCharacters;

public class Wolf extends Predator {

    public Wolf(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age,AnimalCharacters.getInstance().WOLF_MAX_EAT);
    }

    @Override
    public String toString() {
        return "Wolf";}

}
