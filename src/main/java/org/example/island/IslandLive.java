package org.example.island;
import org.example.animals.Animal;
import org.example.animals.Direction;
import org.example.island.characters.AnimalCharacters;
import org.example.island.factory.FactoryAnimals;
import org.example.vegetation.Vegetation;
import org.springframework.scheduling.annotation.Scheduled;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.example.island.characters.AnimalCharacters.*;
import static org.example.island.characters.IslandCharacters.*;
import static org.example.island.characters.VegetationCharacters.*;

public class IslandLive {




    public ArrayList<Animal>[][] island = new ArrayList[WIDTH][HEIGHT];
    private int countAnimalInCage;
    private int countAllAnimals;
    private int countHungerDeath;
    private int countAgeDeath;
    private int ageOfTheIsland;
    private int animalsEaten;
    private int vegetationEaten;
    private boolean isEndSimulation=false;


    public Map<String, Integer>[][] animalsMax = new HashMap[WIDTH][HEIGHT];
    FactoryAnimals factory=new FactoryAnimals();
    public boolean isEndSimulation() {
        return isEndSimulation;
    }

    public void initialize() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                IslandCage islandCage=new IslandCage(i,j);
                island[i][j]=islandCage.getRandAnimalsInCageStart();
            }
        }
    }

    private void countingAnimal(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal>animals=island[i][j];
                Map<String, Integer>animalTemp = new HashMap<>();
        for(String str:AnimalCharacters.getInstance().animalsCage.keySet()){
            countAnimalInCage=0;
            for(Animal animal:animals){
                if(animal.toString().equals(str)){
                    countAnimalInCage++;
                }
            }
            animalTemp.put(str,countAnimalInCage);
        }
        animalsMax[i][j]=animalTemp;
            }
        }
    }
    private void moveAll(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal> animals = island[i][j];
                for (Animal animal : new ArrayList<>(animals)) {
                    animal.move();
                    while ((animal.getDirection()==Direction.UP&&j==0)||(animal.getDirection()==Direction.DOWN&&j==HEIGHT-1)||
                            (animal.getDirection()==Direction.LEFT&&i==0)||(animal.getDirection()==Direction.RIGHT&&j==WIDTH-1)){
                        animal.move();
                    }
                    if (animal.getDirection() == Direction.UP) {
                        if ((j - animal.getSpeed() < 0)&&(animalsMax[i][0].get(animal.toString())<AnimalCharacters.getInstance().animalsCage.get(animal.toString()))) {
                            island[i][0].add(animal);
                            island[i][j].remove(animal);
                        } else if((j - animal.getSpeed() >= 0)&&   (animalsMax[i][j - animal.getSpeed()].get(animal.toString())<AnimalCharacters.getInstance().animalsCage.get(animal.toString()))){
                            island[i][j - animal.getSpeed()].add(animal);
                            island[i][j].remove(animal);
                        }
                    } else if (animal.getDirection() == Direction.DOWN) {
                        if ((j + animal.getSpeed() > HEIGHT - 1)&&(animalsMax[i][HEIGHT - 1].get(animal.toString())<AnimalCharacters.getInstance().animalsCage.get(animal.toString()))) {
                            island[i][HEIGHT - 1].add(animal);
                            island[i][j].remove(animal);
                        } else if((j + animal.getSpeed() <= HEIGHT - 1)&&     (animalsMax[i][j + animal.getSpeed()].get(animal.toString())<AnimalCharacters.getInstance().animalsCage.get(animal.toString()))){
                            island[i][j + animal.getSpeed()].add(animal);
                            island[i][j].remove(animal);
                        }
                    } else if (animal.getDirection() == Direction.LEFT) {
                        if ((i - animal.getSpeed() < 0)&&(animalsMax[0][j].get(animal.toString())<AnimalCharacters.getInstance().animalsCage.get(animal.toString()))) {
                            island[0][j].add(animal);
                            island[i][j].remove(animal);
                        } else if((i - animal.getSpeed() >= 0)&&   animalsMax[i - animal.getSpeed()][j].get(animal.toString())<AnimalCharacters.getInstance().animalsCage.get(animal.toString())){
                            island[i - animal.getSpeed()][j].add(animal);
                            island[i][j].remove(animal);
                        }
                    } else if (animal.getDirection() == Direction.RIGHT) {
                        if ((i + animal.getSpeed() > WIDTH-1)&&(animalsMax[WIDTH - 1][j].get(animal.toString())<AnimalCharacters.getInstance().animalsCage.get(animal.toString()))) {
                            island[WIDTH - 1][j].add(animal);
                            island[i][j].remove(animal);
                        } else if((i + animal.getSpeed() <= WIDTH-1)&&animalsMax[i + animal.getSpeed()][j].get(animal.toString())<AnimalCharacters.getInstance().animalsCage.get(animal.toString())){
                            island[i + animal.getSpeed()][j].add(animal);
                            island[i][j].remove(animal);
                        }
                    }
                }
            }
        }
    }
    private void info() {
        System.out.println("=Животные=");
        for (String str : AnimalCharacters.getInstance().animalsCage.keySet()) {
            countAllAnimals = 0;
            for (int i = 0; i < WIDTH; i++) {
                for (int j = 0; j < HEIGHT; j++) {
                    ArrayList<Animal> animals = island[i][j];
                    for (Animal animal : animals) {
                        if (animal.toString().equals(str)) {
                            countAllAnimals++;
                        }
                    }
                }
            }
            String name=new String();
            switch (str){
                case WOLF_NAME:name="\uD83D\uDC3A";break;
                case BEAR_NAME:name="\uD83D\uDC3B";break;
                case HORSE_NAME:name="\uD83D\uDC0E";break;
                case  DEER_NAME:name="\uD83E\uDD8C";break;
                case  WILD_BOAR_NAME:name="\uD83D\uDC17";break;
                case  SHEEP_NAME:name="\uD83D\uDC11";break;
                case  GOAT_NAME:name="\uD83D\uDC10";break;
                case  BUFFALO_NAME:name="\uD83D\uDC03";break;
                case  BOA_NAME:name="\uD83D\uDC0D";break;
                case  FOX_NAME:name="\uD83E\uDD8A";break;
                case  EAGLE_NAME:name="\uD83E\uDD85";break;
                case  RABBIT_NAME:name="\uD83D\uDC07";break;
                case  DUCK_NAME:name="\uD83E\uDD86";break;
                case  MOUSE_NAME:name="\uD83D\uDC01";break;
                case  BUG_NAME:name="\uD83D\uDC1C";
            }
            System.out.println(name + "-" + countAllAnimals);
        }
        System.out.println("=Растения=");
        Map<String, Integer>vegCount=VegetationLive.getInstance().getCountAll();
        for(String str: vegCount.keySet()) {
            String name=new String();
            switch (str){
                case BERRIES_NAME:name="\uD83C\uDF4F";break;
                case HERB_NAME:name="\uD83C\uDF3F";break;
                case MUSHROOM_NAME:name="\uD83C\uDF44";
            }
            System.out.println(name+": "+vegCount.get(str));


        }

        System.out.println("==========");

    }
    private void eatAll(){
        animalsEaten=0;
        vegetationEaten=0;
        ArrayList<Vegetation>[][]vegTemp=VegetationLive.getInstance().getVegetationPull();
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal> animals = island[i][j];
                Animal[]animal= island[i][j].toArray(new Animal[island[i][j].size()]);
                for(int x=0;x<animal.length;x++){
                    for (Animal anim : new ArrayList<>(animals)) {
                        if (animal[x].eat(anim)) {
                            if(anim.getWeight()>animal[x].getMaxEat()){
                            animal[x].setWeight(animal[x].getWeight()+animal[x].getMaxEat());}
                            else{animal[x].setWeight(animal[x].getWeight()+anim.getWeight());}
                            island[i][j].remove(anim);
                            animalsEaten++;
                            animal[x].setEat(true);break;
                        }
                        else {animal[x].setEat(true);break;}
                    }
                    for(Vegetation vegetation:new ArrayList<>(vegTemp[i][j])){
                        if(animal[x].eat(vegetation)){
                            if(vegetation.getWeight()>animal[x].getMaxEat()){
                                animal[x].setWeight(animal[x].getWeight()+animal[x].getMaxEat());
                            }
                            else{animal[x].setWeight(animal[x].getWeight()+vegetation.getWeight());}
                            vegTemp[i][j].remove(vegetation);
                            vegetationEaten++;
                            animal[x].setEat(true);break;
                        }
                    }
                }
            }
        }
        VegetationLive.getInstance().setVegetationPull(vegTemp);
    }
    private void allReproduction(){

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Animal[]animal= island[i][j].toArray(new Animal[island[i][j].size()]);
                ArrayList<Animal> animals = island[i][j];


                for(int x=0;x<animal.length;x++){
                    for (Animal anim : new ArrayList<>(animals)) {
                        if(animalsMax[i][j].get(anim.toString())>=AnimalCharacters.getInstance().animalsCage.get(anim.toString())){continue;}
                        if((animal[x].getAge()>3)&&animal[x].reproduction(anim)){
                            if(Randomizer.getInstance().randomizer(10)<CHANCE_REPRODUCTION){
                            island[i][j].add(factory.create(anim.toString()));}
                        }
                    }
                }
            }
        }

    }



    private void nextTurn() {
        ageOfTheIsland++;
        if(ageOfTheIsland>NUMBER_TURN_SIMULATION_ISLAND){isEndSimulation=true;}
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal> animals = island[i][j];
                for (Animal anim : new ArrayList<>(animals)) {
                    anim.setWeight(anim.getWeight()*WEIGHT_LOSS_PER_TURN);
                    anim.setEat(false);
                    anim.setReproduction(false);
                    anim.setAge(anim.getAge()+1);
                }

            }
        }
    }
    private void allDeath() {
        countHungerDeath=0;
        countAgeDeath=0;

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal> animals = island[i][j];
                for (Animal anim : new ArrayList<>(animals)) {
                if((anim.getWeight()*100<AnimalCharacters.getInstance().animalsWeight.get(anim.toString())*DEATH_WEIGHT)){
                    island[i][j].remove(anim);
                    countHungerDeath++;}
                   else if(anim.getAge()>DEATH_AGE){island[i][j].remove(anim);countAgeDeath++;}
                }
            }
        }
        System.out.println("Возраст острова: "+ageOfTheIsland);
        System.out.println("Умерло от голода: "+countHungerDeath);
        System.out.println("Умерло от старости: "+countAgeDeath);
        System.out.println("Cъедено животных: "+animalsEaten);
        System.out.println("Съедено растений: "+vegetationEaten);
    }
    @Scheduled
    public void simulation(){
        countingAnimal();
        moveAll();
        eatAll();
        allReproduction();
        allDeath();
        info();
        nextTurn();
    }

}
