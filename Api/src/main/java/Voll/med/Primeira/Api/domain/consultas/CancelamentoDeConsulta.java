package Voll.med.Primeira.Api.domain.consultas;

import Voll.med.Primeira.Api.domain.consultas.validacoes.cancelamento.CancelaConsulta;
import Voll.med.Primeira.Api.domain.consultas.validacoes.cancelamento.DadosCancelaConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancelamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    List<CancelaConsulta> validaCancelamento;

    public void cancelamento(DadosCancelaConsulta dados) {
        validaCancelamento.forEach(v -> v.cancelar(dados));
    }
}
