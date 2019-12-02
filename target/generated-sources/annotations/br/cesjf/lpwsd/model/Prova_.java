package br.cesjf.lpwsd.model;

import br.cesjf.lpwsd.model.Curso;
import br.cesjf.lpwsd.model.Questao;
import br.cesjf.lpwsd.model.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-02T20:59:04")
@StaticMetamodel(Prova.class)
public class Prova_ { 

    public static volatile SingularAttribute<Prova, Integer> idProva;
    public static volatile SingularAttribute<Prova, Date> ano;
    public static volatile ListAttribute<Prova, Usuario> usuarioList;
    public static volatile SingularAttribute<Prova, Curso> cursoIdCurso;
    public static volatile ListAttribute<Prova, Questao> questaoList;

}