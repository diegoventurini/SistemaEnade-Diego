package br.cesjf.lpwsd.model;

import br.cesjf.lpwsd.model.Questao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-02T20:59:04")
@StaticMetamodel(TipoQuestao.class)
public class TipoQuestao_ { 

    public static volatile SingularAttribute<TipoQuestao, String> tipoQuest;
    public static volatile SingularAttribute<TipoQuestao, Integer> idTipoQuestao;
    public static volatile ListAttribute<TipoQuestao, Questao> questaoList;

}