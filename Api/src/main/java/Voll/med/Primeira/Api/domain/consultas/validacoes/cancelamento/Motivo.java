package Voll.med.Primeira.Api.domain.consultas.validacoes.cancelamento;


import Voll.med.Primeira.Api.domain.consultas.ConsultaRepository;
import Voll.med.Primeira.Api.domain.consultas.DadosAgendamentoDeConsulta;
import Voll.med.Primeira.Api.infra.exception.ValidacaoException;
import org.springframework.stereotype.Component;

@Component
public class Motivo implements CancelaConsulta{

    public void cancelar(DadosCancelaConsulta dados){
        var motivo = dados.motivo();
        if (motivo == ""){
            throw new ValidacaoException("Por favor informar o motivo do cancelamento da consulta");
        }
    }
}
