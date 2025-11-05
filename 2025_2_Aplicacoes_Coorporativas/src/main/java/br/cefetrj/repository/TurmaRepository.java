package br.cefetrj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import br.cefetrj.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer>, JpaSpecificationExecutor<Turma> {

}