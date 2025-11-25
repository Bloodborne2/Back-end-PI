package projeto_integrador.estacionamento.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import projeto_integrador.estacionamento.DTO.WhatsAppMessageDTO;
import projeto_integrador.estacionamento.entity.Usuario;
import projeto_integrador.estacionamento.repository.UsuarioRepository;
import projeto_integrador.estacionamento.util.WhatsAppParser;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatbotService {

    private final MensageriaWhatsAppService mensageriaWhatsAppService;
    private final UsuarioRepository usuarioRepository;
    // Futuro: ReservaService, VagaService, etc.

    public void processarWebhook(String payload) {
        WhatsAppMessageDTO msg = WhatsAppParser.parse(payload);

        System.out.println("=== PAYLOAD RECEBIDO ===");
        System.out.println(payload);

        if (msg == null) {
            System.out.println(">>> Mensagem ignorada (provavelmente status ou formato não suportado)");
            return;
        }

        System.out.printf(">>> De: %s | Texto: %s | waId: %s%n",
                msg.getFrom(), msg.getBody(), msg.getWaId());

        String telefone = normalizarTelefone(msg.getFrom());
        String texto = msg.getBody().trim();

        // 1. Verifica se usuário existe (usuário == cliente final)
        Optional<Usuario> usuarioOpt = usuarioRepository.findByTelefone(telefone);

        if (usuarioOpt.isEmpty()) {
            // Fluxo básico para quem ainda não está cadastrado (pelo menos o telefone já temos)
            mensageriaWhatsAppService.enviarTexto(telefone,
                    "Olá! Não encontrei seu cadastro no sistema.\n" +
                            "Acesse o app/web do estacionamento para se cadastrar, " +
                            "ou informe seus dados para um atendente.");
            return;
        }

        Usuario usuario = usuarioOpt.get();

        // MENU INICIAL
        if (isSaudacao(texto)) {
            enviarMenuInicial(telefone, usuario);
            return;
        }

        switch (texto) {
            case "1" -> tratarReserva(telefone, usuario);
            case "2" -> tratarListagemReservas(telefone, usuario);
            default -> mensageriaWhatsAppService.enviarTexto(telefone,
                    "Não entendi sua opção.\n" +
                            "Digite *oi* para ver o menu novamente.");
        }
    }

    private String normalizarTelefone(String from) {
        if (from == null) return null;
        return from.trim();
    }

    private boolean isSaudacao(String texto) {
        String t = texto.toLowerCase();
        return t.equals("oi") || t.equals("ola") || t.equals("olá") || t.equals("menu") || t.equals("hey");
    }

    private void enviarMenuInicial(String telefone, Usuario usuario) {
        String nome = usuario.getNome() != null ? usuario.getNome() : "";
        String mensagem = "Olá " + nome + " 👋\n" +
                "Bem-vindo ao *PI Estacionamento*.\n\n" +
                "Escolha uma opção:\n" +
                "1️⃣ Reservar vaga\n" +
                "2️⃣ Minhas reservas\n";
        mensageriaWhatsAppService.enviarTexto(telefone, mensagem);
    }

    private void tratarReserva(String telefone, Usuario usuario) {
        // integrar com Reserva/Vaga depois
        mensageriaWhatsAppService.enviarTexto(telefone,
                "Funcionalidade de *reserva de vaga* em desenvolvimento.\n" +
                        "Em breve você poderá escolher vaga e horário aqui pelo WhatsApp. 😉");
    }

    private void tratarListagemReservas(String telefone, Usuario usuario) {
        // integrar com ReservaService e ReservaStatus depois
        mensageriaWhatsAppService.enviarTexto(telefone,
                "Funcionalidade de *listar reservas* em desenvolvimento.\n" +
                        "Você verá aqui suas reservas ativas e histórico. 🚗");
    }
}
