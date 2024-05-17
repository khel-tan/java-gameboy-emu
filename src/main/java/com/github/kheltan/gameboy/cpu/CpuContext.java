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
    /*
     * @param registers an instance of the CPU registers
     * @param bus the memory bus
     */
    public CpuContext(final Registers registers,
                    final Bus bus){
        this.registers = registers;
        this.bus = bus;
    }

    //Register operations
    /*
     * @
     */
    public int get(final Register register){
        return registers.getRegister(register);
    }
    public int pc(){
        return registers.getProgramCounter();
    }
    public void set(final Register register, final int value){
        registers.setRegister(register, value);
    }
    public void setPc(final int value){
        registers.setProgramCounter(value);
    }

    //Flag operations
    public boolean get(final Flag flag){
        return registers.getFlag(flag);
    }
    public void set(final Flag flag, final boolean value){
        if(value){
            registers.setFlag(flag);
        }
        else{
            registers.unsetFlag(flag);
        }
    }
    
    // Memory operations
    /*
     * @param address the memory address that we want to read from
     */
    public int read(final int address){
        return bus.getByte(address);
    }
    /*
     * @param address the memory address that we want to write to
     * @param value the value we would like to write
     */
    public void write(final int address, final int value){
        bus.setByte(address, value);
    }

    /*
     * Prints the state of the registers and the flags
     */
    @Override
    public String toString(){
        return "The CPU context is : \n" 
            + registers.printRegisters() + "\n" 
            + registers.printFlags();
    }

}
