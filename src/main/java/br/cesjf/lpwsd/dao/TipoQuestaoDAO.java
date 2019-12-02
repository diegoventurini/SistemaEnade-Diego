/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.dao;

import br.cesjf.lpwsd.db.PersistenceUtil;
import br.cesjf.lpwsd.model.TipoQuestao;
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
public class TipoQuestaoDAO implements Serializable {
    
    public static TipoQuestaoDAO tipoQuestaoDAO;

    public static TipoQuestaoDAO getInstance() {
        if (tipoQuestaoDAO == null) {
            tipoQuestaoDAO = new TipoQuestaoDAO();
        }
        return tipoQuestaoDAO;
    }

    public TipoQuestao buscar(int id) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT tq FROM TipoQuestao tq WHERE tq.idTipoQuestao =:id");
            query.setParameter("id", id);
            TipoQuestao tipoQuestao = (TipoQuestao) query.getSingleResult();
            if (tipoQuestao != null && tipoQuestao.getIdTipoQuestao() > 0) {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Foram encontrados os tipos de Questões");
                return tipoQuestao;
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontrados os tipos de questões");
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizado o tipo de questao");
            return null;
        }

    }
    
    public TipoQuestao buscar(TipoQuestao tq) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT tq FROM TipoQuestao tq WHERE tq.idTipoQuestao =:id");
            query.setParameter("id", tq.getIdTipoQuestao());
            TipoQuestao tipoQuestao = (TipoQuestao) query.getSingleResult();
            if (tipoQuestao != null && tipoQuestao.getIdTipoQuestao() > 0) {
                return tipoQuestao;
            
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontrados os tipos de questões");
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizado o tipo de questao");
            return null;
        }
        
    }
    
    public List<TipoQuestao> buscarTodas() {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT tq FROM TipoQuestao tq");
                return query.getResultList();
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível buscar os tipos de questões");
            return new ArrayList();
        } 
    }
    
    public String remover(TipoQuestao tipoQuestao) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            tipoQuestao = em.merge(tipoQuestao);
            em.remove(tipoQuestao);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "O tipo de questao será removido");
                return "Tipo de questao " + tipoQuestao.getIdTipoQuestao()+ " Removido com sucesso!";
                
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover o tipo de questao!", e.getMessage());
            return "Não foi possível remover o tipo de questao " + tipoQuestao.getIdTipoQuestao() + " , pois está vincula a um ou mais tipos de questões";
        }         
    }
    
    public String persistir(TipoQuestao tipoQuestao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            tipoQuestao = em.merge(tipoQuestao);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Tipo de questao salva com sucesso!");
            return "Tipo de questao " + tipoQuestao.getIdTipoQuestao() + " salva com sucesso";
        
        } catch (Exception e) {
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível salvar o tipoQuestao!" , e);
            if(e.getMessage().contains("ConstrainViolationException")) {
                return "Não foi possível salvar o tipo de questao " + tipoQuestao.getIdTipoQuestao() + ", pois o tipo de questao deve ser único";
            }
            return "Não foi possível salvar o tipo de questao" + tipoQuestao.getIdTipoQuestao() + "!";
        }    
    }
    
    public String removaAll() {
        try {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query =  em.createQuery("DELETE FROM TipoQuestao");
        query.executeUpdate();
        em.getTransaction().commit();
        Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Tipo de questões foram removidas com sucesso!");
            return "Todos os tipos de questões foram removidas!";
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover todos os tipos de questões!", e.getMessage());
            return "Não foi possível remover todos os tipos de questões!";
        }  
    
    }
}
