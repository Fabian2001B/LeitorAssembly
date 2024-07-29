import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorAssembly {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: java LeitorAssembly <caminho_arquivo_entrada> <caminho_arquivo_saida>");
            System.exit(1);
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        try {
            List<String> instructions = ManipuladorArquivos.lerInstrucoesDoArquivo(inputFilePath);
            List<String> binaryInstructions = new ArrayList<>();

            for (String instruction : instructions) {
                try {
                    System.out.println("Convertendo instrução: " + instruction);
                    String binaryInstruction = ConversorDeInstrucoes.converterParaBinario(instruction);
                    binaryInstructions.add(binaryInstruction);
                } catch (IllegalArgumentException e) {
                    System.err.println("Erro na conversão da instrução: " + instruction);
                    e.printStackTrace();
                }
            }

            ManipuladorArquivos.escreverInstrucoesNoArquivo(binaryInstructions, outputFilePath);
            System.out.println("Tradução concluída. Saída salva em " + outputFilePath);
        } catch (IOException e) {
            System.err.println("Erro ao ler ou escrever o arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
