package br.cefetrj.to.output;

import java.util.List;

import br.cefetrj.model.Aluno;

public class AlunoTOOutput {
    private Integer id;
    private String nome;
    private String documento;

    public AlunoTOOutput(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.documento = aluno.getDocumento();
    }

    public Integer getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
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

}