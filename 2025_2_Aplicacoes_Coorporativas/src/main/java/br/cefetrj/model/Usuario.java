package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Usuario extends Entidade{

    @Column(name = "nome")
    public String nome;
    @Column(name = "documento")
    public String documento;


    //get e set
    public String getNome() {
        return nome;
    }
    public String getDocumento() {
        return documento;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
