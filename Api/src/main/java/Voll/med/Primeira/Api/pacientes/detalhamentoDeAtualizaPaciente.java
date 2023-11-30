package Voll.med.Primeira.Api.pacientes;

import Voll.med.Primeira.Api.domain.enderecos.Endereco;
import Voll.med.Primeira.Api.domain.pacientes.Paciente;

public record detalhamentoDeAtualizaPaciente(Long id, String nome,String cpf,String telefone, Endereco endereco) {

    public detalhamentoDeAtualizaPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getEndereco());
    }
}
