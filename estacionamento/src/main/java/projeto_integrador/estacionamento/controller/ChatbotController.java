package projeto_integrador.estacionamento.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.service.ChatbotService;

@RestController
@RequestMapping("/webhook/whatsapp")
@RequiredArgsConstructor
public class ChatbotController {

    private final ChatbotService chatbotService;

    @Value("${whatsapp.api.verify-token}")
    private String verifyToken;

    @GetMapping
    public ResponseEntity<String> validarWebhook(
            @RequestParam(name = "hub.mode", required = false) String mode,
            @RequestParam(name = "hub.verify_token", required = false) String token,
            @RequestParam(name = "hub.challenge", required = false) String challenge
    ) {
        if ("subscribe".equals(mode) && verifyToken.equals(token)) {
            return ResponseEntity.ok(challenge);
        }
        return ResponseEntity.status(403).body("Erro na validação do webhook");
    }

    @PostMapping
    public ResponseEntity<String> receberMensagem(@RequestBody String payload) {
        System.out.println(">>> POST /webhook/whatsapp recebido");
        chatbotService.processarWebhook(payload);
        return ResponseEntity.ok("EVENT_RECEIVED");
    }
}
