package com.github.kheltan.gameboy.cpu.instructions.branch_mode;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Flag;

/*
 * Check if the zero flag is unset
 */
public class NotZeroBranch implements BranchMode {
    @Override
    public boolean checkCondition(CpuContext cpuContext) {
        return cpuContext.get(Flag.Zero) != true;
    }
}
