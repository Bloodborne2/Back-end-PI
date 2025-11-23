package projeto_integrador.estacionamento.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import projeto_integrador.estacionamento.DTO.WhatsAppMessageDTO;


public class WhatsAppParser {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static WhatsAppMessageDTO parse(String payload) {
        try {
            JsonNode root = MAPPER.readTree(payload);

            JsonNode messagesNode = root.path("entry")
                    .get(0)
                    .path("changes")
                    .get(0)
                    .path("value")
                    .path("messages");

            if (messagesNode.isMissingNode() || !messagesNode.isArray() || messagesNode.isEmpty()) {
                return null; // pode ser um status de entrega, ignore
            }

            JsonNode msg = messagesNode.get(0);

            String from = msg.path("from").asText(null);
            String body = msg.path("text").path("body").asText(null);
            String waId = msg.path("id").asText(null);

            if (from == null || body == null) {
                return null;
            }

            return new WhatsAppMessageDTO(from, body, waId);
        } catch (Exception e) {
            // logar se quiser
            return null;
        }
    }
}
