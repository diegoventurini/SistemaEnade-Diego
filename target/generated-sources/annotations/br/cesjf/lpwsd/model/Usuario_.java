package br.cesjf.lpwsd.model;

import br.cesjf.lpwsd.model.Curso;
import br.cesjf.lpwsd.model.Prova;
import br.cesjf.lpwsd.model.TipoUsuario;
import br.cesjf.lpwsd.model.UsuarioHasQuestao;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-02T20:59:04")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> senha;
    public static volatile SingularAttribute<Usuario, TipoUsuario> idTipoUsuario;
    public static volatile SingularAttribute<Usuario, Integer> idUsuario;
    public static volatile ListAttribute<Usuario, Prova> provaList;
    public static volatile SingularAttribute<Usuario, String> cpf;
    public static volatile SingularAttribute<Usuario, Short> reset;
    public static volatile SingularAttribute<Usuario, String> nmUsuario;
    public static volatile SingularAttribute<Usuario, String> tipoUsuario;
    public static volatile SingularAttribute<Usuario, String> email;
    public static volatile ListAttribute<Usuario, Curso> cursoList;
    public static volatile ListAttribute<Usuario, UsuarioHasQuestao> usuarioHasQuestaoList;

}