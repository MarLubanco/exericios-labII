package listaTelefonica.service;

import listaTelefonica.Opcao;
import listaTelefonica.exception.ComandoNaoEncontradoException;
import listaTelefonica.model.Contato;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class MenuService {

    public static void listarMenu() {
        System.out.println(
                "__________________________________________________ \n\n" +
                "Lista Telefonica \n" +
                "___________________________________________________\n\n" +
                "INSERIR - Inserir novo contato\n" +
                "DELETAR - Deletar contato \n" +
                "LISTAR - Mostrar numero de contato\n" +
                "PESQUISAR - Pesquisar contato");
    }

    public static void opcaoSelecionada(List<Contato> contatosExistentes) throws IOException, ClassNotFoundException {
        System.out.println("Escolha uma opção: ");
        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.next();
        Contato contato = null;
        if(!opcao.equalsIgnoreCase("LISTAR") && !opcao.equalsIgnoreCase("DELETAR") && !opcao.equalsIgnoreCase("PESQUISAR")) {
            contato = criarUsuario(scanner);
            Opcao.valueOf(opcao).realizarOpcao(contatosExistentes, contato);
        } else if(opcao.equalsIgnoreCase("PESQUISAR")) {
            pesquisarContato(contatosExistentes, scanner);
        } else if(opcao.equalsIgnoreCase("DELETAR")) {
            System.out.println("Numero do contato pra deletar: ");
            String numeroRemovido = scanner.next();
            deletarUsuario(contatosExistentes, Long.valueOf(numeroRemovido));
        } else {
            Opcao.valueOf(opcao).realizarOpcao(contatosExistentes, contato);
        }
    }

    public static Contato criarUsuario(Scanner scanner) {
        System.out.print("Nome do contato: ");
        String nome = scanner.next();
        System.out.println("Numeros do contato(separados por ;): ");
        String[] numeros = scanner.next().split(";");
        List<Long> numerosConvertidos = Arrays.asList(numeros).stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());

        return new Contato(nome, numerosConvertidos);
    }

    public static void pesquisarContato(List<Contato> contatos, Scanner scanner) throws ClassNotFoundException {
        System.out.print("Pesquisar por nome ou numero? ");
        String escolha = scanner.next();
        String nome = null;
        String numero =  null;
        if(escolha.equalsIgnoreCase("nome")) {
            System.out.print("Nome: ");
            nome = scanner.next();
            search(contatos, new Contato(nome));
        } else  if(escolha.equalsIgnoreCase("numero")){
            System.out.print("Numero: ");
            numero = scanner.next();
            search(contatos, new Contato(Arrays.asList(Long.valueOf(numero))));
        } else {
            System.out.println("Esse comando não existe, tente novamente.");
        }
    }

    public static void commitDataBase(List<Contato> contatosExistentes) throws IOException {
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
            System.out.println("_______________________________________________\n");
            System.out.println("Pesquisa realizada");
            System.out.println("_______________________________________________");
            contatosExistentes.stream()
                    .filter(c -> (contato.getNome() != null && c.getNome().contains(contato.getNome()))
                            || (contato.getNumero() != null && String.valueOf(c.getNumero().toString()).contains(contato.getNumero().toString())))
                    .sorted(Comparator.comparing(Contato::getNome))
                    .forEach(c -> System.out.println(c.toString()));
    }

    public static void deletarUsuario(List<Contato> contatosExistentes, Long numero) throws IOException {
        AtomicInteger index = new AtomicInteger();
        AtomicInteger aux = new AtomicInteger();
        contatosExistentes.stream()
                .forEach(c -> {
                    if(c.getNumero().contains(numero)) {
                        aux.set(index.incrementAndGet());
                        return;
                    }
                    index.incrementAndGet();

                });
        contatosExistentes.remove(aux.get() -1);
        commitDataBase(contatosExistentes);

    }
}
