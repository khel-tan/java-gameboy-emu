package com.github.kheltan.gameboy.cpu;

import java.util.ArrayList;
import java.util.List;

import com.github.kheltan.gameboy.cpu.instructions.Instruction;
import com.github.kheltan.gameboy.cpu.instructions.InstructionContext;

/*
 * CPU 
 */
public class Cpu {
    private final CpuContext cpuContext;
    public Cpu(final CpuContext context){
        this.cpuContext = context;
    }
    public CpuContext getCpuContext() {
        return cpuContext;
    }
    public void run(){
        while (true) {
            try{
                //Read Program Counter
                int pc = cpuContext.pc();
                int oldPc = pc;

                int opcode = cpuContext.read(pc++);
                // If the addressing is out of bounds, the bus returns -1
                if(opcode == -1){
                    break;
                }
                
                //Decoding
                Instruction instruction = InstructionDecoder.INSTANCE.decode(opcode);
                
                //Constructing the instruction context
                List<Integer> arguments = new ArrayList<Integer>();
                for(int i = 0; i < instruction.getNumOfArgs(); ++i){
                    arguments.add(cpuContext.read(pc++));
                }

                InstructionContext instructionContext = new InstructionContext(arguments);

                //Execution
                instruction.execute(cpuContext, instructionContext);

                /*
                 * If the pc state in the cpu context changed before we have updated it in our loop,
                 * it means that there was a branching instruction. Therefore, we do not update.
                 * TODO: Find a better solution. This is messy.
                 */
                if(cpuContext.pc() != oldPc){
                    continue;
                }
                cpuContext.setPc(pc);
            }
            catch(Exception e){
                break;
            }
            
        }
    }
}
