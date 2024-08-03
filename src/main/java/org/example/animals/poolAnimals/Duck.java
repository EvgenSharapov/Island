package org.example.animals.poolAnimals;

import org.example.animals.Herbivore;

public class Duck extends Herbivore {
    public Duck(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age);
    }

    @Override
    public String toString() {
        return "Duck";
    }
}
