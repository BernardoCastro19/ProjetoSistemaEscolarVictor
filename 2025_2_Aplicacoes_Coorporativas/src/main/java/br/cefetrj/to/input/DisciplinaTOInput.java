package br.cefetrj.to.input;

import java.io.Serializable;

import br.cefetrj.model.Disciplina;

public class DisciplinaTOInput implements Serializable {
    private String nome;
    private Integer horas;
    private Integer id;

    public DisciplinaTOInput() {
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Disciplina build() {
        var disciplina = new Disciplina();
        disciplina.setId(id);
        disciplina.setNome(nome);
        disciplina.setHoras(horas);
        return disciplina;
    }
}