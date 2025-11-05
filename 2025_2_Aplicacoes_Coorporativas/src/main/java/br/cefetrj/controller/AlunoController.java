package br.cefetrj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import br.cefetrj.model.Aluno;
import br.cefetrj.service.AlunoService;
import br.cefetrj.to.input.AlunoTOInput;
import br.cefetrj.to.output.AlunoTOOutput;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/alunos", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "/alunos", tags = { "Alunos - AlunoController" })
public class AlunoController {
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    @ApiOperation(value = "Salvar registro", notes = "Salva um novo registro no banco de dados")
    public ResponseEntity<AlunoTOOutput> save(@RequestBody AlunoTOInput input) {
        final var aluno = input;

        final Aluno created = alunoService.save(aluno.build());

        return new ResponseEntity<>(new AlunoTOOutput(created),
                HttpStatus.CREATED);
    }

    @PutMapping
    @ApiOperation(value = "Atualizar registro", notes = "Atualiza um registro existente no banco de dados")
    public ResponseEntity<AlunoTOOutput> edit(@RequestBody AlunoTOInput input) {

        final Aluno created = alunoService.save(input.build());

        return new ResponseEntity<>(new AlunoTOOutput(created), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Pesquisar por ID", notes = "Retorna o registro de acordo com o ID repassado")
    public ResponseEntity<AlunoTOOutput> findById(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(alunoService.findById(id).map(AlunoTOOutput::new).orElse(null));

    }

    @GetMapping
    @ApiOperation(value = "Listar todos", notes = "Retorna todos os registros")
    public ResponseEntity<List<AlunoTOOutput>> findAll() {

        return ResponseEntity.ok(alunoService.findAll().stream().map(AlunoTOOutput::new).toList());

    }

    @DeleteExchange("/{id}")
    @ApiOperation(value = "Deletar por ID", notes = "Remove o registro de acordo com o ID repassado")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {

        alunoService.delete(id);
        return ResponseEntity.noContent().build();

    }
}