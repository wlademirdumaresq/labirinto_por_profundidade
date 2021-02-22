package ufrn.imd.br.application;

import ufrn.imd.br.entities.BuscaEmProfundidade;
import ufrn.imd.br.entities.Labirinto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String labirinto_em_matriz[][] = {
                {"E", "#", "#", "#"},
                {".", ".", ".", "."},
                {"#", ".", "#", "#"},
                {"#", ".", ".", "."},
                {"#", "#", "#", "."},
                {"#", ".", ".", "."},
                {"#", ".", ".", "."},
                {"#", "#", ".", "."},
                {"#", ".", ".", "."},
                {"#", ".", ".", "#"},
                {"#", "S", "#", "#"}
        };

        for (int i = 0; i < labirinto_em_matriz.length; i++) {
            for (int j = 0; j < labirinto_em_matriz[0].length; j++) {
                System.out.print(labirinto_em_matriz[i][j] + " "); //imprime caracter a caracter
            }
            System.out.println(" "); //muda de linha
        }
        System.out.println();
        Labirinto labirinto = new Labirinto(labirinto_em_matriz);

        BuscaEmProfundidade buscaEmProfundidade = new BuscaEmProfundidade(labirinto);


        if (buscaEmProfundidade.percorrer()) {
            for (int i = 0; i < buscaEmProfundidade.getCaminhosPercorridos().length; i++) {
                for (int j = 0; j < buscaEmProfundidade.getCaminhosPercorridos()[0].length; j++) {
                    if (labirinto.getMatriz()[i][j].equals("E") || labirinto.getMatriz()[i][j].equals("S")) {
                        System.out.print(labirinto_em_matriz[i][j] + " ");
                    } else {
                        if (buscaEmProfundidade.getCaminhosPercorridos()[i][j]) {
                            System.out.print("* ");
                        } else {
                            System.out.print(labirinto_em_matriz[i][j] + " ");
                        }
                    }
                }
                System.out.println(" ");
            }
        } else {
            System.out.println("não chegou");
        }

        scanner.close();
    }

}
