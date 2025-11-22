package projeto_integrador.estacionamento.service;

import projeto_integrador.estacionamento.DTO.UsuarioCadastroDTO;
import projeto_integrador.estacionamento.entity.Usuario;
import projeto_integrador.estacionamento.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    // Injeção de dependência via construtor
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Usuario cadastrarUsuario(UsuarioCadastroDTO dto) {

        // 1. Verificação de Duplicidade
        if (usuarioRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email já cadastrado.");
        }

        if (usuarioRepository.findByCpf(dto.getCpf()).isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }

        // 2. Criptografar Senha
        String senhaCriptografada = passwordEncoder.encode(dto.getSenha());

        // 3. Mapear DTO para Entity
        Usuario novoUsuario = new Usuario(
                dto.getNome(),
                dto.getEmail(),
                dto.getCpf(),
                dto.getCep(),
                dto.getTelefone(),
                dto.getEndereco(),
                senhaCriptografada
        );

        return usuarioRepository.save(novoUsuario);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}