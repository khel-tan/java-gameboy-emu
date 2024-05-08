package com.github.kheltan.gameboy.cpu.instructions.addressing;

import com.github.kheltan.gameboy.cpu.CpuContext;

public interface AddressingMode {
    int read(CpuContext context);
    void write(CpuContext context);
}
