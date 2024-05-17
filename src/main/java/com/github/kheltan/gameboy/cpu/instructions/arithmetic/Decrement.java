package com.github.kheltan.gameboy.cpu.instructions.arithmetic;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Flag;
import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.AddressingMode;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.RegisterMode;

/*
 * Decrement the specified register
 */
public class Decrement implements Instruction {
    private final int SUCCESS_CYCLES;
    private final int NUM_OF_ARGS = 0;
    private final AddressingMode targetAddressingMode;
    public Decrement(AddressingMode targetAddressingMode){
        this.targetAddressingMode = targetAddressingMode;
        if(this.targetAddressingMode.getClass() == RegisterMode.class){
            SUCCESS_CYCLES = 4;
        }
        else{
            SUCCESS_CYCLES = 12;
        }
    }
    @Override
    public void execute(CpuContext cpuContext, InstructionContext instructionContext) {
        // TODO Implement Flags
        int original = targetAddressingMode.read(cpuContext);
        int result = original - 1;
        targetAddressingMode.write(cpuContext, result);

        cpuContext.set(Flag.Zero, result == 0);
        cpuContext.set(Flag.Sub, true);
        cpuContext.set(Flag.HalfCarry, (original & 0xFF) > 0xFF);

        
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
