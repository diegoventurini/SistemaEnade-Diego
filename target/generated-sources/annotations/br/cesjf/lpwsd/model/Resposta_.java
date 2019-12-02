package br.cesjf.lpwsd.model;

import br.cesjf.lpwsd.model.Questao;
import br.cesjf.lpwsd.model.UsuarioHasQuestao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-02T20:59:04")
@StaticMetamodel(Resposta.class)
public class Resposta_ { 

    public static volatile SingularAttribute<Resposta, Integer> idResposta;
    public static volatile SingularAttribute<Resposta, String> opcao;
    public static volatile SingularAttribute<Resposta, Questao> questaoIdQuestao;
    public static volatile SingularAttribute<Resposta, String> justificativa;
    public static volatile SingularAttribute<Resposta, String> respostaCorreta;
    public static volatile ListAttribute<Resposta, UsuarioHasQuestao> usuarioHasQuestaoList;

}