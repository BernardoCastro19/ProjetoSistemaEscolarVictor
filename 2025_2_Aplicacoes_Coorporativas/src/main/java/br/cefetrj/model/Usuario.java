package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Usuario {
    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer id;
    @Column(name = "nome")
    public String nome;
    @Column(name = "documento")
    public String documento;

    public Usuario(Integer id, String nome, String documento){
        this.nome = nome;
        this.documento = documento;
    }

    //get e set
    public Integer getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getDocumento() {
        return documento;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
