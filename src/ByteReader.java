import java.io.*;

public class ByteReader {

    public static void main(String[] args) throws IOException {
        double inicio = System.currentTimeMillis();
        InputStream inputStream =  null;
        OutputStream outputStream = null;
        double acabou = 0;
        try {
            inputStream = new FileInputStream("testeEntrada.txt");
            outputStream = new FileOutputStream("testeSaida.txt");
            int c;

            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream == null) {
                inputStream.close();
            }
            if(outputStream == null) {
                outputStream.close();
            }
            acabou = System.currentTimeMillis();
        }
        double resultado = acabou - inicio;
        System.out.println("Desempenho Byte: " + resultado  + " milissegundos");
    }
}
