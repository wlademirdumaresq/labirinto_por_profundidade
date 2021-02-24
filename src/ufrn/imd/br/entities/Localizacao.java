package ufrn.imd.br.entities;

public class Localizacao {
    private final Integer linha;
    private final Integer coluna;
    private Localizacao localizacaoAnterior;

    public Localizacao(Integer linha, Integer coluna) {
        this.linha = linha;
        this.coluna = coluna;
        this.localizacaoAnterior = null;
    }

    public Localizacao(Integer linha, Integer coluna, Localizacao localizacaoAnterior) {
        this.linha = linha;
        this.coluna = coluna;
        this.localizacaoAnterior = localizacaoAnterior;
    }

    public Integer getLinha() {
        return linha;
    }

    public Integer getColuna() {
        return coluna;
    }

    public Localizacao getLocalizacaoAnterior() {
        return localizacaoAnterior;
    }
}
