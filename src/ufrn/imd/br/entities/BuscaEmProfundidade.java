package ufrn.imd.br.entities;

public class BuscaEmProfundidade {

    private Integer largura;
    private Integer altura;
    private Integer matriz [][];

    public BuscaEmProfundidade(Integer largura, Integer altura, Integer[][] matriz) {
        this.largura = largura;
        this.altura = altura;
        this.matriz = matriz;
    }


}
