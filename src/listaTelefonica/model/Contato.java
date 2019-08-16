package listaTelefonica.model;

import java.util.List;

public class Contato {

    private String nome;
    private List<Long> numero;

    public Contato() {
    }

    public Contato(String nome, List<Long> numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public Contato(String nome) {
        this.nome = nome;
    }

    public Contato(List<Long> numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Long> getNumero() {
        return numero;
    }

    public void setNumero(List<Long> numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Contato - Nome: " + nome + ", Numero=" + numero;
    }
}
