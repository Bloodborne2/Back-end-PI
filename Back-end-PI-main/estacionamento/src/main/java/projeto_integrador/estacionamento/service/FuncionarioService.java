package projeto_integrador.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_integrador.estacionamento.entity.Estacionamento;
import projeto_integrador.estacionamento.entity.Funcionario;
import projeto_integrador.estacionamento.repository.EstacionamentoRepository;
import projeto_integrador.estacionamento.repository.FuncionarioRepository;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public Funcionario salvar(Funcionario funcionario, Long estacionamentoId) {
        if (estacionamentoId != null) {
            Estacionamento est = estacionamentoRepository.findById(estacionamentoId)
                    .orElseThrow(() -> new RuntimeException("Estacionamento não encontrado"));
            funcionario.setEstacionamento(est);
        }
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    public Funcionario atualizar(Long id, Funcionario atualizado) {
        Funcionario existente = buscarPorId(id);

        existente.setNome(atualizado.getNome());
        existente.setCpf(atualizado.getCpf());
        existente.setTelefone(atualizado.getTelefone());
        existente.setCargo(atualizado.getCargo());
        existente.setEstacionamento(atualizado.getEstacionamento());

        return funcionarioRepository.save(existente);
    }

    public void deletar(Long id) {
        Funcionario f = buscarPorId(id);
        funcionarioRepository.delete(f);
    }
}
