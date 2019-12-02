/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.dao;

import br.cesjf.lpwsd.db.PersistenceUtil;
import br.cesjf.lpwsd.model.Curso;
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
public class CursoDAO implements Serializable {

    public static CursoDAO cursoDAO;

    public static CursoDAO getInstance() {
        if (cursoDAO == null) {
            cursoDAO = new CursoDAO();
        }
        return cursoDAO;
    }

    public Curso buscar(int id) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT c FROM Curso c WHERE c.idCurso =:id");
            query.setParameter("id", id);
            Curso curso = (Curso) query.getSingleResult();
            if (curso != null && curso.getIdCurso() > 0) {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Foram encontrados os cursos");
                return curso;
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontrados os cursos");
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizado o curso");
            return null;
        }

    }
    
    public Curso buscar(Curso c) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT c FROM Curso c WHERE c.idCurso =:id");
            query.setParameter("id", c.getIdCurso());
            Curso curso = (Curso) query.getSingleResult();
            if (curso != null && curso.getIdCurso() > 0) {
                return curso;
            
            } else {
                Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "Não foram encontrados os cursos" +c.getNmCurso());
                return null;
            }

        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Não foi localizado o curso" +c.getNmCurso());
            return null;
        }
        
    }
    
    public List<Curso> buscarTodas() {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT c FROM Curso c");
                return query.getResultList();
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível buscar os cursos");
            return new ArrayList();
        } 
    }
    
    public String remover(Curso curso) {
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            curso = em.merge(curso);
            em.remove(curso);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, "O curso será removido");
                return "Curso " + curso.getNmCurso()+ " Removido com sucesso!";
                
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover o curso!", e.getMessage());
            return "Não foi possível remover o curso " + curso.getNmCurso() + " , pois está vincula a um ou mais cursos";
        }         
    }
    
    public String persistir(Curso curso) {
        EntityManager em = PersistenceUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            curso = em.merge(curso);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Curso salvo com sucesso!");
            return "Curso " + curso.getNmCurso() + " salvo com sucesso";
        
        } catch (Exception e) {
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível salvar o curso!" , e);
            if(e.getMessage().contains("ConstrainViolationException")) {
                return "Não foi possível salvar o curso " + curso.getNmCurso() + ", pois o curso deve ser único";
            }
            return "Não foi possível salvar o curso" + curso.getNmCurso() + "!";
        }    
    }
    
    public String removaAll() {
        try {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query =  em.createQuery("DELETE FROM Curso");
        query.executeUpdate();
        em.getTransaction().commit();
        Logger.getLogger(PersistenceUnit.class.getName()).log(Level.INFO, " Cursos removidos com sucesso!");
            return "Todos os cursos foram removidos!";
        
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING, "Error! Não foi possível remover todos os curso!", e.getMessage());
            return "Não foi possível remover todos  os cursos!";
        }  
    
    }
}



