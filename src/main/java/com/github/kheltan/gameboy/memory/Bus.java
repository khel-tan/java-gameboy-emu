package com.github.kheltan.gameboy.memory;

import com.github.kheltan.gameboy.utility.Constants;
/*
 * The memory bus manages all memory components of the Gameboy and handles the memory mappigng as well.
 * Currently, we have only the ROM and the Work-RAM.
 */
public class Bus implements AddressSpace {
    private final Wram ram;
    private final Rom rom;
    public Bus(final Wram ram, final Rom rom){
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
