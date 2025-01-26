package br.com.medxp.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.medxp.domain.ValidacaoException;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErros {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<String> tratarErro404() {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(ValidacaoException.class)
	public ResponseEntity<?> tratarErroRegraDeNegócio(ValidacaoException ex) {
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

}
