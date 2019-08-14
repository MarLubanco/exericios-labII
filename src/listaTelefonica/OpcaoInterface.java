package listaTelefonica;

import listaTelefonica.model.Contato;

import java.io.IOException;
import java.util.List;

public interface OpcaoInterface {

    void realizarOpcao(List<Contato> contatosExistentes, Contato contato) throws IOException;
}
