package br.cefetrj.model;

public class Disciplina {
    public Integer id;
    public String nome;
    public Integer horas;

    public Disciplina(Integer id,String nome, int horas){
        this.id = id;
        this.nome = nome;
        this.horas = horas;
    }

    //get e set
    public String getNome() {
        return nome;
    }
    public int getHoras() {
        return horas;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setHoras(int horas) {
        this.horas = horas;
    }
}
