/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alunoces
 */
@Entity
@Table(name = "prova")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prova.findAll", query = "SELECT p FROM Prova p"),
    @NamedQuery(name = "Prova.findByIdProva", query = "SELECT p FROM Prova p WHERE p.idProva = :idProva"),
    @NamedQuery(name = "Prova.findByAno", query = "SELECT p FROM Prova p WHERE p.ano = :ano")})
public class Prova implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_prova")
    private Integer idProva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    @Temporal(TemporalType.DATE)
    private Date ano;
    @JoinTable(name = "prova_has_usuario", joinColumns = {
        @JoinColumn(name = "prova_id_prova", referencedColumnName = "id_prova")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario")})
    @ManyToMany
    private List<Usuario> usuarioList;
    @JoinColumn(name = "curso_id_curso", referencedColumnName = "id_curso")
    @ManyToOne(optional = false)
    private Curso cursoIdCurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "prova")
    private List<Questao> questaoList;

    public Prova() {
    }

    public Prova(Integer idProva) {
        this.idProva = idProva;
    }

    public Prova(Integer idProva, Date ano) {
        this.idProva = idProva;
        this.ano = ano;
    }

    public Integer getIdProva() {
        return idProva;
    }

    public void setIdProva(Integer idProva) {
        this.idProva = idProva;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    public Curso getCursoIdCurso() {
        return cursoIdCurso;
    }

    public void setCursoIdCurso(Curso cursoIdCurso) {
        this.cursoIdCurso = cursoIdCurso;
    }

    @XmlTransient
    public List<Questao> getQuestaoList() {
        return questaoList;
    }

    public void setQuestaoList(List<Questao> questaoList) {
        this.questaoList = questaoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProva != null ? idProva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prova)) {
            return false;
        }
        Prova other = (Prova) object;
        if ((this.idProva == null && other.idProva != null) || (this.idProva != null && !this.idProva.equals(other.idProva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cesjf.lpwsd.model.Prova[ idProva=" + idProva + " ]";
    }
    
}
