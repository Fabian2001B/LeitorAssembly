import java.util.Map;

public class ConversorDeInstrucoes {
    private static final Map<String, String> OPCODES = Listas.OPCODES;
    private static final Map<String, String> FUNCT_CODES = Listas.FUNCT_CODES;
    private static final Map<String, String> REGISTER_CODES = Listas.REGISTER_CODES;

    public static String converterParaBinario(String instrucao) {
        String[] partes = instrucao.split("\\s+|,\\s*|\\(|\\)");
        String opcode = partes[0].trim();

        if (OPCODES.containsKey(opcode)) {
            switch (opcode) {
                case "add":
                case "sub":
                case "mult":
                    return converterTipoR(partes);
                case "sll":
                case "srl":
                case "sra":
                case "sllv":
                case "srlv":
                case "srav":
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
        if (partes.length != 4) {
            throw new IllegalArgumentException("Formato de instrução inválido: " + partes);
        }

        String opcode = OPCODES.get(partes[0].trim());
        String rt = registradorParaBinario(partes[1].trim());
        String rs;
        String imediato;

        // Verifique se o terceiro parâmetro é um registrador ou um número imediato
        if (REGISTER_CODES.containsKey(partes[2].trim())) {
            rs = registradorParaBinario(partes[2].trim());
            imediato = partes[3].trim();
        } else {
            rs = "00000"; // rs é 0 se não for um registrador
            imediato = partes[2].trim();
        }

        String imediatoBinario = imediatoParaBinario(imediato, 16);

        return opcode + rs + rt + imediatoBinario;
    }

    private static String converterTipoJ(String[] partes) {
        String opcode = OPCODES.get(partes[0]);
        String endereco = imediatoParaBinario(partes[1], 26);
        return opcode + endereco;
    }

    private static String registradorParaBinario(String registrador) {
        registrador = registrador.trim();

        if (REGISTER_CODES.containsKey(registrador)) {
            return REGISTER_CODES.get(registrador);
        } else {
            throw new IllegalArgumentException("Registrador desconhecido: " + registrador);
        }
    }

    private static String imediatoParaBinario(String imediato, int tamanho) {
        imediato = imediato.trim();

        try {
            // Verifica se o imediato é um número
            int valor = Integer.parseInt(imediato);

            // Converte para binário
            String binario = Integer.toBinaryString(valor);

            // Preenche com zero à esquerda se for positivo
            if (valor >= 0) {
                binario = String.format("%" + tamanho + "s", binario).replace(' ', '0');
            } else {
                // Converte negativo para formato binário com complemento de dois
                binario = String.format("%" + tamanho + "s", binario).replace(' ', '1');
            }
            return binario.substring(binario.length() - tamanho);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Imediato inválido: " + imediato);
        }
    }
}

