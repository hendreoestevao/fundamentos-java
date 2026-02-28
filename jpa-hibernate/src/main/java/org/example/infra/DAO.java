package org.example.infra;

import org.example.model.basic.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> clazz;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("jpa-hibernate");
        } catch (Exception e) {
            // logar - log4j
        }
    }

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

    public DAO<E> fecharT() {
        em.getTransaction().commit();
        em.close();
        return this;
    }

    public DAO<E> incluir(E entidade) {
        em.persist(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade) {

        return  this.abrirT().incluir(entidade).fecharT();
    }

    public List<E> obterTodos() {
        return  this.obterTodos(10,0);
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

}
