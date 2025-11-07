package treino.FK.application.dto.produto;

import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdutoRequestDTO {

    @NotBlank
    private String nome;

    @NotNull
    @Positive(message = "O preço NÃO pode ser negativo")
    private Double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public ProdutoRequestDTO(String nome, Double preco) {
        this.nome = nome;
        this.preco = preco;
    }
}
