package com.github.kheltan.gameboy.cpu;

import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.Registers.Register;

import com.github.kheltan.gameboy.cpu.instructions.addressing.ImmediateMode;
import com.github.kheltan.gameboy.cpu.instructions.load.LoadByteImmediate;

public class InstructionDecoder {
    public static final InstructionDecoder INSTANCE = new InstructionDecoder();

    private InstructionDecoder() {

    }

    public Instruction decode(final int opcode) {
        Opcode op = Opcode.getOpcode(opcode);
        switch (op) {
            case LD_B_D8:
                return new LoadByteImmediate(new ImmediateMode(Register.B));
            case LD_D_D8:
                return new LoadByteImmediate(new ImmediateMode(Register.D));
            case LD_H_D8:
                return new LoadByteImmediate(new ImmediateMode(Register.H));
            case LD_C_D8:
                return new LoadByteImmediate(new ImmediateMode(Register.C));
            case LD_E_D8:
                return new LoadByteImmediate(new ImmediateMode(Register.E));
            case LD_L_D8:
                return new LoadByteImmediate(new ImmediateMode(Register.L));
            case LD_A_D8:
                return new LoadByteImmediate(new ImmediateMode(Register.A));
            default:
                throw new IllegalArgumentException("Unknown opcode");
        }
    }
}
