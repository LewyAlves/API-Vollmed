package Voll.med.Primeira.Api.domain.pacientes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
