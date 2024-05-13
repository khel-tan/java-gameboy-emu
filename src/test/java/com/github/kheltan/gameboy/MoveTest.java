package com.github.kheltan.gameboy;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.github.kheltan.gameboy.cpu.Cpu;
import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Opcode;
import com.github.kheltan.gameboy.cpu.Registers.Register;

@TestInstance(Lifecycle.PER_CLASS)
public class MoveTest extends CpuTest{
    @ParameterizedTest
    @MethodSource("source_Move_To_B")
    public void test_Move_To_B(List<Integer> instructions, Register source){
        Cpu cpu = createCpu(instructions);
        CpuContext context = cpu.getCpuContext();
        cpu.run();
        
        // System.out.println(context);
        testRegister(context, Register.B, context.get(source));
    }

    @ParameterizedTest
    @MethodSource("source_Move_To_C")
    public void test_Move_To_C(List<Integer> instructions, Register source){
        Cpu cpu = createCpu(instructions);
        CpuContext context = cpu.getCpuContext();
        cpu.run();
        
        // System.out.println(context);
        testRegister(context, Register.C, context.get(source));
    }

    @ParameterizedTest
    @MethodSource("source_Move_To_D")
    public void test_Move_To_D(List<Integer> instructions, Register source){
        Cpu cpu = createCpu(instructions);
        CpuContext context = cpu.getCpuContext();
        cpu.run();
        
        // System.out.println(context);
        testRegister(context, Register.D, context.get(source));
    }

    @ParameterizedTest
    @MethodSource("source_Move_To_E")
    public void test_Move_To_E(List<Integer> instructions, Register source){
        Cpu cpu = createCpu(instructions);
        CpuContext context = cpu.getCpuContext();
        cpu.run();
        
        // System.out.println(context);
        testRegister(context, Register.E, context.get(source));
    }

    @ParameterizedTest
    @MethodSource("source_Move_To_H")
    public void test_Move_To_H(List<Integer> instructions, Register source){
        Cpu cpu = createCpu(instructions);
        CpuContext context = cpu.getCpuContext();
        cpu.run();
        
        // System.out.println(context);
        testRegister(context, Register.H, context.get(source));
    }

    @ParameterizedTest
    @MethodSource("source_Move_To_L")
    public void test_Move_To_L(List<Integer> instructions, Register source){
        Cpu cpu = createCpu(instructions);
        CpuContext context = cpu.getCpuContext();
        cpu.run();
        
        // System.out.println(context);
        testRegister(context, Register.L, context.get(source));
    }

    @ParameterizedTest
    @MethodSource("source_Move_To_A")
    public void test_Move_To_A(List<Integer> instructions, Register source){
        Cpu cpu = createCpu(instructions);
        CpuContext context = cpu.getCpuContext();
        cpu.run();
        
        // System.out.println(context);
        testRegister(context, Register.A, context.get(source));
    }

    private static Stream<Arguments> source_Move_To_B(){
        List<SimpleEntry<Opcode, Register>> opcodeRegisterPairs = new ArrayList<>();
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_B_B, Register.B));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_B_C, Register.C));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_B_D, Register.D));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_B_E, Register.E));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_B_H, Register.H));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_B_L, Register.L));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_B_A, Register.A));
        return opcodeRegisterPairs.stream()
                .map(pair -> createMoveTestArgs(pair.getKey(), pair.getValue()));
    }

    private static Stream<Arguments> source_Move_To_C(){
        List<SimpleEntry<Opcode, Register>> opcodeRegisterPairs = new ArrayList<>();
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_C_B, Register.B));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_C_C, Register.C));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_C_D, Register.D));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_C_E, Register.E));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_C_H, Register.H));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_C_L, Register.L));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_C_A, Register.A));
        return opcodeRegisterPairs.stream()
                .map(pair -> createMoveTestArgs(pair.getKey(), pair.getValue()));
    }

    private static Stream<Arguments> source_Move_To_D(){
        List<SimpleEntry<Opcode, Register>> opcodeRegisterPairs = new ArrayList<>();
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_D_B, Register.B));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_D_C, Register.C));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_D_D, Register.D));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_D_E, Register.E));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_D_H, Register.H));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_D_L, Register.L));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_D_A, Register.A));
        return opcodeRegisterPairs.stream()
                .map(pair -> createMoveTestArgs(pair.getKey(), pair.getValue()));
    }

    private static Stream<Arguments> source_Move_To_E(){
        List<SimpleEntry<Opcode, Register>> opcodeRegisterPairs = new ArrayList<>();
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_E_B, Register.B));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_E_C, Register.C));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_E_D, Register.D));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_E_E, Register.E));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_E_H, Register.H));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_E_L, Register.L));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_E_A, Register.A));
        return opcodeRegisterPairs.stream()
                .map(pair -> createMoveTestArgs(pair.getKey(), pair.getValue()));
    }

    private static Stream<Arguments> source_Move_To_H(){
        List<SimpleEntry<Opcode, Register>> opcodeRegisterPairs = new ArrayList<>();
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_H_B, Register.B));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_H_C, Register.C));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_H_D, Register.D));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_H_E, Register.E));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_H_H, Register.H));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_H_L, Register.L));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_H_A, Register.A));
        return opcodeRegisterPairs.stream()
                .map(pair -> createMoveTestArgs(pair.getKey(), pair.getValue()));
    }

    private static Stream<Arguments> source_Move_To_L(){
        List<SimpleEntry<Opcode, Register>> opcodeRegisterPairs = new ArrayList<>();
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_L_B, Register.B));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_L_C, Register.C));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_L_D, Register.D));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_L_E, Register.E));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_L_H, Register.H));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_L_L, Register.L));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_L_A, Register.A));
        return opcodeRegisterPairs.stream()
                .map(pair -> createMoveTestArgs(pair.getKey(), pair.getValue()));
    }

    private static Stream<Arguments> source_Move_To_A(){
        List<SimpleEntry<Opcode, Register>> opcodeRegisterPairs = new ArrayList<>();
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_A_B, Register.B));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_A_C, Register.C));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_A_D, Register.D));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_A_E, Register.E));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_A_H, Register.H));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_A_L, Register.L));
        opcodeRegisterPairs.add(new SimpleEntry<>(Opcode.LD_A_A, Register.A));
        return opcodeRegisterPairs.stream()
                .map(pair -> createMoveTestArgs(pair.getKey(), pair.getValue()));
    }
    private static Arguments createMoveTestArgs(final Opcode opcodeToTest, final Register registerToTest) {
        final EightBitRandom randomGenerator = EightBitRandom.INSTANCE;
        final int b = randomGenerator.next();
        final int c = randomGenerator.next();
        final int d = randomGenerator.next();
        final int e = randomGenerator.next();
        final int h = randomGenerator.next();
        final int l = randomGenerator.next();
        final int a = randomGenerator.next();
        List<Integer> initInstructions = new ArrayList<>(Arrays.asList(
                Opcode.LD_B_D8.getValue(), b,
                Opcode.LD_C_D8.getValue(), c,
                Opcode.LD_D_D8.getValue(), d,
                Opcode.LD_E_D8.getValue(), e,
                Opcode.LD_H_D8.getValue(), h,
                Opcode.LD_L_D8.getValue(), l,
                Opcode.LD_A_D8.getValue(), a));
        initInstructions.add(opcodeToTest.getValue());

        return Arguments.of(initInstructions, registerToTest);
    }
}
