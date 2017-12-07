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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TemporalType;

/**
 *
 * @author Administrador
 */


@NamedQueries ({           
    @NamedQuery(name = "Maratona.listarMaratona", query = "select m from Maratona m JOIN m.entidade e where e.maratona = ?1 and m.id = ?2")
})
@Entity
public class Maratona extends AbstractEntity {
    
    
    @Column(length = 60)
    private String nm_maratona;
    @Column(length = 100)
    private String ds_objetivo;
    @Column(length = 60)
    private String nm_tecnologia;

   
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    
    @ManyToOne
    private Entidade entidade = new Entidade();
    
    public String getNomeMaratona() {
        return nm_maratona; //To change body of generated methods, choose Tools | Templates.
    }

    public String getDs_objetivo() {
        return ds_objetivo;
    }

    public void setDs_objetivo(String ds_objetivo) {
        this.ds_objetivo = ds_objetivo;
    }

    public String getNm_tecnologia() {
        return nm_tecnologia;
    }

    public void setNm_tecnologia(String nm_tecnologia) {
        this.nm_tecnologia = nm_tecnologia;
    }
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setEntidade(Entidade entidade) {
      this.entidade = entidade;
    }

   

}
