package projeto_integrador.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_integrador.estacionamento.entity.Estacionamento;
import projeto_integrador.estacionamento.repository.EstacionamentoRepository;

import java.util.List;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public Estacionamento salvar(Estacionamento estacionamento) {
        return estacionamentoRepository.save(estacionamento);
    }

    public List<Estacionamento> listarTodos() {
        return estacionamentoRepository.findAll();
    }

    public Estacionamento buscarPorId(Long id) {
        return estacionamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado"));
    }

    public Estacionamento atualizar(Long id, Estacionamento atualizado) {
        Estacionamento existente = buscarPorId(id);

        existente.setNome(atualizado.getNome());
        existente.setEndereco(atualizado.getEndereco());
        existente.setCnpj(atualizado.getCnpj());

        return estacionamentoRepository.save(existente);
    }

    public void deletar(Long id) {
        Estacionamento est = buscarPorId(id);
        estacionamentoRepository.delete(est);
    }
}
