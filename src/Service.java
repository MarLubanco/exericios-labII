import java.io.*;
import java.util.Scanner;

public class Service {

    public void leituraBufferedReader(String caminhoEntrada, String tipoArquivo) throws IOException {
        double inicio = System.currentTimeMillis();
        BufferedWriter outputStream = null;
        Scanner scanner = null;
        double acabou = 0;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(caminhoEntrada)));
            outputStream = new BufferedWriter(new FileWriter("testeSaida.txt"));
            int c;

            while (scanner.hasNext()) {
                outputStream.write(scanner.next());
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if(outputStream != null) {
                outputStream.close();
            }
            acabou = System.currentTimeMillis();
        }
        double resultado = acabou - inicio;
        System.out.println("Desempenho Scanner( " + tipoArquivo + "): " + resultado  + " milissegundos");
    }
}
