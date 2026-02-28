package org.example.test.basic;

import org.example.model.basic.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = new Usuario("Jpa2","jpa@gmail.com");

        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
