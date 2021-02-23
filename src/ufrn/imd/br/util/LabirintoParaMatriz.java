package ufrn.imd.br.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class  LabirintoParaMatriz {
    public static String[][] Matriz (){
        String[][] labirinto_em_matriz;
        try {
            FileReader arq = new FileReader("src/ufrn/imd/br/application/labirintosTXT/labirinto01");

            Scanner leitor = new Scanner(arq);
            int leitorLinhas = 0;
            int leitorColunas = 0;

            while (leitor.hasNext()){
                String line = leitor.nextLine();
                leitorColunas=line.length();
                leitorLinhas+=1;
            }
            arq.close();
            FileReader arq2 = new FileReader("src/ufrn/imd/br/application/labirintosTXT/labirinto01");
            leitor = new Scanner(arq2);
            labirinto_em_matriz = new String [leitorLinhas][leitorColunas];
            int i = 0;
            while (leitor.hasNext()){
                String line = leitor.nextLine();
                for (int j = 0; j < leitorColunas; j++) {
                    labirinto_em_matriz[i][j]= Character.toString(line.charAt(j));

                }
                i+=1;
            }
            return labirinto_em_matriz;
        } catch (IOException e) {
            System.out.println("parametro invalido" + e.getMessage());
        }
        return null;
        }

}
