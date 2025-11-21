package projeto_integrador.estacionamento.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projeto_integrador.estacionamento.entity.Horario;
import projeto_integrador.estacionamento.repository.HorarioRepository;

import java.util.List;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    public Horario salvar(Horario horario) {
        return horarioRepository.save(horario);
    }

    public List<Horario> listarTodos() {
        return horarioRepository.findAll();
    }

    public Horario buscarPorId(Long id) {
        return horarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horário não encontrado"));
    }

    public Horario atualizar(Long id, Horario atualizado) {
        Horario existente = buscarPorId(id);

        existente.setDescricao(atualizado.getDescricao());
        existente.setHoraInicio(atualizado.getHoraInicio());
        existente.setHoraFim(atualizado.getHoraFim());

        return horarioRepository.save(existente);
    }

    public void deletar(Long id) {
        Horario horario = buscarPorId(id);
        horarioRepository.delete(horario);
    }
}
