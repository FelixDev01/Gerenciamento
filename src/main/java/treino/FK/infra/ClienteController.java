package treino.FK.infra;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import treino.FK.application.dto.cliente.ClienteRequestDTO;
import treino.FK.application.dto.cliente.ClienteResponseDTO;
import treino.FK.application.dto.cliente.ClienteUpdateDTO;
import treino.FK.application.service.ClienteService;
import treino.FK.domain.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {


    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(@RequestBody @Valid ClienteRequestDTO dto){
        ClienteResponseDTO clienteCriado = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Page<ClienteResponseDTO>> listarTodos(Pageable pageable){
        Page<ClienteResponseDTO> listar = service.listarTodos(pageable);
        return ResponseEntity.ok(listar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> encontrarPorId(@PathVariable Long id){
        ClienteResponseDTO clienteEncontrado = service.buscarPorId(id);
        return ResponseEntity.ok(clienteEncontrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> atualizar(@PathVariable Long id, @Valid ClienteUpdateDTO dto){
        ClienteResponseDTO clienteAtualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(clienteAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
