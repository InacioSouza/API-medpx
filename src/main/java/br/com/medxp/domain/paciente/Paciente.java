package br.com.medxp.domain.paciente;

import br.com.medxp.domain.endereco.Endereco;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Table(name = "pacientes")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;

	private String telefone;

	private String cpf;

	@Embedded
	private Endereco endereco;

	private boolean ativo;

	public void excluir() {
		this.ativo = false;
	}

	public Paciente(@Valid DadosCadastroPaciente dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.cpf = dados.cpf();
		this.endereco = new Endereco(dados.endereco());
	}

	public void atualizarInformacoes(DadosAtualizacaoPaciente dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
		if (dados.email() != null) {
			this.email = dados.email();
		}
		if (dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	}

}
