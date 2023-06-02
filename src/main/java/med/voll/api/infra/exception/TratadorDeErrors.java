package med.voll.api.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class TratadorDeErrors {
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity idNotExist() {
		return ResponseEntity.notFound().build();
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity error400 (MethodArgumentNotValidException ex) {
		var erros = ex.getFieldErrors();
		return ResponseEntity.badRequest().body(erros.stream().map(MessageError::new).toList());
	}
	
	private record MessageError (String campo, String message) {
		public MessageError (FieldError erro) {
			this(erro.getField(), erro.getDefaultMessage());
		}
	}
}
