package ufrn.imd.br.entities;

public class BuscaEmProfundidade {

    private Labirinto labirinto;
    private boolean caminhosPercorridos [][];

    public BuscaEmProfundidade(Labirinto labirinto) {
        this.labirinto = labirinto;
        this.caminhosPercorridos = new boolean[labirinto.getLinhas()][labirinto.getColunas()];
    }

    public boolean[][] getCaminhosPercorridos() {
        return caminhosPercorridos;
    }

    public boolean validadorLocalizacao(int linha, int coluna){
        if(linha < 0 || linha >= this.labirinto.getLinhas() || coluna < 0 || coluna >= this.labirinto.getColunas()){
            return true;
        }
        return false;
    }

    public void alterarValidadorRota(int linha, int coluna, boolean caminhou){
        this.caminhosPercorridos[linha][coluna] = caminhou;
    }
    public boolean checandoCaminho(int linha, int coluna){
        return this.caminhosPercorridos[linha][coluna];
    }

    public boolean percorrer(){
       return  percorrer(this.labirinto, this.labirinto.getEntrada().getLinha(), this.labirinto.getEntrada().getColuna());
    }
    public boolean percorrer(Labirinto l, int linha, int coluna){

        if(validadorLocalizacao(linha,coluna) || this.labirinto.getMatriz()[linha][coluna].equals("#") || checandoCaminho(linha,coluna)){
            return false;
        }
        this.alterarValidadorRota(linha,coluna,true);

        if(this.labirinto.getSaida().getLinha() == linha && this.labirinto.getSaida().getColuna() == coluna){
            return true;
        }
        if (percorrer(l, linha, coluna + 1)) {
            return true;
        }
        if (percorrer(l, linha + 1, coluna)) {
            return true;
        }
        if (percorrer(l, linha, coluna - 1)) {
            return true;
        }
        if (percorrer(l, linha - 1, coluna)) {
            return true;
        }

        this.alterarValidadorRota(linha,coluna,false);
        return false;
    }
}
