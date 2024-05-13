package com.github.kheltan.gameboy.memory;

import com.github.kheltan.gameboy.utility.Constants;

public class Ram implements AddressSpace {
    private final int[] space = new int[Constants.WRAM_END - Constants.WRAM_START + 1];
    private static int OFFSET = Constants.WRAM_START;
    public Ram(){
    }
    @Override
    public int getByte(int address) {
        if(checkBounds(address)){
            return space[address - OFFSET];
        }
        else{
            throw new IllegalAccessError("Index wrong on Ram : " + String.format("0x%4X", address));
        }
    }

    @Override
    public void setByte(int address, int value) {
        if(checkBounds(address)){
            space[address - OFFSET] = value;
        }
        else{
            throw new IllegalAccessError("Index wrong on Ram : " + String.format("0x%4X", address));
        }
    }

    public Boolean checkBounds(int address){
        return (address - OFFSET) >= 0 && (address - OFFSET) < space.length;
    }
    
}
