package com.github.kheltan.gameboy.cpu.instructions.addressing;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Register;

public class IndirectMode implements AddressingMode {
    private final Register register;
    public IndirectMode(final Register register){
        this.register = register;
    }
    @Override
    public int read(CpuContext context) {
        return context.read(context.get(register));
    }

    @Override
    public void write(CpuContext context, int value) {
        context.write(context.get(register), value);
    }
    
}
