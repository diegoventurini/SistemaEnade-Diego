/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.dao;

import br.cesjf.lpwsd.db.PersistenceUtil;
import br.cesjf.lpwsd.model.Usuario;
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
public class UsuarioDAO implements Serializable {
    
    public static UsuarioDAO usuarioDAO;

    public static UsuarioDAO getInstance() {
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
    }

    public Usuario buscar(int id) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario =:id");
            query.setParameter("id", id);
            Usuario usuario = (Usuario) query.getSingleResult();
            if (usuario != null && usuario.getIdUsuario() > 0) {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Foram encontrados os usuarios");
                return usuario;
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontrados os usuarios");
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizado o usuario");
            return null;
        }

    }
    
    public Usuario buscar(Usuario u) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = :id");
            query.setParameter("id", u.getIdUsuario());
            Usuario usuario = (Usuario) query.getSingleResult();
            if (usuario != null && usuario.getIdUsuario() > 0) {
                return usuario;
            
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontrados os usuarios" + u.getNmUsuario());
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizado o usuario" + u.getNmUsuario());
            return null;
        }
        
    }
    
    public List<Usuario> buscarTodas() {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT u FROM Usuario u");
                return query.getResultList();
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível buscar os usuarios");
            return new ArrayList();
        } 
    }
    
    public String remover(Usuario usuario) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            usuario = em.merge(usuario);
            em.remove(usuario);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "O usuario será removido");
                return "Usuario " + usuario.getNmUsuario()+ " Removido com sucesso!";
                
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover o usuario!", e.getMessage());
            return "Não foi possível remover o usuario " + usuario.getNmUsuario() + " , pois está vincula a um ou mais usuarios";
        }         
    }
    
    public String persistir(Usuario usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            usuario = em.merge(usuario);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Usuario salvo com sucesso!");
            return "Usuario " + usuario.getNmUsuario() + " salvo com sucesso";
        
        } catch (Exception e) {
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível salvar o usuario!" , e);
            if(e.getMessage().contains("ConstrainViolationException")) {
                return "Não foi possível salvar o usuario " + usuario.getNmUsuario() + ", pois o usuario deve ser único";
            }
            return "Não foi possível salvar o usuario" + usuario.getNmUsuario() + "!";
        }    
    }
    
    public String removaAll() {
        try {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query =  em.createQuery("DELETE FROM Usuario");
        query.executeUpdate();
        em.getTransaction().commit();
        Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Usuarios removidos com sucesso!");
            return "Todos os usuarios foram removidos!";
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover todos os usuario!", e.getMessage());
            return "Não foi possível remover todos  os usuarios!";
        }  
    
    }
    
}
