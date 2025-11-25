package projeto_integrador.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import projeto_integrador.estacionamento.entity.Horario;

import java.time.LocalDateTime;
import java.util.Optional;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    // Busca um horário existente pelo intervalo exato (usado no ReservaService)
    Optional<Horario> findByInicioAndFim(LocalDateTime inicio, LocalDateTime fim);
}
