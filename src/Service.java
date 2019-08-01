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
        System.out.printf("Desempenho Scanner( %s): %s milissegundos%n", tipoArquivo, resultado);
    }

    public void leituraCharacterReader(String caminhoEntrada, String tipoArquivo) throws IOException {
        double inicio = System.currentTimeMillis();
        FileReader in = null;
        FileWriter out = null;
        double acabou = 0;
        try {
            in = new FileReader(caminhoEntrada);
            out =  new FileWriter("testeSaida.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if(out != null) {
                out.close();
            }
            acabou = System.currentTimeMillis();
        }
        double resultado = acabou - inicio;
        System.out.printf("Desempenho Scanner( %s): %s milissegundos%n", tipoArquivo, resultado);
    }

    public void leituraByteReader(String caminhoEntrada, String tipoArquivo) throws IOException {
        double inicio = System.currentTimeMillis();
        InputStream inputStream =  null;
        OutputStream outputStream = null;
        double acabou = 0;
        try {
            inputStream = new FileInputStream(caminhoEntrada);
            outputStream = new FileOutputStream("testeSaida.txt");
            int c;

            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if(outputStream != null) {
                outputStream.close();
            }
            acabou = System.currentTimeMillis();
        }
        double resultado = acabou - inicio;
        System.out.printf("Desempenho Scanner( %s): %s milissegundos%n", tipoArquivo, resultado);
    }
}
