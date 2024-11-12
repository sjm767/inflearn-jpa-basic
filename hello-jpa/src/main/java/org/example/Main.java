package org.example;

import org.entity.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // 비영속
            Member member = new Member(1L, "test");
            em.persist(member);
            em.flush();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        // close
        em.close();
        emf.close();
    }
}