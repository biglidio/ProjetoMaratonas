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

/**
 *
 * @author Administrador
 */
@NamedQueries({
    @NamedQuery(name = "Entidade.listarTodas", query = "select e from Entidade c order by e.nm_entidade")
})
@Entity
    public class Entidade extends AbstractEntity{

@Column(length = 60)
private String nm_entidade;
private Integer vl_pontos;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name = "fk_cd_entidade")
private List<Maratona> maratona = new ArrayList<>();


@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name = "fk_cd_entidade")
private List<Aluno> aluno = new ArrayList<>();

    public List<Aluno> getAluno() {
        return aluno;
    }

    public void setAluno(List<Aluno> aluno) {
        this.aluno = aluno;
    }

    public List<Maratona> getMaratona() {
        return maratona;
    }

    public void setMaratona(List<Maratona> maratona) {
        this.maratona = maratona;
    }
    

    public Integer getVl_pontos() {
        return vl_pontos;
    }


    public void setVl_pontos(Integer vl_pontos) {
        this.vl_pontos = vl_pontos;
    }

    public String getNm_entidade() {
        return nm_entidade;
    }

    public void setNm_entidade(String nm_entidade) {
        this.nm_entidade = nm_entidade;
    }
public Entidade(){}
}
