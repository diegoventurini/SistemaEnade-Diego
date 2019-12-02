/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.dao;

import br.cesjf.lpwsd.db.PersistenceUtil;
import br.cesjf.lpwsd.model.TipoUsuario;
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
public class TipoUsuarioDAO implements Serializable {
    
    public static TipoUsuarioDAO tipoUsuarioDAO;

    public static TipoUsuarioDAO getInstance() {
        if (tipoUsuarioDAO == null) {
            tipoUsuarioDAO = new TipoUsuarioDAO();
        }
        return tipoUsuarioDAO;
    }

    public TipoUsuario buscar(int id) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT tu FROM TipoUsuario tu WHERE tu.idTipoUsuario =:id");
            query.setParameter("id", id);
            TipoUsuario tipoUsuario = (TipoUsuario) query.getSingleResult();
            if (tipoUsuario != null && tipoUsuario.getIdTipoUsuario() > 0) {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Foram encontrados os tipos de usuários");
                return tipoUsuario;
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontrados os tipos de usuários");
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizado o tipo de usuário");
            return null;
        }

    }
    
    public TipoUsuario buscar(TipoUsuario tu) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT tu FROM TipoUsuario tu WHERE tu.idTipoUsuario =:id");
            query.setParameter("id", tu.getIdTipoUsuario());
            TipoUsuario tipoUsuario = (TipoUsuario) query.getSingleResult();
            if (tipoUsuario != null && tipoUsuario.getIdTipoUsuario() > 0) {
                return tipoUsuario;
            
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontrados os tipos de usuários");
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizado o tipo de usuário");
            return null;
        }
        
    }
    
    public List<TipoUsuario> buscarTodas() {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT tu FROM TipoUsuario tu");
                return query.getResultList();
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível buscar os tipos de usuários");
            return new ArrayList();
        } 
    }
    
    public String remover(TipoUsuario tipoUsuario) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            tipoUsuario = em.merge(tipoUsuario);
            em.remove(tipoUsuario);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "O tipo de usuário será removido");
                return "Tipo de usuário " + tipoUsuario.getIdTipoUsuario()+ " Removido com sucesso!";
                
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover o tipo de usuário!", e.getMessage());
            return "Não foi possível remover o tipo de usuário " + tipoUsuario.getIdTipoUsuario() + " , pois está vincula a um ou mais tipos de usuários";
        }         
    }
    
    public String persistir(TipoUsuario tipoUsuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            tipoUsuario = em.merge(tipoUsuario);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Tipo de usuário salvo com sucesso!");
            return "Tipo de usuário " + tipoUsuario.getIdTipoUsuario() + " salva com sucesso";
        
        } catch (Exception e) {
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível salvar o tipo de usuario!" , e);
            if(e.getMessage().contains("ConstrainViolationException")) {
                return "Não foi possível salvar o tipo de usuário " + tipoUsuario.getIdTipoUsuario() + ", pois o tipo de usuário deve ser único";
            }
            return "Não foi possível salvar o tipo de usuário" + tipoUsuario.getIdTipoUsuario() + "!";
        }    
    }
    
    public String removaAll() {
        try {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query =  em.createQuery("DELETE FROM TipoUsuario");
        query.executeUpdate();
        em.getTransaction().commit();
        Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Tipo de usuários foram removidas com sucesso!");
            return "Todos os tipos de usuários foram removidas!";
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover todos os tipos de usuários!", e.getMessage());
            return "Não foi possível remover todos os tipos de usuários!";
        }  
    
    }
}
