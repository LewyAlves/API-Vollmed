package Voll.med.Primeira.Api.domain.pacientes;

import Voll.med.Primeira.Api.domain.enderecos.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record atualizaDadosPaciente(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {
}
