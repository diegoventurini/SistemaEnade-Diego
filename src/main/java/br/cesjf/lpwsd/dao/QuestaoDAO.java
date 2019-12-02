/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.dao;

import br.cesjf.lpwsd.db.PersistenceUtil;
import br.cesjf.lpwsd.model.Questao;
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
 * @author diego
 */



public class QuestaoDAO implements Serializable {
    
    public static QuestaoDAO questaoDAO;

    public static QuestaoDAO getInstance() {
        if (questaoDAO == null) {
            questaoDAO = new QuestaoDAO();
        }
        return questaoDAO;
    }

    public Questao buscar(int id) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT q FROM Questao q WHERE q.questaoPK =:id ");
            query.setParameter("id", id);
            Questao questao = (Questao) query.getSingleResult();
            if (questao != null && questao.getIdRespostaFk()> 0 ) {
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
    
    public Questao buscar(Questao q) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT q FROM Questao q WHERE q.questaoPK =:id");
            query.setParameter("id", q.getIdRespostaFk());
            Questao questao = (Questao) query.getSingleResult();
            if (questao != null && questao.getIdRespostaFk() > 0) {
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
    
    public List<Questao> buscarTodas() {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT q FROM Questao q");
                return query.getResultList();
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível buscar as questaos");
            return new ArrayList();
        } 
    }
    
    public String remover(Questao questao) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            questao = em.merge(questao);
            em.remove(questao);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "A questao será removida");
                return "Questao " + questao.getQuestaoPK()+ " Removida com sucesso!";
                
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover a questao!", e.getMessage());
            return "Não foi possível remover a questao " + questao.getQuestaoPK() + " , pois está vincula a uma ou mais questaos";
        }         
    }
    
    public String persistir(Questao questao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            questao = em.merge(questao);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Questao salvo com sucesso!");
            return "Questao " + questao.getQuestaoPK() + " salvo com sucesso";
        
        } catch (Exception e) {
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível salvar a questao!" , e);
            if(e.getMessage().contains("ConstrainViolationException")) {
                return "Não foi possível salvar a questao " + questao.getQuestaoPK() + ", pois a questao deve ser único";
            }
            return "Não foi possível salvar a questao" + questao.getQuestaoPK() + "!";
        }    
    }
    
    public String removaAll() {
        try {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query =  em.createQuery("DELETE FROM Questao");
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


