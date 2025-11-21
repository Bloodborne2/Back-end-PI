package projeto_integrador.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Vaga;
import projeto_integrador.estacionamento.service.VagaService;

import java.util.List;

@RestController
@RequestMapping("/vagas")
@CrossOrigin(origins = "*")
public class VagaController {

    @Autowired
    private VagaService vagaService;


    @PostMapping
    public ResponseEntity<Vaga> criar(@RequestBody Vaga vaga,
                                      @RequestParam(required = false) Long estacionamentoId) {
        Vaga salva = vagaService.salvar(vaga, estacionamentoId);
        return ResponseEntity.ok(salva);
    }

    @GetMapping
    public ResponseEntity<List<Vaga>> listarTodos() {
        return ResponseEntity.ok(vagaService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscarPorId(@PathVariable Long id) {
        Vaga vaga = vagaService.buscarPorId(id);
        return ResponseEntity.ok(vaga);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vaga> atualizar(@PathVariable Long id,
                                          @RequestBody Vaga atualizada) {
        Vaga vaga = vagaService.atualizar(id, atualizada);
        return ResponseEntity.ok(vaga);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        vagaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
