package com.github.kheltan.gameboy;
import java.util.List;

import com.github.kheltan.gameboy.cpu.Cpu;
import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.InstructionDecoder;
import com.github.kheltan.gameboy.cpu.Registers;
import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;
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
        Instruction instruction = InstructionDecoder.INSTANCE.decode(0x11);
        List<Integer> arguments = List.of(0x66, 0x55);
        InstructionContext instructionContext = new InstructionContext(arguments);

        Bus bus = new Bus(new Ram(), new Rom(new int[]{0x11, 0x66, 0x55}));
        CpuContext cpuContext = new CpuContext(new Registers(), bus);
        Cpu cpu = new Cpu(cpuContext);
        cpu.run();
        System.out.println(cpuContext);
    }
}
