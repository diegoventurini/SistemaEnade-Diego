package br.cesjf.lpwsd.model;

import br.cesjf.lpwsd.model.Prova;
import br.cesjf.lpwsd.model.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-02T20:59:04")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, String> sigla;
    public static volatile ListAttribute<Curso, Usuario> usuarioList;
    public static volatile ListAttribute<Curso, Prova> provaList;
    public static volatile SingularAttribute<Curso, Integer> idCurso;
    public static volatile SingularAttribute<Curso, String> nmCurso;

}