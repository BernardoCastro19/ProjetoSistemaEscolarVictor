package br.cefetrj.model;

public class Professor extends Usuario{

    public String diploma;
    public Professor(Integer id, String nome, String documento, String diploma){
        super(id,nome,documento);
        this.diploma = diploma;
    }

    //get e set
    public String getDiploma() {
        return diploma;
    }
    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }
    
}
