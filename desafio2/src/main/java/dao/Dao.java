/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jéssica Petersen
 */
public class Dao {
    
    public static void salvar(Object objeto) {
        //Nome que está no persistencia.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DswJpa");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        try {
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    public static Object ler(Class classe, long id){
        Object object = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DswJpa");
        
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        try{
            object = em.find(classe, id);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            em.getTransaction().rollback();
        } finally{
            em.close();
        }
        return object;
    }
    
    public static void update(Object object){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DswJpa");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        try{
            em.merge(object);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
    
    public static void remover(Object object){
         EntityManagerFactory emf = Persistence.createEntityManagerFactory("desafio1");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        try{
            em.remove(object);
            em.getTransaction().commit();
        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
    }
}
