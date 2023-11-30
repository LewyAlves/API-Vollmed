package Voll.med.Primeira.Api.domain.pacientes;

public record DadosDeListaDePacientes(Long id, String nome,String cpf, String email) {

   public DadosDeListaDePacientes(Paciente pacientes){
        this(pacientes.getId(), pacientes.getNome(), pacientes.getCpf(), pacientes.getEmail());
    }
}
