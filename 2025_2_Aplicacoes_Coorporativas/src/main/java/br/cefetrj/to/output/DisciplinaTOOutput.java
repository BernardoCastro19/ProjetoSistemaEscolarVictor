package br.cefetrj.to.output;

import java.util.List;

import br.cefetrj.model.Disciplina;

public class DisciplinaTOOutput {
    private Integer id;
    private String nome;
    private Integer horas;

    public DisciplinaTOOutput(Disciplina disciplina) {
        this.id = disciplina.getId();
        this.nome = disciplina.getNome();
        this.horas = disciplina.getHoras();
    }

    public Integer getId() {
        return id;
    }

    public Integer getHoras() {
        return horas;
    }
   

    public String getNome() {
        return nome;
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

}