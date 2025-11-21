package projeto_integrador.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Funcionario;
import projeto_integrador.estacionamento.service.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
@CrossOrigin(origins = "*")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    // aq cria funcionário vinculando a um estacionamento via ?estacionamentoId=1
    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario,
                                             @RequestParam(required = false) Long estacionamentoId) {
        Funcionario salvo = funcionarioService.salvar(funcionario, estacionamentoId);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodos() {
        return ResponseEntity.ok(funcionarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        Funcionario f = funcionarioService.buscarPorId(id);
        return ResponseEntity.ok(f);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id,
                                                 @RequestBody Funcionario atualizado) {
        Funcionario f = funcionarioService.atualizar(id, atualizado);
        return ResponseEntity.ok(f);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
