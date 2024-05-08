package com.github.kheltan.gameboy.cpu;

import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.Registers.Register;

import com.github.kheltan.gameboy.cpu.instructions.addressing.ImmediateMode;
import com.github.kheltan.gameboy.cpu.instructions.load.LoadByteImmediate;
import com.github.kheltan.gameboy.cpu.instructions.load.LoadWordImmediate;

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
            case LD_BC_D16:
                return new LoadWordImmediate(new ImmediateMode(Register.BC));
            case LD_DE_D16:
                return new LoadWordImmediate(new ImmediateMode(Register.DE));
            case LD_HL_D16:
                return new LoadWordImmediate(new ImmediateMode(Register.HL));
            case LD_SP_D16:
                return new LoadWordImmediate(new ImmediateMode(Register.SP));
            default:
                throw new IllegalArgumentException("Unknown opcode");
        }
    }
}
