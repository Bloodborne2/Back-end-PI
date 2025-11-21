package projeto_integrador.estacionamento.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "estacionamento")
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estacionamento")
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 255)
    private String endereco;

    @Column(length = 18)
    private String cnpj;

    public Estacionamento() {
    }

    public Estacionamento(Long id, String nome, String endereco, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cnpj = cnpj;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
