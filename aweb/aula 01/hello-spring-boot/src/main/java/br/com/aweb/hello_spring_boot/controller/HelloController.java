package br.com.aweb.hello_spring_boot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
public class HelloController {
    @GetMapping
    public String SayHello() {
        return "Ola mundo Spring Boot";
    }
    @GetMapping("/ola")
    public String SayHelloCustom() {
        return "ola endpoint especifico";
    }
    @GetMapping("/greet")
    public String greet(@RequestParam ("name")String username) {
        return "ola " +username+ "! bem vindo";
    }
    @GetMapping("/mensagem")
    public String mensagem(
        @RequestParam(required = false, defaultValue = "visitante") String username,
        @RequestParam(required = false, defaultValue = "pt") String idioma
        ) {
        
        return !idioma.equals("pt") ? "hello " +username+ " welcome" : "ola " +username+ " bemvindo";
    }
}
