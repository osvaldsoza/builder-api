package br.com.osvaldsoza.service;

import br.com.osvaldsoza.model.Cliente;
import br.com.osvaldsoza.model.dto.ClienteDTO;
import br.com.osvaldsoza.model.response.ClienteResponse;
import br.com.osvaldsoza.repository.ClienteRepository;
import br.com.osvaldsoza.util.exception.EntidadeNaoEncontradaException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.osvaldsoza.util.ClienteUtil.calcularIdadeEmAnos;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    private static final String CLIENTE_NAO_ENCONTRADO = "Cliente não encontrado.";

    public List<ClienteResponse> listaClientes(String nome, Pageable pageable) {
        List<Cliente> clientes;

        if (nome == null) {
            clientes = clienteRepository
                    .findAll(pageable)
                    .stream()
                    .collect(Collectors.toList());
        } else {
            clientes = clienteRepository
                    .findClienteByNomeContaining(nome, pageable)
                    .stream()
                    .collect(Collectors.toList());
        }

        List<ClienteResponse> clienteResponses = new ArrayList<>();
        return retornaClienteResponse(clientes, clienteResponses);
    }

    private List<ClienteResponse> retornaClienteResponse(List<Cliente> clientes, List<ClienteResponse> clienteResponses) {
        for (Cliente cliente : clientes) {
            ClienteResponse clienteResponse = new ClienteResponse();
            clienteResponse.setId(cliente.getId());
            clienteResponse.setNome(cliente.getNome());
            clienteResponse.setIdade(calcularIdadeEmAnos(cliente.getDataNascimentopo()));
            clienteResponses.add(clienteResponse);
        }
        return clienteResponses;
    }

    public Cliente buscarClientePorId(Long clienteId) {
        return clienteRepository.findById(clienteId).orElseThrow(
                () -> new EntidadeNaoEncontradaException(CLIENTE_NAO_ENCONTRADO));
    }

    public Cliente salvar(ClienteDTO clienteDTO) {
        var cliente = parseDTOParaEntidade(clienteDTO);
        return clienteRepository.save(cliente);
    }
    public Cliente atualizar(Long clienteId, ClienteDTO clienteDTO) {
        var clienteAtual = buscarClientePorId(clienteId);

        BeanUtils.copyProperties(clienteDTO, clienteAtual, "id");

        return clienteRepository.save(clienteAtual);
    }
    public void remover(Long clienteId) {
        try {
            clienteRepository.deleteById(clienteId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException((CLIENTE_NAO_ENCONTRADO));
        }
    }

    private Cliente parseDTOParaEntidade(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setDataNascimentopo(clienteDTO.getDataNascimentopo());

        return cliente;
    }
}
