package org.example.island;

import org.example.animals.Animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnimalCharacters {

   public Map<String, Integer> animals = new HashMap<String, Integer>() {{
        put(WOLF_NAME, WOLF_MAX_IN_CAGE);
        put(RABBIT_NAME, RABBIT_MAX_IN_CAGE);
    }};
    public static final int WIDTH = 2;
    public static final int HEIGHT = 2;
    public static final String WOLF_NAME="Wolf";
    public static final double WOLF_WEIGHT=50;
    public static final int WOLF_MAX_IN_CAGE=30;
    public static final int WOLF_MAX_SPEED=3;
    public static final double WOLF_MAX_EAT=8;
    public static final String RABBIT_NAME="Rabbit";
    public static final double RABBIT_WEIGHT=2;
    public static final int RABBIT_MAX_IN_CAGE=150;
    public static final int RABBIT_MAX_SPEED=2;
    public static final double RABBIT_MAX_EAT=0.45;


}
