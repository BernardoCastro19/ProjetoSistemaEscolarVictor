package br.cefetrj.to.output;

import java.util.List;

import br.cefetrj.model.Turma;

public class TurmaTOOutput {
    private Integer id;
    private String nome;
    private int numeroAlunos;
    private String disciplina;
    

    public TurmaTOOutput(Turma turma) {
        this.id = turma.getId();
        this.nome = turma.getNome();
        this.numeroAlunos = turma.getNumeroAlunos();
        this.disciplina = turma.getDisciplina();
    }

    public Integer getId() {
        return id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public int getNumeroAlunos() {
        return numeroAlunos;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void setNumeroAlunos(int numeroAlunos) {
        this.numeroAlunos = numeroAlunos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}