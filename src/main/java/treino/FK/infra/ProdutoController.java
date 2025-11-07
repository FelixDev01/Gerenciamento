package treino.FK.infra;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import treino.FK.application.dto.produto.ProdutoRequestDTO;
import treino.FK.application.dto.produto.ProdutoResponseDTO;
import treino.FK.application.dto.produto.ProdutoUpdateDTO;
import treino.FK.application.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;


    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> criar(@RequestBody @Valid ProdutoRequestDTO dto){
        ProdutoResponseDTO produtoCriado = service.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoResponseDTO>> listarTodos(Pageable pageable){
        Page<ProdutoResponseDTO> todosOsProdutos = service.listarTodos(pageable);
        return ResponseEntity.ok(todosOsProdutos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> encontrarPorId(@PathVariable Long id){
        ProdutoResponseDTO produtoEncontrado = service.encontrarPorId(id);
        return ResponseEntity.ok(produtoEncontrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoUpdateDTO dto){
        ProdutoResponseDTO produtoAtualizado = service.atualizar(id, dto);
        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
