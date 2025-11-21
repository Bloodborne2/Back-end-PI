package projeto_integrador.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_integrador.estacionamento.entity.Reserva;
import projeto_integrador.estacionamento.entity.Ticket;
import projeto_integrador.estacionamento.repository.ReservaRepository;
import projeto_integrador.estacionamento.repository.TicketRepository;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    public Ticket salvar(Ticket ticket, Long reservaId) {
        if (reservaId != null) {
            Reserva reserva = reservaRepository.findById(reservaId)
                    .orElseThrow(() -> new RuntimeException("Reserva não encontrada"));
            ticket.setReserva(reserva);
        }
        return ticketRepository.save(ticket);
    }

    public List<Ticket> listarTodos() {
        return ticketRepository.findAll();
    }

    public Ticket buscarPorId(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket não encontrado"));
    }

    public Ticket atualizar(Long id, Ticket atualizado) {
        Ticket existente = buscarPorId(id);

        existente.setReserva(atualizado.getReserva());
        existente.setEntrada(atualizado.getEntrada());
        existente.setSaida(atualizado.getSaida());
        existente.setValor(atualizado.getValor());

        return ticketRepository.save(existente);
    }

    public void deletar(Long id) {
        Ticket ticket = buscarPorId(id);
        ticketRepository.delete(ticket);
    }
}
