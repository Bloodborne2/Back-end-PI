package projeto_integrador.estacionamento.controller;

import projeto_integrador.estacionamento.DTO.*;
import projeto_integrador.estacionamento.entity.Usuario;
import projeto_integrador.estacionamento.service.AuthService;
import projeto_integrador.estacionamento.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/usuarios")  // prefixo para evitar conflitos
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final AuthService authService;

    // Injeção de dependência do Service
    public UsuarioController(UsuarioService usuarioService, AuthService authService) {
        this.usuarioService = usuarioService;
        this.authService = authService;
    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrar(@RequestBody @Valid UsuarioCadastroDTO dto) {
        try {
            Usuario usuarioSalvo = usuarioService.cadastrarUsuario(dto);
            return new ResponseEntity<>("Usuário cadastrado com sucesso!", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao tentar cadastrar o usuário.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginRequestDTO request) {
        try {
            LoginResponseDTO response = authService.autenticar(request);
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException | IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro interno ao tentar fazer login.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/me")
    public UsuarioDTO getUsuarioLogado(@RequestParam String email) {
        Usuario usuario = usuarioService.buscarPorEmail(email);
        return new UsuarioDTO(
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getCep(),
                usuario.getTelefone(),
                usuario.getEndereco()
        );
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> listarTodos() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }
}
