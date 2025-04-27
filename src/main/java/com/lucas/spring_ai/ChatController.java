package com.lucas.spring_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Esta classe é um controlador REST, que responde a requisições HTTP
@RestController
public class ChatController {
    // Declara uma variável final para armazenar o ChatClient
    private final ChatClient chatClient;

    // Construtor da classe que recebe um ChatClient.Builder e cria uma instância de ChatClient
    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    // Mapeia requisições HTTP GET para o caminho "/ai"
    @GetMapping("/ai")
    String generation(String userInput) {
        // Usa o ChatClient para enviar a entrada do usuário para a IA
        // Cria um prompt, define o input do usuário, realiza a chamada, e retorna apenas o conteúdo da resposta
        return this.chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }
}
