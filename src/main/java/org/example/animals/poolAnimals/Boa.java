package org.example.animals.poolAnimals;

import org.example.animals.Predator;

public class Boa extends Predator {

    public Boa(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age);
    }

    @Override
    public String toString() {
        return "Boa";}

}

