package com.github.kheltan.gameboy.cpu.instructions.branch;

import java.util.List;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Register;
import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;
import com.github.kheltan.gameboy.cpu.instructions.branch_mode.BranchMode;
import com.github.kheltan.gameboy.cpu.instructions.branch_mode.ImmediateBranch;

/*
 * Relative jumps take an 8 bit value v as an operand and jump to currentValue + v.
 */
public class RelativeJump implements Instruction {
    private final int SUCCESS_CYCLES;
    private final int FAILURE_CYCLES;
    private final int NUM_OF_ARGS;

    private final BranchMode branchMode;
    
    public RelativeJump(BranchMode branchMode){
        this.branchMode = branchMode;
        if(this.branchMode instanceof ImmediateBranch){
            this.SUCCESS_CYCLES = 12;
            this.FAILURE_CYCLES = 12;

            this.NUM_OF_ARGS = 1;
        }
        else{
            this.SUCCESS_CYCLES = 12;
            this.FAILURE_CYCLES = 8;

            this.NUM_OF_ARGS = 1;
        }

    }

    @Override
    public void execute(CpuContext cpuContext, InstructionContext instructionContext) {
        boolean condition = false;
        if(this.branchMode instanceof ImmediateBranch){
            
            condition = true;
        }
        else{
            condition = this.branchMode.checkCondition(cpuContext);
        }
        int value = 0;
        List<Integer> arguments = instructionContext.getArguments();
        for(int i = 0; i < arguments.size(); i++){
            value = (value << 8) | arguments.get(i);
        }
        if(condition){
            
            cpuContext.set(Register.PC, cpuContext.get(Register.PC) + value);
        }
        
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
