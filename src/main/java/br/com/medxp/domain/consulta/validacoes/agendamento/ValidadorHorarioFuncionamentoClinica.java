package br.com.medxp.domain.consulta.validacoes.agendamento;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import br.com.medxp.domain.ValidacaoException;
import br.com.medxp.domain.consulta.DadosAgendamentoConsulta;

@Component
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta {

	@Override
	public void validar(DadosAgendamentoConsulta dados) {
		var dataConsulta = dados.data();

		var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
		var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
		var depoisDoencerramentoDaClinica = dataConsulta.getHour() > 18;

		if (domingo || antesDaAberturaDaClinica || depoisDoencerramentoDaClinica) {
			throw new ValidacaoException("Consulta fora do horário de funcionamento da clínica!");
		}
	}

}
