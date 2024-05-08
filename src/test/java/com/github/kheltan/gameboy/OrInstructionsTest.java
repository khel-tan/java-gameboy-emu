package com.github.kheltan.gameboy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.kheltan.gameboy.cpu.Cpu;
import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Opcode;
import com.github.kheltan.gameboy.cpu.Registers.Register;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.List;
import java.util.stream.Stream;

@TestInstance(Lifecycle.PER_CLASS)
public class OrInstructionsTest extends CpuTest {
    @BeforeAll
    void BeforeAll(){
        // System.out.println("Running tests on OR instructions!");
    }

    @ParameterizedTest
    @MethodSource("source_OR_R")
    void test_OR_R(List<Integer> instructions, Register registerToTest){
        Cpu cpu = createCpu(instructions);
        CpuContext context = cpu.getContext();
        cpu.run();
        // System.out.println(context);
        testRegister(context, Register.A, context.get(Register.A) & context.get(registerToTest));  // Assuming AND results go to register A
        // Optionally check flags here, especially the zero flag
    }

    private static Stream<Arguments> source_OR_R(){
        EightBitRandom randomGenerator = EightBitRandom.INSTANCE;
        int R_VALUE = randomGenerator.next(); 
        return Stream.of(
            createAndTestArgs(Opcode.OR_B, Opcode.LD_B_D8, R_VALUE, Register.B),
            createAndTestArgs(Opcode.OR_C, Opcode.LD_C_D8, R_VALUE, Register.C),
            createAndTestArgs(Opcode.OR_D, Opcode.LD_D_D8, R_VALUE, Register.D),
            createAndTestArgs(Opcode.OR_E, Opcode.LD_E_D8, R_VALUE, Register.E),
            createAndTestArgs(Opcode.OR_H, Opcode.LD_H_D8, R_VALUE, Register.H),
            createAndTestArgs(Opcode.OR_L, Opcode.LD_L_D8, R_VALUE, Register.L),
            createAndTestArgs(Opcode.OR_A, Opcode.LD_A_D8, R_VALUE, Register.A) // AND A with itself
        );
    }

    private static Arguments createAndTestArgs(Opcode opToTest, Opcode loadTestValue, int R_VALUE,Register reg) {
        return Arguments.of(List.of(Opcode.LD_A_D8.getValue(), 0x00, 
                                loadTestValue.getValue(), R_VALUE, opToTest.getValue()), 
                                 reg);
    }
}