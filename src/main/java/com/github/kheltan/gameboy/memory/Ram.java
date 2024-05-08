package com.github.kheltan.gameboy.memory;

import com.github.kheltan.gameboy.utility.Constants;

public class Ram implements AddressSpace {
    private final int[] space = new int[Constants.WRAM_END - Constants.WRAM_START + 1];
    public Ram(){
    }
    @Override
    public int getByte(int address) {
        if(checkBounds(address)){
            return space[address];
        }
        else{
            throw new IllegalAccessError("Index wrong on Ram!");
        }
    }

    @Override
    public void setByte(int address, int value) {
        if(checkBounds(address)){
            space[address] = value;
        }
        else{
            throw new IllegalAccessError("Index wrong on Ram!");
        }
    }

    public Boolean checkBounds(int address){
        return address >= 0 && address < space.length;
    }
    
}
