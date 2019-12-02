/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alunoces diego
 */
@Entity
@Table(name = "usuario_has_questao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioHasQuestao.findAll", query = "SELECT u FROM UsuarioHasQuestao u"),
    @NamedQuery(name = "UsuarioHasQuestao.findByUsuarioIdUsuario", query = "SELECT u FROM UsuarioHasQuestao u WHERE u.usuarioHasQuestaoPK.usuarioIdUsuario = :usuarioIdUsuario"),
    @NamedQuery(name = "UsuarioHasQuestao.findByQuestaoIdQuestao", query = "SELECT u FROM UsuarioHasQuestao u WHERE u.usuarioHasQuestaoPK.questaoIdQuestao = :questaoIdQuestao"),
    @NamedQuery(name = "UsuarioHasQuestao.findByQuestaoProvaIdProva", query = "SELECT u FROM UsuarioHasQuestao u WHERE u.usuarioHasQuestaoPK.questaoProvaIdProva = :questaoProvaIdProva")})
public class UsuarioHasQuestao implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioHasQuestaoPK usuarioHasQuestaoPK;
    @JoinColumns({
        @JoinColumn(name = "questao_id_questao", referencedColumnName = "id_questao", insertable = false, updatable = false),
        @JoinColumn(name = "questao_prova_id_prova", referencedColumnName = "prova_id_prova", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Questao questao;
    @JoinColumn(name = "resposta_id_resposta", referencedColumnName = "id_resposta")
    @ManyToOne(optional = false)
    private Resposta respostaIdResposta;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioHasQuestao() {
    }

    public UsuarioHasQuestao(UsuarioHasQuestaoPK usuarioHasQuestaoPK) {
        this.usuarioHasQuestaoPK = usuarioHasQuestaoPK;
    }

    public UsuarioHasQuestao(int usuarioIdUsuario, int questaoIdQuestao, int questaoProvaIdProva) {
        this.usuarioHasQuestaoPK = new UsuarioHasQuestaoPK(usuarioIdUsuario, questaoIdQuestao, questaoProvaIdProva);
    }

    public UsuarioHasQuestaoPK getUsuarioHasQuestaoPK() {
        return usuarioHasQuestaoPK;
    }

    public void setUsuarioHasQuestaoPK(UsuarioHasQuestaoPK usuarioHasQuestaoPK) {
        this.usuarioHasQuestaoPK = usuarioHasQuestaoPK;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Resposta getRespostaIdResposta() {
        return respostaIdResposta;
    }

    public void setRespostaIdResposta(Resposta respostaIdResposta) {
        this.respostaIdResposta = respostaIdResposta;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioHasQuestaoPK != null ? usuarioHasQuestaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasQuestao)) {
            return false;
        }
        UsuarioHasQuestao other = (UsuarioHasQuestao) object;
        if ((this.usuarioHasQuestaoPK == null && other.usuarioHasQuestaoPK != null) || (this.usuarioHasQuestaoPK != null && !this.usuarioHasQuestaoPK.equals(other.usuarioHasQuestaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.cesjf.lpwsd.model.UsuarioHasQuestao[ usuarioHasQuestaoPK=" + usuarioHasQuestaoPK + " ]";
    }
    
}
