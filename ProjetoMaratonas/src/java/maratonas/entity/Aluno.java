package maratonas.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author lucas
 */
@NamedQueries({
    @NamedQuery(name = "Aluno.listarTodos", query = "select a from Aluno a order by a.nome"),
    @NamedQuery(name = "Aluno.consultarPorNome",  query = "select a from Aluno a where a.nome like ?1 order by a.nome")
})
@Entity
public class Aluno extends AbstractEntity {
    private String nome;
    private String ra;
    private Integer idade;

    public Aluno() {
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getRa(){
        return ra;
    }
    public void setRa(String ra){
        this.ra = ra;
    }
    public Integer getIdade(){
        return idade;
    }
    public void setIdade(Integer idade){
        this.idade = idade;
    }
    
    
}
