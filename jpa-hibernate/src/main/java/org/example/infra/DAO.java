package org.example.infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("jpa-hibernate");
        } catch (Exception e) {
            // logar - log4j
        }
    }

    private final EntityManager em;
    private final Class<E> clazz;

    public DAO() {
        this(null);
    }

    public DAO(Class<E> clazz) {
        this.clazz = clazz;
        em = emf.createEntityManager();
    }

    public DAO<E> abrirT() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> commitT() {
        em.getTransaction().commit();
        return this;
    }


    public DAO<E> fecharT() {
        em.close();
        return this;
    }

    public DAO<E> incluir(E entidade) {
        em.persist(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade) {

        return this.abrirT().incluir(entidade).commitT().fecharT();
    }

    public E obterPorId(Object id) {
        return em.find(clazz, id);
    }

    public List<E> obterTodos() {
        return this.obterTodos(10, 0);
    }

    public List<E> obterTodos(int qtde, int deslocamento) {
        if (clazz == null) {
            throw new UnsupportedOperationException("Classe nula.");
        }

        String jpql = "select e from " + clazz.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, clazz);
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);
        return query.getResultList();
    }

    public List<E> consultar(String nomeConsulta, Object... params) {
        TypedQuery<E> query = em.createNamedQuery(nomeConsulta, clazz);

        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }

        return query.getResultList();
    }

    public E consultarUm(String nomeConsulta, Object... param) {
        List<E> lista = consultar(nomeConsulta, param);

        return lista.isEmpty() ? null : lista.get(0);
    }

}
