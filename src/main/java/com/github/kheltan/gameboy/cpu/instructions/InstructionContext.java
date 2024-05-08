package com.github.kheltan.gameboy.cpu.instructions;

import java.util.List;

public class InstructionContext {
    private final List<Integer> arguments;
    public List<Integer> getArguments() {
        return arguments;
    }
    public InstructionContext(final List<Integer> arguments){
        this.arguments = arguments;
    }
}
