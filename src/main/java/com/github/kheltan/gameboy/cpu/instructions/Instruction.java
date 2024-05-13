package com.github.kheltan.gameboy.cpu.instructions;

import com.github.kheltan.gameboy.cpu.CpuContext;
/*
 * Interface representing a CPU instruction
 * This interface defines the framework for implementing the behaviour of instructions.
 */
public interface Instruction {
    /*
     * Returns the number of CPU cycles the instruction consumes when executed.
     * For branching instructions, the number depends on whether they branched or not.
     * @return the number of CPU cycles the instruction takes to execute
     */
    int getCycles();

    /*
     * @return the number of arguments the instruction consumes
     */
    int getNumOfArgs();

    /*
     * Executes the instruction within the context of the specified CPU.
     * This method is responsible for manipulating the CPU's state according
     * to the semantics of the instruction, which may involve modifying registers,
     * updating flags, performing arithmetic operations, handling interrupts,
     * or interacting with memory. If the instruction takes arguments, they are provided
     * by the CPU through the Instruction Context
     *
     * @param cpuContext the context of the CPU on which this instruction operates,
     *                   providing access to CPU registers, memory, and other components
     * @param instructionContext additional context specific to this instruction, 
     *                  such as arguments
     */
    void execute(CpuContext cpuContext,
                InstructionContext instructionContext);
}
