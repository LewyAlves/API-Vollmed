package Voll.med.Primeira.Api.domain.medicos;

import Voll.med.Primeira.Api.domain.enderecos.Endereco;

public record dadosDetalhamentoDeAtualizacao(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade, Endereco endereco) {

    public dadosDetalhamentoDeAtualizacao(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
