package org.example.test.basic;

import org.example.model.basic.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterUsuario {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate");
        EntityManager em = emf.createEntityManager();

        Usuario usuario = em.find(Usuario.class, 2L);
        System.out.println(usuario.getNome());

        em.close();
        emf.close();
    }
}
