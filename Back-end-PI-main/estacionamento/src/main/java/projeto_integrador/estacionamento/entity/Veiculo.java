package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veiculo")
    private Long id;

    @Column(nullable = false, length = 10)
    private String placa;

    @Column(length = 50)
    private String modelo;

    @Column(length = 50)
    private String marca;

    @Column(length = 20)
    private String cor;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Veiculo() {
    }

    public Veiculo(Long id, String placa, String modelo, String marca, String cor, Cliente cliente) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.cliente = cliente;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
