package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ALUNO")
public class Aluno extends Usuario{
    public Aluno(Integer id, String nome, String documento){
        super(id,nome,documento);
    }
    
}
