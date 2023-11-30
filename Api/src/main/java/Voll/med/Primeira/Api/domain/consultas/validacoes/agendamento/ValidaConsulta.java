package Voll.med.Primeira.Api.domain.consultas.validacoes.agendamento;

import Voll.med.Primeira.Api.domain.consultas.DadosAgendamentoDeConsulta;

public interface ValidaConsulta {
    void validar(DadosAgendamentoDeConsulta dados);
}
