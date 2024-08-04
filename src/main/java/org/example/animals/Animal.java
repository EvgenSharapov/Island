package org.example.animals;

import org.example.island.ChanceToEat;
import org.example.island.Randomizer;

public abstract class Animal {
    protected double weight;
    protected int maxInCage;
    protected int maxSpeed;
    protected double maxEat;
    private boolean isEat;
    private boolean isReproduction;
    private int age;
    private ChanceToEat chanceToEat=new ChanceToEat();
    public Animal(double weight, boolean isEat, boolean isReproduction,int age,double maxEat) {
        this.weight = weight;
        this.isEat=isEat;
        this.isReproduction=isReproduction;
        this.age=age;
        this.maxEat=maxEat;

    }

    public double getMaxEat() {
        return maxEat;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }




    public boolean isReproduction() {
        return isReproduction;
    }

    public void setReproduction(boolean reproduction) {
        isReproduction = reproduction;
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
    public boolean reproduction(Animal animal){
        if(this.toString().equals(animal.toString())&&(this.isReproduction==false&&animal.isReproduction==false)){this.setReproduction(true);animal.setReproduction(true);return true;}
        return false;
    }
    public void death(){}
}
