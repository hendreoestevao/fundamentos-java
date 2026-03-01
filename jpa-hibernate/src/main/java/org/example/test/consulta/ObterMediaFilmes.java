package org.example.test.consulta;

import org.example.infra.DAO;
import org.example.model.consulta.NotaFilme;
import org.example.model.muitospramuitos.Filme;

public class ObterMediaFilmes {
    public static void main(String[] args) {
        DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
        NotaFilme obterMediaGeralDosFilmes = dao.consultarUm("obterMediaGeralDosFilmes");

        System.out.println(obterMediaGeralDosFilmes.getMedia());
        dao.fecharT();


    }
}
