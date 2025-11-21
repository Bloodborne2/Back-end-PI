package projeto_integrador.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Estacionamento;
import projeto_integrador.estacionamento.service.EstacionamentoService;

import java.util.List;

@RestController
@RequestMapping("/estacionamentos")
@CrossOrigin(origins = "*")
public class EstacionamentoController {

    @Autowired
    private EstacionamentoService estacionamentoService;

    @PostMapping
    public ResponseEntity<Estacionamento> criar(@RequestBody Estacionamento estacionamento) {
        Estacionamento salvo = estacionamentoService.salvar(estacionamento);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Estacionamento>> listarTodos() {
        return ResponseEntity.ok(estacionamentoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estacionamento> buscarPorId(@PathVariable Long id) {
        Estacionamento est = estacionamentoService.buscarPorId(id);
        return ResponseEntity.ok(est);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estacionamento> atualizar(@PathVariable Long id,
                                                    @RequestBody Estacionamento atualizado) {
        Estacionamento est = estacionamentoService.atualizar(id, atualizado);
        return ResponseEntity.ok(est);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        estacionamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
