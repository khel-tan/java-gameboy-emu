package com.github.kheltan.gameboy.cpu.instructions.branch_mode;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers.Flag;

public class ZeroBranch implements BranchMode {

    @Override
    public boolean checkCondition(CpuContext cpuContext) {
        return cpuContext.get(Flag.Zero) == true;
    }
    
}
