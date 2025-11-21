package projeto_integrador.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Ticket;
import projeto_integrador.estacionamento.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    @Autowired
    private TicketService ticketService;


    @PostMapping
    public ResponseEntity<Ticket> criar(@RequestBody Ticket ticket,
                                        @RequestParam(required = false) Long reservaId) {
        Ticket salvo = ticketService.salvar(ticket, reservaId);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> listarTodos() {
        return ResponseEntity.ok(ticketService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> buscarPorId(@PathVariable Long id) {
        Ticket ticket = ticketService.buscarPorId(id);
        return ResponseEntity.ok(ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> atualizar(@PathVariable Long id,
                                            @RequestBody Ticket atualizado) {
        Ticket ticket = ticketService.atualizar(id, atualizado);
        return ResponseEntity.ok(ticket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        ticketService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
