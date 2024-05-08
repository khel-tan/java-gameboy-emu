package com.github.kheltan.gameboy;
import java.util.List;

import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.InstructionDecoder;
import com.github.kheltan.gameboy.cpu.Registers;
import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;
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

        CpuContext cpuContext = new CpuContext(new Registers());
        instruction.execute(cpuContext, instructionContext);
        System.out.println(cpuContext);
    }
}
