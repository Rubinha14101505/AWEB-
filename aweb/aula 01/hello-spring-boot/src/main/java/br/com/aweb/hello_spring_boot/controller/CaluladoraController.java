package br.com.aweb.hello_spring_boot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class CaluladoraController {
    @GetMapping("/calcular")
    public String calcular(
        @RequestParam Integer num1,
        @RequestParam Integer num2,
        @RequestParam(required = false, defaultValue = "soma" ) String op 
        ) {
        if (op.equals("subtracao"))
            return "resultado " + (num1 - num2);    
        return "resultafo " + (num1 + num2);
    }
    
}
