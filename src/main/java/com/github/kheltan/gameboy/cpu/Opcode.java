package com.github.kheltan.gameboy.cpu;

import java.util.HashMap;
import java.util.Map;

public enum Opcode {
    NOP(0x00),
    STOP(0x10),
    HALT(0x76),
    PREFIX(0xCB),
    DI(0xF3),
    EI(0xFB),

    JR_NZ_R8(0x20),
    JR_NC_R8(0x30),
    JR_R8(0x18),
    JR_Z_R8(0x28),
    JR_C_R8(0x38),
    RET_NZ(0xC0),
    RET_NC(0xD0),
    JP_NZ_A16(0xC2),
    JP_NC_A16(0xD2),
    JP_A16(0xC3),
    CALL_NZ_A16(0xC4),
    CALL_NC_A16(0xD4),
    RST_00H(0xC7),
    RST_10H(0xD7),
    RST_20H(0xE7),
    RST_30H(0xF7),
    RET_Z(0xC8),
    RET_C(0xD8),
    RET(0xC9),
    RETI(0xD9),
    JP_INDIRECT_HL(0xE9),
    JP_Z_A16(0xCA),
    JP_C_A16(0xDA),
    CALL_Z_A16(0xCC),
    CALL_C_A16(0xDC),
    CALL_A16(0xCD),
    RST_08H(0xCF),
    RST_18H(0xDF),
    RST_28H(0xEF),
    RST_38H(0xFF),

    LD_INDIRECT_BC_A(0x02),
    LD_INDIRECT_DE_A(0x12),
    LD_INDIRECT_HLplus_A(0x22),
    LD_INDIRECT_HLminus_A(0x32),
    LD_B_D8(0x06),
    LD_D_D8(0x16),
    LD_H_D8(0x26),
    LD_INDIRECT_HL_D8(0x36);

    private static final Map<Integer, Opcode> opcodeMap = new HashMap<>();
    static {
        for (Opcode op : values()) {
            opcodeMap.put(op.opcode, op);
        }
    }


    private final int opcode;
    Opcode(final int opcode){
        this.opcode = opcode;
    }
    public static Opcode getOpcode(int opcode) {
        return opcodeMap.get(opcode);
    }
}
