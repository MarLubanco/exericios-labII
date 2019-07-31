import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Service service = new Service();

        service.leituraBufferedReader("textoGrande", "Grande");
        service.leituraBufferedReader("textoMedio", "Medio");
        service.leituraBufferedReader("textoPequeno", "Pequeno");
    }
}
