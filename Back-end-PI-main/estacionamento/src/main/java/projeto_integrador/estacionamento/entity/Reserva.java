package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "id_vaga")
    private Vaga vaga;

    @ManyToOne
    @JoinColumn(name = "id_horario")
    private Horario horario;

    @Column(name = "data_hora_reserva")
    private LocalDateTime dataHoraReserva;

    @Column(name = "status", length = 20)
    private String status; // ATIVA, CANCELADA, CONCLUIDA...

    public Reserva() {
    }

    public Reserva(Long id, Cliente cliente, Veiculo veiculo, Vaga vaga, Horario horario,
                   LocalDateTime dataHoraReserva, String status) {
        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.horario = horario;
        this.dataHoraReserva = dataHoraReserva;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public LocalDateTime getDataHoraReserva() {
        return dataHoraReserva;
    }

    public void setDataHoraReserva(LocalDateTime dataHoraReserva) {
        this.dataHoraReserva = dataHoraReserva;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
