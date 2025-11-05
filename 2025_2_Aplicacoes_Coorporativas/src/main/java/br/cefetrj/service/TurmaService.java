package br.cefetrj.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import br.cefetrj.model.Turma;
import br.cefetrj.repository.TurmaRepository;

@Service
public class TurmaService {
    protected TurmaRepository repository;

    public TurmaService(TurmaRepository repository) {
        this.repository = repository;
    }

    public Turma save(Turma entity) {
        return repository.save(entity);
    }

    public Turma update(Turma entity) {
        return repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Turma> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Turma> findAll() {

        return repository.findAll();
    }

}