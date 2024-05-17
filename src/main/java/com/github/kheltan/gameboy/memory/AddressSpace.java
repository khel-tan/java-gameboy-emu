package com.github.kheltan.gameboy.memory;

/*
 * Interface representing a memory space that we can read from and write to
 */
public interface AddressSpace {
    /*
     * @param address the address that we are writing to
     * @param value the value that we are writing
     */
    void setByte(int address, int value);

    /*
     * @param address the address that we are reading from
     */
    int getByte(int address);
}
