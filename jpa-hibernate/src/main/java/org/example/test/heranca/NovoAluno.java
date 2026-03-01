package org.example.test.heranca;

import org.example.infra.DAO;
import org.example.model.heranca.Aluno;
import org.example.model.heranca.AlunoBolsista;

import java.util.List;

public class NovoAluno {
    public static void main(String[] args) {
        DAO<Aluno> alunoDAO = new DAO<Aluno>(Aluno.class);
        DAO<AlunoBolsista> alunoBolsita = new DAO<AlunoBolsista>(AlunoBolsista.class);


//        Aluno aluno = new Aluno(123L, "João");
//        AlunoBolsista alunoBolsista = new AlunoBolsista(345L, "Maria", 1000);
//
//        alunoDAO.incluirAtomico(aluno);
//        alunoDAO.incluirAtomico(alunoBolsista);
//
//        alunoDAO.fecharT();

        List<Aluno> alunos = alunoDAO.obterTodos().stream().filter(a -> a.getNome().equals("João")).toList();

        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }

        List<AlunoBolsista> alunosComBolsa = alunoBolsita.obterTodos().stream().filter(alunoBolsista -> alunoBolsista.getValorBolsa() > 0).toList();


        for (AlunoBolsista alunoBolsista : alunosComBolsa) {
            System.out.println(alunoBolsista.getNome());
        }
    }
}
