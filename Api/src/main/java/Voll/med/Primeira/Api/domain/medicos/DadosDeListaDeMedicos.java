package Voll.med.Primeira.Api.domain.medicos;

public record DadosDeListaDeMedicos(Long id, String nome, String email, String crm, Especialidade especialidade) {

    public DadosDeListaDeMedicos(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
