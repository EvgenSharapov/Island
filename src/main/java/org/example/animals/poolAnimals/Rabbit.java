package org.example.animals.poolAnimals;

import org.example.animals.Herbivore;

public class Rabbit extends Herbivore {
    public Rabbit(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age);
    }

    @Override
    public String toString() {
        return "Rabbit";
    }
}
