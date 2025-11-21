package projeto_integrador.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Horario;
import projeto_integrador.estacionamento.service.HorarioService;

import java.util.List;

@RestController
@RequestMapping("/horarios")
@CrossOrigin(origins = "*")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @PostMapping
    public ResponseEntity<Horario> criar(@RequestBody Horario horario) {
        Horario salvo = horarioService.salvar(horario);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Horario>> listarTodos() {
        return ResponseEntity.ok(horarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> buscarPorId(@PathVariable Long id) {
        Horario h = horarioService.buscarPorId(id);
        return ResponseEntity.ok(h);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> atualizar(@PathVariable Long id,
                                             @RequestBody Horario atualizado) {
        Horario h = horarioService.atualizar(id, atualizado);
        return ResponseEntity.ok(h);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        horarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
