package org.example.visao;

import org.example.excecao.ExplosaoException;
import org.example.excecao.SairException;
import org.example.model.Tabuleiro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TabuleiroConsole {

    private final Tabuleiro tabuleiro;
    private final Scanner scanner = new Scanner(System.in);

    public TabuleiroConsole(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;

        executarJogo();
    }

    private void executarJogo() {
        try {
            boolean continuar = true;
            while (continuar) {
                cicloDoJogo();
                System.out.println("Outra partida? (S/n) ");
                String resposta = scanner.nextLine();

                if ("n".equalsIgnoreCase(resposta)) {
                    continuar = false;
                } else {
                    tabuleiro.reiniciar();
                }
            }
        } catch (SairException e) {
            System.out.println("Fim do jogo!");
        } finally {
            scanner.close();
        }
    }

    private void cicloDoJogo() {
        try {
            while (!tabuleiro.objetivoAlcancado()) {
                System.out.println(tabuleiro);
                String digitado = capturarValorDigitado("Digite (x,y): ");
                Iterator<Integer> iterator = Arrays.stream(digitado.split(",")).map(e -> Integer.parseInt(e.trim())).iterator();

                digitado = capturarValorDigitado("1 - Abrir ou 2 - (Des)Marcar: ");

                if (digitado.equals("1")) {
                    tabuleiro.abrir(iterator.next(), iterator.next());
                } else if (digitado.equals("2")) {
                    tabuleiro.alterarMarcacao(iterator.next(), iterator.next());
                }

            }
            System.out.println("Você ganhou!!!");
        } catch (ExplosaoException e) {
            System.out.println(tabuleiro);
            System.out.println("Você perdeu!");
        }
    }

    private String capturarValorDigitado(String texto) {
        System.out.print(texto);
        String digitado = scanner.nextLine();


        if ("sair".equalsIgnoreCase(digitado)) {
            throw new SairException();
        }
        return digitado;
    }
}
