package org.example;

import org.example.model.Tabuleiro;
import org.example.visao.TabuleiroConsole;

public class Main {
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro(6,6,6);
        new TabuleiroConsole(tabuleiro);
    }
}