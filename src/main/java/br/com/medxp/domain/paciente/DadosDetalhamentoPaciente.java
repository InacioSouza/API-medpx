package br.com.medxp.domain.paciente;

import br.com.medxp.domain.endereco.Endereco;

public record DadosDetalhamentoPaciente(Long id, String nome, String email, String cpf, String telefone,
		Endereco endereco) {

	public DadosDetalhamentoPaciente(Paciente paciente) {
		this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(),
				paciente.getEndereco());
	}

}
