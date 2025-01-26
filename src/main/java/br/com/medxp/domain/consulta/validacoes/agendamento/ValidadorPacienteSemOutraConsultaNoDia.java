package br.com.medxp.domain.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.medxp.domain.ValidacaoException;
import br.com.medxp.domain.consulta.ConsultaRepository;
import br.com.medxp.domain.consulta.DadosAgendamentoConsulta;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {

	@Autowired
	private ConsultaRepository repository;

	@Override
	public void validar(DadosAgendamentoConsulta dados) {
		var primeiroHorario = dados.data().withHour(7);
		var ultimoHorario = dados.data().withHour(18);
		var pacientePossuiOutraConsultaNoDia = repository.existsByPacienteIdAndDataBetween(dados.idPaciente(),
				primeiroHorario, ultimoHorario);

		if (pacientePossuiOutraConsultaNoDia) {
			throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
		}
	}

}
