package br.com.erudio.model;
// Define o pacote onde esse arquivo está (boa prática de organização)

public record Greeting(long id, String content) { }
// 'record' é uma estrutura do Java que cria automaticamente um construtor, getters, equals, hashCode e toString.
// Aqui estamos definindo que a resposta da nossa API terá dois campos:
// - id: identificador numérico da saudação
// - content: a mensagem de saudação (ex: "Hello, Arthur!")
