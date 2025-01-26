package br.com.medxp.domain.consulta.validacoes.agendamento;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.com.medxp.domain.ValidacaoException;
import br.com.medxp.domain.consulta.DadosAgendamentoConsulta;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

	@Override
	public void validar(DadosAgendamentoConsulta dados) {
		var dataConsulta = dados.data();
		var agora = LocalDateTime.now();
		var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

		if (diferencaEmMinutos < 30) {
			throw new ValidacaoException("Consulta deve ser agendada com antecedência mínima de 30 minutos");
		}
	}

}
