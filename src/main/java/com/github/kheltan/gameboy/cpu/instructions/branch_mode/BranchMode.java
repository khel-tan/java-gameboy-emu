package com.github.kheltan.gameboy.cpu.instructions.branch_mode;

import com.github.kheltan.gameboy.cpu.CpuContext;

/*
 * An instance of BranchMode is used by an instance of Instruction to separate the concern of
 * manually checking certain flags from the instruction classes.x
 */
public interface BranchMode {
    /*
     * @param cpuContext the state of the CPU : the memory bus, registers, etc
     * This method checks the flag associated with the class
     */
    boolean checkCondition(CpuContext cpuContext);
}
