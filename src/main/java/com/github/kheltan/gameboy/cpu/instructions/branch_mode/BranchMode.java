package com.github.kheltan.gameboy.cpu.instructions.branch_mode;

import com.github.kheltan.gameboy.cpu.CpuContext;

/*
 * An instance of BranchMode is used by an instance of Instruction to separate the concern of
 * checking certain flags from the instruction classes.x
 */
public interface BranchMode {
    boolean checkCondition(CpuContext cpuContext);
}
