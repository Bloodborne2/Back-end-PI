package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoria;
    private String placa;
    private String montadora;
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario; // dono do veículo
}
