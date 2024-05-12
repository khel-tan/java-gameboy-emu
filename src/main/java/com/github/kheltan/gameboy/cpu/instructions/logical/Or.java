package com.github.kheltan.gameboy.cpu.instructions.logical;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Flag;
import com.github.kheltan.gameboy.cpu.Registers.Register;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.AddressingMode;

public class Or extends Logical{
    private static final int SUCCESS_CYCLES = 4;
    private static final int NUM_OF_ARGS = 0;
    private final Register accumulator = Register.A;
    public Or(AddressingMode addressingMode){
        super(addressingMode);
    }
    @Override
    public void execute(CpuContext cpuContext, InstructionContext instructionContext) {
        int result = cpuContext.get(accumulator) | getAddressingMode().read(cpuContext);
        cpuContext.set(accumulator, result);

        cpuContext.set(Flag.Zero, result == 0);
        cpuContext.set(Flag.Sub, false);
        cpuContext.set(Flag.HalfCarry, false);
        cpuContext.set(Flag.Carry, false);
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
