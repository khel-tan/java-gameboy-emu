package com.github.kheltan.gameboy.memory;

/*
 * Interface representing a memory space that we can read from and write to
 */
public interface AddressSpace {
    void setByte(int address, int value);

    int getByte(int address);
}
