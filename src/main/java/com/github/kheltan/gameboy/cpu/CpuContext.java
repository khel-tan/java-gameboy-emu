package com.github.kheltan.gameboy.cpu;

import com.github.kheltan.gameboy.cpu.Registers.Flag;
import com.github.kheltan.gameboy.cpu.Registers.Register;
import com.github.kheltan.gameboy.memory.Bus;

/*
 * This class encapsulates the state of the CPU and the Memory Bus.
 * In addition, it also provides wrapping methods for easy getting and setting.
 * An instance of this will be passed to the Instructions and then be modified.
 */
public class CpuContext {
    private final Registers registers;
    private final Bus bus;
    public CpuContext(final Registers registers,
                    final Bus bus){
        this.registers = registers;
        this.bus = bus;
    }

    //Register operations
    public int get(final Register r){
        return registers.getRegister(r);
    }
    public int pc(){
        return registers.getProgramCounter();
    }
    public void set(final Register r, final int value){
        registers.setRegister(r, value);
    }
    public void setPc(final int value){
        registers.setProgramCounter(value);
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
    
    // Memory operations
    public int read(final int address){
        return bus.getByte(address);
    }
    public void write(final int address, final int value){
        bus.setByte(address, value);
    }

    @Override
    public String toString(){
        return "The CPU context is : \n" 
            + registers.printRegisters() + "\n" 
            + registers.printFlags();
    }

}
