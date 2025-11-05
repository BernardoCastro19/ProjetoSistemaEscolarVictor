package br.cefetrj.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import br.cefetrj.model.Disciplina;
import br.cefetrj.repository.DisciplinaRepository;

@Service
public class DisciplinaService {
    protected DisciplinaRepository repository;

    public DisciplinaService(DisciplinaRepository repository) {
        this.repository = repository;
    }

    public Disciplina save(Disciplina entity) {
        return repository.save(entity);
    }

    public Disciplina update(Disciplina entity) {
        return repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Disciplina> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Disciplina> findAll() {

        return repository.findAll();
    }

}