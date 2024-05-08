package com.github.kheltan.gameboy.cpu.instructions.arithmetic;

import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.addressing.AddressingMode;

public abstract class Arithmetic implements Instruction {
    private final AddressingMode addressingMode;
    protected Arithmetic(final AddressingMode addressingMode){
        this.addressingMode = addressingMode;
    }
    public AddressingMode getAddressingMode() {
        return addressingMode;
    }
}
