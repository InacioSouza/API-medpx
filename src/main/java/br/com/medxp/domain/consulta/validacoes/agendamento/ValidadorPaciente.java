package br.com.medxp.domain.consulta.validacoes.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.medxp.domain.ValidacaoException;
import br.com.medxp.domain.consulta.DadosAgendamentoConsulta;
import br.com.medxp.domain.paciente.PacienteRepository;

@Component
public class ValidadorPaciente implements ValidadorAgendamentoDeConsulta {

	@Autowired
	private PacienteRepository repository;

	@Override
	public void validar(DadosAgendamentoConsulta dados) {
		var pacienteEstaAtivo = repository.findAtivoById(dados.idPaciente());
		if (!pacienteEstaAtivo) {
			throw new ValidacaoException("Consulta não pode ser agendada com paciente excluído!");
		}
	}

}
