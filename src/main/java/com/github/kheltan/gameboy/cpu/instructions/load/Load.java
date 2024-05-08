package com.github.kheltan.gameboy.cpu.instructions.load;

import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.addressing.AddressingMode;

public abstract class Load implements Instruction{
    private final AddressingMode addressingMode;
    protected Load(final AddressingMode addressingMode){
        this.addressingMode = addressingMode;
    }
    public AddressingMode getAddressingMode() {
        return addressingMode;
    }
    
} 
