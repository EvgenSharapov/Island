package org.example.animals;

import org.example.island.ChanceToEat;
import org.example.island.Randomizer;
import org.example.island.characters.AnimalCharacters;
import org.example.vegetation.Vegetation;

public abstract class Animal {
    private double weight;
    private double maxEat;
    private boolean isEat;
    private boolean isReproduction;
    private int age;
    private Direction direction;
    private int speed;
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

    public Direction getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean eat(Vegetation vegetation){
        if(this instanceof Herbivore){
            return true;}
        else return false;
    }


    public void move(){
      this.direction=Randomizer.getInstance().randomDirection();
      this.speed=Randomizer.getInstance().randomizer(AnimalCharacters.getInstance().animalsSpeed.get(this.toString()));
    }
    public boolean reproduction(Animal animal){
        if(this.toString().equals(animal.toString())&&(this.isReproduction==false&&animal.isReproduction==false)){this.setReproduction(true);animal.setReproduction(true);return true;}
        return false;
    }
    public void death(){}

}
