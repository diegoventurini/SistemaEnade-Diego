package br.cesjf.lpwsd.model;

import br.cesjf.lpwsd.model.Prova;
import br.cesjf.lpwsd.model.QuestaoPK;
import br.cesjf.lpwsd.model.Resposta;
import br.cesjf.lpwsd.model.TipoQuestao;
import br.cesjf.lpwsd.model.UsuarioHasQuestao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-02T20:59:04")
@StaticMetamodel(Questao.class)
public class Questao_ { 

    public static volatile SingularAttribute<Questao, TipoQuestao> idTipoQuestaoFk;
    public static volatile SingularAttribute<Questao, Prova> prova;
    public static volatile SingularAttribute<Questao, QuestaoPK> questaoPK;
    public static volatile SingularAttribute<Questao, String> descricaoQuestao;
    public static volatile SingularAttribute<Questao, Integer> idRespostaFk;
    public static volatile ListAttribute<Questao, UsuarioHasQuestao> usuarioHasQuestaoList;
    public static volatile ListAttribute<Questao, Resposta> respostaList;

}