package br.cefetrj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import br.cefetrj.model.Professor;
import br.cefetrj.service.ProfessorService;
import br.cefetrj.to.input.ProfessorTOInput;
import br.cefetrj.to.output.ProfessorTOOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/professores", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/professores", tags = { "professores - ProfessorController" })
public class ProfessorController {

    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @PostMapping
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo registro no banco de dados")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProfessorTOOutput> save(@RequestBody ProfessorTOInput input) {
        final var professor = input;

        final Professor created = professorService.save(professor.build());

        return new ResponseEntity<>(new ProfessorTOOutput(created),
                HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza um registro existente no banco de dados")
    public ResponseEntity<ProfessorTOOutput> edit(@RequestBody ProfessorTOInput input) {

        final Professor created = professorService.save(input.build());

        return new ResponseEntity<>(new ProfessorTOOutput(created), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o registro de acordo com o ID repassado")
    public ResponseEntity<ProfessorTOOutput> findById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(professorService.findById(id).map(ProfessorTOOutput::new).orElse(null));

    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os registros")
    public ResponseEntity<List<ProfessorTOOutput>> findAll() {

        return ResponseEntity.ok(professorService.findAll().stream().map(ProfessorTOOutput::new).toList());

    }

    @DeleteExchange("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o registro de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {

        professorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
