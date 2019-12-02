/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.bean;

import br.cesjf.lpwsd.dao.UsuarioDAO;
import br.cesjf.lpwsd.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;

/**
 *
 * @author diego
 */
public class usuarioBean {
    
     Usuario usuario = new Usuario();
    
    List usuarios = new ArrayList();

        
    public usuarioBean() {
        usuarios = new UsuarioDAO().buscarTodas();
        usuario = new Usuario();
    }
    
    //Métodos dos botões 
    public void persistir(ActionEvent actionEvent) {
        new UsuarioDAO().persistir(usuario);
        usuarios = new UsuarioDAO().buscarTodas();
        usuario = new Usuario();
    }
    public void excluir(ActionEvent actionEvent){
        new UsuarioDAO().remover(usuario);
        usuarios = new UsuarioDAO().buscarTodas();
        usuario = new Usuario();
    }
            
    //getters and setters

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List usuarios) {
        this.usuarios = usuarios;
    }
}
