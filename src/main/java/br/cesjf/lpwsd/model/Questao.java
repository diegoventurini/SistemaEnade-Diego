/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author alunoces
 */
@Entity
@Table(name = "questao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questao.findAll", query = "SELECT q FROM Questao q"),
    @NamedQuery(name = "Questao.findByIdQuestao", query = "SELECT q FROM Questao q WHERE q.questaoPK.idQuestao = :idQuestao"),
    @NamedQuery(name = "Questao.findByDescricaoQuestao", query = "SELECT q FROM Questao q WHERE q.descricaoQuestao = :descricaoQuestao"),
    @NamedQuery(name = "Questao.findByIdRespostaFk", query = "SELECT q FROM Questao q WHERE q.idRespostaFk = :idRespostaFk"),
    @NamedQuery(name = "Questao.findByProvaIdProva", query = "SELECT q FROM Questao q WHERE q.questaoPK.provaIdProva = :provaIdProva")})
public class Questao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected QuestaoPK questaoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricao_questao")
    private String descricaoQuestao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_resposta_fk")
    private int idRespostaFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questao")
    private List<UsuarioHasQuestao> usuarioHasQuestaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questaoIdQuestao")
    private List<Resposta> respostaList;
    @JoinColumn(name = "prova_id_prova", referencedColumnName = "id_prova", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Prova prova;
    @JoinColumn(name = "id_tipo_questao_fk", referencedColumnName = "id_tipo_questao")
    @ManyToOne(optional = false)
    private TipoQuestao idTipoQuestaoFk;

    public Questao() {
    }

    public Questao(QuestaoPK questaoPK) {
        this.questaoPK = questaoPK;
    }

    public Questao(QuestaoPK questaoPK, String descricaoQuestao, int idRespostaFk) {
        this.questaoPK = questaoPK;
        this.descricaoQuestao = descricaoQuestao;
        this.idRespostaFk = idRespostaFk;
    }

    public Questao(int idQuestao, int provaIdProva) {
        this.questaoPK = new QuestaoPK(idQuestao, provaIdProva);
    }

    public QuestaoPK getQuestaoPK() {
        return questaoPK;
    }

    public void setQuestaoPK(QuestaoPK questaoPK) {
        this.questaoPK = questaoPK;
    }

    public String getDescricaoQuestao() {
        return descricaoQuestao;
    }

    public void setDescricaoQuestao(String descricaoQuestao) {
        this.descricaoQuestao = descricaoQuestao;
    }

    public int getIdRespostaFk() {
        return idRespostaFk;
    }

    public void setIdRespostaFk(int idRespostaFk) {
        this.idRespostaFk = idRespostaFk;
    }

    @XmlTransient
    public List<UsuarioHasQuestao> getUsuarioHasQuestaoList() {
        return usuarioHasQuestaoList;
    }

    public void setUsuarioHasQuestaoList(List<UsuarioHasQuestao> usuarioHasQuestaoList) {
        this.usuarioHasQuestaoList = usuarioHasQuestaoList;
    }

    @XmlTransient
    public List<Resposta> getRespostaList() {
        return respostaList;
    }

    public void setRespostaList(List<Resposta> respostaList) {
        this.respostaList = respostaList;
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public TipoQuestao getIdTipoQuestaoFk() {
        return idTipoQuestaoFk;
    }

    public void setIdTipoQuestaoFk(TipoQuestao idTipoQuestaoFk) {
        this.idTipoQuestaoFk = idTipoQuestaoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questaoPK != null ? questaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questao)) {
            return false;
        }
        Questao other = (Questao) object;
        if ((this.questaoPK == null && other.questaoPK != null) || (this.questaoPK != null && !this.questaoPK.equals(other.questaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cesjf.lpwsd.model.Questao[ questaoPK=" + questaoPK + " ]";
    }
    
}
