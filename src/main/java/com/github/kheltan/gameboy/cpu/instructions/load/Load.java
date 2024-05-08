package com.github.kheltan.gameboy.cpu.instructions.load;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;
import com.github.kheltan.gameboy.cpu.instructions.addressing.AddressingMode;

public class Load implements Instruction {
    private final int SUCCESS_CYCLES = 8;
    private static final int NUM_OF_ARGS = 0;
    private final AddressingMode sourceAddressingMode;
    private final AddressingMode destinationAddressingMode;
    public Load(final AddressingMode sourceAddressingMode,
                            final AddressingMode destinationAddressingMode){
        this.sourceAddressingMode = sourceAddressingMode;
        this.destinationAddressingMode = destinationAddressingMode;
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
