package Voll.med.Primeira.Api.domain.medicos;

import Voll.med.Primeira.Api.domain.consultas.Consulta;
import Voll.med.Primeira.Api.domain.enderecos.DadosEndereco;
import Voll.med.Primeira.Api.domain.pacientes.DadosPacientes;
import Voll.med.Primeira.Api.domain.pacientes.Paciente;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicoRepositoryTest {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private EntityManager em;




    @Test
    @DisplayName("Deveria devolver null quando unico medico cadastrado não está disponível na data")
    void escolherMedicoAleatorioDisponivelNaDataCenario1() {
        //given ou arrange
        var proximaSegundaAs10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10,00);
        var medico = cadastrarMedico("Medico", "medico@vollmed.com", "123456", Especialidade.Cardiologia);
        var paciente = cadastrarPaciente("Paciente", "paciente@vollmed.com", "00000000000");
        cadastrarConsulta(medico, paciente, proximaSegundaAs10);

        //when ou act
       var medicoLivre = medicoRepository.escolherMedicoAleatorioDisponivelNaData(Especialidade.Cardiologia, proximaSegundaAs10);

       //then ou assert
       assertThat(medicoLivre).isNull();
    }

    @Test
    @DisplayName("Deveria devolver medico quando ele estiver disponivel na data")
    void escolherMedicoAleatorioDisponivelNaDataCenario2() {
        var proximaSegundaAs10 = LocalDateTime.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        var medico = cadastrarMedico("Medico", "medico@vollmed.com", "123456", Especialidade.Cardiologia);

        var medicoLivre = medicoRepository.escolherMedicoAleatorioDisponivelNaData(Especialidade.Cardiologia, proximaSegundaAs10);
        assertThat(medicoLivre).isEqualTo(medico);
    }



    private void cadastrarConsulta(Medico medico, Paciente paciente, LocalDateTime data) {
        em.persist(new Consulta(null, medico, paciente, data));
    }
    private Medico cadastrarMedico(String nome, String email, String crm, Especialidade especialidade) {
        var medico = new Medico(dadosMedico(nome, email, crm, especialidade));
        em.persist(medico);
        return medico;
    }

    private Paciente cadastrarPaciente(String nome, String email, String cpf) {
        var paciente = new Paciente(dadosPaciente(nome, email, cpf));
        em.persist(paciente);
        return paciente;
    }

    private DadosMedicos dadosMedico(String nome, String email, String crm, Especialidade especialidade) {
        return new DadosMedicos(
                nome,
                email,
                "61999999999",
                crm,
                especialidade,
                dadosEndereco()
        );
    }

    private DadosPacientes dadosPaciente(String nome, String email, String cpf) {
        return new DadosPacientes(
                nome,
                email,
                "61999999999",
                cpf,
                dadosEndereco()
        );
    }

    private DadosEndereco dadosEndereco() {
        return new DadosEndereco(
                "rua xpto",
                "bairro",
                "00000000",
                "Brasilia",
                "DF",
                null,
                null
        );
    }
}