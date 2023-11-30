package Voll.med.Primeira.Api.domain.consultas;

import Voll.med.Primeira.Api.domain.medicos.Especialidade;

import java.time.LocalDateTime;

public record DetalhamentoDaConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {

    public DetalhamentoDaConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getData());
    }
}
