/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.dao;

import br.cesjf.lpwsd.db.PersistenceUtil;
import br.cesjf.lpwsd.model.Resposta;
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
public class RespostaDAO implements Serializable {
    
    public static RespostaDAO respostaDAO;

    public static RespostaDAO getInstance() {
        if (respostaDAO == null) {
            respostaDAO = new RespostaDAO();
        }
        return respostaDAO;
    }

    public Resposta buscar(int id) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT r FROM Resposta r WHERE r.idResposta =:id");
            query.setParameter("id", id);
            Resposta resposta = (Resposta) query.getSingleResult();
            if (resposta != null && resposta.getIdResposta() > 0) {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Foram encontradas as respostas");
                return resposta;
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontradas as respostas");
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizada a resposta");
            return null;
        }

    }
    
    public Resposta buscar(Resposta r) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT r FROM Resposta r WHERE r.idResposta =:id");
            query.setParameter("id", r.getIdResposta());
            Resposta resposta = (Resposta) query.getSingleResult();
            if (resposta != null && resposta.getIdResposta() > 0) {
                return resposta;
            
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontradas as respostas" + r.getIdResposta());
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizada a resposta" + r.getIdResposta());
            return null;
        }
        
    }
    
    public List<Resposta> buscarTodas() {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT r FROM Resposta r");
                return query.getResultList();
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível buscar as respostas");
            return new ArrayList();
        } 
    }
    
    public String remover(Resposta resposta) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            resposta = em.merge(resposta);
            em.remove(resposta);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "A resposta será removida");
                return "Resposta " + resposta.getIdResposta()+ " Removida com sucesso!";
                
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover as resposta!", e.getMessage());
            return "Não foi possível remover a resposta " + resposta.getIdResposta() + " , pois está vincula a um ou mais respostas";
        }         
    }
    
    public String persistir(Resposta resposta) {
        EntityManager em = PersistenceUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            resposta = em.merge(resposta);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Resposta salva com sucesso!");
            return "Resposta " + resposta.getIdResposta() + " salva com sucesso";
        
        } catch (Exception e) {
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível salvar a resposta!" , e);
            if(e.getMessage().contains("ConstrainViolationException")) {
                return "Não foi possível salvar a resposta " + resposta.getIdResposta() + ", pois a resposta deve ser único";
            }
            return "Não foi possível salvar a resposta" + resposta.getIdResposta() + "!";
        }    
    }
    
    public String removaAll() {
        try {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query =  em.createQuery("DELETE FROM Resposta");
        query.executeUpdate();
        em.getTransaction().commit();
        Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Respostas removidas com sucesso!");
            return "Todos os respostas foram removidas!";
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover todas as resposta!", e.getMessage());
            return "Não foi possível remover todas  as respostas!";
        }  
    
    }
    
}
