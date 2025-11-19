package com.medpro.medpro.infra.exception;

import java.util.List;

import org.hibernate.EntityFilterException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityFilterException.class)
    public ResponseEntity<Void> tratarErro404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<TratadorDeErros.DadosErroValidacao>> tratarErro404(
        MethodArgumentNotValidException e){
            var erros = e.getFieldError();
            return ResponseEntity
            .badRequest()
            .body(erros.stream().map(DadosErroValidacao::new).toList());
        }

        private record DadosErroValidacao(String campo, String mensagem) {
            public DadosErroValidacao(FieldError erro){
                
            }
        }
    
}
