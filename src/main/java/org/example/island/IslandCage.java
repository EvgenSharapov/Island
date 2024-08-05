package org.example.island;

import org.example.animals.Animal;
import org.example.island.characters.AnimalCharacters;
import org.example.island.characters.VegetationCharacters;
import org.example.island.factory.FactoryAnimals;
import org.example.island.factory.FactoryVegetation;
import org.example.vegetation.Vegetation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class IslandCage {
    FactoryAnimals factory=new FactoryAnimals();
    FactoryVegetation factoryVegetation=new FactoryVegetation();
    public ArrayList<Animal>animalsInCage;
    private int x;
    private int y;

    public IslandCage(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public ArrayList<Animal> getRandAnimalsInCage() {
        ArrayList<Animal>animals=new ArrayList<>();
        for (String str:AnimalCharacters.getInstance().animalsCage.keySet()){
            int random= Randomizer.getInstance().randomizer(AnimalCharacters.getInstance().animalsCage.get(str));
            if(random!=0){
                for(int i=1;i<=random;i++){
                    animals.add(factory.create(str));
                }
            }
        }
        Collections.shuffle(animals);
        return animals;
    }
    public ArrayList<Vegetation> getRandVegetationInCage() {
        ArrayList<Vegetation>vegetation=new ArrayList<>();
        for (String str: VegetationCharacters.getInstance().vegetationInCage.keySet()){
            int random= Randomizer.getInstance().randomizer(VegetationCharacters.getInstance().vegetationInCage.get(str));
            if(random!=0){
                for(int i=1;i<=random;i++){
                    vegetation.add(factoryVegetation.create(str));
                }
            }
        }
        Collections.shuffle(vegetation);
        return vegetation;
    }


}

