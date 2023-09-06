package com.example.produtoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class ProdutoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProdutoApiApplication.class, args);
    }
    @GetMapping("/")
    public String funciona(){
        return "EU SOU MT BOM";
    }
}
