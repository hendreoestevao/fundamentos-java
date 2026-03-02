package br.com.financeiro;

import br.com.calculo.Calculadora;

public class Principal {

    public static void main(String[] args) {

        Calculadora calc = new Calculadora();

        double valor = 1000;
        double juros = 5;

        double acrescimo = calc.multiplicar(valor, juros / 100);
        double total = calc.somar(valor, acrescimo);

        System.out.println("Valor original: " + valor);
        System.out.println("Juros (%): " + juros);
        System.out.println("Valor final com juros: " + total);
    }
}