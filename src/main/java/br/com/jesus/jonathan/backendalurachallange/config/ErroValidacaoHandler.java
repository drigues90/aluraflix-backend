package br.com.jesus.jonathan.backendalurachallange.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.jesus.jonathan.backendalurachallange.response.ErroValidacaoResponse;

@RestControllerAdvice
public class ErroValidacaoHandler {

	@Autowired
	private MessageSource messageSource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroValidacaoResponse> handle(MethodArgumentNotValidException exception) {
		List<FieldError> fieldError = exception.getBindingResult().getFieldErrors();
		List<ErroValidacaoResponse> erros = new ArrayList<>();

		fieldError.forEach(e -> {
			String messagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			erros.add(new ErroValidacaoResponse(e.getField(), messagem));
		});
		return erros;
	}
}
