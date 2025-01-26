package br.com.medxp.domain.consulta;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.validation.constraints.NotNull;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

	boolean existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(Long idMedico, LocalDateTime data);

	boolean existsByPacienteIdAndDataBetween(Long idPaciente, LocalDateTime primeiroHorario,
			LocalDateTime ultimoHorario);

}
