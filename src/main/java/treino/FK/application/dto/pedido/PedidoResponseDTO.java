package treino.FK.application.dto.pedido;

import treino.FK.domain.Pedido;
import treino.FK.domain.Produto;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponseDTO {
    private Long id;

    private Long clienteId;

    private List<Long> produtosId;

    private LocalDateTime data;

    public PedidoResponseDTO(Long id, Long clienteId, List<Long> produtosId, LocalDateTime data) {
        this.id = id;
        this.clienteId = clienteId;
        this.produtosId = produtosId;
        this.data = data;
    }

    public PedidoResponseDTO() {
    }

    public PedidoResponseDTO(Pedido salvo) {
        this.id = salvo.getId();
        this.clienteId = salvo.getCliente().getId();
        this.produtosId = salvo.getProdutos().stream().map(Produto::getId).toList();
        this.data = salvo.getData();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<Long> getProdutosId() {
        return produtosId;
    }

    public void setProdutosId(List<Long> produtosId) {
        this.produtosId = produtosId;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
