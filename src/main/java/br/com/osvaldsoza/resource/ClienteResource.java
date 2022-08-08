package br.com.osvaldsoza.resource;

import br.com.osvaldsoza.model.Cliente;
import br.com.osvaldsoza.model.dto.ClienteDTO;
import br.com.osvaldsoza.model.response.ClienteResponse;
import br.com.osvaldsoza.service.ClienteService;
import br.com.osvaldsoza.util.exception.EntidadeNaoEncontradaException;
import io.swagger.annotations.Api;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/builders")
@Api(tags = "Clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<ClienteResponse> listaClientes(@RequestParam(required = false) String nome,
                                               @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return clienteService.listaClientes(nome, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaCliente(@PathVariable("id") Long clienteID) {
        try {
            var cliente = clienteService.buscarClientePorId(clienteID);
            return ResponseEntity.ok().body(cliente);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionaCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        return clienteService.salvar(clienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizaCliente(@PathVariable("id") Long clienteID, @RequestBody @Valid ClienteDTO clienteDTO) {
        try {
            var cliente = clienteService.atualizar(clienteID, clienteDTO);
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(@PathVariable("id") Long clienteID) {
        try {
            clienteService.remover(clienteID);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
