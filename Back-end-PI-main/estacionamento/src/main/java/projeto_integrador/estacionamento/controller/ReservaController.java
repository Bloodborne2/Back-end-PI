package projeto_integrador.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Reserva;
import projeto_integrador.estacionamento.service.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> criar(@RequestBody Reserva reserva,
                                         @RequestParam(required = false) Long clienteId,
                                         @RequestParam(required = false) Long veiculoId,
                                         @RequestParam(required = false) Long vagaId,
                                         @RequestParam(required = false) Long horarioId) {

        Reserva salva = reservaService.salvar(reserva, clienteId, veiculoId, vagaId, horarioId);
        return ResponseEntity.ok(salva);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> listarTodos() {
        return ResponseEntity.ok(reservaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarPorId(@PathVariable Long id) {
        Reserva reserva = reservaService.buscarPorId(id);
        return ResponseEntity.ok(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> atualizar(@PathVariable Long id,
                                             @RequestBody Reserva atualizado) {
        Reserva reserva = reservaService.atualizar(id, atualizado);
        return ResponseEntity.ok(reserva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        reservaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
