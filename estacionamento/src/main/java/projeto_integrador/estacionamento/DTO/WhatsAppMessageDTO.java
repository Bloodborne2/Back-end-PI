package projeto_integrador.estacionamento.DTO;

public class WhatsAppMessageDTO {

    private String from;   // número do usuário (whatsapp)
    private String body;   // texto digitado
    private String waId;   // id interno do WhatsApp (opcional)

    public WhatsAppMessageDTO() {}

    public WhatsAppMessageDTO(String from, String body, String waId) {
        this.from = from;
        this.body = body;
        this.waId = waId;
    }

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public String getWaId() { return waId; }
    public void setWaId(String waId) { this.waId = waId; }
}
