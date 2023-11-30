package Voll.med.Primeira.Api.domain.consultas.validacoes.agendamento;

import Voll.med.Primeira.Api.domain.consultas.DadosAgendamentoDeConsulta;
import Voll.med.Primeira.Api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class AntecedenciaDeAgendamento implements ValidaConsulta {

    public void validar(DadosAgendamentoDeConsulta dados){
        var dataDaConsulta = dados.data();
        var horarioAtual = LocalDateTime.now();
        var DiferencaEmMinutos = Duration.between(horarioAtual,dataDaConsulta).toMinutes();

        if (DiferencaEmMinutos < 30){
            throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
        }
    }
}
