/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maratonas.bean;

import maratonas.dao.DAO;
import maratonas.entity.Aluno;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
/**
 *
 * @author Lucas
 */
@Named(value = "alunoBean")
@SessionScoped
public class AlunoBean implements Serializable {
    Aluno aluno = new Aluno();
    private List<Aluno> alunos = new ArrayList<>();

    public AlunoBean() {
        DAO dao = new DAO(Aluno.class);
        alunos = dao.listarGenerico("Aluno.listarTodos");
    }
    
    public Aluno getAluno(){
        return aluno;
    }
    
    public void setAluno(Aluno aluno){
        this.aluno = aluno;
    }
    
    public List<Aluno> getAlunos(){
        return alunos;
    }
    
    public String gravar() {
        DAO dao = new DAO(Aluno.class);
        dao.adicionar(aluno);
        aluno = new Aluno();
        return null;
    }
    //@Transactional
    public String excluir(Aluno a) {
        DAO dao = new DAO(Aluno.class);
        dao.excluir(a.getId());
        alunos.remove(a);
        return null;
    }
    
    public String paginaNovoAluno() {
        aluno = new Aluno();
        return "/novo_aluno";
    }
    
    public String paginaInicial() {
        aluno = new Aluno();
        DAO dao = new DAO(Aluno.class);
        alunos = dao.listarGenerico("Aluno.listarTodos");
        return "/aluno_listar";
    }
    
    public String procurar() {
        DAO dao = new DAO(Aluno.class);
        alunos = dao.listarGenerico("Aluno.consultarPorNome", '%' + aluno.getNome() + '%');
        return null;
    }
    
    public String editar(Aluno a) {
        aluno = a;
        return "/editar_aluno";
    }
    
    public String alterar() {
        DAO dao = new DAO(Aluno.class);
        dao.alterar(aluno);
        return "/aluno_listar";
    }
}
