package org.example.animals;

import org.example.island.ChanceToEat;
import org.example.island.Randomizer;

public abstract class Animal {
    protected double weight;
    protected int maxInCage;
    protected int maxSpeed;
    protected double maxEat;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private boolean isEat;
    private boolean isReproduction;
    private int age;
    private ChanceToEat chanceToEat=new ChanceToEat();


    public boolean isReproduction() {
        return isReproduction;
    }

    public void setReproduction(boolean reproduction) {
        isReproduction = reproduction;
    }

    public Animal(double weight, boolean isEat, boolean isReproduction,int age) {
        this.weight = weight;
        this.isEat=isEat;
        this.isReproduction=isReproduction;
        this.age=age;

    }

    public boolean isEat() {
        return isEat;
    }

    public void setEat(boolean eat) {
        isEat = eat;
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;

    }

    public boolean eat(Animal animal){
        if(chanceToEat.chanceEat(this,animal)> Randomizer.getInstance().randomizer(100)+1){
        return true;}
        else return false;
    }
    public void move(){

    }
    public void reproduction(Animal animal){
        if(this.toString().equals(animal.toString())){this.isReproduction=true;animal.isReproduction=true;}

    }
    public void death(){}
}
