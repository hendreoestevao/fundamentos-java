package org.example.model;

import org.example.excecao.ExplosaoException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Tabuleiro {

    private final List<Campo> campos = new ArrayList<Campo>();
    private final int linhas;
    private final int colunas;
    private final int minas;

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;

        gerarCampos();
        associarOsVizinhos();
        sortearMinas();
    }

    public void abrir(int linha, int coluna) {
        try {
            campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna).findFirst().ifPresent(Campo::abrir);

        } catch (ExplosaoException e) {
            campos.forEach(c -> c.setAberto(true));
            throw e;
        }
    }

    public void alterarMarcacao(int linha, int coluna) {
        campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna).findFirst().ifPresent(Campo::alterarMarcacao);
    }


    private void gerarCampos() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                campos.add(new Campo(i, j));
            }
        }
    }

    private void associarOsVizinhos() {
        for (Campo c1 : campos) {
            for (Campo c2 : campos) {
                c1.adicionarVizinho(c2);
            }
        }
    }

    private void sortearMinas() {
        long minasArmadas = 0;
        Predicate<Campo> minado = c -> c.isMinado();
        do {
            int aleatorio = (int) (Math.random() * campos.size());
            campos.get(aleatorio).minar();
            minasArmadas = campos.stream().filter(minado).count();

        } while (minasArmadas < minas);
    }

    public boolean objetivoAlcancado() {
        return campos.stream().allMatch(Campo::objetivoAlcancado);
    }

    public void reiniciar() {
        campos.forEach(Campo::reiniciar);
        sortearMinas();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");

        for (int i = 0; i < linhas; i++) {
            sb.append(" ");
            sb.append(i);
            sb.append(" ");
        }
        sb.append("\n");

        int i = 0;
        for (int l = 0; l < linhas; l++) {

            sb.append(" ");
            sb.append(l);
            sb.append(" ");

            for (int c = 0; c < colunas; c++) {
                sb.append(" ");
                sb.append(campos.get(i));
                sb.append(" ");
                i++;
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
