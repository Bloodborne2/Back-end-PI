package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;

@Entity
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

    // Construtor vazio (obrigatório pelo JPA)
    public Veiculo() {
    }

    // Construtor completo (opcional)
    public Veiculo(Long id, String categoria, String placa, String montadora,
                   String modelo, Usuario usuario) {
        this.id = id;
        this.categoria = categoria;
        this.placa = placa;
        this.montadora = montadora;
        this.modelo = modelo;
        this.usuario = usuario;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
