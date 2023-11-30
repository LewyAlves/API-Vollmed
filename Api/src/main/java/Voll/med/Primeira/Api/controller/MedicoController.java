package Voll.med.Primeira.Api.controller;

import Voll.med.Primeira.Api.domain.medicos.*;
import Voll.med.Primeira.Api.domain.medicos.*;
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
@RequestMapping("medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastros(@RequestBody @Valid DadosMedicos dados, UriComponentsBuilder uriComponents){
        var medico = (new Medico(dados));
        repository.save(medico);
        var uri = uriComponents.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new dadosDetalhamentoDeAtualizacao(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDeListaDeMedicos>> listar(@PageableDefault(sort = {"id"}) Pageable paginacao) {
        var page = repository.findAllByAtivosTrue(paginacao).map(DadosDeListaDeMedicos::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizacaomedico(@RequestBody @Valid atualizaDadosMedicos dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizainformacoes(dados);

        return ResponseEntity.ok(new dadosDetalhamentoDeAtualizacao(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
        repository.save(medico);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity consultar(@PathVariable Long id){
        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new dadosDetalhamentoDeAtualizacao(medico));
    }
}
