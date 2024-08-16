package org.example.animals.pooll;

import org.example.animals.Animal;
import org.example.animals.Herbivore;
import org.example.island.Randomizer;
import org.example.island.characters.AnimalCharacters;

public class WildBoar extends Herbivore {
    public WildBoar(double weight,boolean isEat,boolean isReproduction,int age) {
        super(weight,isEat,isReproduction,age, AnimalCharacters.getInstance().WILD_BOAR_MAX_EAT);
    }

    @Override
    public String toString() {
        return "WildBoar";
    }
    @Override
    public boolean eat(Animal animal) {
        if(animal instanceof Bug){
            if(Randomizer.getInstance().randomizer(9)<9){
                return true;
            }
        }
        return  super.eat(animal);
    }
}
