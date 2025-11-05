package br.cefetrj.to.input;

import java.io.Serializable;

import br.cefetrj.model.Professor;

public class ProfessorTOInput implements Serializable {
    private String nome;
    private String documento;
    private Integer id;
    private String diploma;

    public ProfessorTOInput() {
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

    public String getDiploma() {
        return diploma;
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

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public Professor build() {
        var professor = new Professor();
        professor.setId(id);
        professor.setNome(nome);
        professor.setDocumento(documento);
        professor.setDiploma(diploma);
        return professor;
    }
}