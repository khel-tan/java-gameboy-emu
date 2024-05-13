package com.github.kheltan.gameboy.cpu;

import java.util.HashMap;
import java.util.Map;

/*
 * Enum acting as a hashmap between the name of the opcodes and their actual
 * hexadecimal values
 */
public enum Opcode {
    NOP(0x00),
    STOP(0x10),
    HALT(0x76),
    PREFIX(0xCB),
    DI(0xF3),
    EI(0xFB),

    /*
     * Jumps/calls
     */
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

    /*
     * 8bit load/store/move instructions
     */
    LD_INDIRECT_BC_A(0x02),
    LD_INDIRECT_DE_A(0x12),
    LD_INDIRECT_HLplus_A(0x22),
    LD_INDIRECT_HLminus_A(0x32),

    LD_B_D8(0x06),
    LD_D_D8(0x16),
    LD_H_D8(0x26),
    LD_INDIRECT_HL_D8(0x36)
    ,
    LD_A_INDIRECT_BC(0x0A),
    LD_A_INDIRECT_DE(0x1A),
    LD_A_INDIRECT_HLplus(0x2A),
    LD_A_INDIRECT_HLminus(0x3A),

    LD_C_D8(0x0E),
    LD_E_D8(0x1E),
    LD_L_D8(0x2E),
    LD_A_D8(0x3E),

    LD_B_B(0x40),
    LD_B_C(0x41),
    LD_B_D(0x42),
    LD_B_E(0x43),
    LD_B_H(0x44),
    LD_B_L(0x45),
    LD_B_INDIRECT_HL(0x46),
    LD_B_A(0x47),

    LD_C_B(0x48),
    LD_C_C(0x49),
    LD_C_D(0x4A),
    LD_C_E(0x4B),
    LD_C_H(0x4C),
    LD_C_L(0x4D),
    LD_C_INDIRECT_HL(0x4E),
    LD_C_A(0x4F),

    LD_D_B(0x50),
    LD_D_C(0x51),
    LD_D_D(0x52),
    LD_D_E(0x53),
    LD_D_H(0x54),
    LD_D_L(0x55),
    LD_D_INDIRECT_HL(0x56),
    LD_D_A(0x57),

    LD_E_B(0x58),
    LD_E_C(0x59),
    LD_E_D(0x5A),
    LD_E_E(0x5B),
    LD_E_H(0x5C),
    LD_E_L(0x5D),
    LD_E_INDIRECT_HL(0x5E),
    LD_E_A(0x5F),

    LD_H_B(0x60),
    LD_H_C(0x61),
    LD_H_D(0x62),
    LD_H_E(0x63),
    LD_H_H(0x64),
    LD_H_L(0x65),
    LD_H_INDIRECT_HL(0x66),
    LD_H_A(0x67),

    LD_L_B(0x68),
    LD_L_C(0x69),
    LD_L_D(0x6A),
    LD_L_E(0x6B),
    LD_L_H(0x6C),
    LD_L_L(0x6D),
    LD_L_INDIRECT_HL(0x6E),
    LD_L_A(0x6F),

    LD_INDIRECT_HL_B(0x70),
    LD_INDIRECT_HL_C(0x71),
    LD_INDIRECT_HL_D(0x72),
    LD_INDIRECT_HL_E(0x73),
    LD_INDIRECT_HL_H(0x74),
    LD_INDIRECT_HL_L(0x75),
    LD_INDIRECT_HL_A(0x77),

    LD_A_B(0x78),
    LD_A_C(0x79),
    LD_A_D(0x7A),
    LD_A_E(0x7B),
    LD_A_H(0x7C),
    LD_A_L(0x7D),
    LD_A_INDIRECT_HL(0x7E),
    LD_A_A(0x7F),

    LDH_INDIRECT_A8_A(0xE0),
    LDH_A_INDIRECT_A8(0xF0),
    LD_INDIRECT_C_A(0xE2),
    LD_A_INDIRECT_C(0xF2),

    LD_INDIRECT_A16_A(0xEA),
    LD_A_INDIRECT_A16(0xFA),

    /*
     * 16bit load/store/move instructions
     */
    LD_BC_D16(0x01),
    LD_DE_D16(0x11),
    LD_HL_D16(0x21),
    LD_SP_D16(0x31),

    LD_INDIRECT_A16_SP(0x08),

    POP_BC(0xC1),
    POP_DE(0xD1),
    POP_HL(0xE1),
    POP_AF(0xF1),

    PUSH_BC(0xC5),
    PUSH_DE(0xD5),
    PUSH_HL(0xE5),
    PUSH_AF(0xF5),

    LD_HL_SP_PLUS_R8(0xF8),

    LD_SP_HL(0xF9),

    /*
     * 8bit arithmetic/logical instructions
     */
    INC_B(0x04),
    DEC_B(0x05),
    INC_D(0x14),
    DEC_D(0x15),
    INC_H(0x24),
    DEC_H(0x25),
    INC_INDIRECT_HL(0X34),
    DEC_INDIRECT_HL(0x35),

    DAA(0x27),
    SCF(0x37),

    INC_C(0x0C),
    DEC_C(0x0D),
    INC_E(0x1C),
    DEC_E(0x1D),
    INC_L(0x2C),
    DEC_L(0x2D),
    INC_A(0x3C),
    DEC_A(0x3D),

    CPL(0x2F),
    CCF(0x3F),

    ADD_A_B(0x80),
    ADD_A_C(0x81),
    ADD_A_D(0x82),
    ADD_A_E(0x83),
    ADD_A_H(0x84),
    ADD_A_L(0x85),
    ADD_A_INDIRECT_HL(0x86),
    ADD_A_A(0x87),

    ADC_A_B(0x88),
    ADC_A_C(0x89),
    ADC_A_D(0x8A),
    ADC_A_E(0x8B),
    ADC_A_H(0x8C),
    ADC_A_L(0x8D),
    ADC_A_INDIRECT_HL(0x8E),
    ADC_A_A(0x8F),

    SUB_B(0x90),
    SUB_C(0x91),
    SUB_D(0x92),
    SUB_E(0x93),
    SUB_H(0x94),
    SUB_L(0x95),
    SUB_INDIRECT_HL(0x96),
    SUB_A(0x97),

    SBC_A_B(0x98),
    SBC_A_C(0x99),
    SBC_A_D(0x9A),
    SBC_A_E(0x9B),
    SBC_A_H(0x9C),
    SBC_A_L(0x9D),
    SBC_A_INDIRECT_HL(0x9E),
    SBC_A_A(0x9F),

    AND_B(0xA0),
    AND_C(0xA1),
    AND_D(0xA2),
    AND_E(0xA3),
    AND_H(0xA4),
    AND_L(0xA5),
    AND_INDIRECT_HL(0xA6),
    AND_A(0xA7),

    XOR_B(0xA8),
    XOR_C(0xA9),
    XOR_D(0xAA),
    XOR_E(0xAB),
    XOR_H(0xAC),
    XOR_L(0xAD),
    XOR_INDIRECT_HL(0xAE),
    XOR_A(0xAF),

    OR_B(0xB0),
    OR_C(0xB1),
    OR_D(0xB2),
    OR_E(0xB3),
    OR_H(0xB4),
    OR_L(0xB5),
    OR_INDIRECT_HL(0xB6),
    OR_A(0xB7),

    CP_B(0xB8),
    CP_C(0xB9),
    CP_D(0xBA),
    CP_E(0xBB),
    CP_H(0xBC),
    CP_L(0xBD),
    CP_INDIRECT_HL(0xBE),
    CP_A(0xBF),

    ADD_A_D8(0xC6),
    SUB_D8(0xD6),
    AND_D8(0xE6),
    OR_D8(0xF6),

    ADC_A_D8(0xCE),
    SBC_A_D8(0xDE),
    XOR_D8(0xEE),
    CP_D8(0xFE),

    /*
     * 16bit arithmetic/logical instructions
     */
    INC_BC(0x03),
    INC_DE(0x13),
    INC_HL(0x23),
    INC_SP(0x33),

    ADD_HL_BC(0x09),
    ADD_HL_DE(0x19),
    ADD_HL_HL(0x29),
    ADD_HL_SP(0x39),

    DEC_BC(0x0B),
    DEC_DE(0x1B),
    DEC_HL(0x2B),
    DEC_SP(0x3B),

    ADD_SP_R8(0xE8),

    /*
     * 8bit rotations/shifts and bit instructions
     */
    RLCA(0x07),
    RLA(0x17),

    RRCA(0x0F),
    RRA(0x1F);

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
    public int getValue(){
        return opcode;
    }
}
