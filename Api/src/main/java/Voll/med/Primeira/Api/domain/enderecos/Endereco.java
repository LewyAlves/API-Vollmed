package Voll.med.Primeira.Api.domain.enderecos;

import Voll.med.Primeira.Api.domain.pacientes.atualizaDadosPaciente;
import Voll.med.Primeira.Api.domain.medicos.atualizaDadosMedicos;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.cep = endereco.cep();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
    }

    public void atualizarEndereco(atualizaDadosMedicos dados) {
        if (dados.endereco().logradouro() != null){
            this.logradouro = dados.endereco().logradouro();
        }
        if (dados.endereco().cep() != null){
            this.logradouro = dados.endereco().cep();}
        if (dados.endereco().bairro() != null){
            this.logradouro = dados.endereco().bairro();}
        if (dados.endereco().logradouro() != null){
            this.logradouro = dados.endereco().uf();}
        if (dados.endereco().logradouro() != null){
            this.logradouro = dados.endereco().numero();}
        if (dados.endereco().uf() != null){
            this.uf = dados.endereco().uf();
        }

    }

    public void atualizarEnderecoDoPaciente(atualizaDadosPaciente dadosDoPaciente) {
        if (dadosDoPaciente.endereco().logradouro() != null){
            this.logradouro = dadosDoPaciente.endereco().logradouro();
        }
        if (dadosDoPaciente.endereco().cep() != null){
            this.logradouro = dadosDoPaciente.endereco().cep();}
        if (dadosDoPaciente.endereco().bairro() != null){
            this.logradouro = dadosDoPaciente.endereco().bairro();}
        if (dadosDoPaciente.endereco().logradouro() != null){
            this.logradouro = dadosDoPaciente.endereco().uf();}
        if (dadosDoPaciente.endereco().logradouro() != null){
            this.logradouro = dadosDoPaciente.endereco().numero();}
        if (dadosDoPaciente.endereco().uf() != null){
            this.uf = dadosDoPaciente.endereco().uf();
        }

    }
}
