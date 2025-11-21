package projeto_integrador.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projeto_integrador.estacionamento.entity.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
}
