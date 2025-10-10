package br.cefetrj.model;

import java.time.LocalDate;
import java.util.Set;

import javax.annotation.processing.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDate dataCriacao;
    @Column(nullable = true)
    private LocalDate dataUltimaAlteração;
    @ManyToOne
    private Usuario criadoPor;
    @ManyToOne(optional = true)
    private Usuario alteradoPor;

    //get e set
    public Usuario getAlteradoPor() {
        return alteradoPor;
    }
    public Usuario getCriadoPor() {
        return criadoPor;
    }
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public LocalDate getDataUltimaAlteração() {
        return dataUltimaAlteração;
    }
    public Integer getId() {
        return id;
    }

    public void setAlteradoPor(Usuario alteradoPor) {
        this.alteradoPor = alteradoPor;
    }
    public void setCriadoPor(Usuario criadoPor) {
        this.criadoPor = criadoPor;
    }
    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    public void setDataUltimaAlteração(LocalDate dataUltimaAlteração) {
        this.dataUltimaAlteração = dataUltimaAlteração;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
