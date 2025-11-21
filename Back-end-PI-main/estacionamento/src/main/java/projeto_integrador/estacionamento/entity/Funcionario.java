package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcionario")
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(length = 14)
    private String cpf;

    @Column(length = 20)
    private String telefone;

    @Column(length = 100)
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "id_estacionamento")
    private Estacionamento estacionamento;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String cpf, String telefone, String cargo, Estacionamento estacionamento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.cargo = cargo;
        this.estacionamento = estacionamento;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
    }
}
