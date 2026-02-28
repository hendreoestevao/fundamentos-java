package org.example.test.basic;

import org.example.model.basic.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuario2 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-hibernate");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Usuario usuario = em.find(Usuario.class, 1L);
        usuario.setNome("Nome Atualizado 33");
        usuario.setEmail("email@email.com");
       // em.merge(usuario);

        System.out.println(usuario.getNome());
        System.out.println(usuario.getEmail());

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
