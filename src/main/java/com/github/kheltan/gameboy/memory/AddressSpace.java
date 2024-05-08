package com.github.kheltan.gameboy.memory;

public interface AddressSpace {
    /*
     * 
     */
    void setByte(int address, int value);

    int getByte(int address);
}
