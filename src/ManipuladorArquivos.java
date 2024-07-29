import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorArquivos {
    public static List<String> lerInstrucoesDoArquivo(String nomeDoArquivo) throws IOException {
        List<String> instrucoes = new ArrayList<>();
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeDoArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                instrucoes.add(linha.trim());
            }
        }
        return instrucoes;
    }

    public static void escreverInstrucoesNoArquivo(List<String> instrucoes, String nomeDoArquivo) throws IOException {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nomeDoArquivo))) {
            for (String instrucao : instrucoes) {
                escritor.write(instrucao);
                escritor.newLine();
            }
        }
    }
}
