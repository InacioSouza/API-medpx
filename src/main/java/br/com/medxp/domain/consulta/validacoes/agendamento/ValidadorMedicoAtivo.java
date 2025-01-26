package br.com.medxp.domain.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.medxp.domain.ValidacaoException;
import br.com.medxp.domain.consulta.DadosAgendamentoConsulta;
import br.com.medxp.domain.medico.MedicoRepository;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

	@Autowired
	private MedicoRepository repository;

	@Override
	public void validar(DadosAgendamentoConsulta dados) {

		if (dados.idMedico() == null) {
			return;
		}

		var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
		if (!medicoEstaAtivo) {
			throw new ValidacaoException("Consulta não pode ser agendada com médico excluído!");
		}
	}

}
