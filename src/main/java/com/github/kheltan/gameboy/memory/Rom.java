package com.github.kheltan.gameboy.memory;

import java.util.List;

/*
 * Read-only memory that is typically a game cartridge
 */
public class Rom implements AddressSpace {
    private final int[] space;
    public Rom(final int[] space){
        this.space = space;
    }
    public Rom(final List<Integer> space){
        this.space = space.stream().mapToInt(Integer::intValue).toArray();
    }
    @Override
    public int getByte(int address) {
        if(checkBounds(address)){
            return space[address];
        }
        else{
            return -1;
        }
    }

    @Override
    public void setByte(int address, int value) {
        throw new IllegalAccessError("Rom is read only " + address + ", " + value);
    }
    public Boolean checkBounds(int address){
        return address >= 0 && address < space.length;
    }
}
