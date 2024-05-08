package com.github.kheltan.gameboy.cpu;

import com.github.kheltan.gameboy.cpu.Registers.Flag;
import com.github.kheltan.gameboy.cpu.Registers.Register;

public class CpuContext {
    private final Registers registers;
    public CpuContext(final Registers registers){
        this.registers = registers;
    }

    //Register operations
    public int get(final Register r){
        return registers.getRegister(r);
    }
    public void set(final Register r, final int value){
        registers.setRegister(r, value);
    }

    //Flag operations
    public boolean get(final Flag f){
        return registers.getFlag(f);
    }
    public void set(final Flag f, final boolean value){
        if(value){
            registers.setFlag(f);
        }
        else{
            registers.unsetFlag(f);
        }
    }

    @Override
    public String toString(){
        return "The CPU context is : \n" + registers.printRegisters() + registers.printFlags();
    }

}
