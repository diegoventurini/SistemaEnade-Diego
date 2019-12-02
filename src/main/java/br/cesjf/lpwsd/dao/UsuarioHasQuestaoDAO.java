/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




/*

package br.cesjf.lpwsd.dao;

import br.cesjf.lpwsd.db.PersistenceUtil;
import br.cesjf.lpwsd.model.UsuarioHasQuestao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
*/


/**
 *
 * @author diego
 */



//public class UsuarioHasQuestaoDAO implements Serializable {
//    
//        public static UsuarioHasQuestaoDAO usuarioHasQuestaoDAO;
//
//    public static UsuarioHasQuestaoDAO getInstance() {
//        if (usuarioHasQuestaoDAO == null) {
//            usuarioHasQuestaoDAO = new UsuarioHasQuestaoDAO();
//        }
//        return usuarioHasQuestaoDAO;
//    }
//
//    public UsuarioHasQuestao buscar(int id) {
//        try {
//            EntityManager em = PersistenceUtil.getEntityManager();
//            Query query = em.createQuery("SELECT uhq FROM UsuarioHasQuestao uhq WHERE uhq.???? =:id");
//            query.setParameter("id", id);
//            UsuarioHasQuestao usuarioHasQuestao = (UsuarioHasQuestao) query.getSingleResult();
//            if (usuarioHasQuestao != null && usuarioHasQuestao.getIdUsuarioHasQuestao() > 0) {
//                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Foram encontrados os tipos de usuários");
//                return usuarioHasQuestao;
//            } else {
//                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontrados os tipos de usuários");
//                return null;
//            }
//
//        } catch (Exception e) {
//            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizado o tipo de usuário");
//            return null;
//        }
//
//    }
//    
//    public UsuarioHasQuestao buscar(UsuarioHasQuestao tu) {
//        try {
//            EntityManager em = PersistenceUtil.getEntityManager();
//            Query query = em.createQuery("SELECT uhq FROM UsuarioHasQuestao uhq WHERE uhq.??? =:id");
//            query.setParameter("id", tu.getIdUsuarioHasQuestao());
//            UsuarioHasQuestao usuarioHasQuestao = (UsuarioHasQuestao) query.getSingleResult();
//            if (usuarioHasQuestao != null && usuarioHasQuestao.getIdUsuarioHasQuestao() > 0) {
//                return usuarioHasQuestao;
//            
//            } else {
//                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontrados os tipos de usuários");
//                return null;
//            }
//
//        } catch (Exception e) {
//            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizado o tipo de usuário");
//            return null;
//        }
//        
//    }
//    
//    public List<UsuarioHasQuestao> buscarTodas() {
//        try {
//            EntityManager em = PersistenceUtil.getEntityManager();
//            Query query = em.createQuery("SELECT uhq FROM UsuarioHasQuestao uhq");
//                return query.getResultList();
//        
//        } catch (Exception e) {
//            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível buscar os tipos de usuários");
//            return new ArrayList();
//        } 
//    }
//    
//    public String remover(UsuarioHasQuestao usuarioHasQuestao) {
//        try {
//            EntityManager em = PersistenceUtil.getEntityManager();
//            em.getTransaction().begin();
//            usuarioHasQuestao = em.merge(usuarioHasQuestao);
//            em.remove(usuarioHasQuestao);
//            em.getTransaction().commit();
//            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "O tipo de usuário será removido");
//                return "Tipo de usuário " + usuarioHasQuestao.getIdUsuarioHasQuestao()+ " Removido com sucesso!";
//                
//        } catch (Exception e) {
//            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover o tipo de usuário!", e.getMessage());
//            return "Não foi possível remover o tipo de usuário " + usuarioHasQuestao.getIdUsuarioHasQuestao() + " , pois está vincula a um ou mais tipos de usuários";
//        }         
//    }
//    
//    public String persistir(UsuarioHasQuestao usuarioHasQuestao) {
//        EntityManager em = PersistenceUtil.getEntityManager();
//        try {
//            em.getTransaction().begin();
//            usuarioHasQuestao = em.merge(usuarioHasQuestao);
//            em.getTransaction().commit();
//            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Tipo de usuário salvo com sucesso!");
//            return "Tipo de usuário " + usuarioHasQuestao.getIdUsuarioHasQuestao() + " salva com sucesso";
//        
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível salvar o tipo de usuario!" , e);
//            if(e.getMessage().contains("ConstrainViolationException")) {
//                return "Não foi possível salvar o tipo de usuário " + usuarioHasQuestao.getIdUsuarioHasQuestao() + ", pois o tipo de usuário deve ser único";
//            }
//            return "Não foi possível salvar o tipo de usuário" + usuarioHasQuestao.getIdUsuarioHasQuestao() + "!";
//        }    
//    }
//    
//    public String removaAll() {
//        try {
//        EntityManager em = PersistenceUtil.getEntityManager();
//        em.getTransaction().begin();
//        Query query =  em.createQuery("DELETE FROM UsuarioHasQuestao");
//        query.executeUpdate();
//        em.getTransaction().commit();
//        Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Tipo de usuários foram removidas com sucesso!");
//            return "Todos os tipos de usuários foram removidas!";
//        
//        } catch (Exception e) {
//            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover todos os tipos de usuários!", e.getMessage());
//            return "Não foi possível remover todos os tipos de usuários!";
//        }  
//    
//    }
//        
//
//    
//}
