package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vaga")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaga")
    private Long id;

    @Column(name = "codigo", nullable = false, length = 20)
    private String codigo;

    @Column(name = "tipo", length = 20)
    private String tipo; // carro, moto, etc.

    @Column(name = "ocupada")
    private boolean ocupada;

    @ManyToOne
    @JoinColumn(name = "id_estacionamento")
    private Estacionamento estacionamento;

    public Vaga() {
    }

    public Vaga(Long id, String codigo, String tipo, boolean ocupada, Estacionamento estacionamento) {
        this.id = id;
        this.codigo = codigo;
        this.tipo = tipo;
        this.ocupada = ocupada;
        this.estacionamento = estacionamento;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }
}
