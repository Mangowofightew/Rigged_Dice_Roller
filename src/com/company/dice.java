package com.company;
import java.util.Random;
public class dice {
    //dice properties
    int numOfSides;
    char[] dataOnSides;
    boolean isFair;
    int[] sideProbabilities;
    Random r = new Random();
    //dice constructor
    dice(int numOfSides, char[] dataOnSides, boolean isFair, int[] sideProbabilities){

        //use arguments to set the values for your properties
        this.numOfSides = numOfSides;
        this.dataOnSides = dataOnSides;
        this.isFair = isFair;
        //if the dice is fair set the probability of each side at 100/number of sides
        if (isFair) {
            int[] probabilities = new int[numOfSides];
            for (int i = 0; i < numOfSides; i++) {
                probabilities[i] = 100/numOfSides;
            }
            this.sideProbabilities = probabilities;

        }
        //if the dice isn't fair manually input the probabilities
        else{this.sideProbabilities = sideProbabilities;}

    }
    char roll() {
        int helperNum = r.nextInt(100)+1;
        int a = 100;
        for (int i = 0; i < numOfSides; i++) {
            a -= sideProbabilities[i];
            sideProbabilities[i] = 100 - a;
        }
        for (int i = 0; i < numOfSides; i++) {
            if (i == 0) {
                if (helperNum <= sideProbabilities[i]) {return dataOnSides[i];}
            }
            else {
                if (helperNum <= sideProbabilities[i] && helperNum > sideProbabilities[i-1]) {
                    return dataOnSides[i];
                }
            }
        }
        return '⁊';
    }
}