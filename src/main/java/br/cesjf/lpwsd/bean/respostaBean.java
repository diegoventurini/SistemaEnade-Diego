/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpwsd.bean;

import br.cesjf.lpwsd.dao.RespostaDAO;
import br.cesjf.lpwsd.model.Resposta;
import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;

/**
 *
 * @author diego
 */
public class respostaBean {
    
    Resposta resposta = new Resposta();
    
    List respostas = new ArrayList();
    
    public respostaBean() {
        respostas = new RespostaDAO().buscarTodas();
        resposta = new Resposta();
    }
    
    //Métodos dos botões 
    public void persistir(ActionEvent actionEvent){
        new RespostaDAO().persistir(resposta);
//        respostas = new RespostaDAO().bu(resposta);
        resposta = new Resposta();
    }
    
    public void excluir(ActionEvent actionEvent){
        new RespostaDAO().remover(resposta);
        respostas = new RespostaDAO().buscarTodas();
        resposta = new Resposta();
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }

    public List getRespostas() {
        return respostas;
    }

    public void setRespostas(List respostas) {
        this.respostas = respostas;
    }
}
