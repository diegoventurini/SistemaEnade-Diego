/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.dao;

import br.cesjf.lpwsd.db.PersistenceUtil;
import br.cesjf.lpwsd.model.Prova;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

/**
 *
 * @author alunoces
 */
public class ProvaDAO implements Serializable {
    
    public static ProvaDAO provaDAO;

    public static ProvaDAO getInstance() {
        if (provaDAO == null) {
            provaDAO = new ProvaDAO();
        }
        return provaDAO;
    }

    public Prova buscar(int id) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT p FROM Prova p WHERE p.idProva =:id");
            query.setParameter("id", id);
            Prova prova = (Prova) query.getSingleResult();
            if (prova != null && prova.getIdProva() > 0) {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Foram encontradas as provas");
                return prova;
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontradas as provas");
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizada a prova");
            return null;
        }

    }
    
    public Prova buscar(Prova p) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT p FROM Prova p WHERE p.idProva =:id");
            query.setParameter("id", p.getIdProva());
            Prova prova = (Prova) query.getSingleResult();
            if (prova != null && prova.getIdProva() > 0) {
                return prova;
            
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontradas as provas" + p.getIdProva());
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizada a prova" + p.getIdProva());
            return null;
        }
        
    }
    
    public List<Prova> buscarTodas() {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT p FROM Prova p");
                return query.getResultList();
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível buscar as provas");
            return new ArrayList();
        } 
    }
    
    public String remover(Prova prova) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            prova = em.merge(prova);
            em.remove(prova);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "A prova será removido");
                return "Prova " + prova.getIdProva()+ " Removido com sucesso!";
                
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover a prova!", e.getMessage());
            return "Não foi possível remover a prova " + prova.getIdProva() + " , pois está vincula a um ou mais provas";
        }         
    }
    
    public String persistir(Prova prova) {
        EntityManager em = PersistenceUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            prova = em.merge(prova);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Prova salva com sucesso!");
            return "Prova " + prova.getIdProva() + " salvo com sucesso";
        
        } catch (Exception e) {
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível salvar a prova!" , e);
            if(e.getMessage().contains("ConstrainViolationException")) {
                return "Não foi possível salvar a prova " + prova.getIdProva() + ", pois a prova deve ser única";
            }
            return "Não foi possível salvar a prova" + prova.getIdProva() + "!";
        }    
    }
    
    public String removaAll() {
        try {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query =  em.createQuery("DELETE FROM Prova");
        query.executeUpdate();
        em.getTransaction().commit();
        Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Provas removidos com sucesso!");
            return "Todas as provas foram removidos!";
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover todas as prova!", e.getMessage());
            return "Não foi possível remover todas  as provas!";
        }  
    
    }
   
    
}
