package com.github.kheltan.gameboy.cpu.instructions.logical;

import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.addressing.AddressingMode;

public abstract class Logical implements Instruction  {
    private final AddressingMode addressingMode;
    protected Logical(final AddressingMode addressingMode){
        this.addressingMode = addressingMode;
    }
    public AddressingMode getAddressingMode() {
        return addressingMode;
    }
}
