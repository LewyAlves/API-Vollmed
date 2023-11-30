package Voll.med.Primeira.Api.domain.consultas.validacoes.agendamento;

import Voll.med.Primeira.Api.domain.consultas.DadosAgendamentoDeConsulta;
import Voll.med.Primeira.Api.domain.medicos.MedicoRepository;
import Voll.med.Primeira.Api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoAtivo implements ValidaConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoDeConsulta dados){
        if (dados.idMedico() == null){
            return;
        }
        var verifcaMedicoAtivo = repository.findAtivosById(dados.idMedico());
        if (verifcaMedicoAtivo == null || !verifcaMedicoAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada, medico não cadastrado no sistema");
        }
    }
}
