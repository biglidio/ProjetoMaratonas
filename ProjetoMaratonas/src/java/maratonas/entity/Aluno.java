/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maratonas.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Administrador
 */
@NamedQueries ({
    @NamedQuery(name = "Aluno.listarAluno", query = "select a from Aluno a where a.fk_cd_entidade = ?1 and m.id = ?2")
})

@Entity
public class Aluno extends AbstractEntity{

@Column(length = 60)
private String nm_aluno;

@ManyToOne
private Entidade entidade = new Entidade();



public Aluno() {
}

    public String getNm_aluno() {
        return nm_aluno;
    }

    public void setNm_aluno(String nm_aluno) {
        this.nm_aluno = nm_aluno;
    }
    public Entidade getEntidade() {
        return entidade;
    }

    public void setEntidade(Entidade entidade) {
        this.entidade = entidade;
    }
    
}
