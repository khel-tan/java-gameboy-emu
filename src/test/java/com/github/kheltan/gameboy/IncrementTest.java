package com.github.kheltan.gameboy;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import com.github.kheltan.gameboy.cpu.Opcode;
import com.github.kheltan.gameboy.cpu.Registers.Register;

@TestInstance(Lifecycle.PER_CLASS)
public class IncrementTest {
    private static List<SimpleEntry<Opcode, Register>> opcodeRegisterPairs = new ArrayList<>();

    static {
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.INC_B, Register.B));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.INC_D, Register.D));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.INC_H, Register.H));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.INC_C, Register.C));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.INC_E, Register.E));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.INC_L, Register.L));
    }
}
