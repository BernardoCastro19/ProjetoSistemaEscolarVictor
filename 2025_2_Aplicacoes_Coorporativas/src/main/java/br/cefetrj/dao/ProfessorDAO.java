package br.cefetrj.dao;

import br.cefetrj.model.Professor;

public class ProfessorDAO extends GenericDAO<Professor> {

    public ProfessorDAO() {
        super(Professor.class);
    }
}