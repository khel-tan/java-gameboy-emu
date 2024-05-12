package com.github.kheltan.gameboy.cpu.instructions.arithmetic;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Flag;
import com.github.kheltan.gameboy.cpu.Registers.Register;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.AddressingMode;

public class Adc extends Arithmetic {
    private static final int SUCCESS_CYCLES = 4;
    private static final int NUM_OF_ARGS = 0;
    private final Register accumulator = Register.A;
    public Adc(final AddressingMode addressingMode){
        super(addressingMode);
    }
    @Override
    public void execute(CpuContext cpuContext, InstructionContext instructionContext) {
        
        int carryFlag = cpuContext.get(Flag.Carry) ? 1 : 0;
        int result = cpuContext.get(accumulator) + getAddressingMode().read(cpuContext) + carryFlag;
        cpuContext.set(Flag.Zero, result == 0);
        cpuContext.set(Flag.Sub, false);
        cpuContext.set(Flag.HalfCarry, (cpuContext.get(accumulator) & 0x0F)
                                        + (getAddressingMode().read(cpuContext)) + carryFlag > 0x0F);
        cpuContext.set(Flag.Carry, result > 0xFF);
        cpuContext.set(accumulator, result);
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
