package Voll.med.Primeira.Api.domain.consultas.validacoes.cancelamento;

import Voll.med.Primeira.Api.domain.consultas.ConsultaRepository;
import Voll.med.Primeira.Api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class CancelaNoPrazo implements CancelaConsulta{

    @Autowired
    private ConsultaRepository consultaRepository;

    public void cancelar(DadosCancelaConsulta dados){
        var dataDoCancelamento = LocalDateTime.now();
        var dataDaConsulta = consultaRepository.getReferenceById(dados.id());
        var diferencaDeHrs = Duration.between(dataDoCancelamento,dataDaConsulta.getData()).toHours();
        if(diferencaDeHrs < 24){
            throw new ValidacaoException("Consulta somente pode ser cancelada com antecedência mínima de 24h!");

        }
    }
}
