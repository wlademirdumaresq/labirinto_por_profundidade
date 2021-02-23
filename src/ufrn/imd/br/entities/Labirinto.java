package ufrn.imd.br.entities;

public class Labirinto {

    private Integer colunas;
    private Integer linhas;
    private final String[][] matriz;
    private Localizacao entrada;
    private Localizacao saida;



    public Labirinto(String[][] matriz) {
        this.matriz = matriz;
        setAtibutos(this.matriz);
    }

    public Integer getColunas() {
        return colunas;
    }

    public Integer getLinhas() {
        return linhas;
    }

    public String[][] getMatriz() {
        return matriz;
    }

    public Localizacao getEntrada() {
        return entrada;
    }

    public Localizacao getSaida() {
        return saida;
    }
    public  void print() {
        for (int i = 0; i < this.getLinhas(); i++) {
            for (int j = 0; j < this.getColunas(); j++) {
                System.out.print(this.getMatriz()[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println();
    }
    public void setAtibutos(String[][] matriz) {
        this.colunas = matriz[0].length;
        this.linhas = matriz.length;

        for (int i = 0; i < linhas ; i++) {
            for (int j = 0; j <colunas; j++) {
                if (matriz[i][j].equals("E")){
                    this.entrada = new Localizacao(i,j);
                }
                if (matriz[i][j].equals("S")){
                    this.saida = new Localizacao(i,j);
                }

            }
        }
    }
}
