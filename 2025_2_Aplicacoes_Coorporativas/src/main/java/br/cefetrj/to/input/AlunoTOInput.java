package br.cefetrj.to.input;

import java.io.Serializable;

import br.cefetrj.model.Aluno;

public class AlunoTOInput implements Serializable {
    private String nome;
    private String documento;
    private Integer id;

    public AlunoTOInput() {
    }

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

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Aluno build() {
        var aluno = new Aluno();
        aluno.setId(id);
        aluno.setNome(nome);
        aluno.setDocumento(documento);
        return aluno;
    }
}