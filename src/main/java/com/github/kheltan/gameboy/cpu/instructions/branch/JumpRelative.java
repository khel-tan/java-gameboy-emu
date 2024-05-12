package com.github.kheltan.gameboy.cpu.instructions.branch;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;

public class JumpRelative implements Instruction {
    private static final int SUCCESS_CYCLES = 12;
    private static final int NUM_OF_ARGS = 1;

    @Override
    public void execute(CpuContext cpuContext, InstructionContext instructionContext) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getCycles() {
        // TODO Auto-generated method stub
        return SUCCESS_CYCLES;
    }

    @Override
    public int getNumOfArgs() {
        // TODO Auto-generated method stub
        return NUM_OF_ARGS;
    }
    
}
