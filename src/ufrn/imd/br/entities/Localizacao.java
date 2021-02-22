package ufrn.imd.br.entities;

public class Localizacao {
    private Integer linha;
    private Integer coluna;

    public Localizacao(Integer linha, Integer coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public Localizacao(Integer linha, Integer coluna, Localizacao anterior) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public Integer getLinha() {
        return linha;
    }

    public Integer getColuna() {
        return coluna;
    }

}
