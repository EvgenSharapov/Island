package org.example.island;

import org.example.animals.Animal;
import org.example.island.characters.AnimalCharacters;
import org.example.island.characters.VegetationCharacters;
import org.example.island.factory.FactoryAnimals;
import org.example.island.factory.FactoryVegetation;
import org.example.vegetation.Vegetation;

import java.util.ArrayList;
import java.util.Collections;
import static org.example.island.characters.IslandCharacters.*;

public class IslandCage {
    public ArrayList<Animal> getRandAnimalsInCageStart() {
        ArrayList<Animal>animals=new ArrayList<>();
        for (String str:AnimalCharacters.getInstance().animalsCage.keySet()){
            int population=AnimalCharacters.getInstance().animalsCage.get(str)*START_POPULATION_ANIMAL;
            if(population<200){population=200;}
            int random= Randomizer.getInstance().randomizer(population/100);
            if(random!=0){
                for(int i=0;i<=random;i++){
                    animals.add(FactoryAnimals.create(str));
                }
            }
        }
        Collections.shuffle(animals);
        return animals;
    }
    public ArrayList<Vegetation> getRandVegetationInCageStart() {
        ArrayList<Vegetation>vegetation=new ArrayList<>();
        for (String str: VegetationCharacters.getInstance().vegetationInCage.keySet()){
            int population=VegetationCharacters.getInstance().vegetationInCage.get(str)*START_POPULATION_VEGETATION;

            if(population<100){population=100;}
            int random= Randomizer.getInstance().randomizer(population/100);
            if(random!=0){
                for(int i=0;i<=random;i++){
                    vegetation.add(FactoryVegetation.create(str));
                }
            }
        }
        Collections.shuffle(vegetation);
        return vegetation;
    }


}

