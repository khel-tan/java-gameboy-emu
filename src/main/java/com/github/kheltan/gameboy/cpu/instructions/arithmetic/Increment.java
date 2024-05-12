package com.github.kheltan.gameboy.cpu.instructions.arithmetic;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;
import com.github.kheltan.gameboy.cpu.instructions.addressing.AddressingMode;
import com.github.kheltan.gameboy.cpu.instructions.addressing.RegisterMode;

public class Increment implements Instruction {
    private final int SUCCESS_CYCLES;
    private final int NUM_OF_ARGS = 0;
    private final AddressingMode targetAddressingMode;
    public Increment(AddressingMode targetAddressingMode){
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
        targetAddressingMode.write(cpuContext, targetAddressingMode.read(cpuContext) + 1);
        
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
