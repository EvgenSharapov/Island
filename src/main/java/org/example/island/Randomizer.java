package org.example.island;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
        private static Randomizer ourInstance = new Randomizer();

        public static Randomizer getInstance() {
            return ourInstance;
        }
        private Randomizer() {
        }
        public int randomizer(int i){
            return ThreadLocalRandom.current().nextInt(0, i);
        }
}
