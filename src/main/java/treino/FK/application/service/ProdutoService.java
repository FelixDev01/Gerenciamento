package treino.FK.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import treino.FK.application.dto.produto.ProdutoRequestDTO;
import treino.FK.application.dto.produto.ProdutoResponseDTO;
import treino.FK.application.dto.produto.ProdutoUpdateDTO;
import treino.FK.domain.Produto;
import treino.FK.domain.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ProdutoResponseDTO criar(ProdutoRequestDTO dto){
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        Produto salvo = repository.save(produto);
        return new ProdutoResponseDTO(salvo);
    }

    public ProdutoResponseDTO encontrarPorId(Long id){
        Produto produto = repository.findById(id)
                .orElseThrow();
        return new ProdutoResponseDTO(produto);
    }

    public Page<ProdutoResponseDTO> listarTodos(Pageable pageable){
        return repository.findAll(pageable).map(ProdutoResponseDTO::new);
    }

    @Transactional
    public ProdutoResponseDTO atualizar(Long id, ProdutoUpdateDTO dto){
        Produto produto = repository.findById(id)
                .orElseThrow();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        Produto atualizado = repository.save(produto);
        return new ProdutoResponseDTO(atualizado);
    }

    @Transactional
    public void delete(Long id){
        Produto produto = repository.findById(id)
                .orElseThrow();
        repository.delete(produto);
    }
}
