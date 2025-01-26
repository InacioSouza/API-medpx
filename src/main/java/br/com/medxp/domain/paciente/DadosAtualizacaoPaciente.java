package br.com.medxp.domain.paciente;

import br.com.medxp.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(@NotNull Long id, String nome, String telefone, String email,
		DadosEndereco endereco) {

}
