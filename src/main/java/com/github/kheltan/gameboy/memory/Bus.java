package com.github.kheltan.gameboy.memory;

public class Bus implements AddressSpace {
    private final Ram ram;
    private final Rom rom;
    public Bus(final Ram ram, final Rom rom){
        this.ram = ram;
        this.rom = rom;
    }
    @Override
    public int getByte(int address) {
        return rom.getByte(address);
    }

    @Override
    public void setByte(int address, int value) {
        rom.setByte(address, value);
    }
    
}
