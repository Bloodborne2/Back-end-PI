package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ticket")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    @Column(name = "entrada")
    private LocalDateTime entrada;

    @Column(name = "saida")
    private LocalDateTime saida;

    @Column(name = "valor", precision = 10, scale = 2)
    private BigDecimal valor;

    public Ticket() {
    }

    public Ticket(Long id, Reserva reserva, LocalDateTime entrada, LocalDateTime saida, BigDecimal valor) {
        this.id = id;
        this.reserva = reserva;
        this.entrada = entrada;
        this.saida = saida;
        this.valor = valor;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public void setSaida(LocalDateTime saida) {
        this.saida = saida;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
