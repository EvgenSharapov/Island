package org.example.vegetation;

public class Herb extends Vegetation{
    public Herb(double weight, boolean isReproduction) {
        super(weight, isReproduction);
    }
    @Override
    public String toString() {
        return "Herb";}
}
