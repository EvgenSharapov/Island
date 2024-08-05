package org.example.animals;

import org.example.island.ChanceToEat;
import org.example.island.Randomizer;
import org.example.vegetation.Vegetation;

public abstract class Predator extends Animal{
    public Predator(double weight,boolean isEat,boolean isReproduction,int age,double maxEat) {
        super(weight,isEat,isReproduction,age,maxEat);
    }

    @Override
    public boolean eat(Animal animal) {
        return super.eat(animal);
    }
}
