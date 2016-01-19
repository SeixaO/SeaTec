/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package seaTec.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author seixa
 */
@Entity
@Table(name = "tb_candidatos")
@XmlRootElement
public class Candidato implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "codVaga")
    private Integer id;
    
    @NotNull
    @Column(name = "tx_nome")
    @Size(max = 100)
    private String nome;
    
    @NotNull
    @Column(name = "nr_idade")
    @Size(max = 11)
    private int idade;
    
    @NotNull
    @Column(name = "tx_cidade")
    private String cidade;

        
    //construtores
    public Candidato() {
       
    }

    public Candidato(Integer id) {
        this.id = id;
    }

    
    //getters e setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
       
    
    
    
}
