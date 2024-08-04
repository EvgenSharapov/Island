package org.example.animals.poolAnimals;

import org.example.animals.Herbivore;
import org.example.island.characters.AnimalCharacters;

public class WildBoar extends Herbivore {
    public WildBoar(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age, AnimalCharacters.getInstance().WILD_BOAR_MAX_EAT);
    }

    @Override
    public String toString() {
        return "WildBoar";
    }
}
