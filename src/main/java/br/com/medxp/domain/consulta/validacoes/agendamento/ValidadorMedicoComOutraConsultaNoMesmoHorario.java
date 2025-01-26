package br.com.medxp.domain.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.medxp.domain.ValidacaoException;
import br.com.medxp.domain.consulta.ConsultaRepository;
import br.com.medxp.domain.consulta.DadosAgendamentoConsulta;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

	@Autowired
	private ConsultaRepository repository;

	@Override
	public void validar(DadosAgendamentoConsulta dados) {
		var medicoPossuiOutraConsultaNoMesmoHorario = repository
				.existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(dados.idMedico(), dados.data());

		System.out.println("\n\nPassei pela validação de horário médico! " + medicoPossuiOutraConsultaNoMesmoHorario +  "\n\n");
		if (medicoPossuiOutraConsultaNoMesmoHorario) {
			throw new ValidacaoException("Médico já possui outra conssulta agendada nesse mesmo horário!");
		}
	}

}
