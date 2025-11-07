package treino.FK.application.dto.pedido;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoRequestDTO {

    private Long clienteId;

    private List<Long> produtosId;

    public PedidoRequestDTO(Long clienteId, List<Long> produtosId) {
        this.clienteId = clienteId;
        this.produtosId = produtosId;
    }

    public PedidoRequestDTO() {
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

}
