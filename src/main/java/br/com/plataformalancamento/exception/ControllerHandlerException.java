package br.com.plataformalancamento.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.plataformalancamento.utility.DateUtility;

/**
 * Responsavel por personalizar uma determinada exception
 */
@ControllerAdvice
public class ControllerHandlerException {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ConfiguradorErrorException> objectNotFoundException(ObjectNotFoundException objectNotFoundException, ServletRequest servletRequest) {
        ConfiguradorErrorException configuradorErrorException = new ConfiguradorErrorException(DateUtility.gerarDataHoraAtualFormatoDDMMAAAAHHMMSS(), HttpStatus.NOT_FOUND, objectNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(configuradorErrorException);
    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ConfiguradorErrorException> dataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException, ServletRequest servletRequest) {
        ConfiguradorErrorException configuradorErrorException = new ConfiguradorErrorException(DateUtility.gerarDataHoraAtualFormatoDDMMAAAAHHMMSS(), HttpStatus.BAD_REQUEST, dataIntegrityViolationException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(configuradorErrorException);
    }
    
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ConfiguradorErrorException> emptyResultDataAccessException(EmptyResultDataAccessException emptyResultDataAccessException, ServletRequest servletRequest) {
        ConfiguradorErrorException configuradorErrorException = new ConfiguradorErrorException(DateUtility.gerarDataHoraAtualFormatoDDMMAAAAHHMMSS(), HttpStatus.NO_CONTENT, emptyResultDataAccessException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(configuradorErrorException);
    }

}
