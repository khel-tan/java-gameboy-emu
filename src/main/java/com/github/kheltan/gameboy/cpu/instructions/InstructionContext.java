package com.github.kheltan.gameboy.cpu.instructions;

import java.util.List;

/*
 * Provides the context needed for executing an instruction
 */
public class InstructionContext {
    private final List<Integer> arguments;
    /*
     * @param arguments A list of integers representing the arguments to an instructions
     */
    public InstructionContext(final List<Integer> arguments){
        this.arguments = arguments;
    }
    /*
     * Return arguments
     */
    public List<Integer> getArguments() {
        return arguments;
    }
    
}
