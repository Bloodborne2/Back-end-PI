package projeto_integrador.estacionamento.controller;


import lombok.RequiredArgsConstructor;
import org.hibernate.sql.results.internal.ResolvedSqlSelection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.DTO.ReservaRequestDTO;
import projeto_integrador.estacionamento.entity.Reserva;
import projeto_integrador.estacionamento.repository.ReservaRepository;
import projeto_integrador.estacionamento.service.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final ReservaService reservaService;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody ReservaRequestDTO dto){
        try {
            Reserva reserva = reservaService.criar(dto);
            return new ResponseEntity<>(reserva, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<Reserva>> ListarPorUsuario(@PathVariable Long usuarioId) {
        List<Reserva> reservas = reservaService.listarPorUsuario(usuarioId);
        return ResponseEntity.ok(reservas);
    }
}
