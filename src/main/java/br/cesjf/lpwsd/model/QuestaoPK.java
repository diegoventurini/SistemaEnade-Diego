/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author alunoces
 */
@Embeddable
public class QuestaoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_questao")
    private int idQuestao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prova_id_prova")
    private int provaIdProva;

    public QuestaoPK() {
    }

    public QuestaoPK(int idQuestao, int provaIdProva) {
        this.idQuestao = idQuestao;
        this.provaIdProva = provaIdProva;
    }

    public int getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(int idQuestao) {
        this.idQuestao = idQuestao;
    }

    public int getProvaIdProva() {
        return provaIdProva;
    }

    public void setProvaIdProva(int provaIdProva) {
        this.provaIdProva = provaIdProva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idQuestao;
        hash += (int) provaIdProva;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestaoPK)) {
            return false;
        }
        QuestaoPK other = (QuestaoPK) object;
        if (this.idQuestao != other.idQuestao) {
            return false;
        }
        if (this.provaIdProva != other.provaIdProva) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cesjf.lpwsd.model.QuestaoPK[ idQuestao=" + idQuestao + ", provaIdProva=" + provaIdProva + " ]";
    }
    
}
