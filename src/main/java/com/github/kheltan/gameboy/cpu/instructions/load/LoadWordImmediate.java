package com.github.kheltan.gameboy.cpu.instructions.load;

import java.util.List;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;
import com.github.kheltan.gameboy.cpu.instructions.addressing.AddressingMode;

public class LoadWordImmediate extends LoadImmediate{
    private static final int SUCCESS_CYCLES = 16;
    private static final int NUM_OF_ARGS = 2;
    public LoadWordImmediate(final AddressingMode addressingMode){
        super(addressingMode);
    }

    @Override
    public void execute(CpuContext cpuContext, InstructionContext instructionContext) {
        List<Integer> arguments = instructionContext.getArguments();
        if(arguments.size() != NUM_OF_ARGS){
            
        }
        int loadValue = (arguments.get(1) << 8) | arguments.get(0);
        getAddressingMode().write(cpuContext, loadValue);
        

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
