package Voll.med.Primeira.Api.controller;

import Voll.med.Primeira.Api.domain.pacientes.*;
import Voll.med.Primeira.Api.pacientes.detalhamentoDeAtualizaPaciente;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;


    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPaciente(@RequestBody @Valid DadosPacientes dados, UriComponentsBuilder uriComponentsBuilder){
        var paciente = new Paciente(dados);
        repository.save(paciente);
        var uri = uriComponentsBuilder.path("/medicos/{id}").buildAndExpand(paciente).toUri();

        return ResponseEntity.created(uri).body(new detalhamentoDeAtualizaPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDeListaDePacientes>> listarPacientes(@PageableDefault(sort = {"id"}) Pageable paginacao){
        var page = repository.findAll(paginacao).map(DadosDeListaDePacientes::new);

        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizaPaciente(@RequestBody @Valid atualizaDadosPaciente dados){
        var pacientes = repository.getReferenceById(dados.id());
        pacientes.atualizaDados(dados);

        return ResponseEntity.ok(new detalhamentoDeAtualizaPaciente(pacientes));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluiPaciente(@PathVariable Long id){
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
