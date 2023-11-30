package Voll.med.Primeira.Api.domain.consultas.validacoes.agendamento;

import Voll.med.Primeira.Api.domain.consultas.DadosAgendamentoDeConsulta;
import Voll.med.Primeira.Api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class HorarioDeFuncionamento implements ValidaConsulta {
    public void validar(DadosAgendamentoDeConsulta dados){
        var domingo = dados.data().getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDeAbrir = dados.data().getHour() < 7;
        var aposFechamento = dados.data().getHour() > 18;


        if (domingo || antesDeAbrir || aposFechamento){
            throw new ValidacaoException("Não foi possivel agendar sua consulta," +
                    " O horário de funcionamento da clínica é de segunda a sábado, das 07:00 às 19:00. ");
        }
    }
}
