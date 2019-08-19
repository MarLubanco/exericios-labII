package listaTelefonica;

import listaTelefonica.model.Contato;
import listaTelefonica.service.MenuService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaTelefonica {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Contato> contatosExistente = new ArrayList<>();
        boolean controle = true;
        while (controle) {
            MenuService.listarMenu();
            contatosExistente = MenuService.carregarBancoDeDados();
            MenuService.opcaoSelecionada(contatosExistente);
        }
    }
}
