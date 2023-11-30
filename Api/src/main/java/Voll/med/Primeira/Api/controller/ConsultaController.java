package Voll.med.Primeira.Api.controller;

import Voll.med.Primeira.Api.domain.consultas.*;
import Voll.med.Primeira.Api.domain.consultas.validacoes.cancelamento.DadosCancelaConsulta;
import Voll.med.Primeira.Api.domain.medicos.dadosDetalhamentoDeAtualizacao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendamentoDeConsulta agendar;

    @Autowired
    private ConsultaRepository repository;

    @Autowired
    private CancelamentoDeConsulta cancelar;


    @PostMapping
    @Transactional
    public ResponseEntity agendamento(@RequestBody @Valid DadosAgendamentoDeConsulta dados){
        var dto = agendar.Agendamento(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelamentoDeConsulta(@RequestBody @Valid DadosCancelaConsulta dados){
        cancelar.cancelamento(dados);
        return ResponseEntity.noContent().build();
    }
}
