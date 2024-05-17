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

/**
 * Load instruction covering all LD *, * cases where the value from the source is loaded to the destination.
 * The source is either a register, a location in memory or an immediate byte/word.
 * The destination is either a register or a location in memory.
 */
public class Load implements Instruction {
    private final int SUCCESS_CYCLES;
    private final int NUM_OF_ARGS;
    private AddressingMode sourceAddressingMode;
    private final AddressingMode destinationAddressingMode;

    /*
    The Addressing Mode abstracts away whether it is a register, a memory location or an immediate value.
    @param sourceAddressingMode We read the value from this.
    @param destinationAddressingMode This is where we write the value to.
     */    
    public Load(final AddressingMode sourceAddressingMode,
                            final AddressingMode destinationAddressingMode){
        this.sourceAddressingMode = sourceAddressingMode;
        this.destinationAddressingMode = destinationAddressingMode;

        // Load an immediate byte value (8 bits)
        if(this.sourceAddressingMode.getClass() == ImmediateByteMode.class){
            this.SUCCESS_CYCLES = 8;
            this.NUM_OF_ARGS = 1;
        }
        // Load an immediate word value (16 bits)
        else if(this.sourceAddressingMode.getClass() == ImmediateWordMode.class){
            this.SUCCESS_CYCLES = 12;
            this.NUM_OF_ARGS = 2;
        }
        // If this is a Move instruction between registers
        else if(this.sourceAddressingMode.getClass() == RegisterMode.class &&
                this.destinationAddressingMode.getClass() == RegisterMode.class){
            this.SUCCESS_CYCLES = 4;
            this.NUM_OF_ARGS = 0;
        }
        // Otherwise, this is a 
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
