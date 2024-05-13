package com.github.kheltan.gameboy.cpu.instructions.branch_mode;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Flag;

/*
 * Is the carry flag set?
 */
public class CarryBranch implements BranchMode {

    @Override
    public boolean checkCondition(CpuContext cpuContext) {
        return cpuContext.get(Flag.Carry) == true;
    }
    
}
