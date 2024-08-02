package org.example.island;
import org.example.animals.Animal;
import org.example.animals.Direction;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.example.island.AnimalCharacters.HEIGHT;
import static org.example.island.AnimalCharacters.WIDTH;

public class IslandInit {
    AnimalCharacters animalCharacters=new AnimalCharacters();
    public ArrayList<Animal>[][] island = new ArrayList[animalCharacters.HEIGHT][animalCharacters.WIDTH];
    private int countAnimalInCage;
    private int countAllAnimals;
    private int countDeath;
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
                System.out.println("Клетка-"+i+"-"+j);
        for(String str:animalCharacters.animalsCage.keySet()){
            countAnimalInCage=0;
            for(Animal animal:animals){
                if(animal.toString().equals(str)){
                    countAnimalInCage++;
                }
            }
            System.out.println(str+"-"+countAnimalInCage);
        }
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
                    int speed =Randomizer.getInstance().randomizer(animalCharacters.animalsSpeed.get(animal.toString()));
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
    public void info(){
        for(String str:animalCharacters.animalsCage.keySet()){
            countAllAnimals=0;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal>animals=island[i][j];
                    for(Animal animal:animals){
                        if(animal.toString().equals(str)){
                            countAllAnimals++;
                        }
                    }
                }
            }
            System.out.println(str+"-"+countAllAnimals);
        }
    }
    public void eatAll(){
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal> animals = island[i][j];
                Animal[]animal= island[i][j].toArray(new Animal[island[i][j].size()]);
                for(int x=0;x<animal.length;x++){
                    for (Animal anim : new ArrayList<>(animals)) {
                        if (animal[x].eat(anim)) {
                            animal[x].setWeight(animal[x].getWeight()+anim.getWeight());
                            island[i][j].remove(anim);
                            animal[x].setEat(true);break;
                        }
                    }
                }
            }
        }
    }
    public void allReproduction(){

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Animal[]animal= island[i][j].toArray(new Animal[island[i][j].size()]);
                ArrayList<Animal> animals = island[i][j];
                for(int x=0;x<animal.length;x++){
                    for (Animal anim : new ArrayList<>(animals)) {
                        if((animal[x].getAge()>3)&& (!animal[x].isReproduction())&&(!anim.isReproduction())){
                            animal[x].reproduction(anim);
                            island[i][j].add(factory.create(anim.toString()));
                        }
                    }
                }
            }
        }

    }

    public void nextTurn() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal> animals = island[i][j];
                for (Animal anim : new ArrayList<>(animals)) {
                    anim.setWeight(anim.getWeight()*0.8);
                    anim.setEat(false);
                    anim.setReproduction(false);
                    anim.setAge(anim.getAge()+1);
                    if(anim.toString().equals("Rabbit")){anim.setWeight(anim.getWeight()+0.4);}
                }
            }
        }
    }
    public void allDeath() {
        countDeath=0;
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                ArrayList<Animal> animals = island[i][j];
                for (Animal anim : new ArrayList<>(animals)) {
                if((anim.getWeight()*100<animalCharacters.animalsWeight.get(anim.toString())*70)||anim.getAge()>10){
                    island[i][j].remove(anim);
                    countDeath++;
                }
                }
            }
        }
        System.out.println("Умерло от голода: "+countDeath);
    }

}
