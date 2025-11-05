package br.cefetrj.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import br.cefetrj.model.Aluno;
import br.cefetrj.repository.AlunoRepository;

@Service
public class AlunoService {
    protected AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public Aluno save(Aluno entity) {
        return repository.save(entity);
    }

    public Aluno update(Aluno entity) {
        return repository.save(entity);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Optional<Aluno> findById(Integer id) {
        return repository.findById(id);
    }

    public List<Aluno> findAll() {

        return repository.findAll();
    }

}