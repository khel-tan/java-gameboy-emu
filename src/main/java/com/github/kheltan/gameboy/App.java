package com.github.kheltan.gameboy;
import java.util.ArrayList;
import java.util.List;

import com.github.kheltan.gameboy.cpu.Cpu;
import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Opcode;
import com.github.kheltan.gameboy.cpu.Registers;
import com.github.kheltan.gameboy.memory.Bus;
import com.github.kheltan.gameboy.memory.Wram;
import com.github.kheltan.gameboy.memory.Rom;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Integer> instructions = new ArrayList<>(loadArrayInstructions());
        instructions.addAll(sortInstructions());
        Bus bus = new Bus(new Wram(), new Rom(instructions));
        CpuContext cpuContext = new CpuContext(new Registers(), bus);
        Cpu cpu = new Cpu(cpuContext);
        System.out.println("Running Bubble Sort...");
        cpu.run();
        System.out.println(cpuContext);
        printMemory(0xC100, 0xC100 + 8, cpuContext);
    }

    private static List<Integer> loadArrayInstructions(){
        return List.of(
            // Initialise array with the first element at address 0xC100
            Opcode.LD_HL_D16.getValue() , 0x00, 0xC1, 
            Opcode.LD_A_D8.getValue(), 0x00,
            Opcode.LD_INDIRECT_HL_D8.getValue() , 5,
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_D8.getValue() , 4,
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_D8.getValue() , 6,
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_D8.getValue() , 2,
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_D8.getValue() , 1);
    }

    private static List<Integer> sortInstructions(){
        return List.of(

            // Initialise the outer loop counter and HL
            Opcode.LD_HL_D16.getValue(), 0x00, 0xC1,
            Opcode.LD_B_D8.getValue(), 4,

            /*
             * B : Outer loop
             * C : Inner loop
             * A : current value
             * D : next value
             */

            //.Outer_loop
            Opcode.LD_C_B.getValue(), //Inner loop counter
            

            //.Inner_loop
            Opcode.LD_A_INDIRECT_HL.getValue(),
            Opcode.INC_HL.getValue(),
            Opcode.LD_D_INDIRECT_HL.getValue(),
            Opcode.DEC_HL.getValue(),         
            Opcode.CP_D.getValue(),
            Opcode.JR_C_R8.getValue(), 6, // Jump to .No_swap

            //Swap values
            Opcode.LD_INDIRECT_HL_D.getValue(),
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_A.getValue(),
            Opcode.DEC_HL.getValue(),

            //.No_swap
            Opcode.INC_HL.getValue(),
            Opcode.DEC_C.getValue(),
            Opcode.JR_NZ_R8.getValue(), -13, //Jump to .Inner_loop

            Opcode.LD_HL_D16.getValue(), 0x00, 0xC1,
            Opcode.DEC_B.getValue(),
            Opcode.JR_NZ_R8.getValue(), -20 //Jump to .Outer_loop
        );
    }

    private static void printMemory(int start, int end, CpuContext cpuContext){
        System.out.println("The state of the memory for the specified range is...");
        for(int current = start; current <= end; current++){
            System.out.println(String.format("0x%04X", current)
                            + " : " 
                            + String.format("0x%04X", cpuContext.read(current)));
        }
    }
}
