package br.cefetrj.to.output;

import java.util.List;

import br.cefetrj.model.Professor;

public class ProfessorTOOutput {
    private Integer id;
    private String nome;
    private String documento;
    private String diploma;

    public ProfessorTOOutput(Professor professor) {
        this.id = professor.getId();
        this.nome = professor.getNome();
        this.documento = professor.getDocumento();
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

}