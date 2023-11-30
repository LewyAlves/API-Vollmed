package Voll.med.Primeira.Api.domain.medicos;

import Voll.med.Primeira.Api.domain.enderecos.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record atualizaDadosMedicos(@NotNull Long id, String nome, String telefone, DadosEndereco endereco) {

}
