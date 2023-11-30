package Voll.med.Primeira.Api.domain.consultas;

import Voll.med.Primeira.Api.domain.consultas.validacoes.agendamento.ValidaConsulta;
import Voll.med.Primeira.Api.domain.medicos.Medico;
import Voll.med.Primeira.Api.domain.medicos.MedicoRepository;
import Voll.med.Primeira.Api.domain.pacientes.PacienteRepository;
import Voll.med.Primeira.Api.infra.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private  MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    List<ValidaConsulta>validaConsulta;



    public DetalhamentoDaConsulta Agendamento(DadosAgendamentoDeConsulta dados){

        if (!pacienteRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Paciente inexistente!");
        }
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Paciente inexistente!");
        }
        validaConsulta.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());
        var medico = escolheMedico(dados);
        if (medico == null) {
            throw new ValidacaoException("Não existe médico disponível nessa data!");
        }



        var consulta = new Consulta(dados.id(), medico, paciente, dados.data());
        consultaRepository.save(consulta);

        return new DetalhamentoDaConsulta(consulta);

    }

    private Medico escolheMedico(DadosAgendamentoDeConsulta dados){
        if (dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if (dados.especialidade() == null){
            throw new ValidacaoException("Especialidade não informada ou invalída, por favor informe a especialidade da consulta corretamente");
        }
        return medicoRepository.escolherMedicoAleatorioDisponivelNaData(dados.especialidade(),dados.data());
    }
}
