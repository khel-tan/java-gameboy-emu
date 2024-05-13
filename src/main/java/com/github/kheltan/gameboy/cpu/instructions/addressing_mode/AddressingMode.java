package com.github.kheltan.gameboy.cpu.instructions.addressing_mode;

import com.github.kheltan.gameboy.cpu.CpuContext;

/*
 * An instance of AddressingMode is used by an instance of Instruction to
 * read and write from registers/memory/immeditate values. This is intended to separate
 * the concern of the semantics of read/writes from the concern of the actual operations
 * that the instruction must perform.
 */

public interface AddressingMode {
    int read(CpuContext context);
    void write(CpuContext context, int value);
}
