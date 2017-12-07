package maratonas.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author lucas
 */
@NamedQueries({
    @NamedQuery(name = "Instituicao.listarTodos", query = "select i from Instituicao i order by i.nome"),
    @NamedQuery(name = "Instituicao.consultarPorNome",  query = "select i from Instituicao i where i.nome like ?1 order by i.nome")
})
@Entity
public class Instituicao extends AbstractEntity {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Instituicao() {
    }
    
    
    
}
