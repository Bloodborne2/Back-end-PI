package projeto_integrador.estacionamento.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioEdicaoDTO {
    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String cpf;
    private String cep;
}
