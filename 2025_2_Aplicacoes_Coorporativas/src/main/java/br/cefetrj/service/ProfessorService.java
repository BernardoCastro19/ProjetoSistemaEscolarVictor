package br.cefetrj.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import br.cefetrj.model.Professor;
import br.cefetrj.repository.ProfessorRepository;

@Service
public class ProfessorService {
    protected ProfessorRepository repository;

    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }

    public Professor save(Professor entity) {
        return repository.save(entity);
    }

    public Professor update(Professor entity) {
        return repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Professor> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Professor> findAll() {

        return repository.findAll();
    }

}