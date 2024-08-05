package org.example.island;
import org.example.animals.Animal;
import org.example.animals.Direction;
import org.example.island.characters.AnimalCharacters;
import org.example.island.characters.VegetationCharacters;
import org.example.island.factory.FactoryAnimals;
import org.example.vegetation.Vegetation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.example.island.characters.IslandCharacters.*;


public class IslandInit {
    public ArrayList<Animal>[][] island = new ArrayList[WIDTH][HEIGHT];
    private int countAnimalInCage;
    private int countAllAnimals;
    private int countHungerDeath;
    private int countAgeDeath;
    private int ageOfTheIsland;
    private int animalsEaten;
    private int vegetationEaten;


    public Map<String, Integer>[][] animalsMax = new HashMap[WIDTH][HEIGHT];
    FactoryAnimals factory=new FactoryAnimals();



    public void initialize() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                IslandCage islandCage=new IslandCage(i,j);
                island[i][j]=islandCage.getRandAnimalsInCage();
            }
        }
    }
    public void live(){
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
    public Direction randomDirection(){
        Direction[]directions=Direction.values();
        int value = Randomizer.getInstance().randomizer(directions.length);
            switch (value){
                case 0:return Direction.UP;
                case 1:return Direction.DOWN;
                case 2:return Direction.RIGHT;
                default:return Direction.LEFT;
            }
    }
    public void moveAll(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal> animals = island[i][j];
                for (Animal animal : new ArrayList<>(animals)) {
                    int speed =Randomizer.getInstance().randomizer(AnimalCharacters.getInstance().animalsSpeed.get(animal.toString()));
                    Direction direction=randomDirection();
                    while ((direction==Direction.UP&&j==0)||(direction==Direction.DOWN&&j==HEIGHT-1)||
                            (direction==Direction.LEFT&&i==0)||(direction==Direction.RIGHT&&j==WIDTH-1)){
                        direction= randomDirection();
                    }
                    if (direction == Direction.UP) {
                        if (j - speed < 0) {
                            island[i][0].add(animal);
                            island[i][j].remove(animal);
                        } else {
                            island[i][j - speed].add(animal);
                            island[i][j].remove(animal);
                        }
                    } else if (direction == Direction.DOWN) {
                        if (j + speed > HEIGHT - 1) {
                            island[i][HEIGHT - 1].add(animal);
                            island[i][j].remove(animal);
                        } else {
                            island[i][j + speed].add(animal);
                            island[i][j].remove(animal);
                        }
                    } else if (direction == Direction.LEFT) {
                        if (i - speed < 0) {
                            island[0][j].add(animal);
                            island[i][j].remove(animal);
                        } else {
                            island[i - speed][j].add(animal);
                            island[i][j].remove(animal);
                        }
                    } else if (direction == Direction.RIGHT) {
                        if (i + speed > WIDTH - 1) {
                            island[WIDTH - 1][j].add(animal);
                            island[i][j].remove(animal);
                        } else {
                            island[i + speed][j].add(animal);
                            island[i][j].remove(animal);
                        }
                    }
                }
            }
        }
    }
    public void info() {
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
                case "Wolf":name="\uD83D\uDC3A";break;
                case "Bear":name="\uD83D\uDC3B";break;
                case "Horse":name="\uD83D\uDC0E";break;
                case  "Deer":name="\uD83E\uDD8C";break;
                case  "WildBoar":name="\uD83D\uDC17";break;
                case  "Sheep":name="\uD83D\uDC11";break;
                case  "Goat":name="\uD83D\uDC10";break;
                case  "Buffalo":name="\uD83D\uDC03";break;
                case  "Boa":name="\uD83D\uDC0D";break;
                case  "Fox":name="\uD83E\uDD8A";break;
                case  "Eagle":name="\uD83E\uDD85";break;
                case  "Rabbit":name="\uD83D\uDC07";break;
                case  "Duck":name="\uD83E\uDD86";break;
                case  "Mouse":name="\uD83D\uDC01";break;
                case  "Bug":name="\uD83D\uDC1C";
            }
            System.out.println(name + "-" + countAllAnimals);
        }
        System.out.println("=Растения=");
        Map<String, Integer>vegCount=VegetationLive.getInstance().getCountAll();
        for(String str: vegCount.keySet()) {
            String name=new String();
            switch (str){
                case "Berries":name="\uD83C\uDF4F";break;
                case "Herb":name="\uD83C\uDF3F";break;
                case "Mushroom":name="\uD83C\uDF44";
            }
            System.out.println(name+": "+vegCount.get(str));


        }

        System.out.println("==========");

    }

    public void eatAll(){
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
    public void allReproduction(){

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Animal[]animal= island[i][j].toArray(new Animal[island[i][j].size()]);
                ArrayList<Animal> animals = island[i][j];


                for(int x=0;x<animal.length;x++){
                    for (Animal anim : new ArrayList<>(animals)) {
                        if(animalsMax[i][j].get(anim.toString())>=AnimalCharacters.getInstance().animalsCage.get(anim.toString())){continue;}
                        if((animal[x].getAge()>3)&&animal[x].reproduction(anim)){
                            if(Randomizer.getInstance().randomizer(9)<CHANCE_REPRODUCTION){
                            island[i][j].add(factory.create(anim.toString()));}
                        }
                    }
                }
            }
        }

    }

    public void nextTurn() {
        ageOfTheIsland++;
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
    public void allDeath() {
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

}
