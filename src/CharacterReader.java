import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterReader {

    public static void main(String[] args) throws IOException {
        double inicio = System.currentTimeMillis();
        FileReader in = null;
        FileWriter out = null;
        double acabou = 0;
        try {
            in = new FileReader("testeEntrada.txt");
            out =  new FileWriter("testeSaida.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in == null) {
                in.close();
            }
            if(out == null) {
                out.close();
            }
            acabou = System.currentTimeMillis();
        }
        double resultado = acabou - inicio;
        System.out.println("Desempenho Character: " +  resultado  + " milissegundos");
    }
}
