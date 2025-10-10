package br.cefetrj.model;

import jakarta.persistence.Entity;

@Entity
public class Turma extends Entidade {
    public String nome;
    public Integer numeroAlunos;
    public String disciplina;


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
