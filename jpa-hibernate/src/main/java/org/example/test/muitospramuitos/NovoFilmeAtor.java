package org.example.test.muitospramuitos;

import org.example.infra.DAO;
import org.example.model.muitospramuitos.Ator;
import org.example.model.muitospramuitos.Filme;

public class NovoFilmeAtor {
    public static void main(String[] args) {
        Filme filmeA = new Filme("Star Wrs EP  4", 8.7);
        Filme filmeB = new Filme("O fugitivo", 8.9);

        Ator ator = new Ator("Harrison Ford");
        Ator atriz = new Ator("Carrie Fisher");

        filmeA.addAtor(ator);
        filmeA.addAtor(atriz);

        filmeB.addAtor(ator);

        DAO<Filme> dao = new DAO<>(Filme.class);
        dao.incluirAtomico(filmeA);
    }
}
