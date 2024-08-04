package org.example.island;

import org.example.animals.Animal;
import org.example.island.characters.AnimalCharacters;
import org.example.island.factory.FactoryAnimals;

import java.util.ArrayList;
import java.util.Random;

public class IslandCage {
    FactoryAnimals factory=new FactoryAnimals();
    public ArrayList<Animal>animalsInCage;
    private int x;
    private int y;

    public IslandCage(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList<Animal> getRandAnimalsInCage() {
        ArrayList<Animal>animals=new ArrayList<>();
            Random r = new Random();
        for (String str:AnimalCharacters.getInstance().animalsCage.keySet()){
            int random= r.nextInt(AnimalCharacters.getInstance().animalsCage.get(str));
            if(random!=0){
                for(int i=1;i<=random;i++){
                    animals.add(factory.create(str));
                }
            }
        }
        return animals;
    }

}

