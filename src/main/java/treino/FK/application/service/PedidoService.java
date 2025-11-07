package treino.FK.application.service;

import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import treino.FK.application.dto.pedido.PedidoRequestDTO;
import treino.FK.application.dto.pedido.PedidoResponseDTO;
import treino.FK.domain.*;

import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final ClienteRepository clienteRepository;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, ClienteRepository clienteRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.clienteRepository = clienteRepository;
    }

    public PedidoResponseDTO criar(Long clienteId, List<Long> produtosId){
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow();
        List<Produto> produtos = produtoRepository.findAllById(produtosId);
        if (produtos.size() != produtosId.size()){
            throw new RuntimeException("Um ou mais produtos estão com o id invalido");
        }

        Pedido pedido = new Pedido(cliente, produtos);

        Pedido salvo = pedidoRepository.save(pedido);
        return new PedidoResponseDTO(salvo);
    }

    public Page<PedidoResponseDTO> listarTodos(Pageable pageable){
        return pedidoRepository.findAll(pageable).map(PedidoResponseDTO::new);
    }

}
