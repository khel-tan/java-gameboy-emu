package com.github.kheltan.gameboy;
import java.util.List;

import com.github.kheltan.gameboy.cpu.Cpu;
import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Opcode;
import com.github.kheltan.gameboy.cpu.Registers;
import com.github.kheltan.gameboy.cpu.Registers.Flag;
import com.github.kheltan.gameboy.memory.Bus;
import com.github.kheltan.gameboy.memory.Ram;
import com.github.kheltan.gameboy.memory.Rom;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Bus bus = new Bus(new Ram(), new Rom(instructions()));
        CpuContext cpuContext = new CpuContext(new Registers(), bus);
        Cpu cpu = new Cpu(cpuContext);
        // cpuContext.set(Flag.Zero, true);
        cpu.run();
        System.out.println(cpuContext);
        printMemory(0xC100, 0xC100 + 8, cpuContext);
    }

    private static List<Integer> instructions(){
        return List.of(
            Opcode.LD_HL_D16.getValue() , 0x00, 0xC1, //LD HL, 0xC100
            Opcode.LD_A_D8.getValue(), 0x00,
            Opcode.LD_B_D8.getValue(), 0x05,
            Opcode.LD_INDIRECT_HL_D8.getValue() , 1,
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_D8.getValue() , 6,
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_D8.getValue() , 5,
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_D8.getValue() , 10,
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_D8.getValue() , 3,
            Opcode.INC_HL.getValue(),
            Opcode.INC_A.getValue(),
            Opcode.CP_B.getValue(),
            Opcode.JR_C_R8.getValue(), -5
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
