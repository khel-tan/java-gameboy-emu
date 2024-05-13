package com.github.kheltan.gameboy.cpu.instructions.addressing_mode;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Register;

/*
 * This mode is for when we are getting a value directly from the contents
 * of the register
 */
public class RegisterMode implements AddressingMode{
    private final Register destination;
    
    public RegisterMode(Register destination){
        this.destination = destination;
    }

    @Override
    public int read(CpuContext context) {
        return context.get(destination);
    }

    @Override
    public void write(CpuContext context, int value) {
        context.set(destination, value);
    }
    
}
