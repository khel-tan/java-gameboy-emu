package com.github.kheltan.gameboy.cpu.instructions.addressing;

import com.github.kheltan.gameboy.cpu.CpuContext;

public class ImmediateMode implements AddressingMode{
    private final int immediateValue;
    
    public ImmediateMode(int immediateValue){
        this.immediateValue = immediateValue;
    }

    @Override
    public int read(CpuContext context) {
        return immediateValue;
    }

    @Override
    public void write(CpuContext context, int value) {
        throw new IllegalArgumentException("Cannot write to an immediate value!");
    }
    
}
