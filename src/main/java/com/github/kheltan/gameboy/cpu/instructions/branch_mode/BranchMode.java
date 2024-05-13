package com.github.kheltan.gameboy.cpu.instructions.branch_mode;

import com.github.kheltan.gameboy.cpu.CpuContext;

public interface BranchMode {
    boolean checkCondition(CpuContext cpuContext);
}
