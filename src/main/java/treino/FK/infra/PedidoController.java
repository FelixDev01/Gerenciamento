package treino.FK.infra;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import treino.FK.application.dto.pedido.PedidoResponseDTO;
import treino.FK.application.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO>  criarPedido(@RequestBody PedidoResponseDTO dto){
        PedidoResponseDTO pedidoCriado = service.criar(dto.getClienteId(), dto.getProdutosId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Page<PedidoResponseDTO>> listarPedidos(Pageable pageable){
        Page<PedidoResponseDTO> pedidos = service.listarTodos(pageable);
        return ResponseEntity.ok(pedidos);
    }
}
