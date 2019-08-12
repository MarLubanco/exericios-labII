package listaTelefonica;

import listaTelefonica.model.Contato;
import listaTelefonica.service.MenuService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

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
                contatosExistentes.remove(contato);
            }
        }
    },
    LISTAR("3") {
        @Override
        public void realizarOpcao(List<Contato> contatosExistentes, Contato contato) {
            System.out.println("Contatos existentes: \n");
            contatosExistentes.forEach(c -> System.out.println(c.toString()));
        }
    };


    private String opcao;

    Opcao(String opcao) {
        this.opcao = opcao;
    }


}
