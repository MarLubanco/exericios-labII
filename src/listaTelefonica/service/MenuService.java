package listaTelefonica.service;

import listaTelefonica.Opcao;
import listaTelefonica.model.Contato;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuService {

    public static void listarMenu() {
        System.out.println("Lista Telefonica \n" +
                "-------------------------------\n" +
                "1 - Inserir novo contato\n" +
                "2 - Deletar contato \n" +
                "3 - Mostar numero de contato\n" +
                "4 - Pesquisar contato");
    }

    public static void opcaoSelecionada(List<Contato> contatosExistentes) throws IOException {
        System.out.println("Escolha uma opção: ");
        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.next();
        Contato contato = null;
        contato = !opcao.equals("LISTAR") ? criarUsuario(scanner): null;
        Opcao.valueOf(opcao).realizarOpcao(contatosExistentes, contato);
    }

    public static Contato criarUsuario(Scanner scanner) {
        System.out.print("Nome do contato: ");
        String nome = scanner.next();
        System.out.println("Numeros do contato(separados por ;): ");
        String[] numeros = scanner.next().split(";");;
        List<Long> numerosConvertidos = Arrays.asList(numeros).stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());
        return new Contato(nome, numerosConvertidos);
    }

    public static void persistirBanco(List<Contato> contatosExistentes) throws IOException {
        FileWriter out = null;
        try {
            out =  new FileWriter("banco-de-dados.txt");
            FileWriter finalOut = out;
            for(Contato contato: contatosExistentes) {
                String nome = contato.getNome();
                for(Long numero : contato.getNumero()) {
                    finalOut.write(nome + ", " + numero + "\n");
                }
            }
        } finally {
            if(out != null) {
                out.close();
            }
        }
        System.out.println("Dados persistdos no banco de dados");
    }

    public static List<Contato> carregarBancoDeDados() throws IOException {
        FileReader in = null;
        List<Contato> contatosBanco = new ArrayList<>();
        BufferedReader lerArq= null;
        try {
            lerArq = new BufferedReader(new FileReader("banco-de-dados.txt"));
            String linha = lerArq.readLine();
            while (linha != null) {
                String[] usuario = linha.split(",");
                contatosBanco.add(new Contato(usuario[0], Arrays.asList(Long.parseLong(usuario[1].trim()))));
                linha = lerArq.readLine();
            }
        } finally {
            if (in != null) {
                lerArq.close();
            }
        }
        System.out.println("Dados recuperado do banco de dados");
        return contatosBanco;
    }
}
