package projeto_integrador.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.entity.Cliente;
import projeto_integrador.estacionamento.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        Cliente salvo = clienteService.salvar(cliente);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarTodos() {
        return ResponseEntity.ok(clienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id,
                                             @RequestBody Cliente clienteAtualizado) {
        Cliente atualizado = clienteService.atualizar(id, clienteAtualizado);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
