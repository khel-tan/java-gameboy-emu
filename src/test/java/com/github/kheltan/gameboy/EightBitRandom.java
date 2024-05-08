package com.github.kheltan.gameboy;

import java.util.Random;

public class EightBitRandom {
    private Random random;
    public static EightBitRandom INSTANCE = new EightBitRandom();

    private EightBitRandom() {
        this.random = new Random();
    }

    // This method returns an 8-bit value, from 0 to 255
    public int next() {
        return random.nextInt(256);  // 256 because nextInt(n) returns values from 0 to n-1
    }
}