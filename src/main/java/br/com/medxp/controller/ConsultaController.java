package br.com.medxp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.medxp.domain.consulta.AgendaDeConsultas;
import br.com.medxp.domain.consulta.ConsultaRepository;
import br.com.medxp.domain.consulta.DadosAgendamentoConsulta;
import br.com.medxp.domain.consulta.DadosCancelamentoConsulta;
import br.com.medxp.domain.consulta.DadosDetalhamentoConsulta;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("consultas")
@SecurityRequirement(name = "bearer-key")
public class ConsultaController {

	@Autowired
	private AgendaDeConsultas agenda;

	@Autowired
	private ConsultaRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<?> agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
		var dto = agenda.agendar(dados);
		return ResponseEntity.ok(dto);
	}

	@GetMapping
	@Transactional
	public ResponseEntity<Page<DadosDetalhamentoConsulta>> listar(
			@PageableDefault(size = 10, sort = { "data" }) Pageable paginacao) {
		var page = repository.findAll(paginacao).map(DadosDetalhamentoConsulta::new);
		return ResponseEntity.ok(page);
	}

	@DeleteMapping
	@Transactional
	public ResponseEntity<?> cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
		agenda.cancelar(dados);
		return ResponseEntity.noContent().build();
	}
}
