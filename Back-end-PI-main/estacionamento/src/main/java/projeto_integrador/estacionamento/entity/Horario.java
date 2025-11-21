package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Long id;

    @Column(name = "descricao", length = 100)
    private String descricao;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fim")
    private LocalTime horaFim;

    public Horario() {
    }

    public Horario(Long id, String descricao, LocalTime horaInicio, LocalTime horaFim) {
        this.id = id;
        this.descricao = descricao;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
}
