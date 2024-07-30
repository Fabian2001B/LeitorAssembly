import java.util.HashMap;
import java.util.Map;

public class Listas {
    public static final Map<String, String> OPCODES = new HashMap<>();
    public static final Map<String, String> FUNCT_CODES = new HashMap<>();
    public static final Map<String, String> REGISTER_CODES = new HashMap<>();

    static {
        // Instruções tipo R
        OPCODES.put("add", "000000");
        FUNCT_CODES.put("add", "100000");
        OPCODES.put("addu", "000000");
        FUNCT_CODES.put("addu", "100001");
        OPCODES.put("sub", "000000");
        FUNCT_CODES.put("sub", "100010");
        OPCODES.put("subu", "000000");
        FUNCT_CODES.put("subu", "100011");
        OPCODES.put("and", "000000");
        FUNCT_CODES.put("and", "100100");
        OPCODES.put("or", "000000");
        FUNCT_CODES.put("or", "100101");
        OPCODES.put("xor", "000000");
        FUNCT_CODES.put("xor", "100110");
        OPCODES.put("nor", "000000");
        FUNCT_CODES.put("nor", "100111");
        OPCODES.put("slt", "000000");
        FUNCT_CODES.put("slt", "101010");
        OPCODES.put("sltu", "000000");
        FUNCT_CODES.put("sltu", "101011");
        OPCODES.put("sll", "000000");
        FUNCT_CODES.put("sll", "000000");
        OPCODES.put("srl", "000000");
        FUNCT_CODES.put("srl", "000010");
        OPCODES.put("sra", "000000");
        FUNCT_CODES.put("sra", "000011");
        OPCODES.put("sllv", "000000");
        FUNCT_CODES.put("sllv", "000100");
        OPCODES.put("srlv", "000000");
        FUNCT_CODES.put("srlv", "000110");
        OPCODES.put("srav", "000000");
        FUNCT_CODES.put("srav", "000111");
        OPCODES.put("mfhi", "000000");
        FUNCT_CODES.put("mfhi", "010000");
        OPCODES.put("mthi", "000000");
        FUNCT_CODES.put("mthi", "010001");
        OPCODES.put("mflo", "000000");
        FUNCT_CODES.put("mflo", "010010");
        OPCODES.put("mtlo", "000000");
        FUNCT_CODES.put("mtlo", "010011");
        OPCODES.put("mult", "000000");
        FUNCT_CODES.put("mult", "011000");
        OPCODES.put("multu", "000000");
        FUNCT_CODES.put("multu", "011001");
        OPCODES.put("div", "000000");
        FUNCT_CODES.put("div", "011010");
        OPCODES.put("divu", "000000");
        FUNCT_CODES.put("divu", "011011");
        OPCODES.put("jr", "000000");
        FUNCT_CODES.put("jr", "001000");
        OPCODES.put("jalr", "000000");
        FUNCT_CODES.put("jalr", "001001");

        // Instruções tipo I
        OPCODES.put("lb", "100000");
        OPCODES.put("lh", "100001");
        OPCODES.put("lwl", "100010");
        OPCODES.put("lw", "100011");
        OPCODES.put("lbu", "100100");
        OPCODES.put("lhu", "100101");
        OPCODES.put("lwr", "100110");
        OPCODES.put("sb", "101000");
        OPCODES.put("sh", "101001");
        OPCODES.put("swl", "101010");
        OPCODES.put("sw", "101011");
        OPCODES.put("swr", "101110");
        OPCODES.put("addi", "001000");
        OPCODES.put("addiu", "001001");
        OPCODES.put("slti", "001010");
        OPCODES.put("sltiu", "001011");
        OPCODES.put("andi", "001100");
        OPCODES.put("ori", "001101");
        OPCODES.put("xori", "001110");
        OPCODES.put("lui", "001111");
        OPCODES.put("bltz", "000001");
        FUNCT_CODES.put("bltz", "00000");
        OPCODES.put("bgez", "000001");
        FUNCT_CODES.put("bgez", "00001");
        OPCODES.put("bltzal", "000001");
        FUNCT_CODES.put("bltzal", "10000");
        OPCODES.put("bgezal", "000001");
        FUNCT_CODES.put("bgezal", "10001");
        OPCODES.put("beq", "000100");
        OPCODES.put("bne", "000101");
        OPCODES.put("blez", "000110");
        OPCODES.put("bgtz", "000111");

        // Instruções tipo J
        OPCODES.put("j", "000010");
        OPCODES.put("jal", "000011");

        // Mapeamento de registradores
        REGISTER_CODES.put("$zero", "00000");
        REGISTER_CODES.put("$at", "00001");
        REGISTER_CODES.put("$v0", "00010");
        REGISTER_CODES.put("$v1", "00011");
        REGISTER_CODES.put("$a0", "00100");
        REGISTER_CODES.put("$a1", "00101");
        REGISTER_CODES.put("$a2", "00110");
        REGISTER_CODES.put("$a3", "00111");
        REGISTER_CODES.put("$t0", "01000");
        REGISTER_CODES.put("$t1", "01001");
        REGISTER_CODES.put("$t2", "01010");
        REGISTER_CODES.put("$t3", "01011");
        REGISTER_CODES.put("$t4", "01100");
        REGISTER_CODES.put("$t5", "01101");
        REGISTER_CODES.put("$t6", "01110");
        REGISTER_CODES.put("$t7", "01111");
        REGISTER_CODES.put("$s0", "10000");
        REGISTER_CODES.put("$s1", "10001");
        REGISTER_CODES.put("$s2", "10010");
        REGISTER_CODES.put("$s3", "10011");
        REGISTER_CODES.put("$s4", "10100");
        REGISTER_CODES.put("$s5", "10101");
        REGISTER_CODES.put("$s6", "10110");
        REGISTER_CODES.put("$s7", "10111");
        REGISTER_CODES.put("$t8", "11000");
        REGISTER_CODES.put("$t9", "11001");
        REGISTER_CODES.put("$k0", "11010");
        REGISTER_CODES.put("$k1", "11011");
        REGISTER_CODES.put("$gp", "11100");
        REGISTER_CODES.put("$sp", "11101");
        REGISTER_CODES.put("$fp", "11110");
        REGISTER_CODES.put("$ra", "11111");
    }
}
