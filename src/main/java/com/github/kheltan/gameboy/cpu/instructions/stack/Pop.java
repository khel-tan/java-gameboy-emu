package com.github.kheltan.gameboy.cpu.instructions.stack;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Register;
import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;

/*
 * Pop the stack and store it to the specified register
 */
public class Pop implements Instruction {
    private final static int SUCCESS_CYCLES = 12;
    private final static int NUM_OF_ARGS = 0;
    private final Register destination;
    public Pop(Register destination){
        this.destination = destination;
    }

    public void execute(CpuContext cpuContext, InstructionContext instructionContext) {
        
        int lsb = cpuContext.read(cpuContext.get(Register.SP));
        cpuContext.set(Register.SP, cpuContext.get(Register.SP) + 1);
        int msb = cpuContext.read(cpuContext.get(Register.SP));
        cpuContext.set(Register.SP, cpuContext.get(Register.SP) + 1);

        int result = (msb << 8) | lsb;
        cpuContext.set(destination, result);
        

        if(destination == Register.AF){
            //TODO: Implement flags
        }
        
    }

    public int getCycles() {
        return SUCCESS_CYCLES;
    }

    @Override
    public int getNumOfArgs() {
        return NUM_OF_ARGS;
    }
    
}
