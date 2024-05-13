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
public class AndInstructionsTest extends CpuTest {
    @BeforeAll
    void BeforeAll(){
        // System.out.println("Running tests on AND instructions!");
    }

    @ParameterizedTest
    @MethodSource("source_AND_R")
    void test_AND_R(List<Integer> instructions, Register registerToTest){
        Cpu cpu = createCpu(instructions);
        CpuContext context = cpu.getCpuContext();
        cpu.run();
        // System.out.println(context);
        testRegister(context, Register.A, context.get(Register.A) & context.get(registerToTest));  // Assuming AND results go to register A
        // Optionally check flags here, especially the zero flag
    }

    private static Stream<Arguments> source_AND_R(){
        EightBitRandom randomGenerator = EightBitRandom.INSTANCE;
        int A_VALUE = randomGenerator.next(); 
        return Stream.of(
            createAndTestArgs(Opcode.AND_B, A_VALUE, Register.B),
            createAndTestArgs(Opcode.AND_C, A_VALUE, Register.C),
            createAndTestArgs(Opcode.AND_D, A_VALUE, Register.D),
            createAndTestArgs(Opcode.AND_E, A_VALUE, Register.E),
            createAndTestArgs(Opcode.AND_H, A_VALUE, Register.H),
            createAndTestArgs(Opcode.AND_L, A_VALUE, Register.L),
            createAndTestArgs(Opcode.AND_A, A_VALUE, Register.A) // AND A with itself
        );
    }

    private static Arguments createAndTestArgs(Opcode opcode, int A_VALUE,Register reg) {
        return Arguments.of(List.of(Opcode.LD_A_D8.getValue(), A_VALUE, 
                                opcode.getValue()), 
                                 reg);
    }
}