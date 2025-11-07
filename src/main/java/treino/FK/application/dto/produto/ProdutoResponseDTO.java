package treino.FK.application.dto.produto;

import treino.FK.domain.Produto;

public class ProdutoResponseDTO {

    private Long id;

    private String nome;

    private Double preco;

    public ProdutoResponseDTO(Long id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public ProdutoResponseDTO(Produto salvo) {
        this.id = salvo.getId();
        this.nome = salvo.getNome();
        this.preco = salvo.getPreco();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
