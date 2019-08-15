package listaTelefonica.service;

import listaTelefonica.Opcao;
import listaTelefonica.model.Contato;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
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
        if(!opcao.equals("LISTAR") && !opcao.equals("PESQUISAR")) {
            contato = criarUsuario(scanner);
            Opcao.valueOf(opcao).realizarOpcao(contatosExistentes, contato);
        } else if(opcao.equals("PESQUISAR")) {
            pesquisarContato(contatosExistentes, scanner);
        } else {
            Opcao.valueOf(opcao).realizarOpcao(contatosExistentes, contato);

        }
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

    public static void pesquisarContato(List<Contato> contatos, Scanner scanner) {
        System.out.print("Pesquisar por nome ou numero? ");
        String escolha = scanner.next();
        String nome = null;
        String numero =  null;
        if(escolha.equalsIgnoreCase("nome")) {
            System.out.print("Nome: ");
            nome = scanner.next();
            search(contatos, new Contato(nome));
        } else {
            System.out.print("Numero: ");
            numero = scanner.next();
            search(contatos, new Contato(Arrays.asList(Long.valueOf(numero))));
        }
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

    public static void search(List<Contato> contatosExistentes, Contato contato) {
            System.out.println("___________________________");
            System.out.println("Pesquisa realizada");
            System.out.println("___________________________");
            contatosExistentes.stream()
                    .filter(c -> (contato.getNome() != null && c.getNome().contains(contato.getNome()))
                            || (contato.getNumero() != null && String.valueOf(c.getNumero().toString()).contains(contato.getNumero().toString())))
                    .sorted(Comparator.comparing(Contato::getNome))
                    .forEach(c -> System.out.println(c.toString()));
        }
}
