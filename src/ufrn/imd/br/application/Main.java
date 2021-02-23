package ufrn.imd.br.application;

import ufrn.imd.br.entities.BuscaEmProfundidade;
import ufrn.imd.br.entities.Labirinto;
import ufrn.imd.br.util.LabirintoParaMatriz;

import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        String pathArquivo = new String();
        if (args.length >= 1){
            try {
                pathArquivo = args[0];
            }catch (Exception e){
                System.out.println("Erro ao abrir arquivo");
            }
        }
        System.out.println(pathArquivo);

        if (Objects.equals(LabirintoParaMatriz.Matriz(pathArquivo), null)) {
            System.out.println("labirinto invalido");
        } else {
            String[][] labirinto_em_matriz = LabirintoParaMatriz.Matriz(pathArquivo);
            Labirinto labirinto = new Labirinto(labirinto_em_matriz);
            labirinto.print();

            BuscaEmProfundidade buscaEmProfundidade = new BuscaEmProfundidade(labirinto);

            if (buscaEmProfundidade.percorrer()) {
                buscaEmProfundidade.printSolucao();
            } else {
                System.out.println("não chegou");
            }

        }


    }

}
