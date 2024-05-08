package com.github.kheltan.gameboy.cpu.instructions.load;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;
import com.github.kheltan.gameboy.cpu.instructions.addressing.AddressingMode;
import com.github.kheltan.gameboy.cpu.instructions.addressing.IndirectMode;

public class Move implements Instruction {
    private final int SUCCESS_CYCLES;
    private static final int NUM_OF_ARGS = 0;
    private final AddressingMode sourceAddressingMode;
    private final AddressingMode destinationAddressingMode;
    public Move(final AddressingMode sourceAddressingMode,
                            final AddressingMode destinationAddressingMode){
        this.sourceAddressingMode = sourceAddressingMode;
        this.destinationAddressingMode = destinationAddressingMode;
        if(this.sourceAddressingMode.getClass() == IndirectMode.class ||
            this.destinationAddressingMode.getClass() == IndirectMode.class){
                SUCCESS_CYCLES = 8;
            }
        else{
            SUCCESS_CYCLES = 4;
        }
    }
    @Override
    public void execute(CpuContext cpuContext, InstructionContext instructionContext) {
        this.destinationAddressingMode
            .write(cpuContext, this.sourceAddressingMode.read(cpuContext));
    }

    @Override
    public int getCycles() {
        return SUCCESS_CYCLES;
    }

    @Override
    public int getNumOfArgs() {
        return NUM_OF_ARGS;
    }
    
}
