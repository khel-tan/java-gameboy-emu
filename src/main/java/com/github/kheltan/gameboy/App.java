package com.github.kheltan.gameboy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import com.github.kheltan.gameboy.cpu.Cpu;
import com.github.kheltan.gameboy.cpu.CpuContext;
import com.github.kheltan.gameboy.cpu.Opcode;
import com.github.kheltan.gameboy.cpu.Registers;
import com.github.kheltan.gameboy.memory.Bus;
import com.github.kheltan.gameboy.memory.Rom;
import com.github.kheltan.gameboy.memory.Wram;
import com.github.kheltan.gameboy.utility.Constants;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        
        int offset = 0xC100;
        System.out.print("Enter the array length: ");
        int arrayLength = scanner.nextInt();

        scanner.close();
        bubbleSort(offset, arrayLength);
    }
    private static void bubbleSort(final int offset, final int arrayLength){
        List<Integer> instructions = initializeArray(offset, arrayLength);

        Cpu cpu = createCpu(instructions);
        cpu.run();
        System.out.println("Here is the array before sorting.");
        printMemory(offset, offset + arrayLength, cpu.getCpuContext());

        System.out.println("...........");
        instructions.addAll(bubbleSortLogic(offset, arrayLength));
        cpu = createCpu(instructions);
        cpu.run();
        System.out.println("Here is the array after sorting.");
        printMemory(offset, offset + arrayLength, cpu.getCpuContext());
    }

    private static Cpu createCpu(final List<Integer> instructions){
        Bus bus = new Bus(new Wram(), new Rom(instructions));
        CpuContext cpuContext = new CpuContext(new Registers(), bus);
        Cpu cpu = new Cpu(cpuContext);
        return cpu;
    }

    // Initialise array with the first element at address specified by offset
    private static List<Integer> initializeArray(final int offset, final int arrayLength){
        final int lsbOffset = offset & 0xFF;
        final int msbOffset = offset >> 8;
        List<Integer> instructions = new ArrayList<>(Arrays.asList(
                Opcode.LD_HL_D16.getValue() , lsbOffset, msbOffset
        ));
        for(int i = 0; i < arrayLength; i++){
            final int value = ThreadLocalRandom.current().nextInt(Constants.MAX_8BIT_VAL);
            instructions.addAll(Arrays.asList(
                Opcode.LD_INDIRECT_HL_D8.getValue(), value,
                Opcode.INC_HL.getValue()
            ));
        }
        return instructions;
    }

    private static List<Integer> bubbleSortLogic(final int offset, final int arrayLength){
        final int lsbOffset = offset & 0xFF;
        final int msbOffset = offset >> 8;
        return Arrays.asList(
            Opcode.LD_HL_D16.getValue(), lsbOffset, msbOffset,
            Opcode.LD_B_D8.getValue(), arrayLength,

            /*
             * B : Outer loop
             * C : Inner loop
             * A : current value
             * D : next value
             */

             //.Outer_loop
            Opcode.LD_C_B.getValue(), //Inner loop counter
            

            //.Inner_loop
            Opcode.LD_A_INDIRECT_HL.getValue(),
            Opcode.INC_HL.getValue(),
            Opcode.LD_D_INDIRECT_HL.getValue(),
            Opcode.DEC_HL.getValue(),         
            Opcode.CP_D.getValue(),
            Opcode.JR_C_R8.getValue(), 6, // Jump to .No_swap

            //Swap values
            Opcode.LD_INDIRECT_HL_D.getValue(),
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_A.getValue(),
            Opcode.DEC_HL.getValue(),

            //.No_swap
            Opcode.INC_HL.getValue(),
            Opcode.DEC_C.getValue(),
            Opcode.JR_NZ_R8.getValue(), -13, //Jump to .Inner_loop

            Opcode.LD_HL_D16.getValue(), 0x00, 0xC1,
            Opcode.DEC_B.getValue(),
            Opcode.JR_NZ_R8.getValue(), -20 //Jump to .Outer_loop
        );
    }
    private static List<Integer> loadArrayInstructions(){
        return List.of(
            // Initialise array with the first element at address 0xC100
            Opcode.LD_HL_D16.getValue() , 0x00, 0xC1, 
            Opcode.LD_A_D8.getValue(), 0x00,
            Opcode.LD_INDIRECT_HL_D8.getValue() , 5,
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_D8.getValue() , 4,
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_D8.getValue() , 6,
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_D8.getValue() , 2,
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_D8.getValue() , 1);
    }

    private static List<Integer> sortInstructions(){
        return List.of(

            // Initialise the outer loop counter and HL
            Opcode.LD_HL_D16.getValue(), 0x00, 0xC1,
            Opcode.LD_B_D8.getValue(), 4,

            /*
             * B : Outer loop
             * C : Inner loop
             * A : current value
             * D : next value
             */

            //.Outer_loop
            Opcode.LD_C_B.getValue(), //Inner loop counter
            

            //.Inner_loop
            Opcode.LD_A_INDIRECT_HL.getValue(),
            Opcode.INC_HL.getValue(),
            Opcode.LD_D_INDIRECT_HL.getValue(),
            Opcode.DEC_HL.getValue(),         
            Opcode.CP_D.getValue(),
            Opcode.JR_C_R8.getValue(), 6, // Jump to .No_swap

            //Swap values
            Opcode.LD_INDIRECT_HL_D.getValue(),
            Opcode.INC_HL.getValue(),
            Opcode.LD_INDIRECT_HL_A.getValue(),
            Opcode.DEC_HL.getValue(),

            //.No_swap
            Opcode.INC_HL.getValue(),
            Opcode.DEC_C.getValue(),
            Opcode.JR_NZ_R8.getValue(), -13, //Jump to .Inner_loop

            Opcode.LD_HL_D16.getValue(), 0x00, 0xC1,
            Opcode.DEC_B.getValue(),
            Opcode.JR_NZ_R8.getValue(), -20 //Jump to .Outer_loop
        );
    }

    private static void printMemory(int start, int end, CpuContext cpuContext){
        // System.out.println("The state of the memory for the specified range is...");
        for(int current = start; current <= end; current++){
            System.out.println(String.format("0x%04X", current)
                            + " : " 
                            + String.format("0x%04X", cpuContext.read(current))
                            + " -converted-to-decimal-> "
                            + cpuContext.read(current));
        }
    }
}
