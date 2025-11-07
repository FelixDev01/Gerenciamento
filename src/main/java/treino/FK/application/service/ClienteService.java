package treino.FK.application.service;

import ch.qos.logback.core.net.server.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import treino.FK.application.dto.cliente.ClienteRequestDTO;
import treino.FK.application.dto.cliente.ClienteResponseDTO;
import treino.FK.application.dto.cliente.ClienteUpdateDTO;
import treino.FK.domain.Cliente;
import treino.FK.domain.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }
    @Transactional
    public ClienteResponseDTO criar(ClienteRequestDTO dto){
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        Cliente criado = repository.save(cliente);

        return new ClienteResponseDTO(criado);
    }

    public ClienteResponseDTO buscarPorId(Long id){
        Cliente cliente = repository.findById(id)
                .orElseThrow();
        return new ClienteResponseDTO(cliente);
    }

    public Page<ClienteResponseDTO> listarTodos(Pageable pageable){
        return repository.findAll(pageable).map(ClienteResponseDTO::new);
    }

    @Transactional
    public ClienteResponseDTO atualizar(Long id, ClienteUpdateDTO dto){
        Cliente cliente = repository.findById(id)
                .orElseThrow();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        Cliente atualizado = repository.save(cliente);

        return new ClienteResponseDTO(atualizado);
    }

    @Transactional
    public void delete (Long id){
        Cliente cliente = repository.findById(id)
                .orElseThrow();
        repository.delete(cliente);
    }
}
