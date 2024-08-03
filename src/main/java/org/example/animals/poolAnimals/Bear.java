package org.example.animals.poolAnimals;

import org.example.animals.Predator;

public class Bear extends Predator {

    public Bear(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age);
    }

    @Override
    public String toString() {
        return "Bear";}

}
