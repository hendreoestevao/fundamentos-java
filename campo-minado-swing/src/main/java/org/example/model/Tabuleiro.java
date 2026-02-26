package org.example.model;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Tabuleiro implements CampoObservador {

    private final int linhas;
    private final int colunas;
    private final int minas;

    private final List<Campo> campos = new ArrayList<Campo>();
    private final List<Consumer<ResultadoEvento>> observadores = new ArrayList<>();

    public Tabuleiro(int linhas, int colunas, int minas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.minas = minas;

        gerarCampos();
        associarOsVizinhos();
        sortearMinas();
    }

    public void paraCadaCampo(Consumer<Campo> funcao){
        campos.forEach(funcao);
    }

    public void registraObservador(Consumer<ResultadoEvento> observador) {
        observadores.add(observador);
    }

    private void notificarObservador(boolean resultado) {
        observadores.stream().forEach(observador -> observador.accept(new ResultadoEvento(resultado)));
    }

    public void abrir(int linha, int coluna) {
        campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna).findFirst().ifPresent(Campo::abrir);
    }

    public void alterarMarcacao(int linha, int coluna) {
        campos.parallelStream().filter(c -> c.getLinha() == linha && c.getColuna() == coluna).findFirst().ifPresent(Campo::alterarMarcacao);
    }

    private void gerarCampos() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                Campo campo = new Campo(i, j);
                campo.registrarObservador(this);
                campos.add(campo);
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

    @Override
    public void eventoOcorreu(Campo campo, CampoEvento evento) {
        if (evento == CampoEvento.EXPLODIR) {
            mostrarMinas();
            notificarObservador(false);
        } else if (objetivoAlcancado()) {
            notificarObservador(true);
        }
    }

    private void mostrarMinas() {
        campos.stream()
                .filter(c -> c.isMinado())
                .filter(c -> !c.isMarcado())
                .forEach(c -> c.setAberto(true));
    }


    public int getColunas() {
        return colunas;
    }

    public int getLinhas() {
        return linhas;
    }

    public int getMinas() {
        return minas;
    }
}
