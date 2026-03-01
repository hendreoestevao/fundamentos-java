package org.example.test.consulta;

import org.example.infra.DAO;
import org.example.model.muitospramuitos.Ator;
import org.example.model.muitospramuitos.Filme;

import java.util.List;

public class ObterFilmes {
    public static void main(String[] args) {
        DAO<Filme> dao = new DAO<Filme>(Filme.class);
        List<Filme> filmes = dao.consultar("obterFilmesComNotaMaiorQue", "nota", 8.5);

        for (Filme filme : filmes) {
            System.out.println("Nome do filme: " + filme.getNome() + " - " + filme.getNota());

            for (Ator ator : filme.getAtores()) {
                System.out.println("Nome dos Atores: " + ator.getNome());
            }
        }
    }
}
