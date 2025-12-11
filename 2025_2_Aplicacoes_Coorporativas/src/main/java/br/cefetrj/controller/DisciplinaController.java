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

import br.cefetrj.model.Disciplina;
import br.cefetrj.service.DisciplinaService;
import br.cefetrj.to.input.DisciplinaTOInput;
import br.cefetrj.to.output.DisciplinaTOOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/disciplinas", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/disciplinas", tags = { "disciplinas - DisciplinaController" })
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    @Autowired
    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @PostMapping
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo registro no banco de dados")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DisciplinaTOOutput> save(@RequestBody DisciplinaTOInput input) {
        final var disciplina = input;

        final Disciplina created = disciplinaService.save(disciplina.build());

        return new ResponseEntity<>(new DisciplinaTOOutput(created),
                HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza um registro existente no banco de dados")
    public ResponseEntity<DisciplinaTOOutput> edit(@RequestBody DisciplinaTOInput input) {

        final Disciplina created = disciplinaService.save(input.build());

        return new ResponseEntity<>(new DisciplinaTOOutput(created), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o registro de acordo com o ID repassado")
    public ResponseEntity<DisciplinaTOOutput> findById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(disciplinaService.findById(id).map(DisciplinaTOOutput::new).orElse(null));

    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os registros")
    public ResponseEntity<List<DisciplinaTOOutput>> findAll() {

        return ResponseEntity.ok(disciplinaService.findAll().stream().map(DisciplinaTOOutput::new).toList());

    }

    @DeleteExchange("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o registro de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {

        disciplinaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
