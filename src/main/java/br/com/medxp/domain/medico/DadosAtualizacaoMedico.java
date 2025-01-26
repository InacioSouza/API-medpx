package br.com.medxp.domain.medico;

import br.com.medxp.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(@NotNull Long id, String nome, String email, String telefone,
		Especialidade especialidade, DadosEndereco endereco) {

}
