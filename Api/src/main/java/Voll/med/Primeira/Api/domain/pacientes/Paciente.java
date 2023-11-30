package Voll.med.Primeira.Api.domain.pacientes;


import Voll.med.Primeira.Api.domain.enderecos.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Embedded
    private Endereco endereco;

    public Paciente(DadosPacientes dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizaDados(atualizaDadosPaciente dadosDoPaciente) {
        if (dadosDoPaciente.nome() != null) {
            this.nome = dadosDoPaciente.nome();
        }
        if (dadosDoPaciente.telefone() != null) {
            this.telefone = dadosDoPaciente.telefone();
        }
        if (dadosDoPaciente.endereco() != null) {
            this.endereco.atualizarEnderecoDoPaciente(dadosDoPaciente);
        }
    }
}
