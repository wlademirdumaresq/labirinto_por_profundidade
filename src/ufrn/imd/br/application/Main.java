package ufrn.imd.br.application;

import ufrn.imd.br.entities.BuscaEmProfundidade;
import ufrn.imd.br.entities.Labirinto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String labirinto_em_matriz[][] = {
                {"E", "#", "#", "#"},
                {".", ".", "#", "."},
                {"#", ".", "#", "#"},
                {"#", ".", ".", "."},
                {"#", "#", "#", "."},
                {"#", ".", ".", "."},
                {"#", ".", ".", "#"},
                {"#", "#", ".", "#"},
                {"#", ".", ".", "#"},
                {"#", ".", ".", "#"},
                {"#", "#", "S", "#"}
        };

        for (int l = 0; l < labirinto_em_matriz.length; l++) {
            for (int c = 0; c < labirinto_em_matriz[0].length; c++) {
                System.out.print(labirinto_em_matriz[l][c] + " "); //imprime caracter a caracter
            }
            System.out.println(" "); //muda de linha
        }
        System.out.println();
        Labirinto labirinto = new Labirinto(labirinto_em_matriz);

        BuscaEmProfundidade buscaEmProfundidade = new BuscaEmProfundidade(labirinto);


        if (buscaEmProfundidade.percorrer()) {
            for (int l = 0; l < buscaEmProfundidade.getCaminhosPercorridos().length; l++) {
                for (int c = 0; c < buscaEmProfundidade.getCaminhosPercorridos()[0].length; c++) {
                    if (labirinto.getMatriz()[l][c].equals("E") || labirinto.getMatriz()[l][c].equals("S")) {
                        System.out.print(labirinto_em_matriz[l][c] + " ");
                    } else {
                        if (buscaEmProfundidade.getCaminhosPercorridos()[l][c]) {
                            System.out.print("* ");
                        } else {
                            System.out.print(labirinto_em_matriz[l][c] + " ");
                        }
                    }
                }
                System.out.println(" "); //muda de linha
            }
        } else {
            System.out.println("não chegou");
        }

        scanner.close();
    }

}
