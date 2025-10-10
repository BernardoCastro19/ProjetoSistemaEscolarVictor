package br.cefetrj.model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ALUNO")
public class Aluno extends Usuario{
    
}
