package org.example.animals;

import org.example.vegetation.Vegetation;

public abstract class Herbivore extends Animal{

    public Herbivore(double weight,boolean isEat,boolean isReproduction,int age,double maxEat) {
        super(weight,isEat,isReproduction,age,maxEat);
    }

    @Override
    public boolean eat(Vegetation vegetation) {
        return super.eat(vegetation);
    }
}
