package com.github.kheltan.gameboy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import com.github.kheltan.gameboy.cpu.Cpu;
import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Registers;
import com.github.kheltan.gameboy.cpu.Registers.Register;
import com.github.kheltan.gameboy.memory.Bus;
import com.github.kheltan.gameboy.memory.Wram;
import com.github.kheltan.gameboy.memory.Rom;

public class CpuTest {
    public Cpu createCpu(List<Integer> instructions){
        Bus bus = new Bus(new Wram(), new Rom(instructions));
        CpuContext cpuContext = new CpuContext(new Registers(), bus);
        Cpu cpu = new Cpu(cpuContext);
        return cpu;
    }

    public void testRegister(CpuContext context, Register r, int expected){
        assertEquals(expected, context.get(r),
                    "Expected value is " + convertToHex(expected)
                    + " but the actual value is " + convertToHex(context.get(r)));
    }
    public String convertToHex(int value){
        return String.format("0x%04x", value);
    }
}
