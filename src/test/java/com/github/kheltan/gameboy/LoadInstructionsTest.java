package com.github.kheltan.gameboy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;

public class LoadInstructionsTest {
    @BeforeAll
    static void BeforeAll(){
        System.out.println("Running tests on loading instructions!");
    }

    @ParameterizedTest
    @MethodSource
    void test_LD_R_D8(List<Integer> instructions){
        
    }

    private static Stream<Arguments> source_LD_R_D8(){
        return Stream.of(
            Arguments.of(List.of(0x06, EightBitRandom.INSTANCE)),
            Arguments.of(List.of(0x16, EightBitRandom.INSTANCE)),
            Arguments.of(List.of(0x26, EightBitRandom.INSTANCE)),
            Arguments.of(List.of(0x0E, EightBitRandom.INSTANCE)),
            Arguments.of(List.of(0x1E, EightBitRandom.INSTANCE)),
            Arguments.of(List.of(0x2E, EightBitRandom.INSTANCE)),
            Arguments.of(List.of(0x3E, EightBitRandom.INSTANCE))
        );
    }
}
