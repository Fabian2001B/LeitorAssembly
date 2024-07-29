import java.util.Map;

public class ConversorInstrucoes {
    private static final Map<String, String> OPCODES = Listas.OPCODES;
    private static final Map<String, String> FUNCT_CODES = Listas.FUNCT_CODES;
    private static final Map<String, String> REGISTER_CODES = Listas.REGISTER_CODES;

    public static String converterParaBinario(String instrucao) {
        String[] partes = instrucao.split("\\s+|,\\s*|\\(|\\)");
        String opcode = partes[0];

        if (OPCODES.containsKey(opcode)) {
            switch (opcode) {
                case "add":
                case "sub":
                case "mult":
                    return converterTipoR(partes);
                case "sll":
                case "srl":
                    return converterTipoShift(partes);
                case "lw":
                case "sw":
                case "addi":
                case "ori":
                case "beq":
                case "bne":
                    return converterTipoI(partes);
                case "j":
                case "jal":
                    return converterTipoJ(partes);
                default:
                    throw new IllegalArgumentException("Instrução desconhecida: " + opcode);
            }
        } else {
            throw new IllegalArgumentException("Opcode desconhecido: " + opcode);
        }
    }

    private static String converterTipoR(String[] partes) {
        String opcode = "000000";
        String rs = registradorParaBinario(partes[2]);
        String rt = registradorParaBinario(partes[3]);
        String rd = registradorParaBinario(partes[1]);
        String shamt = "00000";
        String funct = FUNCT_CODES.get(partes[0]);
        return opcode + rs + rt + rd + shamt + funct;
    }

    private static String converterTipoShift(String[] partes) {
        String opcode = "000000";
        String rs = "00000";
        String rt = registradorParaBinario(partes[2]);
        String rd = registradorParaBinario(partes[1]);
        String shamt = imediatoParaBinario(partes[3], 5);
        String funct = FUNCT_CODES.get(partes[0]);
        return opcode + rs + rt + rd + shamt + funct;
    }

    private static String converterTipoI(String[] partes) {
        String opcode = OPCODES.get(partes[0]);
        String rs = registradorParaBinario(partes[2]);
        String rt = registradorParaBinario(partes[1]);
        String imediato = imediatoParaBinario(partes[3], 16);
        return opcode + rs + rt + imediato;
    }

    private static String converterTipoJ(String[] partes) {
        String opcode = OPCODES.get(partes[0]);
        String endereco = imediatoParaBinario(partes[1], 26);
        return opcode + endereco;
    }

    private static String registradorParaBinario(String registrador) {
        if (REGISTER_CODES.containsKey(registrador)) {
            return REGISTER_CODES.get(registrador);
        } else {
            throw new IllegalArgumentException("Registrador desconhecido: " + registrador);
        }
    }

    private static String imediatoParaBinario(String valor, int bits) {
        int numero = Integer.parseInt(valor);
        String binario = Integer.toBinaryString(numero);
        if (binario.length() > bits) {
            return binario.substring(binario.length() - bits);
        } else {
            return String.format("%" + bits + "s", binario).replace(' ', '0');
        }
    }
}
