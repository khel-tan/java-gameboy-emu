package com.github.kheltan.gameboy.cpu.instructions.stack;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Register;
import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;

public class Push implements Instruction {
    private final static int SUCCESS_CYCLES = 16;
    private final static int NUM_OF_ARGS = 0;
    private final Register source;
    public Push(Register source){
        this.source = source;
    }

    @Override
    public void execute(CpuContext cpuContext, InstructionContext instructionContext) {
        
        push(source, Register.SP, cpuContext);


        
    }

    public int getCycles() {
        return SUCCESS_CYCLES;
    }

    public int getNumOfArgs() {
        return NUM_OF_ARGS;
    }

    private void push(Register source, Register stackRegister,
                    CpuContext cpuContext){
        int writeValue = cpuContext.get(source);
        cpuContext.set(stackRegister, cpuContext.get(stackRegister) - 1);
        cpuContext.write(cpuContext.get(stackRegister), writeValue >> 8);
        cpuContext.set(stackRegister, cpuContext.get(stackRegister) - 1);
        cpuContext.write(cpuContext.get(stackRegister), writeValue & 0xFF);
    }
    
}
