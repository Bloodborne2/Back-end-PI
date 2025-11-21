package projeto_integrador.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_integrador.estacionamento.entity.Cliente;
import projeto_integrador.estacionamento.entity.Veiculo;
import projeto_integrador.estacionamento.repository.ClienteRepository;
import projeto_integrador.estacionamento.repository.VeiculoRepository;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public Veiculo salvar(Veiculo veiculo, Long clienteId) {
        if (clienteId != null) {
            Cliente cliente = clienteRepository.findById(clienteId)
                    .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
            veiculo.setCliente(cliente);
        }
        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return veiculoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }

    public Veiculo atualizar(Long id, Veiculo atualizado) {
        Veiculo existente = buscarPorId(id);

        existente.setPlaca(atualizado.getPlaca());
        existente.setModelo(atualizado.getModelo());
        existente.setMarca(atualizado.getMarca());
        existente.setCor(atualizado.getCor());
        existente.setCliente(atualizado.getCliente());

        return veiculoRepository.save(existente);
    }

    public void deletar(Long id) {
        Veiculo v = buscarPorId(id);
        veiculoRepository.delete(v);
    }
}
