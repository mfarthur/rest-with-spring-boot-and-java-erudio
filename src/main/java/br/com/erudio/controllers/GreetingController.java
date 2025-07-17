package br.com.erudio.controllers;
// Define o pacote onde esse controller está localizado

import br.com.erudio.model.Greeting;
// Importa o model Greeting, que será retornado como resposta

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// Importa as anotações do Spring necessárias para criar a rota da API

import java.util.concurrent.atomic.AtomicLong;
// Importa o AtomicLong, que será usado para gerar um contador único e seguro em múltiplas threads

@RestController
// Anotação que diz ao Spring que esta classe vai atender requisições REST
// Os métodos aqui retornarão dados (geralmente em JSON), e não uma página HTML
public class GreetingController {

    private static final String template = "Hello, %s!";
    // Uma string com formato, onde %s será substituído pelo nome fornecido na requisição

    private final AtomicLong counter = new AtomicLong();
    // Contador que será incrementado a cada requisição para gerar um ID único

    // Exemplo de chamada: http://localhost:8080/greeting?name=Arthur
    @RequestMapping("/greeting")
    // Mapeia a URL /greeting para esse método
    public Greeting greeting(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        // @RequestParam indica que vamos receber um parâmetro chamado 'name' na URL
        // Se não for enviado nenhum nome, será usado "World" como valor padrão

        return new Greeting(
                counter.incrementAndGet(), // incrementa o contador e usa como ID
                String.format(template, name) // formata a string usando o nome recebido
        );
        // Retorna um novo objeto Greeting com ID e mensagem personalizada
    }
}
