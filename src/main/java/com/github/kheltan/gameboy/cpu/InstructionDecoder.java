package com.github.kheltan.gameboy.cpu;

public class InstructionDecoder {
    public static final InstructionDecoder INSTANCE = new InstructionDecoder();
    private InstructionDecoder(){

    }
    public void decode(final int opcode){
        Opcode op = Opcode.getOpcode(opcode);
        System.out.println(op);
        switch (op) {
            case LD_B_D8:
                break;
            case LD_D_D8:
                break;
            case LD_H_D8:
                break;
            default:
                break;
        }
    }
}
