package com.github.kheltan.gameboy.cpu.instructions.addressing;

import com.github.kheltan.gameboy.cpu.CpuContext;

public abstract class ImmediateMode implements AddressingMode{
    
    public ImmediateMode(){
    }

    @Override
    public int read(CpuContext context) {
        throw new IllegalArgumentException("Cannot address to an immediate value!");
    }

    @Override
    public void write(CpuContext context, int value) {
        throw new IllegalArgumentException("Cannot write to an immediate value!");
    }
    
}
