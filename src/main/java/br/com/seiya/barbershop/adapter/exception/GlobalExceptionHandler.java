package br.com.seiya.barbershop.adapter.exception;

import java.util.ArrayList;
import java.util.List;

import br.com.seiya.barbershop.adapter.data.exceptions.IdJaCadastradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.seiya.barbershop.adapter.data.exceptions.IdNaoEncontradoException;
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IdNaoEncontradoException.class)
	public ResponseEntity<Object> idNaoEncontrado(Exception e) {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler(IdJaCadastradoException.class)
	public ResponseEntity<Object> IdJaCadastrado(Exception e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> methodArgumentNotValidException(MethodArgumentNotValidException e) {
		List<String> campos = new ArrayList<>();
		e.getFieldErrors().stream().forEach(er -> campos.add(er.getField()));
		return ResponseEntity.badRequest().body("Os seguintes campos não são válidos:\n" + campos + "\n");
	}

}
