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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "resposta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Resposta.findAll", query = "SELECT r FROM Resposta r"),
    @NamedQuery(name = "Resposta.findByIdResposta", query = "SELECT r FROM Resposta r WHERE r.idResposta = :idResposta"),
    @NamedQuery(name = "Resposta.findByRespostaCorreta", query = "SELECT r FROM Resposta r WHERE r.respostaCorreta = :respostaCorreta"),
    @NamedQuery(name = "Resposta.findByJustificativa", query = "SELECT r FROM Resposta r WHERE r.justificativa = :justificativa"),
    @NamedQuery(name = "Resposta.findByOpcao", query = "SELECT r FROM Resposta r WHERE r.opcao = :opcao")})
public class Resposta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_resposta")
    private Integer idResposta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "resposta_correta")
    private String respostaCorreta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "justificativa")
    private String justificativa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "opcao")
    private String opcao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respostaIdResposta")
    private List<UsuarioHasQuestao> usuarioHasQuestaoList;
    @JoinColumn(name = "questao_id_questao", referencedColumnName = "id_questao")
    @ManyToOne(optional = false)
    private Questao questaoIdQuestao;

    public Resposta() {
    }

    public Resposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public Resposta(Integer idResposta, String respostaCorreta, String justificativa, String opcao) {
        this.idResposta = idResposta;
        this.respostaCorreta = respostaCorreta;
        this.justificativa = justificativa;
        this.opcao = opcao;
    }

    public Integer getIdResposta() {
        return idResposta;
    }

    public void setIdResposta(Integer idResposta) {
        this.idResposta = idResposta;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    @XmlTransient
    public List<UsuarioHasQuestao> getUsuarioHasQuestaoList() {
        return usuarioHasQuestaoList;
    }

    public void setUsuarioHasQuestaoList(List<UsuarioHasQuestao> usuarioHasQuestaoList) {
        this.usuarioHasQuestaoList = usuarioHasQuestaoList;
    }

    public Questao getQuestaoIdQuestao() {
        return questaoIdQuestao;
    }

    public void setQuestaoIdQuestao(Questao questaoIdQuestao) {
        this.questaoIdQuestao = questaoIdQuestao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResposta != null ? idResposta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resposta)) {
            return false;
        }
        Resposta other = (Resposta) object;
        if ((this.idResposta == null && other.idResposta != null) || (this.idResposta != null && !this.idResposta.equals(other.idResposta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cesjf.lpwsd.model.Resposta[ idResposta=" + idResposta + " ]";
    }
    
}
