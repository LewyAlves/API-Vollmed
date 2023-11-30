package Voll.med.Primeira.Api.domain.consultas.validacoes.agendamento;

import Voll.med.Primeira.Api.domain.consultas.ConsultaRepository;
import Voll.med.Primeira.Api.domain.consultas.DadosAgendamentoDeConsulta;
import Voll.med.Primeira.Api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoComOutraConsultaNoMesmoHorario implements ValidaConsulta {
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoDeConsulta dados){
        var medicoPossuiOutraConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMesmoHorario){
            throw new ValidacaoException("O médico selecionado já possui consulta marcada nesse horário.");
        }

    }
}
