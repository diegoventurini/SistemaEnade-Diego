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
public class UsuarioHasQuestaoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id_usuario")
    private int usuarioIdUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "questao_id_questao")
    private int questaoIdQuestao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "questao_prova_id_prova")
    private int questaoProvaIdProva;

    public UsuarioHasQuestaoPK() {
    }

    public UsuarioHasQuestaoPK(int usuarioIdUsuario, int questaoIdQuestao, int questaoProvaIdProva) {
        this.usuarioIdUsuario = usuarioIdUsuario;
        this.questaoIdQuestao = questaoIdQuestao;
        this.questaoProvaIdProva = questaoProvaIdProva;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public int getQuestaoIdQuestao() {
        return questaoIdQuestao;
    }

    public void setQuestaoIdQuestao(int questaoIdQuestao) {
        this.questaoIdQuestao = questaoIdQuestao;
    }

    public int getQuestaoProvaIdProva() {
        return questaoProvaIdProva;
    }

    public void setQuestaoProvaIdProva(int questaoProvaIdProva) {
        this.questaoProvaIdProva = questaoProvaIdProva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioIdUsuario;
        hash += (int) questaoIdQuestao;
        hash += (int) questaoProvaIdProva;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasQuestaoPK)) {
            return false;
        }
        UsuarioHasQuestaoPK other = (UsuarioHasQuestaoPK) object;
        if (this.usuarioIdUsuario != other.usuarioIdUsuario) {
            return false;
        }
        if (this.questaoIdQuestao != other.questaoIdQuestao) {
            return false;
        }
        if (this.questaoProvaIdProva != other.questaoProvaIdProva) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cesjf.lpwsd.model.UsuarioHasQuestaoPK[ usuarioIdUsuario=" + usuarioIdUsuario + ", questaoIdQuestao=" + questaoIdQuestao + ", questaoProvaIdProva=" + questaoProvaIdProva + " ]";
    }
    
}
