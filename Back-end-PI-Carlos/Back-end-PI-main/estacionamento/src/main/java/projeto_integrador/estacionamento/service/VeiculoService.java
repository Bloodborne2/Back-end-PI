package projeto_integrador.estacionamento.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import projeto_integrador.estacionamento.DTO.VeiculoCadastroDTO;
import projeto_integrador.estacionamento.entity.Usuario;
import projeto_integrador.estacionamento.entity.Veiculo;
import projeto_integrador.estacionamento.repository.UsuarioRepository;
import projeto_integrador.estacionamento.repository.VeiculoRepository;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final UsuarioRepository usuarioRepository;

    public Veiculo cadastrarVeiculo(Long usuarioId, VeiculoCadastroDTO dto) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Veiculo veiculo = new Veiculo();
        veiculo.setCategoria(dto.getCategoria());
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setMontadora(dto.getMontadora());
        veiculo.setModelo(dto.getModelo());
        veiculo.setUsuario(usuario);

        return veiculoRepository.save(veiculo);
    }
}
