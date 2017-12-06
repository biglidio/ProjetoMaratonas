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
import javax.enterprise.context.SessionScoped;
import maratonas.dao.DAO;
import maratonas.entity.Aluno;
import maratonas.entity.Instituicao;

/**
 *
 * @author Lucas
 */
@Named(value = "instituicaoBean")
@SessionScoped
public class InstituicaoBean implements Serializable {
    Instituicao ins = new Instituicao();
    private List<Instituicao> instituicoes = new ArrayList<>();
    private Instituicao instituicao;

    public InstituicaoBean() {
        DAO dao = new DAO(Aluno.class);
        instituicoes = dao.listarGenerico("Instituicao.listarTodos");
    }
    
    /**
     *
     * @return
     */
    public Instituicao getInstituicao(){
        return instituicao;
    }
    
    
    public void setInstituicao(Instituicao instituicao){
        this.instituicao = instituicao;
    }
    
    public List<Instituicao> getInstituicoes(){
        return instituicoes;
    }
    
    public String gravar() {
        DAO dao = new DAO(Instituicao.class);
        dao.adicionar(instituicao);
        instituicao = new Instituicao();
        return null;
    }
    //@Transactional
    public String excluir(Instituicao i) {
        DAO dao = new DAO(Instituicao.class);
        dao.excluir(i.getId());
        instituicoes.remove(i);
        return null;
    }
    
    public String paginaNovoInstituicao() {
        instituicao = new Instituicao();
        return "/novo_instituicao";
    }
    
    public String paginaInicial() {
        instituicao = new Instituicao();
        DAO dao = new DAO(Instituicao.class);
        instituicoes = dao.listarGenerico("Instituicoes.listarTodos");
        return "/instituicao_listar";
    }
    
    
   /*FALTA ARRUMAR A ENTIDADE DE INSTITUIÇÃO
    public String procurar() {
        DAO dao = new DAO(Instituicao.class);
        instituicao = dao.listarGenerico("Instituicao.consultarPorNome", '%' + aluno.getNome() + '%');
        return null;
    }
     */
    public String editar(Instituicao i) {
        instituicao = i;
        return "/editar_Instituicao";
    }
    
    public String alterar() {
        DAO dao = new DAO(Instituicao.class);
        dao.alterar(instituicao);
        return "/instituicao_listar";
    }
    
}
