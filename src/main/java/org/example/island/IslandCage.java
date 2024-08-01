package org.example.island;

import org.example.animals.Animal;

import java.util.ArrayList;
import java.util.Random;

public class IslandCage {
    FactoryAnimals factory=new FactoryAnimals();
    public ArrayList<Animal>animalsInCage;
    AnimalCharacters animalCharacters=new AnimalCharacters();
    private int x;
    private int y;

    public IslandCage(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public ArrayList<Animal> getRandAnimalsInCage() {
        ArrayList<Animal>animals=new ArrayList<>();
            Random r = new Random();
        for (String str:animalCharacters.animals.keySet()){
            int random= r.nextInt(animalCharacters.animals.get(str));
            if(random!=0){
                for(int i=1;i<=random;i++){
                    animals.add(factory.create(str));
                }
            }
        }

        return animals;
    }
}

