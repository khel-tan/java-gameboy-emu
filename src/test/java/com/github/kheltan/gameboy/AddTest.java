package com.github.kheltan.gameboy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.kheltan.gameboy.cpu.Cpu;
import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Opcode;
import com.github.kheltan.gameboy.cpu.Registers.Register;

import java.util.List;
import java.util.stream.Stream;

@TestInstance(Lifecycle.PER_CLASS)
public class AddTest extends CpuTest {
    @BeforeAll
    void BeforeAll(){
        System.out.println("Running tests on ADD instructions!");
    }

    @ParameterizedTest
    @MethodSource("source_ADD_R")
    void test_ADD_R(List<Integer> instructions, Register registerToTest){
        Cpu cpu = createCpu(instructions);
        CpuContext context = cpu.getContext();
        int initialAValue = context.get(Register.A);
        cpu.run();
        // System.out.println(context);
        testRegister(context, Register.A, initialAValue + context.get(registerToTest));  // Assuming AND results go to register A
        // Optionally check flags here, especially the zero flag
    }
    private static Stream<Arguments> source_ADD_R(){
        EightBitRandom randomGenerator = EightBitRandom.INSTANCE;
        int R_VALUE = randomGenerator.next();
        return Stream.of(
            createAddTestArgs(Opcode.ADD_A_B, Opcode.LD_B_D8, R_VALUE, Register.B),
            createAddTestArgs(Opcode.ADD_A_C, Opcode.LD_C_D8, R_VALUE, Register.C),
            createAddTestArgs(Opcode.ADD_A_D, Opcode.LD_D_D8, R_VALUE, Register.D),
            createAddTestArgs(Opcode.ADD_A_E, Opcode.LD_E_D8, R_VALUE, Register.E),
            createAddTestArgs(Opcode.ADD_A_H, Opcode.LD_H_D8, R_VALUE, Register.H),
            createAddTestArgs(Opcode.ADD_A_L, Opcode.LD_L_D8, R_VALUE, Register.L),
            createAddTestArgs(Opcode.ADD_A_A, Opcode.LD_A_D8, R_VALUE, Register.A)
        );
    }
    private static Arguments createAddTestArgs(Opcode opcode,
                                            Opcode loadOp, int R_VALUE,
                                            Register reg) {
        return Arguments.of(List.of(Opcode.LD_A_D8.getValue(), 0x00, 
                                loadOp.getValue(), R_VALUE,
                                opcode.getValue()), 
                                 reg);
    }
}
