package Voll.med.Primeira.Api.domain.consultas.validacoes.agendamento;

import Voll.med.Primeira.Api.domain.consultas.ConsultaRepository;
import Voll.med.Primeira.Api.domain.consultas.DadosAgendamentoDeConsulta;
import Voll.med.Primeira.Api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteSemOutraConsultaNoDia implements ValidaConsulta {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoDeConsulta dados){
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHoraio = dados.data().withHour(18);
        var pacientePossuiConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHoraio);
        if (pacientePossuiConsultaNoDia){
            throw new ValidacaoException("Paciente já possui consulta nessa data");
        }
    }
}
