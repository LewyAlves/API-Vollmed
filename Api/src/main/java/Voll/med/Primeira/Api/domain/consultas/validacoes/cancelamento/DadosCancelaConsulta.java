package Voll.med.Primeira.Api.domain.consultas.validacoes.cancelamento;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCancelaConsulta(
        @NotNull
        Long id,
        @NotNull
        String motivo,
        LocalDateTime data
) {
}
