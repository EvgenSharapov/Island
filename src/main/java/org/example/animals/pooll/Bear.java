package org.example.animals.pooll;

import org.example.animals.Predator;
import org.example.island.characters.AnimalCharacters;

public class Bear extends Predator {
    public Bear(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age,AnimalCharacters.getInstance().BEAR_MAX_EAT);
    }

    @Override
    public String toString() {
        return "Bear";}

}
