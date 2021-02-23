package ufrn.imd.br.entities.test;

import org.junit.BeforeClass;
import org.junit.Test;
import ufrn.imd.br.entities.BuscaEmProfundidade;
import ufrn.imd.br.entities.Labirinto;
import ufrn.imd.br.entities.Localizacao;

import static org.junit.Assert.*;

public class BuscaEmProfundidadeTest {
private static Labirinto labirinto;
private static BuscaEmProfundidade buscaEmProfundidade;

    @BeforeClass
    public static void setUpBeforeClass(){
        String[][] labirinto_em_matriz = {
                {"#", "E", "#", "#"},
                {".", ".", ".", "."},
                {".", ".", ".", "."},
                {".", ".", ".", "."},
                {"#", ".", "#", "#"},
                {"#", ".", ".", "."},
                {"#", "#", "#", "."},
                {"#", ".", ".", "."},
                {"#", ".", ".", "."},
                {"#", "#", ".", "."},
                {"#", ".", ".", "."},
                {"#", ".", ".", "."},
                {"#", "#", "#", "S"}
        };
        labirinto = new Labirinto(labirinto_em_matriz);
        buscaEmProfundidade = new BuscaEmProfundidade(labirinto);
    }

    @Test
    public void saidaColuna() {
        Localizacao tmp =new Localizacao(12,3);
        assertEquals(labirinto.getSaida().getColuna(),tmp.getColuna());
    }
    @Test
    public void saidaLinha() {
        Localizacao tmp =new Localizacao(12,3);
        assertEquals(labirinto.getSaida().getLinha(),tmp.getLinha());
    }
    @Test
    public void entradaColuna() {
        Localizacao tmp =new Localizacao(0,1);
        assertEquals(labirinto.getEntrada().getColuna(),tmp.getColuna());
    }
    @Test
    public void entradaLinha() {
        Localizacao tmp =new Localizacao(0,1);
        assertEquals(labirinto.getEntrada().getLinha(),tmp.getLinha());
    }
    @Test
    public void Linhas() {
        assertEquals(labirinto.getLinhas().longValue(), 13);
    }
    @Test
    public void colunas() {
        assertEquals(labirinto.getColunas().longValue(), 4);
    }
    @Test
    public void percorrer() {
        assertTrue(buscaEmProfundidade.percorrer());
    }
    @Test
    public void percorrerCaminhoFechado() {
        String[][] labirinto_em_matriz = {
                {"#", "E", "#", "#"},
                {".", ".", ".", "."},
                {".", ".", ".", "."},
                {".", ".", ".", "."},
                {"#", ".", "#", "#"},
                {"#", ".", ".", "."},
                {"#", "#", "#", "."},
                {"#", ".", ".", "."},
                {"#", ".", ".", "."},
                {"#", "#", ".", "."},
                {"#", ".", ".", "."},
                {"#", ".", ".", "#"},
                {"#", "#", "#", "S"}
        };

        Labirinto tmp = new Labirinto(labirinto_em_matriz);
        BuscaEmProfundidade buscaTMP = new BuscaEmProfundidade(tmp);

        assertFalse(buscaTMP.percorrer());
    }


}