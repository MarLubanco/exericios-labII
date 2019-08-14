package listaTelefonica;

import listaTelefonica.model.Contato;
import listaTelefonica.service.MenuService;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum  Opcao implements OpcaoInterface {
    INSERIR("1") {
        @Override
        public void realizarOpcao(List<Contato> contatosExistentes, Contato contato) throws IOException {
            if (!Objects.isNull(contato) && !contato.getNome().isEmpty()
                && !contato.getNumero().isEmpty()) {
                contatosExistentes.add(contato);
                MenuService.persistirBanco(contatosExistentes);
            }
        }
    },
    DELETAR("2") {
        @Override
        public void realizarOpcao(List<Contato> contatosExistentes, Contato contato) {
            if (!Objects.isNull(contato) && !contato.getNome().isEmpty()
                    && !contato.getNumero().isEmpty()) {
                contatosExistentes.stream()
                        .filter(c -> c.getNumero() == contato.getNumero())
                        .filter(c -> c.getNome().equals(contato.getNome()))
                        .forEach(c -> {

                            contatosExistentes.remove(c);
                        });
            }
        }
    },

    LISTAR("3") {
        @Override
        public void realizarOpcao(List<Contato> contatosExistentes, Contato contato) {
            System.out.println("Contatos existentes: \n");
            contatosExistentes.stream()
                    .sorted(Comparator.comparing(Contato::getNome))
                    .forEach(c -> System.out.println(c.toString()));
        }
    },
    PESQUISAR("4") {
        @Override
        public void realizarOpcao(List<Contato> contatosExistentes, Contato contato) {
            System.out.println("___________________________");
            System.out.println("Pesquisa realizada");
            System.out.println("___________________________");
            contatosExistentes.stream()
                    .filter(c -> (contato.getNome() != null && c.getNome().contains(contato.getNome()))
                            || (contato.getNumero() != null && String.valueOf(c.getNumero().toString()).contains(contato.getNumero().toString())))
                    .sorted(Comparator.comparing(Contato::getNome))
                    .forEach(c -> System.out.println(c.toString()));
        }
    };


    private String opcao;

    Opcao(String opcao) {
        this.opcao = opcao;
    }


}
