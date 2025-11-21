package projeto_integrador.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_integrador.estacionamento.entity.Estacionamento;
import projeto_integrador.estacionamento.entity.Vaga;
import projeto_integrador.estacionamento.repository.EstacionamentoRepository;
import projeto_integrador.estacionamento.repository.VagaRepository;

import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public Vaga salvar(Vaga vaga, Long estacionamentoId) {
        if (estacionamentoId != null) {
            Estacionamento est = estacionamentoRepository.findById(estacionamentoId)
                    .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado"));
            vaga.setEstacionamento(est);
        }
        return vagaRepository.save(vaga);
    }

    public List<Vaga> listarTodos() {
        return vagaRepository.findAll();
    }

    public Vaga buscarPorId(Long id) {
        return vagaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
    }

    public Vaga atualizar(Long id, Vaga atualizada) {
        Vaga existente = buscarPorId(id);

        existente.setCodigo(atualizada.getCodigo());
        existente.setTipo(atualizada.getTipo());
        existente.setOcupada(atualizada.isOcupada());
        existente.setEstacionamento(atualizada.getEstacionamento());

        return vagaRepository.save(existente);
    }

    public void deletar(Long id) {
        Vaga vaga = buscarPorId(id);
        vagaRepository.delete(vaga);
    }
}
