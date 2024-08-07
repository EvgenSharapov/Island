package org.example.vegetation;

import org.example.island.Randomizer;
import org.example.island.factory.FactoryVegetation;

import static org.example.island.characters.IslandCharacters.*;

public abstract class Vegetation {
    FactoryVegetation factoryVegetation=new FactoryVegetation();
    private double weight;
    private boolean isReproduction;
    public Vegetation(double weight, boolean isReproduction) {
        this.weight = weight;
        this.isReproduction=isReproduction;

    }
    public double getWeight() {
        return weight;
    }
    public boolean isReproduction() {
        return isReproduction;
    }
    public void setReproduction(boolean reproduction) {
        isReproduction = reproduction;
    }
    public boolean reproduction(){
       if(CHANCE_REPRODUCTION_VEGETATION> Randomizer.getInstance().randomizer(9)&&this.isReproduction==false)
        {this.setReproduction(true);return true;
        }
       else this.setReproduction(true);return false;
    }
}
