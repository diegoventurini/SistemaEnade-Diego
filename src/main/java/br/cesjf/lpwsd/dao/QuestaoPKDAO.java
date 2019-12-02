/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.dao;

import br.cesjf.lpwsd.db.PersistenceUtil;
import br.cesjf.lpwsd.model.QuestaoPK;
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
public class QuestaoPKDAO implements Serializable {
    
    public static QuestaoPKDAO questaoPKDAO;

    public static QuestaoPKDAO getInstance() {
        if (questaoPKDAO == null) {
            questaoPKDAO = new QuestaoPKDAO();
        }
        return questaoPKDAO;
    }

    public QuestaoPK buscar(int id) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT qpk FROM QuestaoPK qpk WHERE qpk.questaoPK =:id ");
            query.setParameter("id", id);
            QuestaoPK questao = (QuestaoPK) query.getSingleResult();
            if (questao != null ) {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Foram encontradas as questoes");
                return questao;
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontradas as questoes");
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizada a questao");
            return null;
        }

    }
    
    public QuestaoPK buscar(QuestaoPK qpk) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT qpk FROM Questao qpk WHERE qpk.questaoPK =:idQ & qpk.prova=:idP");
            query.setParameter("idQ", qpk.getIdQuestao());
            query.setParameter("idP", qpk.getProvaIdProva());
            
            QuestaoPK questao = (QuestaoPK) query.getSingleResult();
            if (questao != null) {
                return questao;
            
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontradas as questoes");
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizado a questao");
            return null;
        }
        
    }
    
    public List<QuestaoPK> buscarTodas() {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT qpk FROM QuestaoPK qpk");
                return query.getResultList();
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível buscar as questoes");
            return new ArrayList();
        } 
    }
    
    public String remover(QuestaoPK questao) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            questao = em.merge(questao);
            em.remove(questao);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "A questao será removida");
                return "Removida com sucesso!";
                
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover a questao!", e.getMessage());
            return "Não foi possível remover a questao, pois está vincula a uma ou mais questaos";
        }         
    }
    
    public String persistir(QuestaoPK questao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            questao = em.merge(questao);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " QuestaoPK salvo com sucesso!");
            return "QuestaoPK salvo com sucesso";
        
        } catch (Exception e) {
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível salvar a questao!" , e);
            if(e.getMessage().contains("ConstrainViolationException")) {
                return "Não foi possível salvar a questao, pois a questao deve ser único";
            }
            return "Não foi possível salvar a questao!";
        }    
    }
    
    public String removaAll() {
        try {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query =  em.createQuery("DELETE FROM QuestaoPK");
        query.executeUpdate();
        em.getTransaction().commit();
        Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Questoes removidas com sucesso!");
            return "Todos as questoes foram removidas!";
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover todas as questoes!", e.getMessage());
            return "Não foi possível remover todas  as questoes!";
        }  
    
    }
    
}
