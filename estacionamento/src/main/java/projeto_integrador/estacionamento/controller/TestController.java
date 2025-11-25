package projeto_integrador.estacionamento.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto_integrador.estacionamento.service.MensageriaWhatsAppService;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final MensageriaWhatsAppService whats;

    @GetMapping("/msg")
    public String enviar() {
        whats.enviarTexto("55SEUDDDNUMERO", "Teste via Spring Boot 🚗");
        return "ok";
    }
}
