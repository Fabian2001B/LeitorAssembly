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
        OPCODES.put("sub", "000000");
        FUNCT_CODES.put("sub", "100010");
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
        OPCODES.put("mult", "000000");
        FUNCT_CODES.put("mult", "011000");

        // Instruções tipo I
        OPCODES.put("lw", "100011");
        OPCODES.put("sw", "101011");
        OPCODES.put("addi", "001000");
        OPCODES.put("ori", "001101");
        OPCODES.put("beq", "000100");
        OPCODES.put("bne", "000101");

        // Instruções tipo J
        OPCODES.put("j", "000010");
        OPCODES.put("jal", "000011");

        // Mapeamento de registradores
        REGISTER_CODES.put("$zero", "00000");
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
    }
}
