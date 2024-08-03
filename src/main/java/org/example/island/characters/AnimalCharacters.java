package org.example.island.characters;

import org.example.animals.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnimalCharacters {

   public Map<String, Integer> animalsCage = new HashMap<String, Integer>() {{
        put(WOLF_NAME, WOLF_MAX_IN_CAGE);
        put(RABBIT_NAME, RABBIT_MAX_IN_CAGE);
        put(FOX_NAME,FOX_MAX_IN_CAGE);
        put(BOA_NAME,BOA_MAX_IN_CAGE);
        put(EAGLE_NAME,EAGLE_MAX_IN_CAGE);
        put(DUCK_NAME,DUCK_MAX_IN_CAGE);
        put(BEAR_NAME,BEAR_MAX_IN_CAGE);
    }};
   public Map<String, Integer> animalsSpeed = new HashMap<String, Integer>() {{
        put(WOLF_NAME, WOLF_MAX_SPEED);
        put(RABBIT_NAME, RABBIT_MAX_SPEED);
        put(FOX_NAME,FOX_MAX_SPEED);
        put(BOA_NAME,BOA_MAX_SPEED);
        put(EAGLE_NAME,EAGLE_MAX_SPEED);
        put(DUCK_NAME,DUCK_MAX_SPEED);
        put(BEAR_NAME,BEAR_MAX_SPEED);
    }};
    public Map<String, Double> animalsWeight = new HashMap<String, Double>() {{
        put(WOLF_NAME, WOLF_WEIGHT);
        put(RABBIT_NAME, RABBIT_WEIGHT);
        put(FOX_NAME,FOX_WEIGHT);
        put(BOA_NAME,BOA_WEIGHT);
        put(EAGLE_NAME,EAGLE_WEIGHT);
        put(DUCK_NAME,DUCK_WEIGHT);
        put(BEAR_NAME,BEAR_WEIGHT);
    }};
    public static final int CHANCE_REPRODUCTION=2;//30%

    public static final int WIDTH = 9;
    public static final int HEIGHT = 9;
    public static final String WOLF_NAME="Wolf";
    public static final double WOLF_WEIGHT=30;
    public static final int WOLF_MAX_IN_CAGE=40;
    public static final int WOLF_MAX_SPEED=3;
    public static final double WOLF_MAX_EAT=8;
    public static final String RABBIT_NAME="Rabbit";
    public static final double RABBIT_WEIGHT=2;
    public static final int RABBIT_MAX_IN_CAGE=80;
    public static final int RABBIT_MAX_SPEED=2;
    public static final double RABBIT_MAX_EAT=0.45;

    public static final String FOX_NAME="Fox";
    public static final double FOX_WEIGHT=10;
    public static final int FOX_MAX_IN_CAGE=50;
    public static final int FOX_MAX_SPEED=2;
    public static final double FOX_MAX_EAT=2;
    public static final String BOA_NAME="Boa";
    public static final double BOA_WEIGHT=15;
    public static final int BOA_MAX_IN_CAGE=20;
    public static final int BOA_MAX_SPEED=1;
    public static final double BOA_MAX_EAT=3;
    public static final String EAGLE_NAME="Eagle";
    public static final double EAGLE_WEIGHT=10;
    public static final int EAGLE_MAX_IN_CAGE=40;
    public static final int EAGLE_MAX_SPEED=3;
    public static final double EAGLE_MAX_EAT=1;
    public static final String DUCK_NAME="Duck";
    public static final double DUCK_WEIGHT=4;
    public static final int DUCK_MAX_IN_CAGE=50;
    public static final int DUCK_MAX_SPEED=4;
    public static final double DUCK_MAX_EAT=1;

    public static final String BEAR_NAME="Bear";
    public static final double BEAR_WEIGHT=200;
    public static final int BEAR_MAX_IN_CAGE=10;
    public static final int BEAR_MAX_SPEED=2;
    public static final double BEAR_MAX_EAT=1;






}
