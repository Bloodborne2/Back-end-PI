package projeto_integrador.estacionamento.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import projeto_integrador.estacionamento.DTO.VeiculoCadastroDTO;
import projeto_integrador.estacionamento.entity.Veiculo;
import projeto_integrador.estacionamento.repository.VeiculoRepository;
import projeto_integrador.estacionamento.service.JwtService;
import projeto_integrador.estacionamento.service.VeiculoService;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;
    private final JwtService jwtService;
    private final VeiculoRepository veiculoRepository;

    @PostMapping("/cadastrar")
    public Veiculo cadastrar(@RequestBody VeiculoCadastroDTO dto, HttpServletRequest request) {

        String token = request.getHeader("Authorization").replace("Bearer ", "");
        Long usuarioId = jwtService.extrairUserId(token);

        return veiculoService.cadastrarVeiculo(usuarioId, dto);
    }

    @GetMapping("/meus-veiculos")
    public List<Veiculo> listar(HttpServletRequest request) {

        String token = request.getHeader("Authorization").replace("Bearer ", "");
        Long usuarioId = jwtService.extrairUserId(token);

        return veiculoRepository.findByUsuarioId(usuarioId);
    }
}
