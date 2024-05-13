package com.github.kheltan.gameboy.utility;

/*
 * static class storing constants
 */
public class Constants {
    // Work Ram bounds
    public static final int WRAM_START = 0xC000;
    public static final int WRAM_END = 0xDFFF;

    // 8 bit value bounds
    public static final int MIN_8BIT_VAL = 0;
    public static final int MAX_8BIT_VAL = 255;
    private Constants(){

    }
}
