package br.cefetrj.model;

public class Turma {
    public Integer id;
    public String nome;
    public Integer numeroAlunos;
    public String disciplina;

    public Turma(Integer id, String nome, Integer numeroAlunos,String disciplina){
        this.id = id;
        this.nome = nome;
        this.numeroAlunos = numeroAlunos;
        this.disciplina = disciplina;
    }

    //get e set
    public Integer getId() {
        return id;
    }
    public int getNumeroAlunos() {
        return numeroAlunos;
    }
    public String getDisciplina() {
        return disciplina;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setNumeroAlunos(int numeroAlunos) {
        this.numeroAlunos = numeroAlunos;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
