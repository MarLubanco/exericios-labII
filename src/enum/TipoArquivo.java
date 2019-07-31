@SuppressWarnings("ALL")
public enum TipoArquivo {
    P("PEQUENO"),
    M("MEDIO"),
    G("GRANDE");

    public String tamanho;
    TipoArquivo(String tamanho) {
       this.tamanho = tamanho;
    }
}