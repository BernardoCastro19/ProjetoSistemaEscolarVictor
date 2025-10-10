package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("PROFESSOR")
public class Professor extends Usuario{

    public String diploma;

    //get e set
    public String getDiploma() {
        return diploma;
    }
    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }
    
}
