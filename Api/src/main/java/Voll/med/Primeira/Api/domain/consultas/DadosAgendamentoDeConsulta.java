package Voll.med.Primeira.Api.domain.consultas;

import Voll.med.Primeira.Api.domain.medicos.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoDeConsulta(
        Long id,
        Long idMedico,
        @NotNull
        Long idPaciente,
        @NotNull
        @Future
        LocalDateTime data,
        Especialidade especialidade
) {
}
