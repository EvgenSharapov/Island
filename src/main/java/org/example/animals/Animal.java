package org.example.animals;

public abstract class Animal {
    protected double weight;
    protected int maxInCage;
    protected int maxSpeed;
    protected double maxEat;
    protected int x;
    protected int y;

    public Animal() {
        this.weight = weight;
        this.maxInCage = maxInCage;
        this.maxSpeed = maxSpeed;
        this.maxEat = maxEat;
    }


    public void eat(){}
    public void move(){

    }
    public void reproduction(){}
    public void death(){}
}
