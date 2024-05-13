package com.github.kheltan.gameboy.cpu.instructions.load;

import java.util.List;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.AddressingMode;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.ImmediateByteMode;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.ImmediateMode;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.ImmediateWordMode;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.RegisterMode;

/*
 * Load instruction covering all LD *, * cases
 */
public class Load implements Instruction {
    private final int SUCCESS_CYCLES;
    private final int NUM_OF_ARGS;
    private AddressingMode sourceAddressingMode;
    private final AddressingMode destinationAddressingMode;

    
    public Load(final AddressingMode sourceAddressingMode,
                            final AddressingMode destinationAddressingMode){
        this.sourceAddressingMode = sourceAddressingMode;
        this.destinationAddressingMode = destinationAddressingMode;
        if(this.sourceAddressingMode.getClass() == ImmediateByteMode.class){
            this.SUCCESS_CYCLES = 8;
            this.NUM_OF_ARGS = 1;
        }
        else if(this.sourceAddressingMode.getClass() == ImmediateWordMode.class){
            this.SUCCESS_CYCLES = 12;
            this.NUM_OF_ARGS = 2;
        }
        else if(this.sourceAddressingMode.getClass() == RegisterMode.class &&
                this.destinationAddressingMode.getClass() == RegisterMode.class){
            this.SUCCESS_CYCLES = 4;
            this.NUM_OF_ARGS = 0;
        }
        else{
            this.SUCCESS_CYCLES = 8;
            this.NUM_OF_ARGS = 0;
        }
    }
    @Override
    public void execute(CpuContext cpuContext, InstructionContext instructionContext) {
        int value = 0;
        if(this.sourceAddressingMode instanceof ImmediateMode){
            List<Integer> arguments = instructionContext.getArguments();
            for(int i = 0; i < arguments.size(); i++){
                value = value | (arguments.get(i) << 8* i);
            }
        }
        else{
            value = this.sourceAddressingMode.read(cpuContext);
        }
        this.destinationAddressingMode
            .write(cpuContext, value);
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
