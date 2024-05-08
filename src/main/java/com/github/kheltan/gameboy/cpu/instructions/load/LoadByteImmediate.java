package com.github.kheltan.gameboy.cpu.instructions.load;

import java.util.List;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;
import com.github.kheltan.gameboy.cpu.instructions.addressing.AddressingMode;

public class LoadByteImmediate extends LoadImmediate {
    private static final int SUCCESS_CYCLES = 8;
    private static final int NUM_OF_ARGS = 1;

    public LoadByteImmediate(final AddressingMode addressingMode){
        super(addressingMode);
    }
    @Override
    public void execute(CpuContext cpuContext,
                        InstructionContext instructionContext) {
        List<Integer> args = instructionContext.getArguments();
        if(args.size() != NUM_OF_ARGS){
            
        }
        getAddressingMode().write(cpuContext, args.get(0));

        
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
