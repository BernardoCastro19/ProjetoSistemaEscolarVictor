package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@Table(name = "professor")
public class Professor extends Pessoa{

    public String diploma;

    //get e set
    public String getDiploma() {
        return diploma;
    }
    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }
    
}
