package com.github.kheltan.gameboy.cpu.instructions.branch_mode;

import com.github.kheltan.gameboy.cpu.CpuContext;

/*
 * For immediate jump instructions. You are not supposed to check the condition in this case.
 */
public class ImmediateBranch implements BranchMode{

    @Override
    public boolean checkCondition(CpuContext cpuContext) {
        throw new IllegalArgumentException("There is no condition to be checked in immediate mode!");
    }
    
}
