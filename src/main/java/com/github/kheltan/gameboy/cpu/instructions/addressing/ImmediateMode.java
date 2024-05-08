package com.github.kheltan.gameboy.cpu.instructions.addressing;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Register;

public class ImmediateMode implements AddressingMode{
    private final Register destination;
    
    public ImmediateMode(Register destination){
        this.destination = destination;
    }

    @Override
    public int read(CpuContext context) {
        throw new IllegalAccessError("Cannot address memory with immediate value! Load to a register first");
    }

    @Override
    public void write(CpuContext context, int value) {
        context.set(destination, value);
    }
    
}
