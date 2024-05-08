package com.github.kheltan.gameboy.cpu;

import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.Registers.Register;
import com.github.kheltan.gameboy.cpu.instructions.addressing.IndirectMode;
import com.github.kheltan.gameboy.cpu.instructions.addressing.RegisterMode;
import com.github.kheltan.gameboy.cpu.instructions.arithmetic.Adc;
import com.github.kheltan.gameboy.cpu.instructions.arithmetic.Add;
import com.github.kheltan.gameboy.cpu.instructions.load.LoadByte;
import com.github.kheltan.gameboy.cpu.instructions.load.LoadByteImmediate;
import com.github.kheltan.gameboy.cpu.instructions.load.LoadWordImmediate;
import com.github.kheltan.gameboy.cpu.instructions.logical.And;
import com.github.kheltan.gameboy.cpu.instructions.logical.Or;
import com.github.kheltan.gameboy.cpu.instructions.logical.Xor;

public class InstructionDecoder {
    public static final InstructionDecoder INSTANCE = new InstructionDecoder();

    private InstructionDecoder() {

    }

    public Instruction decode(final int opcode) {
        Opcode op = Opcode.getOpcode(opcode);
        switch (op) {
            case LD_B_D8:
                return new LoadByteImmediate(new RegisterMode(Register.B));
            case LD_D_D8:
                return new LoadByteImmediate(new RegisterMode(Register.D));
            case LD_H_D8:
                return new LoadByteImmediate(new RegisterMode(Register.H));
            case LD_INDIRECT_HL_D8:
                return new LoadByteImmediate(new IndirectMode(Register.HL));

            case LD_A_INDIRECT_BC:
                return new LoadByteImmediate(new IndirectMode(Register.BC));
            case LD_A_INDIRECT_DE:
                return new LoadByteImmediate(new IndirectMode(Register.DE));

            case LD_C_D8:
                return new LoadByteImmediate(new RegisterMode(Register.C));
            case LD_E_D8:
                return new LoadByteImmediate(new RegisterMode(Register.E));
            case LD_L_D8:
                return new LoadByteImmediate(new RegisterMode(Register.L));
            case LD_A_D8:
                return new LoadByteImmediate(new RegisterMode(Register.A));

            case LD_B_B:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.B));
            case LD_B_C:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.C));
            case LD_B_D:
                return new LoadByte(new RegisterMode(Register.D),
                        new RegisterMode(Register.B));
            case LD_B_E:
                return new LoadByte(new RegisterMode(Register.E),
                        new RegisterMode(Register.B));
            case LD_B_H:
                return new LoadByte(new RegisterMode(Register.H),
                        new RegisterMode(Register.B));
            case LD_B_L:
                return new LoadByte(new RegisterMode(Register.L),
                        new RegisterMode(Register.B));
            case LD_B_INDIRECT_HL:
                return new LoadByte(new IndirectMode(Register.HL),
                        new RegisterMode(Register.B));
            case LD_B_A:
                return new LoadByte(new RegisterMode(Register.A),
                        new RegisterMode(Register.B));

            case LD_C_B:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.C));
            case LD_C_C:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.C));
            case LD_C_D:
                return new LoadByte(new RegisterMode(Register.D),
                        new RegisterMode(Register.C));
            case LD_C_E:
                return new LoadByte(new RegisterMode(Register.E),
                        new RegisterMode(Register.C));
            case LD_C_H:
                return new LoadByte(new RegisterMode(Register.H),
                        new RegisterMode(Register.C));
            case LD_C_L:
                return new LoadByte(new RegisterMode(Register.L),
                        new RegisterMode(Register.C));
            case LD_C_INDIRECT_HL:
                return new LoadByte(new IndirectMode(Register.HL),
                        new RegisterMode(Register.C));
            case LD_C_A:
                return new LoadByte(new RegisterMode(Register.A),
                        new RegisterMode(Register.C));

            case LD_D_B:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.D));
            case LD_D_C:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.D));
            case LD_D_D:
                return new LoadByte(new RegisterMode(Register.D),
                        new RegisterMode(Register.D));
            case LD_D_E:
                return new LoadByte(new RegisterMode(Register.E),
                        new RegisterMode(Register.D));
            case LD_D_H:
                return new LoadByte(new RegisterMode(Register.H),
                        new RegisterMode(Register.D));
            case LD_D_L:
                return new LoadByte(new RegisterMode(Register.L),
                        new RegisterMode(Register.D));
            case LD_D_INDIRECT_HL:
                return new LoadByte(new IndirectMode(Register.HL),
                        new RegisterMode(Register.D));
            case LD_D_A:
                return new LoadByte(new RegisterMode(Register.A),
                        new RegisterMode(Register.D));

            case LD_E_B:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.E));
            case LD_E_C:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.E));
            case LD_E_D:
                return new LoadByte(new RegisterMode(Register.D),
                        new RegisterMode(Register.E));
            case LD_E_E:
                return new LoadByte(new RegisterMode(Register.E),
                        new RegisterMode(Register.E));
            case LD_E_H:
                return new LoadByte(new RegisterMode(Register.H),
                        new RegisterMode(Register.E));
            case LD_E_L:
                return new LoadByte(new RegisterMode(Register.L),
                        new RegisterMode(Register.E));
            case LD_E_INDIRECT_HL:
                return new LoadByte(new IndirectMode(Register.HL),
                        new RegisterMode(Register.E));
            case LD_E_A:
                return new LoadByte(new RegisterMode(Register.A),
                        new RegisterMode(Register.E));

            case LD_H_B:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.H));
            case LD_H_C:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.H));
            case LD_H_D:
                return new LoadByte(new RegisterMode(Register.D),
                        new RegisterMode(Register.H));
            case LD_H_E:
                return new LoadByte(new RegisterMode(Register.E),
                        new RegisterMode(Register.H));
            case LD_H_H:
                return new LoadByte(new RegisterMode(Register.H),
                        new RegisterMode(Register.H));
            case LD_H_L:
                return new LoadByte(new RegisterMode(Register.L),
                        new RegisterMode(Register.H));
            case LD_H_INDIRECT_HL:
                return new LoadByte(new IndirectMode(Register.HL),
                        new RegisterMode(Register.H));
            case LD_H_A:
                return new LoadByte(new RegisterMode(Register.A),
                        new RegisterMode(Register.H));

            case LD_L_B:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.L));
            case LD_L_C:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.L));
            case LD_L_D:
                return new LoadByte(new RegisterMode(Register.D),
                        new RegisterMode(Register.L));
            case LD_L_E:
                return new LoadByte(new RegisterMode(Register.E),
                        new RegisterMode(Register.L));
            case LD_L_H:
                return new LoadByte(new RegisterMode(Register.H),
                        new RegisterMode(Register.L));
            case LD_L_L:
                return new LoadByte(new RegisterMode(Register.L),
                        new RegisterMode(Register.L));
            case LD_L_INDIRECT_HL:
                return new LoadByte(new IndirectMode(Register.HL),
                        new RegisterMode(Register.L));
            case LD_L_A:
                return new LoadByte(new RegisterMode(Register.A),
                        new RegisterMode(Register.L));

            case LD_INDIRECT_HL_B:
                return new LoadByte(new RegisterMode(Register.B),
                        new IndirectMode(Register.HL));
            case LD_INDIRECT_HL_C:
                return new LoadByte(new RegisterMode(Register.C),
                        new IndirectMode(Register.HL));
            case LD_INDIRECT_HL_D:
                return new LoadByte(new RegisterMode(Register.D),
                        new IndirectMode(Register.HL));
            case LD_INDIRECT_HL_E:
                return new LoadByte(new RegisterMode(Register.E),
                        new IndirectMode(Register.HL));
            case LD_INDIRECT_HL_H:
                return new LoadByte(new RegisterMode(Register.H),
                        new IndirectMode(Register.HL));
            case LD_INDIRECT_HL_L:
                return new LoadByte(new RegisterMode(Register.L),
                        new IndirectMode(Register.HL));

            case LD_A_B:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.A));
            case LD_A_C:
                return new LoadByte(new RegisterMode(Register.B),
                        new RegisterMode(Register.A));
            case LD_A_D:
                return new LoadByte(new RegisterMode(Register.D),
                        new RegisterMode(Register.A));
            case LD_A_E:
                return new LoadByte(new RegisterMode(Register.E),
                        new RegisterMode(Register.A));
            case LD_A_H:
                return new LoadByte(new RegisterMode(Register.H),
                        new RegisterMode(Register.A));
            case LD_A_L:
                return new LoadByte(new RegisterMode(Register.L),
                        new RegisterMode(Register.A));
            case LD_A_INDIRECT_HL:
                return new LoadByte(new IndirectMode(Register.HL),
                        new RegisterMode(Register.A));
            case LD_A_A:
                return new LoadByte(new RegisterMode(Register.A),
                        new RegisterMode(Register.A));
            
            /*
             * 16bit load/store/move instructions
             */
            case LD_BC_D16:
                return new LoadWordImmediate(new RegisterMode(Register.BC));
            case LD_DE_D16:
                return new LoadWordImmediate(new RegisterMode(Register.DE));
            case LD_HL_D16:
                return new LoadWordImmediate(new RegisterMode(Register.HL));
            case LD_SP_D16:
                return new LoadWordImmediate(new RegisterMode(Register.SP));

            /*
             * 	8bit arithmetic/logical instructions
             */

            case ADD_A_B:
                return new Add(new RegisterMode(Register.B));
            case ADD_A_C:
                return new Add(new RegisterMode(Register.C));
            case ADD_A_D:
                return new Add(new RegisterMode(Register.D));
            case ADD_A_E:
                return new Add(new RegisterMode(Register.E));
            case ADD_A_H:
                return new Add(new RegisterMode(Register.H));
            case ADD_A_L:
                return new Add(new RegisterMode(Register.L));
            case ADD_A_A:
                return new Add(new RegisterMode(Register.A));
            case ADC_A_B:
                return new Adc(new RegisterMode(Register.B));
            case ADC_A_C:
                return new Adc(new RegisterMode(Register.C));
            case ADC_A_D:
                return new Adc(new RegisterMode(Register.D));
            case ADC_A_E:
                return new Adc(new RegisterMode(Register.E));
            case ADC_A_H:
                return new Adc(new RegisterMode(Register.H));
            case ADC_A_L:
                return new Adc(new RegisterMode(Register.L));
            case ADC_A_A:
                return new Adc(new RegisterMode(Register.A));
            case AND_B:
                return new And(new RegisterMode(Register.B));
            case AND_C:
                return new And(new RegisterMode(Register.C));
            case AND_D:
                return new And(new RegisterMode(Register.D));
            case AND_E:
                return new And(new RegisterMode(Register.E));
            case AND_H:
                return new And(new RegisterMode(Register.H));
            case AND_L:
                return new And(new RegisterMode(Register.L));
            case AND_A:
                return new And(new RegisterMode(Register.A));
            case XOR_B:
                return new Xor(new RegisterMode(Register.B));
            case XOR_C:
                return new Xor(new RegisterMode(Register.C));
            case XOR_D:
                return new Xor(new RegisterMode(Register.D));
            case XOR_E:
                return new Xor(new RegisterMode(Register.E));
            case XOR_H:
                return new Xor(new RegisterMode(Register.H));
            case XOR_L:
                return new Xor(new RegisterMode(Register.L));
            case XOR_A:
                return new Xor(new RegisterMode(Register.A));
            case OR_B:
                return new Or(new RegisterMode(Register.B));
            case OR_C:
                return new Or(new RegisterMode(Register.C));
            case OR_D:
                return new Or(new RegisterMode(Register.D));
            case OR_E:
                return new Or(new RegisterMode(Register.E));
            case OR_H:
                return new Or(new RegisterMode(Register.H));
            case OR_L:
                return new Or(new RegisterMode(Register.L));
            case OR_A:
                return new Or(new RegisterMode(Register.A));
            default:
                throw new IllegalArgumentException("Unknown opcode");
        }
    }
}
