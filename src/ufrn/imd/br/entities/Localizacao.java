package ufrn.imd.br.entities;

public class Localizacao {
    private Integer linha;
    private Integer coluna;
    private Localizacao anterior;

    public Localizacao(Integer linha, Integer coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.anterior = null;
    }

    public Localizacao(Integer linha, Integer coluna, Localizacao anterior) {
        this.linha = linha;
        this.coluna = coluna;
        this.anterior = anterior;
    }

    public Integer getLinha() {
        return linha;
    }

    public Integer getColuna() {
        return coluna;
    }

    public Localizacao getAnterior() {
        return anterior;
    }
}
