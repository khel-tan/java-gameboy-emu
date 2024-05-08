package com.github.kheltan.gameboy;
import com.github.kheltan.gameboy.cpu.InstructionDecoder;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        InstructionDecoder.INSTANCE.decode(0x06);
    }
}
