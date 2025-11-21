package projeto_integrador.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_integrador.estacionamento.entity.Cliente;
import projeto_integrador.estacionamento.repository.ClienteRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        Cliente existente = buscarPorId(id);

        existente.setNome(clienteAtualizado.getNome());
        existente.setCpf(clienteAtualizado.getCpf());
        existente.setTelefone(clienteAtualizado.getTelefone());
        existente.setEmail(clienteAtualizado.getEmail());

        return clienteRepository.save(existente);
    }

    public void deletar(Long id) {
        Cliente cliente = buscarPorId(id);
        clienteRepository.delete(cliente);
    }
}
