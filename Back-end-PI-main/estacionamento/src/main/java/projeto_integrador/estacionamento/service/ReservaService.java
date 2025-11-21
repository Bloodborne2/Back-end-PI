package projeto_integrador.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_integrador.estacionamento.entity.*;
import projeto_integrador.estacionamento.repository.*;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    public Reserva salvar(Reserva reserva,
                          Long clienteId,
                          Long veiculoId,
                          Long vagaId,
                          Long horarioId) {

        if (clienteId != null) {
            Cliente cliente = clienteRepository.findById(clienteId)
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            reserva.setCliente(cliente);
        }

        if (veiculoId != null) {
            Veiculo veiculo = veiculoRepository.findById(veiculoId)
                    .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
            reserva.setVeiculo(veiculo);
        }

        if (vagaId != null) {
            Vaga vaga = vagaRepository.findById(vagaId)
                    .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
            reserva.setVaga(vaga);
        }

        if (horarioId != null) {
            Horario horario = horarioRepository.findById(horarioId)
                    .orElseThrow(() -> new RuntimeException("Horário não encontrado"));
            reserva.setHorario(horario);
        }

        return reservaRepository.save(reserva);
    }

    public List<Reserva> listarTodos() {
        return reservaRepository.findAll();
    }

    public Reserva buscarPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
    }

    public Reserva atualizar(Long id, Reserva atualizado) {
        Reserva existente = buscarPorId(id);

        existente.setCliente(atualizado.getCliente());
        existente.setVeiculo(atualizado.getVeiculo());
        existente.setVaga(atualizado.getVaga());
        existente.setHorario(atualizado.getHorario());
        existente.setDataHoraReserva(atualizado.getDataHoraReserva());
        existente.setStatus(atualizado.getStatus());

        return reservaRepository.save(existente);
    }

    public void deletar(Long id) {
        Reserva reserva = buscarPorId(id);
        reservaRepository.delete(reserva);
    }
}
