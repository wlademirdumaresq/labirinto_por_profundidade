package ufrn.imd.br.entities;

import java.util.ArrayList;
import java.util.List;

public class BuscaEmProfundidade {

    private final Labirinto labirinto;
    private final boolean[][] caminhosPercorridos;
    private List<Localizacao> rotaFinal;

    public BuscaEmProfundidade(Labirinto labirinto) {
        this.labirinto = labirinto;
        this.caminhosPercorridos = new boolean[labirinto.getLinhas()][labirinto.getColunas()];
        this.rotaFinal = new ArrayList<Localizacao>();
    }

    public boolean[][] getCaminhosPercorridos() {
        return caminhosPercorridos;
    }

    public boolean validadorLocalizacao(int linha, int coluna) {
        return linha < 0 || linha >= this.labirinto.getLinhas() || coluna < 0 || coluna >= this.labirinto.getColunas();
    }

    public void alterarValidadorRota(int linha, int coluna, boolean caminhou) {
        this.caminhosPercorridos[linha][coluna] = caminhou;
    }

    public boolean checandoCaminho(int linha, int coluna) {
        return this.caminhosPercorridos[linha][coluna];
    }

    public boolean percorrer() {

        return percorrer(this.labirinto, this.labirinto.getEntrada().getLinha(), this.labirinto.getEntrada().getColuna(), this.rotaFinal);
    }

    public boolean percorrer(Labirinto l, int linha, int coluna, List<Localizacao> lista) {

        if (validadorLocalizacao(linha, coluna) || this.labirinto.getMatriz()[linha][coluna].equals("#") || checandoCaminho(linha, coluna)) {
            return false;
        }
        this.alterarValidadorRota(linha, coluna, true);
        lista.add(new Localizacao(linha, coluna));

        if (l.getSaida().getLinha() == linha && l.getSaida().getColuna() == coluna) {
            return true;
        }
        if (percorrer(l, linha, coluna + 1, lista)) {
            return true;
        }
        if (percorrer(l, linha + 1, coluna, lista)) {
            return true;
        }
        if (percorrer(l, linha, coluna - 1, lista)) {
            return true;
        }
        if (percorrer(l, linha - 1, coluna, lista)) {
            return true;
        }

        lista.remove(lista.size() - 1);
        return false;
    }

    public void printSolucao() {
        for (int i = 0; i < this.getCaminhosPercorridos().length; i++) {
            for (int j = 0; j < this.getCaminhosPercorridos()[0].length; j++) {
                if (labirinto.getMatriz()[i][j].equals("E") || this.labirinto.getMatriz()[i][j].equals("S")) {
                    System.out.print(this.labirinto.getMatriz()[i][j] + " ");

                } else {
                    if (this.getCaminhosPercorridos()[i][j]) {
                        System.out.print("* ");
                    } else {
                        System.out.print(this.labirinto.getMatriz()[i][j] + " ");
                    }
                }
            }
            System.out.println(" ");
        }
    }

    public void printRotaFinal() {
        List<Localizacao> tmp = this.rotaFinal;
        String tmpMatriz [][] = this.labirinto.getMatriz();
        for (Localizacao x : tmp) {
            if (this.labirinto.getEntrada().getColuna() == x.getColuna() && this.labirinto.getEntrada().getLinha() == x.getLinha()) {
                continue;
            }
            if (this.labirinto.getSaida().getColuna() == x.getColuna() && this.labirinto.getSaida().getLinha() == x.getLinha()) {
                continue;
            }
            tmpMatriz[x.getLinha()][x.getColuna()]="*";

        }
        Labirinto tmpLab = new Labirinto(tmpMatriz);
        tmpLab.print();
    }
}
