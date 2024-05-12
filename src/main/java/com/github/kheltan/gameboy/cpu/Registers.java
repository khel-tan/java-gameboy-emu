package com.github.kheltan.gameboy.cpu;

public class Registers {
    public enum Register{
        A, F, B, C, D, E, H, L,
        BC, DE, HL, SP, AF
    }
    public enum Flag{
        Zero(0b0001), 
        Sub(0b0010), 
        HalfCarry(0b0100),
        Carry(0b1000);

        private final int value;
        Flag(int value){
            this.value = value;
        }
        public int getValue(){
            return this.value;
        }
    }

    /*
     * a, f, b, c, d, e, h, l represent 8 bit registers
     * pc := program counter
     * sp := stack pointer
     * 
     * 
     */
    int a, f,
        b, c,
        d, e,
        h, l;
    int pc, sp;
    public Registers(){

    }

    public int getRegister(Register register){
        switch (register) {
            case A: return a;
            case F: return f;
            case B: return b;
            case C: return c;
            case D: return d;
            case E: return e;
            case H: return h;
            case L: return l;
            case BC : return mergeIntoWord(Register.B, Register.C);
            case DE : return mergeIntoWord(Register.D, Register.E);
            case HL : return mergeIntoWord(Register.H, Register.L);
            case SP : return sp;
            case AF : return mergeIntoWord(Register.A, Register.F);
            // Add cases for other registers
            default: throw new IllegalArgumentException("Unknown register");
        }
    }
    public void setRegister(Register register, int value){
        switch (register) {
            case A: a = getLSB(value); break;
            case F: f = getLSB(value); break;
            case B: b = getLSB(value); break;
            case C: c = getLSB(value); break;
            case D: d = getLSB(value); break;
            case E: e = getLSB(value); break;
            case H: h = getLSB(value); break;
            case L: l = getLSB(value); break;
            case BC : b = getMSB(value); c =  getLSB(value);  break;
            case DE : d = getMSB(value); e =  getLSB(value); break;
            case HL : h = getMSB(value); l =  getLSB(value); break;
            case SP : sp = value; break;
            case AF: a = getMSB(value); f = getLSB(value); break;
            default: throw new IllegalArgumentException("Unknown register : " + register);
        }
    }
    public int getProgramCounter(){
        return pc;
    }
    public int getStackPointer(){
        return sp;
    }
    public void setProgramCounter(int value){
        pc = value & 0xFFFF;
    }
    public void setStackPointer(int value){
        sp = value & 0xFFFF;
    }
    public void incrementProgramCounter(){
        pc = (pc + 1) & 0xFFFF;
    }
    public void incrementHL(){
        setRegister(Register.HL, getRegister(Register.HL) + 1);
    }
    public void decrementHL(){
        setRegister(Register.HL, getRegister(Register.HL) - 1);
    }
    public String printRegisters() {
        StringBuilder builder = new StringBuilder();

        // Append formatted registers in hexadecimal
        builder.append(String.format("A: 0x%02X, F: 0x%02X, B: 0x%02X, C: 0x%02X, D: 0x%02X, E: 0x%02X, H: 0x%02X, L: 0x%02X\n", a, f, b, c, d, e, h, l));
        builder.append(String.format("PC: 0x%04X, SP: 0x%04X", pc, sp));
        return builder.toString();
    }
    public String printFlags(){
        return "Flags : " + String.format("0b%4s", Integer.toBinaryString(f)).replace(' ', '0');
    }

    //TODO: For now, flags will remain here but think of logically separating them.
    public void setFlag(Flag flag){
        f = f | (flag.getValue());
    }
    public void unsetFlag(Flag flag){
        f = f & (flag.getValue() ^ 0x0F);
    }
    public Boolean getFlag(Flag flag){
        return (f & flag.getValue()) != 0;
    }

    private int getMSB(int word){
        return word >> 8;
    }
    private int getLSB(int word){
        return word & 0xFF;
    }
    private int mergeIntoWord(Register high, Register low){
        return (getRegister(high) << 8) | getRegister(low);
    }
}