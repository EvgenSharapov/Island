package org.example.animals;

public abstract class Predator extends Animal{
    private double weight;
    public Predator(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age);
    }
}
