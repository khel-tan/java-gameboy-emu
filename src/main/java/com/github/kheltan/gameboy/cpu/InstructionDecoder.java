package com.github.kheltan.gameboy.cpu;

import com.github.kheltan.gameboy.cpu.Registers.Register;
import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.ImmediateByteMode;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.ImmediateWordMode;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.IndirectMode;
import com.github.kheltan.gameboy.cpu.instructions.addressing_mode.RegisterMode;
import com.github.kheltan.gameboy.cpu.instructions.arithmetic.Adc;
import com.github.kheltan.gameboy.cpu.instructions.arithmetic.Add;
import com.github.kheltan.gameboy.cpu.instructions.arithmetic.Decrement;
import com.github.kheltan.gameboy.cpu.instructions.arithmetic.Increment;
import com.github.kheltan.gameboy.cpu.instructions.arithmetic.Sbc;
import com.github.kheltan.gameboy.cpu.instructions.arithmetic.Sub;
import com.github.kheltan.gameboy.cpu.instructions.branch.RelativeJump;
import com.github.kheltan.gameboy.cpu.instructions.branch_mode.CarryBranch;
import com.github.kheltan.gameboy.cpu.instructions.branch_mode.ImmediateBranch;
import com.github.kheltan.gameboy.cpu.instructions.branch_mode.NotCarryBranch;
import com.github.kheltan.gameboy.cpu.instructions.branch_mode.NotZeroBranch;
import com.github.kheltan.gameboy.cpu.instructions.branch_mode.ZeroBranch;
import com.github.kheltan.gameboy.cpu.instructions.load.Load;
import com.github.kheltan.gameboy.cpu.instructions.logical.And;
import com.github.kheltan.gameboy.cpu.instructions.logical.Compare;
import com.github.kheltan.gameboy.cpu.instructions.logical.Or;
import com.github.kheltan.gameboy.cpu.instructions.logical.Xor;

public class InstructionDecoder {
    public static final InstructionDecoder INSTANCE = new InstructionDecoder();

    private InstructionDecoder() {

    }

    public Instruction decode(final int opcode) {
        Opcode op = Opcode.getOpcode(opcode);
        System.out.println("Opcode : " + op);
        switch (op) {
            /*
             * Jumps/calls
             */
            case JR_NZ_R8:
                return new RelativeJump(new NotZeroBranch());
            case JR_NC_R8:
                return new RelativeJump(new NotCarryBranch());
            case JR_R8:
                return new RelativeJump(new ImmediateBranch());
            case JR_Z_R8:
                return new RelativeJump(new ZeroBranch());
            case JR_C_R8:
                return new RelativeJump(new CarryBranch());

            /*
             * 8bit load/store/move instructions
             */
            case LD_INDIRECT_BC_A:
                return new Load(new RegisterMode(Register.A),
                        new IndirectMode(Register.BC));
            case LD_INDIRECT_DE_A:
                return new Load(new RegisterMode(Register.A),
                        new IndirectMode(Register.DE));

            case LD_B_D8:
                return new Load(new ImmediateByteMode(),
                        new RegisterMode(Register.B));
            case LD_D_D8:
                return new Load(new ImmediateByteMode(),
                        new RegisterMode(Register.D));
            case LD_H_D8:
                return new Load(new ImmediateByteMode(),
                        new RegisterMode(Register.H));
            case LD_INDIRECT_HL_D8:
                return new Load(new ImmediateByteMode(),
                        new IndirectMode(Register.HL));

            case LD_A_INDIRECT_BC:
                return new Load(new IndirectMode(Register.BC),
                        new RegisterMode(Register.A));
            case LD_A_INDIRECT_DE:
                return new Load(new IndirectMode(Register.DE),
                        new RegisterMode(Register.A));

            case LD_C_D8:
                return new Load(new ImmediateByteMode(), new RegisterMode(Register.C));
            case LD_E_D8:
                return new Load(new ImmediateByteMode(),
                        new RegisterMode(Register.E));
            case LD_L_D8:
                return new Load(new ImmediateByteMode(),
                        new RegisterMode(Register.L));
            case LD_A_D8:
                return new Load(new ImmediateByteMode(),
                        new RegisterMode(Register.A));

            case LD_B_B:
                return new Load(new RegisterMode(Register.B),
                        new RegisterMode(Register.B));
            case LD_B_C:
                return new Load(new RegisterMode(Register.B),
                        new RegisterMode(Register.C));
            case LD_B_D:
                return new Load(new RegisterMode(Register.D),
                        new RegisterMode(Register.B));
            case LD_B_E:
                return new Load(new RegisterMode(Register.E),
                        new RegisterMode(Register.B));
            case LD_B_H:
                return new Load(new RegisterMode(Register.H),
                        new RegisterMode(Register.B));
            case LD_B_L:
                return new Load(new RegisterMode(Register.L),
                        new RegisterMode(Register.B));
            case LD_B_INDIRECT_HL:
                return new Load(new IndirectMode(Register.HL),
                        new RegisterMode(Register.B));
            case LD_B_A:
                return new Load(new RegisterMode(Register.A),
                        new RegisterMode(Register.B));

            case LD_C_B:
                return new Load(new RegisterMode(Register.B),
                        new RegisterMode(Register.C));
            case LD_C_C:
                return new Load(new RegisterMode(Register.B),
                        new RegisterMode(Register.C));
            case LD_C_D:
                return new Load(new RegisterMode(Register.D),
                        new RegisterMode(Register.C));
            case LD_C_E:
                return new Load(new RegisterMode(Register.E),
                        new RegisterMode(Register.C));
            case LD_C_H:
                return new Load(new RegisterMode(Register.H),
                        new RegisterMode(Register.C));
            case LD_C_L:
                return new Load(new RegisterMode(Register.L),
                        new RegisterMode(Register.C));
            case LD_C_INDIRECT_HL:
                return new Load(new IndirectMode(Register.HL),
                        new RegisterMode(Register.C));
            case LD_C_A:
                return new Load(new RegisterMode(Register.A),
                        new RegisterMode(Register.C));

            case LD_D_B:
                return new Load(new RegisterMode(Register.B),
                        new RegisterMode(Register.D));
            case LD_D_C:
                return new Load(new RegisterMode(Register.C),
                        new RegisterMode(Register.D));
            case LD_D_D:
                return new Load(new RegisterMode(Register.D),
                        new RegisterMode(Register.D));
            case LD_D_E:
                return new Load(new RegisterMode(Register.E),
                        new RegisterMode(Register.D));
            case LD_D_H:
                return new Load(new RegisterMode(Register.H),
                        new RegisterMode(Register.D));
            case LD_D_L:
                return new Load(new RegisterMode(Register.L),
                        new RegisterMode(Register.D));
            case LD_D_INDIRECT_HL:
                return new Load(new IndirectMode(Register.HL),
                        new RegisterMode(Register.D));
            case LD_D_A:
                return new Load(new RegisterMode(Register.A),
                        new RegisterMode(Register.D));

            case LD_E_B:
                return new Load(new RegisterMode(Register.B),
                        new RegisterMode(Register.E));
            case LD_E_C:
                return new Load(new RegisterMode(Register.C),
                        new RegisterMode(Register.E));
            case LD_E_D:
                return new Load(new RegisterMode(Register.D),
                        new RegisterMode(Register.E));
            case LD_E_E:
                return new Load(new RegisterMode(Register.E),
                        new RegisterMode(Register.E));
            case LD_E_H:
                return new Load(new RegisterMode(Register.H),
                        new RegisterMode(Register.E));
            case LD_E_L:
                return new Load(new RegisterMode(Register.L),
                        new RegisterMode(Register.E));
            case LD_E_INDIRECT_HL:
                return new Load(new IndirectMode(Register.HL),
                        new RegisterMode(Register.E));
            case LD_E_A:
                return new Load(new RegisterMode(Register.A),
                        new RegisterMode(Register.E));

            case LD_H_B:
                return new Load(new RegisterMode(Register.B),
                        new RegisterMode(Register.H));
            case LD_H_C:
                return new Load(new RegisterMode(Register.C),
                        new RegisterMode(Register.H));
            case LD_H_D:
                return new Load(new RegisterMode(Register.D),
                        new RegisterMode(Register.H));
            case LD_H_E:
                return new Load(new RegisterMode(Register.E),
                        new RegisterMode(Register.H));
            case LD_H_H:
                return new Load(new RegisterMode(Register.H),
                        new RegisterMode(Register.H));
            case LD_H_L:
                return new Load(new RegisterMode(Register.L),
                        new RegisterMode(Register.H));
            case LD_H_INDIRECT_HL:
                return new Load(new IndirectMode(Register.HL),
                        new RegisterMode(Register.H));
            case LD_H_A:
                return new Load(new RegisterMode(Register.A),
                        new RegisterMode(Register.H));

            case LD_L_B:
                return new Load(new RegisterMode(Register.B),
                        new RegisterMode(Register.L));
            case LD_L_C:
                return new Load(new RegisterMode(Register.C),
                        new RegisterMode(Register.L));
            case LD_L_D:
                return new Load(new RegisterMode(Register.D),
                        new RegisterMode(Register.L));
            case LD_L_E:
                return new Load(new RegisterMode(Register.E),
                        new RegisterMode(Register.L));
            case LD_L_H:
                return new Load(new RegisterMode(Register.H),
                        new RegisterMode(Register.L));
            case LD_L_L:
                return new Load(new RegisterMode(Register.L),
                        new RegisterMode(Register.L));
            case LD_L_INDIRECT_HL:
                return new Load(new IndirectMode(Register.HL),
                        new RegisterMode(Register.L));
            case LD_L_A:
                return new Load(new RegisterMode(Register.A),
                        new RegisterMode(Register.L));

            case LD_INDIRECT_HL_B:
                return new Load(new RegisterMode(Register.B),
                        new IndirectMode(Register.HL));
            case LD_INDIRECT_HL_C:
                return new Load(new RegisterMode(Register.C),
                        new IndirectMode(Register.HL));
            case LD_INDIRECT_HL_D:
                return new Load(new RegisterMode(Register.D),
                        new IndirectMode(Register.HL));
            case LD_INDIRECT_HL_E:
                return new Load(new RegisterMode(Register.E),
                        new IndirectMode(Register.HL));
            case LD_INDIRECT_HL_H:
                return new Load(new RegisterMode(Register.H),
                        new IndirectMode(Register.HL));
            case LD_INDIRECT_HL_L:
                return new Load(new RegisterMode(Register.L),
                        new IndirectMode(Register.HL));
            case LD_INDIRECT_HL_A:
                return new Load(new RegisterMode(Register.A),
                        new IndirectMode(Register.HL));

            case LD_A_B:
                return new Load(new RegisterMode(Register.B),
                        new RegisterMode(Register.A));
            case LD_A_C:
                return new Load(new RegisterMode(Register.C),
                        new RegisterMode(Register.A));
            case LD_A_D:
                return new Load(new RegisterMode(Register.D),
                        new RegisterMode(Register.A));
            case LD_A_E:
                return new Load(new RegisterMode(Register.E),
                        new RegisterMode(Register.A));
            case LD_A_H:
                return new Load(new RegisterMode(Register.H),
                        new RegisterMode(Register.A));
            case LD_A_L:
                return new Load(new RegisterMode(Register.L),
                        new RegisterMode(Register.A));
            case LD_A_INDIRECT_HL:
                return new Load(new IndirectMode(Register.HL),
                        new RegisterMode(Register.A));
            case LD_A_A:
                return new Load(new RegisterMode(Register.A),
                        new RegisterMode(Register.A));

            /*
             * 16bit load/store/move instructions
             */
            case LD_BC_D16:
                return new Load(new ImmediateWordMode(), new RegisterMode(Register.BC));
            case LD_DE_D16:
                return new Load(new ImmediateWordMode(), new RegisterMode(Register.DE));
            case LD_HL_D16:
                return new Load(new ImmediateWordMode(), new RegisterMode(Register.HL));
            case LD_SP_D16:
                return new Load(new ImmediateWordMode(), new RegisterMode(Register.SP));

            /*
             * 8bit arithmetic/logical instructions
             */
            case INC_B:
                return new Increment(new RegisterMode(Register.B));
            case DEC_B:
                return new Decrement(new RegisterMode(Register.B));
            case INC_D:
                return new Increment(new RegisterMode(Register.D));
            case DEC_D:
                return new Decrement(new RegisterMode(Register.D));
            case INC_H:
                return new Increment(new RegisterMode(Register.H));
            case DEC_H:
                return new Decrement(new RegisterMode(Register.H));
            case INC_INDIRECT_HL:
                return new Increment(new IndirectMode(Register.HL));
            case DEC_INDIRECT_HL:
                return new Decrement(new IndirectMode(Register.HL));

            case INC_C:
                return new Increment(new RegisterMode(Register.C));
            case DEC_C:
                return new Decrement(new RegisterMode(Register.C));
            case INC_E:
                return new Increment(new RegisterMode(Register.E));
            case DEC_E:
                return new Decrement(new RegisterMode(Register.E));
            case INC_L:
                return new Increment(new RegisterMode(Register.L));
            case DEC_L:
                return new Decrement(new RegisterMode(Register.L));
            case INC_A:
                return new Increment(new RegisterMode(Register.A));
            case DEC_A:
                return new Decrement(new RegisterMode(Register.A));

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
            case ADD_A_INDIRECT_HL:
                return new Add(new IndirectMode(Register.HL));

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
            case ADC_A_INDIRECT_HL:
                return new Adc(new IndirectMode(Register.HL));
            case ADC_A_A:
                return new Adc(new RegisterMode(Register.A));

            case SUB_B:
                return new Sub(new RegisterMode(Register.B));
            case SUB_C:
                return new Sub(new RegisterMode(Register.C));
            case SUB_D:
                return new Sub(new RegisterMode(Register.D));
            case SUB_E:
                return new Sub(new RegisterMode(Register.E));
            case SUB_H:
                return new Sub(new RegisterMode(Register.H));
            case SUB_L:
                return new Sub(new RegisterMode(Register.L));
            case SUB_INDIRECT_HL:
                return new Sub(new IndirectMode(Register.HL));
            case SUB_A:
                return new Sub(new RegisterMode(Register.A));

            case SBC_A_B:
                return new Sbc(new RegisterMode(Register.B));
            case SBC_A_C:
                return new Sbc(new RegisterMode(Register.C));
            case SBC_A_D:
                return new Sbc(new RegisterMode(Register.D));
            case SBC_A_E:
                return new Sbc(new RegisterMode(Register.E));
            case SBC_A_H:
                return new Sbc(new RegisterMode(Register.H));
            case SBC_A_L:
                return new Sbc(new RegisterMode(Register.L));
            case SBC_A_INDIRECT_HL:
                return new Sbc(new IndirectMode(Register.HL));
            case SBC_A_A:
                return new Sbc(new RegisterMode(Register.A));

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
            case AND_INDIRECT_HL:
                return new And(new IndirectMode(Register.HL));
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
            case XOR_INDIRECT_HL:
                return new Xor(new IndirectMode(Register.HL));
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
            case OR_INDIRECT_HL:
                return new Or(new IndirectMode(Register.HL));
            case OR_A:
                return new Or(new RegisterMode(Register.A));

            case CP_B:
                return new Compare(new RegisterMode(Register.B));
            case CP_C:
                return new Compare(new RegisterMode(Register.C));
            case CP_D:
                return new Compare(new RegisterMode(Register.D));
            case CP_E:
                return new Compare(new RegisterMode(Register.E));
            case CP_H:
                return new Compare(new RegisterMode(Register.H));
            case CP_L:
                return new Compare(new RegisterMode(Register.L));
            case CP_INDIRECT_HL:
                return new Compare(new IndirectMode(Register.HL));
            case CP_A:
                return new Compare(new RegisterMode(Register.A));

            /*
             * 16bit arithmetic/logical instructions
             */
            case INC_BC:
                return new Increment(new RegisterMode(Register.BC));
            case INC_DE:
                return new Increment(new RegisterMode(Register.DE));
            case INC_HL:
                return new Increment(new RegisterMode(Register.HL));
            case INC_SP:
                return new Increment(new RegisterMode(Register.SP));

            case DEC_BC:
                return new Decrement(new RegisterMode(Register.BC));
            case DEC_DE:
                return new Decrement(new RegisterMode(Register.DE));
            case DEC_HL:
                return new Decrement(new RegisterMode(Register.HL));
            case DEC_SP:
                return new Decrement(new RegisterMode(Register.SP));

            default:
                throw new IllegalArgumentException("Unknown opcode");
        }
    }
}
