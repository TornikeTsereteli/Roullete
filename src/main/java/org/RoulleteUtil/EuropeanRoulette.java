package org.RoulleteUtil;

import java.util.Random;

/**
   concrete implementation of Roulette wheel
 */
public class EuropeanRoulette implements Roulette {
    private int randomNumber;

    @Override
    public void spinWheel() {
        Random random = new Random();
        randomNumber = random.nextInt(0, 36);
    }

    @Override
    public int getNumber() {
        return randomNumber;
    }
}
