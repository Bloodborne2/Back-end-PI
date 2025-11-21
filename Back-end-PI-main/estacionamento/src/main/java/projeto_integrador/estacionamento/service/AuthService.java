package projeto_integrador.estacionamento.service;

import lombok.Data;
import projeto_integrador.estacionamento.DTO.LoginRequestDTO;
import projeto_integrador.estacionamento.DTO.LoginResponseDTO;
import projeto_integrador.estacionamento.entity.Usuario;
import projeto_integrador.estacionamento.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.NoSuchElementException;

@Service
@Data
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService; // Serviço para gerar o JWT

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public LoginResponseDTO autenticar(LoginRequestDTO request) {
        // 1. Buscar o usuário pelo email
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NoSuchElementException("Email ou senha inválidos."));

        // 2. Verificar a senha (hash)
        if (!passwordEncoder.matches(request.getSenha(), usuario.getSenhaHash())) {
            throw new IllegalArgumentException("Email ou senha inválidos.");
        }

        // 3. Gerar o JWT (o token que mantém a sessão)
        String jwtToken = jwtService.generateToken(usuario.getEmail());

        // 4. Retornar DTO de resposta com o token
        return new LoginResponseDTO(jwtToken, usuario.getNome(), usuario.getEmail());
    }
}