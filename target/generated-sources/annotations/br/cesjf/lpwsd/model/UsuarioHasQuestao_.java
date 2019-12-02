package br.cesjf.lpwsd.model;

import br.cesjf.lpwsd.model.Questao;
import br.cesjf.lpwsd.model.Resposta;
import br.cesjf.lpwsd.model.Usuario;
import br.cesjf.lpwsd.model.UsuarioHasQuestaoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-02T20:59:04")
@StaticMetamodel(UsuarioHasQuestao.class)
public class UsuarioHasQuestao_ { 

    public static volatile SingularAttribute<UsuarioHasQuestao, UsuarioHasQuestaoPK> usuarioHasQuestaoPK;
    public static volatile SingularAttribute<UsuarioHasQuestao, Resposta> respostaIdResposta;
    public static volatile SingularAttribute<UsuarioHasQuestao, Usuario> usuario;
    public static volatile SingularAttribute<UsuarioHasQuestao, Questao> questao;

}