package com.github.kheltan.gameboy.cpu;

import java.util.ArrayList;
import java.util.List;

import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;

public class Cpu {
    private final CpuContext context;
    public Cpu(final CpuContext context){
        this.context = context;
    }
    public CpuContext getContext() {
        return context;
    }
    public void run(){
        while (true) {
            try{
                int pc = context.pc();
                int oldPc = pc;

                int opcode = context.read(pc++);
                if(opcode == -1){
                    // System.out.println("??");
                    break;
                }

                Instruction instruction = InstructionDecoder.INSTANCE.decode(opcode);
                
                List<Integer> arguments = new ArrayList<Integer>();
                for(int i = 0; i < instruction.getNumOfArgs(); ++i){
                    arguments.add(context.read(pc++));
                }

                InstructionContext instructionContext = new InstructionContext(arguments);
                instruction.execute(context, instructionContext);
                // System.out.println(context);
                if(context.pc() != oldPc){
                    continue;
                }
                context.setPc(pc);
            }
            catch(Exception e){
                break;
            }
            
        }
    }
}
