package projeto_integrador.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Veiculo;
import projeto_integrador.estacionamento.service.VeiculoService;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin(origins = "*")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;


    @PostMapping
    public ResponseEntity<Veiculo> criar(@RequestBody Veiculo veiculo,
                                         @RequestParam(required = false) Long clienteId) {
        Veiculo salvo = veiculoService.salvar(veiculo, clienteId);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodos() {
        return ResponseEntity.ok(veiculoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        Veiculo v = veiculoService.buscarPorId(id);
        return ResponseEntity.ok(v);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id,
                                             @RequestBody Veiculo atualizado) {
        Veiculo v = veiculoService.atualizar(id, atualizado);
        return ResponseEntity.ok(v);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        veiculoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
