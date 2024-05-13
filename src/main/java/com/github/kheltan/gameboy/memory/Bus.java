package com.github.kheltan.gameboy.memory;

import com.github.kheltan.gameboy.utility.Constants;

public class Bus implements AddressSpace {
    private final Ram ram;
    private final Rom rom;
    public Bus(final Ram ram, final Rom rom){
        this.ram = ram;
        this.rom = rom;
    }
    @Override
    public int getByte(int address) {
        if(address >= Constants.WRAM_START && address <= Constants.WRAM_END){
            return ram.getByte(address);
        }
        else{
            return rom.getByte(address);
        }
    }

    @Override
    public void setByte(int address, int value) {
        if(address >= Constants.WRAM_START && address <= Constants.WRAM_END){
            ram.setByte(address, value);
        }
        else{
            rom.setByte(address, value);
        }
    }
    
}
