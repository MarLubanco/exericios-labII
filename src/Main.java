import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Service service = new Service();
        System.out.println("------------------Buffered Reader------------------------");
        service.leituraBufferedReader("textoGrande", "Grande");
        service.leituraBufferedReader("textoMedio", "Medio");
        service.leituraBufferedReader("textoPequeno", "Pequeno");
        System.out.println("------------------Character Reader------------------------");
        service.leituraCharacterReader("textoGrande", "Grande");
        service.leituraCharacterReader("textoMedio", "Medio");
        service.leituraCharacterReader("textoPequeno", "Pequeno");
        System.out.println("------------------Byte Reader------------------------");
        service.leituraByteReader("textoGrande", "Grande");
        service.leituraByteReader("textoMedio", "Medio");
        service.leituraByteReader("textoPequeno", "Pequeno");

    }
}
