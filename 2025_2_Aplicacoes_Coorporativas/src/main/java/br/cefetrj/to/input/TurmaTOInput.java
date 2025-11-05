package br.cefetrj.to.input;

import java.io.Serializable;

import br.cefetrj.model.Turma;

public class TurmaTOInput implements Serializable {
    private String nome;
    private int numeroAlunos;
    private String disciplina;
    private Integer id;

    public TurmaTOInput() {
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDisciplina() {
        return disciplina;
    }
    
    public int getNumeroAlunos() {
        return numeroAlunos;
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

    public Turma build() {
        var turma = new Turma();
        turma.setId(id);
        turma.setNome(nome);
        turma.setDisciplina(disciplina);
        turma.setNumeroAlunos(numeroAlunos);
        return turma;
    }
}