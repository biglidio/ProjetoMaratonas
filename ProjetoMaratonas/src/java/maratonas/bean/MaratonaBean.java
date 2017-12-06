/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maratonas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import maratonas.dao.DAO;
import maratonas.entity.Aluno;
import maratonas.entity.Maratona;

/**
 *
 * @author Lucas
 */
@Named(value = "maratonaBean")
@SessionScoped
public class MaratonaBean implements Serializable {
    Maratona maratona = new Maratona();
    private List<Maratona> maratonas = new ArrayList<>();

    public MaratonaBean() {
        DAO dao = new DAO(Maratona.class);
        maratonas = dao.listarGenerico("Aluno.listarTodos");
    }
    
    public Maratona getMaratona(){
        return maratona;
    }
    
    public void setMaratona(Maratona maratona){
        this.maratona = maratona;
    }
    
    public List<Maratona> getMaratonas(){
        return maratonas;
    }
    
    public String gravar() {
        DAO dao = new DAO(Maratona.class);
        dao.adicionar(maratona);
        maratona = new Maratona();
        return null;
    }
    //@Transactional
    public String excluir(Maratona m) {
        DAO dao = new DAO(Maratona.class);
        dao.excluir(m.getId());
        maratonas.remove(m);
        return null;
    }
    
    public String paginaNovoMaratona() {
        maratona = new Maratona();
        return "/novo_maratona";
    }
    
    public String paginaInicial() {
        maratona = new Maratona();
        DAO dao = new DAO(Maratona.class);
        maratonas = dao.listarGenerico("Maratona.listarTodos");
        return "/aluno_listar";
    }
    
    public String procurar() {
        DAO dao = new DAO(Aluno.class);
        maratonas = dao.listarGenerico("Aluno.consultarPorNome", '%' + maratona.getNomeMaratona() + '%');
        return null;
    }
    
    public String editar(Maratona m) {
        maratona = m;
        return "/editar_maratona";
    }
    
    public String alterar() {
        DAO dao = new DAO(Maratona.class);
        dao.alterar(maratona);
        return "/maratona_listar";
    }
    
}
