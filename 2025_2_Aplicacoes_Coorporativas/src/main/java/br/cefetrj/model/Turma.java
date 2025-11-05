package br.cefetrj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma extends Entidade {
    private String nome;
    private int numeroAlunos;
    private String disciplina;


    //get e set
    public int getNumeroAlunos() {
        return numeroAlunos;
    }
    public String getDisciplina() {
        return disciplina;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNumeroAlunos(int numeroAlunos) {
        this.numeroAlunos = numeroAlunos;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
