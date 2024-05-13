package com.github.kheltan.gameboy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.kheltan.gameboy.cpu.Cpu;
import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Opcode;
import com.github.kheltan.gameboy.cpu.Registers.Register;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;

public class LoadInstructionsTest extends CpuTest {
    @BeforeAll
    static void BeforeAll(){
        // System.out.println("Running tests on loading instructions!");
    }

    @ParameterizedTest
    @MethodSource("source_LD_R_D8")
    void test_LD_R_D8(List<Integer> instructions, Register registerToTest){
        Cpu cpu = createCpu(instructions);
        CpuContext context = cpu.getCpuContext();
        cpu.run();

        testRegister(context, registerToTest, instructions.get(1));
    }

    private static Stream<Arguments> source_LD_R_D8(){
        EightBitRandom randomGenerator = EightBitRandom.INSTANCE;
        return Stream.of(
            Arguments.of(List.of(Opcode.LD_B_D8.getValue(), randomGenerator.next()), Register.B),
            Arguments.of(List.of(Opcode.LD_D_D8.getValue(), randomGenerator.next()), Register.D),
            Arguments.of(List.of(Opcode.LD_H_D8.getValue(), randomGenerator.next()), Register.H),
            Arguments.of(List.of(Opcode.LD_C_D8.getValue(), randomGenerator.next()), Register.C),
            Arguments.of(List.of(Opcode.LD_E_D8.getValue(), randomGenerator.next()), Register.E),
            Arguments.of(List.of(Opcode.LD_L_D8.getValue(), randomGenerator.next()), Register.L),
            Arguments.of(List.of(Opcode.LD_A_D8.getValue(), randomGenerator.next()), Register.A)
        );
    }
    
}
