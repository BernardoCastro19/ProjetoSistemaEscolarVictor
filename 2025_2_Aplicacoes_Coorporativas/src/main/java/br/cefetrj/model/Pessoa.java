package br.cefetrj.model;

import jakarta.persistence.*;

@MappedSuperclass
public class Pessoa extends Entidade{

    public String nome;
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
