package br.cefetrj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina extends Entidade {
    public String nome;
    public Integer horas;


    //get e set
    public String getNome() {
        return nome;
    }
    public int getHoras() {
        return horas;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setHoras(int horas) {
        this.horas = horas;
    }
}
