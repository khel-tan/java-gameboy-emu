package com.github.kheltan.gameboy.cpu.instructions.addressing_mode;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Register;

/*
 * This class abstracts the scenario in which we use the value in a register
 * as a memory address and retrieve the value from said address
 */
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
