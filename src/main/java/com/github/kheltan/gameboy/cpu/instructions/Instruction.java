package com.github.kheltan.gameboy.cpu.instructions;

import com.github.kheltan.gameboy.cpu.CpuContext;

public interface Instruction {
    int getCycles();
    int getNumOfArgs();
    void execute(CpuContext cpuContext,
                InstructionContext instructionContext);
}
