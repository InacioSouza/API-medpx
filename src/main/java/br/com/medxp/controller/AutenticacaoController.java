package br.com.medxp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.medxp.domain.usuario.DadosAutenticacao;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;

	@PostMapping
	public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
		
		System.out.println("\\n\\n\\nEntrei no método pelo menos\n\n\n");

		// Recebemos um DTO no controller, mas devemos transformá-lo em um DTO
		// reconhecido pelo Spring
		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

		// Devolve um objeto que representa um usuário autenticado no sistema
		var authentication = manager.authenticate(token);

		return ResponseEntity.ok().build();
	}
}
