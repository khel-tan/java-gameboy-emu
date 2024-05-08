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
public class XorInstructionsTest extends CpuTest {
    @BeforeAll
    void BeforeAll(){
        // System.out.println("Running tests on XOR instructions!");
    }

    @ParameterizedTest
    @MethodSource("source_OR_R")
    void test_OR_R(List<Integer> instructions, Register registerToTest){
        Cpu cpu = createCpu(instructions);
        CpuContext context = cpu.getContext();
        int initialAValue = context.get(Register.A);
        cpu.run();
        // System.out.println(context);
        testRegister(context, Register.A, initialAValue ^ context.get(registerToTest));  // Assuming AND results go to register A
        // Optionally check flags here, especially the zero flag
    }

    private static Stream<Arguments> source_OR_R(){
        EightBitRandom randomGenerator = EightBitRandom.INSTANCE;
        int R_VALUE = randomGenerator.next(); 
        return Stream.of(
            createAndTestArgs(Opcode.XOR_B, Opcode.LD_B_D8, R_VALUE, Register.B),
            createAndTestArgs(Opcode.XOR_C, Opcode.LD_C_D8, R_VALUE, Register.C),
            createAndTestArgs(Opcode.XOR_D, Opcode.LD_D_D8, R_VALUE, Register.D),
            createAndTestArgs(Opcode.XOR_E, Opcode.LD_E_D8, R_VALUE, Register.E),
            createAndTestArgs(Opcode.XOR_H, Opcode.LD_H_D8, R_VALUE, Register.H),
            createAndTestArgs(Opcode.XOR_L, Opcode.LD_L_D8, R_VALUE, Register.L),
            createAndTestArgs(Opcode.XOR_A, Opcode.LD_A_D8, R_VALUE, Register.A) // AND A with itself
        );
    }

    private static Arguments createAndTestArgs(Opcode opToTest, Opcode loadTestValue, int R_VALUE,Register reg) {
        return Arguments.of(List.of(
                                loadTestValue.getValue(), R_VALUE, opToTest.getValue()), 
                                 reg);
    }
}